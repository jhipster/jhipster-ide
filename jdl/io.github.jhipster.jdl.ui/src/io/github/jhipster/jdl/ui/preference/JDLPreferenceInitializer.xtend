package io.github.jhipster.jdl.ui.preference

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer
import static io.github.jhipster.jdl.ui.preference.JDLPreferenceProperties.*
import io.github.jhipster.jdl.ui.JdlActivator

interface JDLPreferenceProperties {
	public val P_Shell = 'jdl.shell'
	public val P_Content = 'jdl.content'
	
	public val COMMAND = 'Command:'
	public val SCRIPT = 'Script:'
}

class JDLPreferenceInitializer extends AbstractPreferenceInitializer {

	override initializeDefaultPreferences() {
		JdlActivator.instance.preferenceStore => [
			setDefault(P_Shell, '')
			setDefault(P_Content, '')
		]
	}
}