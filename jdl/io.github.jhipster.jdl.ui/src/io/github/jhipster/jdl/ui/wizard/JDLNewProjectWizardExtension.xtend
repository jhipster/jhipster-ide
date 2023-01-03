/**
 * Copyright 2016-2023 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.ui.wizard

import com.google.inject.Inject
import java.nio.charset.Charset
import java.nio.file.Path
import java.util.concurrent.atomic.AtomicReference
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.core.variables.VariablesPlugin
import org.eclipse.jface.preference.IPreferenceStore
import org.eclipse.swt.widgets.Display
import org.eclipse.tm.terminal.view.core.interfaces.ITerminalService
import org.eclipse.ui.IWorkbench
import org.eclipse.ui.IWorkbenchWindow
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.console.ConsolePlugin
import org.eclipse.xtext.ui.wizard.template.TemplateProjectInfo

import static io.github.jhipster.jdl.ui.internal.JdlActivator.*
import static io.github.jhipster.jdl.ui.preference.JDLPreferenceProperties.*
import static io.github.jhipster.jdl.ui.terminal.TerminalHelper.*
import static java.nio.file.Files.*
import static java.nio.file.attribute.PosixFilePermission.*
import static java.nio.file.attribute.PosixFilePermissions.*
import static org.eclipse.jface.dialogs.MessageDialog.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JDLNewProjectWizardExtension {

	val JDL_PERSPECTIVE_ID = 'io.github.jhipster.jdl.ui.view.JDLPerspective' 

	IPreferenceStore preferenceStore
	VariablesPlugin variablesPlugin
	Path shellScript
    IWorkbench workbench

	@Inject new() {
	    this.workbench = PlatformUI.workbench
		this.preferenceStore = instance.preferenceStore
		this.variablesPlugin = VariablesPlugin.^default
	}

	def void openTerminal(TemplateProjectInfo projectInfo, String project, String location) {
		if (exec.isNullOrEmpty) return;
		prepare(project, location)
		val cliArgs = if (projectInfo.projectTemplate instanceof JHipsterProjectFromCli) args
        openTerminal(project, location, exec, cliArgs, done, envs)
	}

	def done() {
		openJDLPerspective
		new ITerminalService.Done() {
			override void done(IStatus it) {
				if (!isOK) {
					new Status(
						severity, IO_GITHUB_JHIPSTER_JDL_JDL, code, message, exception
					) => [
						ConsolePlugin.log(it)
					]
				}
			}
		}
	}

	def void openJDLPerspective() {
		openPerspective(JDL_PERSPECTIVE_ID)
	}
	
	def void openPerspective(String perspectiveID) {
	    val window = new AtomicReference<IWorkbenchWindow>
		try {
            Display.getDefault().asyncExec [
                PlatformUI.workbench.activeWorkbenchWindow => [
                    window.set = it
                    workbench.showPerspective(perspectiveID, it)
                ]
            ]
		} catch (Exception ex) {
		    if (window.get !== null) openError(window.get.shell, 'Error Opening Perspective', '''Could not open Perspective with ID: «perspectiveID»''')
		    ex.printStackTrace
		}
	}

	def void prepare(String project, String location) {
		if (!isShellEnabled || script.isNullOrEmpty) return
		val isWindows = System.getProperty('os.name').toLowerCase.contains('win')
		shellScript = if (isWindows) createTempFile('jhide', '.cmd') 
			else createTempFile('jhide', '.sh', asFileAttribute(#{
				OWNER_READ, OWNER_WRITE, OWNER_EXECUTE
			}))
		shellScript.toFile.deleteOnExit
		val content = newArrayList
		if (isWindows && !envs.isNullOrEmpty) {
			envs.forEach[content.add('''set «it»''')]
		} 
		content.add(script)
		write(shellScript, content, Charset.forName("UTF-8"))
		#['script' -> shellScript.toString, 'project' -> project, 'path' -> location].forEach[ 
			bindVariable(key, value)
		]
	}

	def boolean isShellEnabled() {
		preferenceStore.getBoolean(P_ShellEnabled)
	}

	def String getExec() {
		preferenceStore.getString(P_Exec)
	}

	def String getArgs() {
		expandVars(preferenceStore.getString(P_Args))
	}

	def String getScript() {
		expandVars(preferenceStore.getString(P_Script))
	}

	def String[] getEnvs() {
// FIXME: add better ui implementation for this...
//		val envs = preferenceStore.getString(P_Envs)
//		if(!envs.isNullOrEmpty) expandVars(envs).split(' ').toArray(#[])
		return null
	}

	def bindVariable(String name, String value) {
		variablesPlugin.stringVariableManager => [
			val vardef = #[newValueVariable(name, '''Variable «name»''', true, value)]
			removeVariables(vardef)
			addVariables(vardef)
		]
	}

	def String expandVars(String input) {
		variablesPlugin.stringVariableManager.performStringSubstitution(input, false)
	}
}
