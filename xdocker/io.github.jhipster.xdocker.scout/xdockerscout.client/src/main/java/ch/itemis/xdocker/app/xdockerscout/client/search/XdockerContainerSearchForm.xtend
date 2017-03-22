package ch.itemis.xdocker.app.xdockerscout.client.search

import ch.itemis.xdocker.app.xdockerscout.client.util.AbstractSearchOptionButton
import ch.itemis.xdocker.app.xdockerscout.shared.service.IXdockerDockerService
import ch.itemis.xdocker.app.xdockerscout.shared.service.XdockerContainerInfo
import com.ocpsoft.pretty.time.PrettyTime
import java.util.Date
import java.util.List
import org.apache.commons.lang.StringUtils
import org.eclipse.scout.rt.client.ui.basic.table.ITable
import org.eclipse.scout.rt.client.ui.basic.table.ITableRow
import org.eclipse.scout.rt.client.ui.form.AbstractForm
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractButton
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox
import org.eclipse.scout.rt.client.ui.form.fields.sequencebox.AbstractSequenceBox
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField
import org.eclipse.scout.rt.platform.BEANS
import org.eclipse.scout.rt.platform.Order
import org.eclipse.scout.rt.shared.TEXTS

import static ch.itemis.xdocker.app.xdockerscout.client.util.ScoutExtensions.*
import static ch.itemis.xdocker.app.xdockerscout.shared.util.XdockerContainerMatcher.*
import static org.apache.commons.lang.StringUtils.isNotBlank

/**
 * XdockerContainerSearchForm - Class
 * 
 * Serano Colameo - Initial contribution and API
 */
class XdockerContainerSearchForm extends AbstractForm {

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
				static class ContainerNameField extends AbstractStringField {
					override String getConfiguredLabel() { 'Container Name' }
					override int getConfiguredLabelPosition() { LABEL_POSITION_ON_FIELD }
				}

				@Order(40)
				static class SearchButton extends AbstractButton {
					override protected String getConfiguredLabel() {
						return TEXTS.get('Search')
					}

					override protected void execClickAction() {
						val pt = new PrettyTime();
						val term = form.getFieldByClass(ContainerNameField).value
						val opBtn = form.getFieldByClass(SearchOptionButton)
						val showAll = !opBtn.isOption1
						val result = BEANS.get(IXdockerDockerService).containers(showAll).filter(XdockerContainerInfo)
						val tableField = form.getFieldByClass(TableBox).tableField

						// remove all items first
						tableField.table.deleteAllRows

						if (result.isNullOrEmpty) {
							showInfoMessageBox('''Search for «opBtn.label» Container''', 'No containers found...')
							return
						}

						tableField => [
							val t = table
							t.deleteAllRows
							result.filter[match(term, it)].forEach [
								val sb = new StringBuffer
								var boolean hasIP
								var boolean hasPrivPort
								for (port : ports) {
									if(sb.length > 0) sb.append(",")
									if(hasIP = isNotBlank(port.getIp())) sb.append(port.ip)
									if (hasPrivPort = (port.privatePort !== null)) {
										if(hasIP) sb.append(":")
										sb.append(String.valueOf(port.privatePort))
									}
									if (port.publicPort !== null) {
										if(hasIP || hasPrivPort) sb.append("->")
										sb.append(String.valueOf(port.publicPort))
									}
									if (port.type !== null) {
										sb.append("/")
										sb.append(port.getType())
									}
								}
								val values = #[
									if(id.length > 12) id.substring(0, 12) else id,
									/*if (image.length>12) image.substring(0, 12) else */
									image,
									command,
									pt.format(new Date(created * 1000)),
									status,
									sb.toString,
									StringUtils.join(names)
								]
								t.addRow.cellValues = values
							]
							t.resetColumnWidths
						]
					}
				}

				@Order(50)
				static class SearchOptionButton extends AbstractSearchOptionButton {
					new() {
						super('Running', 'All')
					}
				}
			}
		}

		static class TableBox extends XdockerContainerSearchTable {
			override protected deleteTableRowsAction(ITable table, List<ITableRow> selectedRows) {
				if (selectedRows.nullOrEmpty == false) {
					val List<String> ids = newArrayList(selectedRows.map[getCellValue(0).toString].toList)
					BEANS.get(IXdockerDockerService).removeContainers(ids, true)
					table.deleteRows(selectedRows)
				}
			}
		}
	}
}
