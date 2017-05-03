package io.github.jhipster.jdl.ui

import io.github.jhipster.jdl.ui.wizard.JDLExtendedProjectCreator
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
class JDLUiModule extends AbstractJDLUiModule {

	override bindIProjectCreator() {
		JDLExtendedProjectCreator
	}	
}
