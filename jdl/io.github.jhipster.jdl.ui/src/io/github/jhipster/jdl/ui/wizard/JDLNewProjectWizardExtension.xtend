package io.github.jhipster.jdl.ui.wizard

import com.google.inject.Inject
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Path
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.core.variables.VariablesPlugin
import org.eclipse.jface.preference.IPreferenceStore
import org.eclipse.tm.terminal.view.core.interfaces.ITerminalService
import org.eclipse.ui.console.ConsolePlugin
import org.eclipse.xtext.ui.wizard.IProjectCreator

import static io.github.jhipster.jdl.ui.internal.JdlActivator.*
import static io.github.jhipster.jdl.ui.preference.JDLPreferenceProperties.*
import static io.github.jhipster.jdl.ui.terminal.TerminalHelper.*
import static java.nio.file.Files.*
import static java.nio.file.attribute.PosixFilePermission.*
import static java.nio.file.attribute.PosixFilePermissions.*
import static org.eclipse.jface.dialogs.MessageDialog.*

class JDLNewProjectWizardExtension extends JDLNewProjectWizardEnhanced {

	val JDL_PERSPECTIVE_ID = 'io.github.jhipster.jdl.ui.view.JDLPerspective' 

	IPreferenceStore preferenceStore
	VariablesPlugin variablesPlugin
	Path shellScript

	@Inject new(IProjectCreator projectCreator) {
		super(projectCreator)
		preferenceStore = instance.preferenceStore
		variablesPlugin = VariablesPlugin.^default
	}

	override performFinish() {
		val result = super.performFinish
		if (mainPage.isCallJhipsterGenerator) openTerminal
		return result
	}

	def private void openTerminal() {
		if (exec.isNullOrEmpty) return
		val project = mainPage.projectName
		val location = mainPage.location + File.separator + project
		prepare(project, location)
		openTerminal(project, location, exec, args, done, envs)
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

	def private void openJDLPerspective() {
		openPerspective(JDL_PERSPECTIVE_ID)
	}
	
	def private void openPerspective(String perspectiveID) {
		val window = workbench.activeWorkbenchWindow
		try {
			workbench.showPerspective(perspectiveID, window)
		} catch (Exception e) {
			openError(window.shell, 'Error Opening Perspective', '''Could not open Perspective with ID: «perspectiveID»''')
		}
	}

	def private void prepare(String project, String location) {
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

	def private boolean isShellEnabled() {
		preferenceStore.getBoolean(P_ShellEnabled)
	}

	def private String getExec() {
		preferenceStore.getString(P_Exec)
	}

	def private String getArgs() {
		expandVars(preferenceStore.getString(P_Args))
	}

	def private String getScript() {
		expandVars(preferenceStore.getString(P_Script))
	}

	def private String[] getEnvs() {
// FIXME: add better ui implementation for this...
//		val envs = preferenceStore.getString(P_Envs)
//		if(!envs.isNullOrEmpty) expandVars(envs).split(' ').toArray(#[])
		return null
	}

	def private bindVariable(String name, String value) {
		variablesPlugin.stringVariableManager => [
			val vardef = #[newValueVariable(name, '''Variable «name»''', true, value)]
			removeVariables(vardef)
			addVariables(vardef)
		]
	}

	def private String expandVars(String input) {
		variablesPlugin.stringVariableManager.performStringSubstitution(input, false)
	}
}
