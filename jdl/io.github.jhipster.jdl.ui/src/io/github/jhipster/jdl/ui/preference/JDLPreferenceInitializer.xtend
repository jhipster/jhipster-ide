package io.github.jhipster.jdl.ui.preference

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer
import static io.github.jhipster.jdl.ui.preference.JDLPreferenceProperties.*
import io.github.jhipster.jdl.ui.JdlActivator

interface JDLPreferenceProperties {
	public val P_Exec = 'exec'
	public val P_Args = 'args'
	public val P_Script = 'script'
	public val P_Envs = 'envs'
	
	public val EXEC = 'Executable:'
	public val ARGS = 'Arguments:'
	public val SCRIPT = 'Script:'
	public val SHELL = 'Shell:'
	public val ENVS = 'Envs (FOO=bar PATH=/path/to):'
}

class JDLPreferenceInitializer extends AbstractPreferenceInitializer {

	override initializeDefaultPreferences() {
		JdlActivator.instance.preferenceStore => [
			setDefault(P_Exec, '/bin/bash')
			setDefault(P_Args, '-c "${script} ${project} ${path} ${switch}"')
			setDefault(P_Script, '''
				#!/bin/bash
				export PATH=$PATH:/usr/local/bin
				if [ -z "$1" ]
				then
					echo "No argument supplied"
				else
					# echo "alias $1='docker exec -it $1  bash'" > .jhenv
					# docker run --name $1 -v $2:/home/jhipster/$1 -v ~/.m2:/home/jhipster/.m2 -d -t jhipster/jhipster
					# docker exec -it $1 bash
					yo jhipster 
				fi
			''')
			setDefault(P_Envs, 'PATH=${env_var:PATH}:/usr/bin')
		]
	}
}
