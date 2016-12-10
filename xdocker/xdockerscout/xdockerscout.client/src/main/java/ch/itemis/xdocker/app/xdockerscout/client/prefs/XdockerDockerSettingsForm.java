package ch.itemis.xdocker.app.xdockerscout.client.prefs;

import static ch.itemis.xdocker.app.xdockerscout.client.util.ScoutExtensions.showErrorMessageBox;
import static ch.itemis.xdocker.app.xdockerscout.client.util.ScoutExtensions.showInfoMessageBox;

import java.util.concurrent.TimeUnit;

import org.eclipse.scout.rt.client.dto.FormData;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.booleanfield.AbstractBooleanField;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.util.SleepUtil;

import ch.itemis.xdocker.app.xdockerscout.client.prefs.XdockerDockerSettingsForm.MainBox.DockerPreferenceBox.SettingsBox;
import ch.itemis.xdocker.app.xdockerscout.client.prefs.XdockerDockerSettingsForm.MainBox.DockerPreferenceBox.SettingsBox.DockerCertPathField;
import ch.itemis.xdocker.app.xdockerscout.client.prefs.XdockerDockerSettingsForm.MainBox.DockerPreferenceBox.SettingsBox.DockerConfigPathField;
import ch.itemis.xdocker.app.xdockerscout.client.prefs.XdockerDockerSettingsForm.MainBox.DockerPreferenceBox.SettingsBox.DockerPasswordField;
import ch.itemis.xdocker.app.xdockerscout.client.prefs.XdockerDockerSettingsForm.MainBox.DockerPreferenceBox.SettingsBox.DockerServerAddressField;
import ch.itemis.xdocker.app.xdockerscout.client.prefs.XdockerDockerSettingsForm.MainBox.DockerPreferenceBox.SettingsBox.DockerUrlField;
import ch.itemis.xdocker.app.xdockerscout.client.prefs.XdockerDockerSettingsForm.MainBox.DockerPreferenceBox.SettingsBox.DockerUserNameField;
import ch.itemis.xdocker.app.xdockerscout.client.prefs.XdockerDockerSettingsForm.MainBox.DockerPreferenceBox.SettingsBox.EnableLoggingFilterButton;
import ch.itemis.xdocker.app.xdockerscout.client.prefs.XdockerDockerSettingsForm.MainBox.DockerPreferenceBox.SettingsBox.SaveButton;
import ch.itemis.xdocker.app.xdockerscout.shared.prefs.UpdateXdockerDockerPropertiesPermission;
import ch.itemis.xdocker.app.xdockerscout.shared.prefs.XdockerDockerPreferncesFormData;
import ch.itemis.xdocker.app.xdockerscout.shared.service.IXdockerDockerPropertiesService;
import ch.itemis.xdocker.app.xdockerscout.shared.service.IXdockerDockerService;

@FormData(value = XdockerDockerPreferncesFormData.class, sdkCommand = FormData.SdkCommand.USE)
public class XdockerDockerSettingsForm extends AbstractForm {

	public XdockerDockerSettingsForm() {
		setHandler(new ModifyHandler());
	}

	public SaveButton getSaveButton() {
		return getFieldByClass(SaveButton.class);
	}

	public SettingsBox getSettingsBox() {
		return getFieldByClass(SettingsBox.class);
	}

	public MainBox getMainBox() {
		return getFieldByClass(MainBox.class);
	}
	
	public DockerUrlField getDockerUrlField() {
		return getFieldByClass(DockerUrlField.class);
	}
	
	public EnableLoggingFilterButton getEnableLoggingFilterButton() {
		return getFieldByClass(EnableLoggingFilterButton.class);
	}
	
	public DockerCertPathField getDockerCertPathField() {
		return getFieldByClass(DockerCertPathField.class);
	}
	
	public DockerConfigPathField getDockerConfigPathField() {
		return getFieldByClass(DockerConfigPathField.class);
	}
		
	public DockerServerAddressField getDockerServerAddressField() {
		return getFieldByClass(DockerServerAddressField.class);
	}
		
	public DockerUserNameField getDockerUserNameField() {
		return getFieldByClass(DockerUserNameField.class);
	}
	
	public DockerPasswordField getDockerPasswordField() {
		return getFieldByClass(DockerPasswordField.class);
	}
	
	@Order(1000.0)
	public class MainBox extends AbstractGroupBox {

		@Order(100010.0)
		public class DockerPreferenceBox extends AbstractGroupBox {
			@Override
			protected String getConfiguredLabel() {
				return "Docker Properties Page";
			}

			@Order(1000)
			public class SettingsBox extends AbstractGroupBox {

				@Order(20)
				public class DockerUrlField extends AbstractStringField {
					@Override
					protected String getConfiguredLabel() {
						return "URL";
					}
				}

				@Order(30)
				public class EnableLoggingFilterButton extends AbstractBooleanField {
					@Override
					protected String getConfiguredLabel() {
						return "Logging Filter";
					}
				}

				@Order(40)
				public class DockerCertPathField extends AbstractStringField {
					@Override
					protected String getConfiguredLabel() {
						return "Cert Path";
					}
				}

				@Order(50)
				public class DockerConfigPathField extends AbstractStringField {
					@Override
					protected String getConfiguredLabel() {
						return "Config Path";
					}
				}

				@Order(60)
				public class DockerServerAddressField extends AbstractStringField {
					@Override
					protected String getConfiguredLabel() {
						return "Server Address";
					}
				}

				@Order(70)
				public class DockerUserNameField extends AbstractStringField {
					@Override
					protected String getConfiguredLabel() {
						return "User Name";
					}
				}

				@Order(80)
				public class DockerPasswordField extends AbstractStringField {
					@Override
					protected String getConfiguredLabel() {
						return "Password";
					}
				}

				@Order(90)
				public class ProjectPathField extends AbstractStringField {
					@Override
					protected String getConfiguredLabel() {
						return "Project Path";
					}
				}

				@Order(100)
				public class SaveButton extends AbstractButton {
					@Override
					protected String getConfiguredLabel() {
						return "Save"; //TEXTS.get("MyNlsKey");
					}

					@Override
					protected void execClickAction() {
						try {
							SleepUtil.sleepSafe(200, TimeUnit.MILLISECONDS);
							XdockerDockerPreferncesFormData formData = new XdockerDockerPreferncesFormData();
							exportFormData(formData);
							BEANS.get(IXdockerDockerPropertiesService.class).store(formData);						
							showInfoMessageBox("Save Settings...", "Settings saved!");
						} catch (Exception e) {
							showErrorMessageBox("Save Settings...", "Could not save settings! Error: " + e.getMessage());
						}
					}
				}
				
				@Order(110)
				public class TestConnectionButton extends AbstractButton {
					@Override
					protected String getConfiguredLabel() {
						return "Test Connection"; //TEXTS.get("MyNlsKey");
					}

					@Override
					protected void execClickAction() {
						try {
							SleepUtil.sleepSafe(200, TimeUnit.MILLISECONDS);
							XdockerDockerPreferncesFormData formData = new XdockerDockerPreferncesFormData();
							exportFormData(formData);
							BEANS.get(IXdockerDockerService.class).doTestConnection(formData);
							showInfoMessageBox("Test Connection...", "Connection established successful!");
						} catch (Exception e) {
							showErrorMessageBox("Test Connection...", "Error connecting to docker! Error: " + e.getMessage());
						}
					}
				}
			}
		}
	}

	public class ModifyHandler extends AbstractFormHandler {
		
		@Override
		protected void execLoad() {
			IXdockerDockerPropertiesService svc = BEANS.get(IXdockerDockerPropertiesService.class);
			XdockerDockerPreferncesFormData formData = svc.load();
			if (formData != null) importFormData(formData); 
			else importFormData(new XdockerDockerPreferncesFormData());
			setEnabledPermission(new UpdateXdockerDockerPropertiesPermission());
		}
	}
}
