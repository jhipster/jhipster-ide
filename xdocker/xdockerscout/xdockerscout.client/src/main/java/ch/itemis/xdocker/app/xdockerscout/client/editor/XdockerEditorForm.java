package ch.itemis.xdocker.app.xdockerscout.client.editor;

import static ch.itemis.xdocker.app.xdockerscout.client.util.ScoutExtensions.showErrorMessageBox;
import static ch.itemis.xdocker.app.xdockerscout.client.util.ScoutExtensions.showInfoMessageBox;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeUnit;

import org.eclipse.scout.rt.client.dto.FormData;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.util.SleepUtil;
import org.eclipse.scout.rt.platform.util.TriState;
import org.eclipse.scout.rt.shared.AbstractIcons;
import org.eclipse.scout.rt.shared.notification.INotificationListener;

import com.google.common.base.Strings;

import ch.itemis.xdocker.app.xdockerscout.client.editor.XdockerEditorForm.MainBox.ConsoleBox;
import ch.itemis.xdocker.app.xdockerscout.client.editor.XdockerEditorForm.MainBox.ConsoleBox.ConsoleField;
import ch.itemis.xdocker.app.xdockerscout.client.editor.XdockerEditorForm.MainBox.XdockerEditorGroupBox;
import ch.itemis.xdocker.app.xdockerscout.client.editor.XdockerEditorForm.MainBox.XdockerEditorGroupBox.XdockerEditorField;
import ch.itemis.xdocker.app.xdockerscout.client.notification.DockerNotificationHandler;
import ch.itemis.xdocker.app.xdockerscout.shared.notification.DockerNotification;
import ch.itemis.xdocker.app.xdockerscout.shared.service.IXdockerDockerService;
import ch.itemis.xdocker.app.xdockerscout.shared.service.XdockerEditorFormData;

/**
 * <h3>{@link XdockerEditorForm}</h3>
 *
 * @author serano
 */
@FormData(value = XdockerEditorFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class XdockerEditorForm extends AbstractForm {

	private Path pathToFile;

	public XdockerEditorForm() {
		setHandler(new ViewHandler());
	}

	public Path getPathToFile() {
		return pathToFile;
	}

	public void setPathToFile(Path pathToFile) {
		this.pathToFile = pathToFile;
	}

	@Override
	protected boolean getConfiguredAskIfNeedSave() {
		return false;
	}

	@Override
	protected String getConfiguredIconId() {
		return AbstractIcons.World;
	}

	@Override
	protected boolean getConfiguredMaximized() {
		return true;
	}

	@Override
	protected int getConfiguredModalityHint() {
		return MODALITY_HINT_MODELESS;
	}

	@Override
	protected boolean getConfiguredShowOnStart() {
		return true;
	}

	public ConsoleField getConsoleField() {
		return getFieldByClass(ConsoleField.class);
	}

	public MainBox getMainBox() {
		return getFieldByClass(MainBox.class);
	}

	public XdockerEditorField getXdockerEditorField() {
		return getFieldByClass(XdockerEditorField.class);
	}

	public XdockerEditorGroupBox getXdockerEditorGroupBox() {
		return getFieldByClass(XdockerEditorGroupBox.class);
	}

	public ConsoleBox getConsoleBox() {
		return getFieldByClass(ConsoleBox.class);
	}

	public void clearConsole() {
		getConsoleField().setValue("");
		getFieldByClass(ConsoleBox.class).setExpanded(true);
	}

	public void closeConsole() {
		getFieldByClass(ConsoleBox.class).setExpanded(false);
	}

	public void clearEditor() {
		getXdockerEditorField().setValue("");
		getXdockerEditorField().initField();
		getXdockerEditorField().refreshDisplayText();
		clearConsole();
		closeConsole();
	}

	public void openEditor(String pathToFileStr) throws IOException {
		setPathToFile(Paths.get(pathToFileStr));
		String dockerFileContent = new String(Files.readAllBytes(pathToFile));
		if (dockerFileContent != null) {
			getXdockerEditorGroupBox().setVisible(true);
			getXdockerEditorGroupBox().setExpanded(true);
			getXdockerEditorGroupBox().setLabel(pathToFile.toString());
//			getXdockerEditorGroupBox().setLabel(pathToFile.getFileName().toString());
			getXdockerEditorField().setValue(dockerFileContent);
		}
	}

	public void logConsole(DockerNotification notification) {
		if (notification != null) {
			logConsole(notification.getMessage());
		}
	}

	public void logConsole(String msg) {
		if (Strings.isNullOrEmpty(msg) == false) {
			StringBuffer sb = new StringBuffer();
			String out = getConsoleField().getValue();
			if (Strings.isNullOrEmpty(out) == false) {
				sb.append(out).append("\n");
			}
			sb.append(msg);
			getConsoleField().setValue(sb.toString());
		}
	}

	public void closeEditor() {
		clearEditor();
		getXdockerEditorGroupBox().setLabel("Editor");
		getXdockerEditorGroupBox().setVisible(false);
		getXdockerEditorGroupBox().setExpanded(false);
		pathToFile = null;
	}

	@Order(1000)
	public class MainBox extends AbstractGroupBox {
		@Order(1010)
		public class XdockerEditorGroupBox extends AbstractGroupBox {
			@Override
			protected boolean getConfiguredVisible() {
				return false;
			}
			
			@Override
			protected boolean getConfiguredExpandable() {
				return true;
			}

			@Override
			protected boolean getConfiguredFillHorizontal() {
				return true;
			}

			@Override
			protected boolean getConfiguredFillVertical() {
				return true;
			}

			@Override
			protected String getConfiguredLabel() {
				return "Editor";
			}
			
			@Order(8)
			public class SaveMenu extends AbstractMenu {
				@Override
				protected String getConfiguredText() {
					return "Save";
				}

				@Override
				protected void execAction() {
					if (pathToFile != null && pathToFile.toFile().canWrite()) {
						try {
							byte[] content = getXdockerEditorField().getValue().getBytes();
							Files.write(pathToFile, content, StandardOpenOption.TRUNCATE_EXISTING);
							SleepUtil.sleepSafe(200, TimeUnit.MILLISECONDS);
							showInfoMessageBox("Save Xdocker File...", "File " + pathToFile + " saved!");
						} catch (IOException e) {
							showErrorMessageBox("Save Xdocker File...", e);
						}
					}
				}
			}

			@Order(10)
			public class CloseMenu extends AbstractMenu {
				@Override
				protected String getConfiguredText() {
					return "Close";
				}

				@Override
				protected void execAction() {
					closeEditor();
				}
			}

			@Order(12)
			public class BuildMenu extends AbstractMenu {
				@Override
				protected String getConfiguredText() {
					return "Build";
				}

				@Override
				protected void execAction() {
					try {
						if (pathToFile != null && Files.exists(pathToFile))  {
							logConsole("Building of dockerfile " + pathToFile.toString() + " started...");
							BEANS.get(IXdockerDockerService.class).build(pathToFile.toString());
							getXdockerEditorGroupBox().setExpanded(false);
							getConsoleBox().setExpanded(true);
						} else {
							showInfoMessageBox("Docker Build...", "Please open a dockerfile first...");
						}
					} catch (Exception e) {
						showErrorMessageBox("Docker Build...", "Error building dockerfile: " + e.getMessage());
					}
				}
			}
			
			@Order(1200)
			public class XdockerEditorField extends AbstractXdockerEditorField {

				@Override
				protected boolean getConfiguredFillHorizontal() {
					return true;
				}

				@Override
				protected boolean getConfiguredFillVertical() {
					return true;
				}

				@Override
				protected int getConfiguredGridH() {
					return 10;
				}
			}
		}

		@Order(2001)
		public class ConsoleBox extends AbstractGroupBox {
			@Override
			protected boolean getConfiguredExpandable() {
				return true;
			}
			
			@Override
			protected boolean getConfiguredExpanded() {
				return false;
			}

			@Override
			protected TriState getConfiguredScrollable() {
				return TriState.TRUE;
			}

			@Override
			protected String getConfiguredLabel() {
				return "Console"; // TEXTS.get("MyNlsKey");
			}

			@Order(1000)
			public class ClearTextMenu extends AbstractMenu {
				@Override
				protected String getConfiguredText() {
					return "Clear Text"; // TEXTS.get("ClearText");
				}

				@Override
				protected void execAction() {
					clearConsole();
				}
			}

			@Order(2002)
			public class ConsoleField extends AbstractStringField {
				@Override
				protected int getConfiguredMaxLength() {
					return 1000000;
				}

				@Override
				protected int getConfiguredGridH() {
					return 4;
				}

				@Override
				protected boolean getConfiguredLabelVisible() {
					return false;
				}

				@Override
				protected boolean getConfiguredMultilineText() {
					return true;
				}

				@Override
				protected boolean getConfiguredEnabled() {
					return false;
				}
			}
		}
	}

	public class ViewHandler extends AbstractFormHandler {
		private DockerNotificationHandler dockerNotificationHandler;
		private final INotificationListener<DockerNotification> m_dockerListener = new INotificationListener<DockerNotification>() {
			@Override
			public void handleNotification(DockerNotification notification) {
				logConsole(notification);
			}
		};

		@Override
		protected void execFinally() {
			dockerNotificationHandler.removeListener(m_dockerListener);
		}

		@Override
		protected void execLoad() {
			dockerNotificationHandler = BEANS.get(DockerNotificationHandler.class);
			dockerNotificationHandler.addListener(m_dockerListener);
		}
	}
}
