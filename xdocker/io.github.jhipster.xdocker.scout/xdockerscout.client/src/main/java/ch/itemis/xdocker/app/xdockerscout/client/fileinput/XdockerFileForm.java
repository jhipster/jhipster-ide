package ch.itemis.xdocker.app.xdockerscout.client.fileinput;

import static ch.itemis.xdocker.app.xdockerscout.client.util.ScoutExtensions.showErrorMessageBox;
import static ch.itemis.xdocker.app.xdockerscout.shared.prefs.XdockerDockerPropertiesConverter.toDockerProperties;

import java.io.File;
import java.io.IOException;

import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.IForm;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;

import ch.itemis.xdocker.app.xdockerscout.client.editor.XdockerEditorForm;
import ch.itemis.xdocker.app.xdockerscout.client.fileinput.XdockerFileForm.MainBox.FileNameField;
import ch.itemis.xdocker.app.xdockerscout.client.util.IPageForm;
import ch.itemis.xdocker.app.xdockerscout.shared.service.IXdockerDockerPropertiesService;
import ch.itemis.xdocker.lib.DockerProperties;

/**
 * <h3>{@link XdockerEditorForm}</h3>
 *
 * @author serano
 */
public class XdockerFileForm extends AbstractForm implements IPageForm {

	private IForm editorForm = null;

	public XdockerFileForm() {
		setHandler(new ViewHandler());
	}

	@Override
	protected String getConfiguredTitle() {
		return "Please enter a Xdocker file name...";
	}

	@Override
	public void startPageForm(IForm editorForm) {
		this.editorForm = editorForm;
		startInternal(new ViewHandler());
	}

	public FileNameField getMyStringField() {
		return getFieldByClass(FileNameField.class);
	}

	@Override
	protected boolean getConfiguredAskIfNeedSave() {
		return false;
	}

	private DockerProperties getDockerProperties() {
		return toDockerProperties(BEANS.get(IXdockerDockerPropertiesService.class).load());
	}

	@Order(1000)
	public class MainBox extends AbstractGroupBox {

		@Order(-1000)
		public class FileNameField extends AbstractStringField {
			@Override
			protected String getConfiguredLabel() {
				return "File Name"; // TEXTS.get("MyNlsKey");
			}

			@Override
			protected int getConfiguredMaxLength() {
				return 128;
			}
		}

		@Order(50)
		public class CloseButton extends AbstractCancelButton {
		}

		@Order(60)
		public class OkButton extends AbstractOkButton {
			@Override
			protected void execClickAction() {
				String filePath = null;
				try {
					String fileName = new File(getFieldByClass(FileNameField.class).getValue()).getName();
					filePath = getDockerProperties().getProjectPath() + File.separator + fileName
							+ (fileName.endsWith(".xdocker") ? "" : ".xdocker");
					if (new File(filePath).createNewFile()) {
						if (editorForm instanceof XdockerEditorForm) {
							((XdockerEditorForm) editorForm).openEditor(filePath);
						}
					}
					doClose();
				} catch (IOException e) {
					showErrorMessageBox("Could not create file: " + filePath, e.toString() + ": " + e.getMessage());
				}
			}
		}
	}

	public class ViewHandler extends AbstractFormHandler {
	}
}
