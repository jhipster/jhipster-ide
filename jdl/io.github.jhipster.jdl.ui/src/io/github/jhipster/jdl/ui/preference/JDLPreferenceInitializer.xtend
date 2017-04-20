package io.github.jhipster.jdl.ui.preference

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer
import static io.github.jhipster.jdl.ui.preference.JDLPreferenceProperties.*
import io.github.jhipster.jdl.ui.JdlActivator

interface JDLPreferenceProperties {
	public val P_ShellEnabled = 'enabled'
	public val P_Exec = 'exec'
	public val P_Args = 'args'
	public val P_Script = 'script'
	public val P_Envs = 'envs'

	public val SCRIPT_CHECKBOX = 'Enable Script'
	public val EXEC = 'Executable:'
	public val ARGS = 'Arguments:'
	public val SCRIPT = 'Script:'
	public val SHELL = 'Shell:'
	public val ENVS = 'Envs (FOO=bar PATH=/path/to):'
}

class JDLPreferenceInitializer extends AbstractPreferenceInitializer {
	
	override initializeDefaultPreferences() {
		System.getProperty('os.name')?.toLowerCase => [ os |
			JdlActivator.instance.preferenceStore => [
				setDefault(P_ShellEnabled, true)
				setDefault(P_Exec, os.execDefault)
				setDefault(P_Args, os.argsDefault)
				setDefault(P_Envs, os.envsDefault)
				setDefault(P_Script, os.scriptDefault)
			]
		]
	}

	def private String getExecDefault(String os) {
		if (os.isUnix) '/bin/bash'
		else if (os.isWindows) 'c:\\windows\\system32\\cmd.exe' 
		else '' // unknown operating system
	}

	def private String getArgsDefault(String os) {
		if (os.isUnix) '-c "${script} ${project} ${path}"'
		else if (os.isWindows) '/c ${script} ${project} ${path}' 
		else '' // unknown operating system
	}

	def private String getEnvsDefault(String os) {
		if (os.isUnix) 'PATH=${env_var:PATH}:/usr/local/bin:'
		else if (os.isWindows) 'PATH=${env_var:PATH}'
		else '' // unknown operating system
	}
	
	def private String getScriptDefault(String os) {
		if (os.isUnix) getScriptForUnix 
		else if (os.isWindows) scriptForWindows 
		else '' // unknown operating system
	}
	
	def private String getScriptForUnix() '''
		#!/bin/bash
		# enable the following statement if you want to call automatically jhipster after creating a new project
		# yo jhipster
		# ./mvnw --no-plugin-registry eclipse:eclipse
		bash
	'''
/* TODO Implement me
		#!/bin/bash
		export PATH=$PATH:/usr/local/bin
		if [ -z "$1" ]
		then
			echo "No argument supplied"
		else
			# echo "alias $1='docker exec -it $1  bash'" > .jhenv
			# [[ $(docker ps -f "name=$1" --format '{{.Names}}') == $1 ]] || \\
			# docker run --name $1 -v $2:/home/jhipster/$1 -v ~/.m2:/home/jhipster/.m2 -d -t jhipster/jhipster
			# docker exec -it $1 bash
			yo jhipster
			bash
		fi  
*/

	def private String getScriptForWindows() '''
		REM enable the following statement if you want to call automatically jhipster after creating a new project
		REM yo jhipster
		REM mvnw --no-plugin-registry eclipse:eclipse
		cmd.exe 
	'''
	
	def private isWindows(String os) {
		return os !== null && os.contains('windows')
	}

	def private isUnix(String os) {
		return os !== null && os.contains('mac') || os.contains('linux')
	}
}
