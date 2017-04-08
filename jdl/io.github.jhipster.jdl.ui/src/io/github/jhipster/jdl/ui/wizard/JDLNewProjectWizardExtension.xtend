package io.github.jhipster.jdl.ui.wizard

import com.google.inject.Inject
import java.io.File
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.tm.terminal.view.core.TerminalServiceFactory
import org.eclipse.tm.terminal.view.core.interfaces.ITerminalService
import org.eclipse.tm.terminal.view.ui.view.TerminalsView
import org.eclipse.ui.PartInitException
import org.eclipse.ui.console.ConsolePlugin
import org.eclipse.xtext.ui.wizard.IProjectCreator

import static org.eclipse.jface.dialogs.MessageDialog.*
import static org.eclipse.tm.terminal.view.core.interfaces.constants.ITerminalsConnectorConstants.*

class JDLNewProjectWizardExtension extends JDLNewProjectWizardEnhanced {

	val static ENCODING = 'UTF-8'
	val static TERMINAL_VIEW_ID = 'org.eclipse.tm.terminal.view.ui.TerminalsView'
	val static DELEGATE_ID = 'org.eclipse.tm.terminal.connector.local.launcher.local'

	@Inject new(IProjectCreator projectCreator) {
		super(projectCreator)
	}

	override performFinish() {
		val result = super.performFinish
		if (getMainPage().isCallJhipsterGenerator()) openTerminal
		return result
	}
	
	def private openTerminal() {
		workbench.display.asyncExec(new Runnable {
			override run() {
				try {
					val project = mainPage.projectName
					val location = mainPage.location + File.separator + project
					val folder = new File(location)
					if (!folder.exists) folder.mkdirs
					newHashMap => [
						put(PROP_TITLE, '''«project»''')
						put(PROP_ENCODING, ENCODING)
						put(PROP_DELEGATE_ID, DELEGATE_ID)
						put(PROP_PROCESS_PATH, '/bin/bash')
						put(PROP_PROCESS_ARGS, '-lc "yo jhipster"')
						put(PROP_PROCESS_WORKING_DIR, location)
						put(PROP_PROCESS_MERGE_ENVIRONMENT, true)
						put(PROP_LOCAL_ECHO, false)
						// Create the done callback object
						val ITerminalService.Done done = new ITerminalService.Done() {
						    override void done(IStatus done) {
						    	ConsolePlugin.log(Status.OK_STATUS)
						    }
						}
						workbench.activeWorkbenchWindow.activePage.showView(
							TERMINAL_VIEW_ID
						) as TerminalsView => [
							show(null)
							setFocus
						]
						// Open the terminal
						TerminalServiceFactory.service => [ terminal |
							if (terminal !== null) terminal.openConsole(it, done)
						]
					]
				} catch (PartInitException e) {
					openError(shell, 'Error opening terminal', e.message)
				}
			}
		})
	}
}
