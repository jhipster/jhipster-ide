package io.github.jhipster.jdl.ui.preference

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer
import static io.github.jhipster.jdl.ui.preference.JDLPreferenceProperties.*
import io.github.jhipster.jdl.ui.JdlActivator

interface JDLPreferenceProperties {
	public val P_ShellEnabled = 'enabled'
	public val P_Exec = 'exec'
	public val P_Args = 'args'
	public val P_Script = 'script'

	public val SCRIPT_CHECKBOX = 'Enable Script'
	public val EXEC = 'Executable:'
	public val ARGS = 'Arguments:'
	public val SCRIPT = 'Script:'
	public val SHELL = 'Shell:'
}

class JDLPreferenceInitializer extends AbstractPreferenceInitializer {
	
	override initializeDefaultPreferences() {
		System.getProperty('os.name')?.toLowerCase => [ os |
			JdlActivator.instance.preferenceStore => [
				setDefault(P_ShellEnabled, true)
				setDefault(P_Exec, os.execDefault)
				setDefault(P_Args, os.argsDefault)
				setDefault(P_Script, os.scriptDefault)
			]
		]
	}

	def private String getExecDefault(String os) {
		if (os.isUnix) '/bin/bash'
		else if (os.isWindows) 'C:\\Windows\\System32\\cmd.exe'
		else '' // unknown operating system
	}

	def private String getArgsDefault(String os) {
		if (os.isUnix) '-lc "${script} ${project} ${path}"'
		else if (os.isWindows) '/k ${script} ${project} ${path}' 
		else '' // unknown operating system
	}
	
	def private String getScriptDefault(String os) {
		if (os.isUnix) getScriptForUnix 
		else if (os.isWindows) scriptForWindows 
		else '' // unknown operating system
	}
	
	def private String getScriptForUnix() '''
		#!/bin/bash
		export PATH=$PATH:/usr/local/bin:
		echo "Initialize JHipster project $1"
		command yo jhipster || { echo >&2 "Yeoman JHipster generator is required but it's not installed!"; }
		./mvnw --no-plugin-registry eclipse:eclipse || { echo >&2 "maven wrapper script not found!"; }
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
		@echo off
		@echo Initialize JHipster project %1
		set PATH=%PATH%;C:\Windows\System32;
		call yo jhipster || echo Yeoman JHipster generator is required but it's not installed!
		call mvnw.cmd --no-plugin-registry eclipse:eclipse || echo maven wrapper script not found!
	'''
	
	def private isWindows(String os) {
		return os !== null && os.contains('win')
	}

	def private isUnix(String os) {
		return os !== null && os.contains('mac') || os.contains('linux')
	}
}
