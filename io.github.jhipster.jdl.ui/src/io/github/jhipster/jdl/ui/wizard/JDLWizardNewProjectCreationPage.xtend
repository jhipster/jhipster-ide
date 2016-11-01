package io.github.jhipster.jdl.ui.wizard

import org.eclipse.ui.dialogs.WizardNewProjectCreationPage

import static io.github.jhipster.jdl.ui.util.ResourceManager.*
import static org.eclipse.jface.resource.ImageDescriptor.*

class JDLWizardNewProjectCreationPage extends WizardNewProjectCreationPage {

	new(String pageName) {
		super(pageName)
		getPluginImage('io.github.jhipster.jdl.ui', 'icons/JHipster.gif') => [
			imageDescriptor = createFromImage(it)	
		]
	}
}
