package io.github.jhipster.jdl.ui.wizard;

import static io.github.jhipster.jdl.ui.util.ResourceManager.getPluginImage;
import static org.eclipse.jface.resource.ImageDescriptor.createFromImage;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class JDLWizardNewProjectCreationPage extends WizardNewProjectCreationPage {

	public JDLWizardNewProjectCreationPage(String pageName) {
		super(pageName);
		Image image = getPluginImage("io.github.jhipster.jdl.ui", "icons/JHipster.gif");
		setImageDescriptor(createFromImage(image));
	}
}
