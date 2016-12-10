package ch.itemis.xdocker.app.xdockerscout.client.search

import ch.itemis.xdocker.app.xdockerscout.client.util.AbstractSearchOptionButton
import ch.itemis.xdocker.app.xdockerscout.shared.service.IImageInfo
import ch.itemis.xdocker.app.xdockerscout.shared.service.IXdockerDockerService
import ch.itemis.xdocker.app.xdockerscout.shared.service.XdockerLocalImageInfo
import ch.itemis.xdocker.app.xdockerscout.shared.service.XdockerRemoteImageInfo
import com.ocpsoft.pretty.time.PrettyTime
import java.util.Comparator
import java.util.Date
import java.util.List
import org.apache.commons.io.FileUtils
import org.eclipse.scout.rt.client.ui.form.AbstractForm
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractButton
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox
import org.eclipse.scout.rt.client.ui.form.fields.sequencebox.AbstractSequenceBox
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField
import org.eclipse.scout.rt.platform.BEANS
import org.eclipse.scout.rt.platform.Order
import org.eclipse.scout.rt.shared.TEXTS

import static ch.itemis.xdocker.app.xdockerscout.client.util.ScoutExtensions.*
import org.eclipse.scout.rt.client.ui.basic.table.ITable
import org.eclipse.scout.rt.client.ui.basic.table.ITableRow

/**
 * XdockerImageSearchForm
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerImageSearchForm extends AbstractForm {

	@Order(10)
	static class MainBox extends AbstractGroupBox {

		@Order(10)
		static class SearchGroupBox extends AbstractGroupBox {

			@Order(10)
			static class SearchBox extends AbstractSequenceBox {
				override boolean getConfiguredAutoCheckFromTo() { false }
				override boolean getConfiguredEqualColumnWidths() { false }
				override boolean getConfiguredLabelVisible() { false }

				@Order(20)
				static class ImageNameField extends AbstractStringField {
					override String getConfiguredLabel() { 'Image Name' }
					override int getConfiguredLabelPosition() { LABEL_POSITION_ON_FIELD }
				}

				@Order(40)
				static class SearchButton extends AbstractButton {
					override protected String getConfiguredLabel() {
						return TEXTS.get('Search')
					}

					override protected void execClickAction() {
						val isLocal = form.getFieldByClass(SearchOptionButton).isOption1
						val term = form.getFieldByClass(ImageNameField).value
						val List<IImageInfo> result = newArrayList
						val tableBox = form.getFieldByClass(TableBox)

						// remove all items first
						if (isLocal) 
							tableBox.localImagesTableField.table.deleteAllRows
						else
							tableBox.remoteImagesTableField.table.deleteAllRows
						
						if (!isLocal && term.nullOrEmpty) {
							showWarnMessageBox("Wrong input!", "Please enter image name to search for...")
							return
						}
						
						try {
							BEANS.get(IXdockerDockerService).search(term, isLocal) => [
								if (!nullOrEmpty) result.addAll(it)
							]
						} catch (Exception ex) {
							showErrorMessageBox("Error calling docker...", ex.message)
							return
						}
						
						if (!result.isNullOrEmpty) {
							if (isLocal) {
								tableBox.localImagesTableField => [
									val images = result.filter(XdockerLocalImageInfo).toList
									visible = true
									table => [ t |
										t.deleteAllRows
										val pt = new PrettyTime
										images.forEach [
											val v = newArrayList
											val tag1 = if(repoTags.length > 0) repoTags.get(0).split(":").get(0) else ""
											val tag2 = if(repoTags.length > 0) repoTags.get(0).split(":").get(1) else ""
											v.addAll(#[
												tag1, tag2, id.substring(0, 12), pt.format(new Date(created * 1000)), FileUtils.byteCountToDisplaySize(virtualSize)
											])
											t.addRow.cellValues = v
										]
										t.resetColumnWidths
									]
								]
							} else {
								tableBox.remoteImagesTableField => [
									val images = result.filter(XdockerRemoteImageInfo).sortWith(new Comparator<XdockerRemoteImageInfo>() {
										override compare(XdockerRemoteImageInfo o1, XdockerRemoteImageInfo o2) {
											if (o1.starCount < o2.starCount) 0 else -1
										}
									})
									visible = true
									table => [ t |
										t.deleteAllRows
										images.forEach [
											val v = newArrayList
											v.addAll(#[name, description, starCount])
											t.addRow.cellValues = v
										]
										t.resetColumnWidths
									]
								]
							}
						} else showInfoMessageBox("Search Image...", "No image found...")
					}
				}

				@Order(50)
				static class SearchOptionButton extends AbstractSearchOptionButton {
					new() { super('Local', 'Remote') }

					override protected execSelectionChanged(boolean selected) {
						super.execSelectionChanged(selected)
						form.getFieldByClass(TableBox).remoteImagesTableField => [
							visible = selected
							table.deleteAllRows
						]
						form.getFieldByClass(TableBox).localImagesTableField => [
							visible = !selected
							table.deleteAllRows
						]
					}
				}
			}
		}

		static class TableBox extends XdockerImageSearchTable { 
			override protected deleteTableRowsAction(ITable table, List<ITableRow> selectedRows) {
				if (selectedRows.nullOrEmpty == false) {
					val List<String> ids = newArrayList(selectedRows.map[getCellValue(2).toString].toList)
					try {
						BEANS.get(IXdockerDockerService).removeImages(ids)
						table.deleteRows(selectedRows)
					} catch (Exception ex) {
						val msg = ex?.cause?.message ?: '''with id(s) «ids.toString.replaceAll('\\[|\\]', '')»'''
						showErrorMessageBox("could not remove image(s)", msg)						
					}
				}
			}
		}
	}
}
