package ch.itemis.xdocker.app.xdockerscout.client.filetree;

import static ch.itemis.xdocker.app.xdockerscout.client.util.ScoutExtensions.showErrorMessageBox;
import static ch.itemis.xdocker.app.xdockerscout.shared.prefs.XdockerDockerPropertiesConverter.toDockerProperties;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.IForm;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCloseButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.exception.PlatformExceptionTranslator;

import ch.itemis.xdocker.app.xdockerscout.client.editor.XdockerEditorForm;
import ch.itemis.xdocker.app.xdockerscout.client.util.IPageForm;
import ch.itemis.xdocker.app.xdockerscout.shared.service.IXdockerDockerPropertiesService;
import ch.itemis.xdocker.lib.DockerProperties;

/**
 * <h3>{@link XdockerEditorForm}</h3>
 *
 * @author serano
 */
public class XdockerFiletreeForm extends AbstractForm implements IPageForm {

	private IForm editorForm = null;

	public XdockerFiletreeForm() {
		setHandler(new ViewHandler());
	}

	@Override
	protected String getConfiguredTitle() {
		return "Please choose your dockerfile...";
	}

	@Override
	public void startPageForm(IForm editorForm) {
		this.editorForm = editorForm;
		startInternal(new ViewHandler());
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

		@Override
		protected String getConfiguredLabel() {
			return "Choose Docker File...";
		}

		@Order(1100)
		public class FileTreeField extends AbstractFileTreeField {

			@Override
			protected int getConfiguredCollapseSpeed() {
				return 100;
			}

			@Override
			protected int getConfiguredExpandSpeed() {
				return 400;
			}

			@Override
			protected int getConfiguredGridH() {
				return 7;
			}

			@Override
			protected int getConfiguredGridW() {
				return 1;
			}

			@Override
			protected boolean getConfiguredLabelVisible() {
				return false;
			}

			@Override
			protected boolean getConfiguredMultiFolder() {
				return false;
			}

			@Override
			protected String getConfiguredLabel() {
				DockerProperties props = getDockerProperties();
				return new File(props.getProjectPath()).getParent();
			}

			@Override
			protected void execInitField() {
				DockerProperties props = getDockerProperties();
				setRootDir(props.getProjectPath());
			}

			@Override
			protected void execClick(String filePath) {
				String dockerFileContent = filePath;
				if (dockerFileContent != null && editorForm instanceof XdockerEditorForm) {
					try {
						((XdockerEditorForm) editorForm).openEditor(dockerFileContent);
						doClose();
					} catch (IOException e) {
						showErrorMessageBox("Could not open file: " + filePath, e.toString() + ": " + e.getMessage());
					}
				}
			}

			@Override
			protected Collection<FileTreeElement> execLoad(String dir, boolean onlyFolders, boolean onlyFiles,
					boolean multiSelect) {
				try {
					try {
						Thread.sleep(200);
						return Files.list(Paths.get(new File(dir).toURI())).map(FileTreeElement::new)
								.collect(Collectors.toCollection(ArrayList::new));
					} catch (InterruptedException e) {
						return null;
					}
				} catch (Exception e) {
					throw BEANS.get(PlatformExceptionTranslator.class).translate(e);
				}
			}
		}

		@Order(50)
		public class CloseButton extends AbstractCloseButton {
		}
	}

	public class ViewHandler extends AbstractFormHandler {
	}
}
