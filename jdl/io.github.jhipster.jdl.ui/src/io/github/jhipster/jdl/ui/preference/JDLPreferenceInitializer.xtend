package io.github.jhipster.jdl.ui.preference

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer
import static io.github.jhipster.jdl.ui.preference.JDLPreferenceProperties.*
import io.github.jhipster.jdl.ui.JdlActivator

interface JDLPreferenceProperties {
	public val P_Exec = 'exec'
	public val P_Args = 'args'
	public val P_Script = 'script'
	
	public val EXEC = 'Executable:'
	public val ARGS = 'Arguments:'
	public val SCRIPT = 'Script:'
	public val SHELL = 'Shell:'
}

class JDLPreferenceInitializer extends AbstractPreferenceInitializer {

	override initializeDefaultPreferences() {
		JdlActivator.instance.preferenceStore => [
			setDefault(P_Exec, '')
			setDefault(P_Args, '')
			setDefault(P_Script, '')
		]
	}
}
