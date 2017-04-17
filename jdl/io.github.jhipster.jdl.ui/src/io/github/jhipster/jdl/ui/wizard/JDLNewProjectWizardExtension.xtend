package io.github.jhipster.jdl.ui.wizard

import com.google.inject.Inject
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files
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
import static java.nio.file.attribute.PosixFilePermission.*
import static java.nio.file.attribute.PosixFilePermissions.*

class JDLNewProjectWizardExtension extends JDLNewProjectWizardEnhanced {

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
		if(mainPage.isCallJhipsterGenerator()) openTerminal
		return result
	}

	def private void openTerminal() {
		if (exec.isNullOrEmpty) return
		val project = mainPage.projectName
		val location = mainPage.location + File.separator + project
		prepare(project, location)
		openTerminal(
			project, location, exec, args, done, envs
		)
	}

	def done() {
		new ITerminalService.Done() {
			override void done(IStatus it) {
				if (!isOK) {
					new Status(severity, IO_GITHUB_JHIPSTER_JDL_JDL, code, message, exception) => [
						ConsolePlugin.log(it)
					]
				}
				// remove temporary files...
				val shellScripFile = shellScript?.toFile
				if (shellScripFile !== null && shellScripFile.canWrite) {
					shellScripFile.delete
				}
			}
		}		
	}

	def private prepare(String project, String location) {
		if (script.isNullOrEmpty) return
		val perms = asFileAttribute(#{OWNER_READ, OWNER_WRITE, OWNER_EXECUTE})
		shellScript = Files.createTempFile('jhide', '.sh', perms)
		Files.write(shellScript, #[script], Charset.forName("UTF-8"))
		#['script' -> shellScript.toString, 'project' -> project, 
		  'path' -> location, 'switch' -> '--creation'
		 ].forEach[ bindVariable(key, value) ]
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
		val envs = preferenceStore.getString(P_Envs)
		if(!envs.isNullOrEmpty) expandVars(envs).split(' ').toArray(#[]) else null
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
