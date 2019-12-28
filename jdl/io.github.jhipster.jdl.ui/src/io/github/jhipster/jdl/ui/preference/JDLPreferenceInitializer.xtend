/**
 * Copyright 2013-2020 the original author or authors from the JHipster project.
 *
 * This file is part of the JHipster project, see http://www.jhipster.tech/
 * for more information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.jhipster.jdl.ui.preference

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer
import static io.github.jhipster.jdl.ui.preference.JDLPreferenceProperties.*
import io.github.jhipster.jdl.ui.JdlActivator

/**
 * @author Serano Colameo - Initial contribution and API
 */
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

	def private String getExecDefault(String it) {
		if (isUnix) '/bin/bash'
		else if (isWindows) 'C:\\Windows\\System32\\cmd.exe'
		else '' // unknown operating system
	}

	def private String getArgsDefault(String it) {
		if (isUnix) '-lc "${script} ${project} ${path}"'
		else if (isWindows) '/k ${script} ${project} ${path}' 
		else '' // unknown operating system
	}
	
	def private String getScriptDefault(String it) {
		if (isUnix) scriptForUnix 
		else if (isWindows) scriptForWindows 
		else '' // unknown operating system
	}
	
	def private String getScriptForUnix() '''
		#!/bin/bash
		echo "Initialize JHipster project $1"
		export PATH=$PATH:/usr/local/bin:$HOME/.nvm:$HOME/.yarn/bin
		export NVM_DIR="$HOME/.nvm"
		[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"
		command yarn || export PATH="$PATH:`yarn global bin`:$HOME/.config/yarn/global/node_modules/.bin"
		command jhipster || { echo >&2 "JHipster is required but it's not installed!"; }
		[ -d ./bin ] && rm -rf ./bin # remove bin folder created by eclipse
		bash
	'''
	
	def private String getScriptForWindows() '''
		@echo off
		@echo Initialize JHipster project %1
		set PATH=%PATH%;C:\Windows\System32;
		call jhipster || echo JHipster generator is required but it's not installed!
		if exist bin rd /q /s bin
	'''
	
	def private isWindows(String os) {
		return os !== null && os.contains('win')
	}

	def private isUnix(String os) {
		return os !== null && os.contains('mac') || os.contains('linux')
	}
}
