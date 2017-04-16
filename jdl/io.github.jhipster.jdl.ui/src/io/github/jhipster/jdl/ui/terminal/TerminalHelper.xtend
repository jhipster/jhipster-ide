package io.github.jhipster.jdl.ui.terminal

import com.google.inject.Singleton
import java.io.File
import org.eclipse.tm.terminal.view.core.TerminalServiceFactory
import org.eclipse.tm.terminal.view.core.interfaces.ITerminalService.Done
import org.eclipse.tm.terminal.view.ui.view.TerminalsView
import org.eclipse.ui.PartInitException
import org.eclipse.ui.PlatformUI

import static org.eclipse.core.runtime.Assert.*
import static org.eclipse.jface.dialogs.MessageDialog.*
import static org.eclipse.tm.terminal.view.core.interfaces.constants.ITerminalsConnectorConstants.*

@Singleton
final class TerminalHelper {

	val static ENCODING = 'UTF-8'
	val static TERMINAL_VIEW_ID = 'org.eclipse.tm.terminal.view.ui.TerminalsView'
	val static DELEGATE_ID = 'org.eclipse.tm.terminal.connector.local.launcher.local'

	def static void openTerminal(String project, String location, String executable, String args, Done doneCallback, String[] envs) {
		#[project, location, executable].forEach[isNotNull(it)] // Check if we have all mandatory parameters
		val workbench = PlatformUI.workbench
		val display = workbench.display
		val shell = display.activeShell
		display.asyncExec(new Runnable {
			override run() {
				try {
					val folder = new File(location)
					if (!folder.exists) folder.mkdirs
					newHashMap => [
						put(PROP_TITLE, '''«project»''')
						put(PROP_ENCODING, ENCODING)
						put(PROP_DELEGATE_ID, DELEGATE_ID)
						put(PROP_PROCESS_PATH, executable)
						put(PROP_PROCESS_WORKING_DIR, location)
						put(PROP_PROCESS_MERGE_ENVIRONMENT, true)
						put(PROP_LOCAL_ECHO, false)
						// put(PROP_FORCE_NEW, true)
						if (!envs.isNullOrEmpty) put(PROP_PROCESS_ENVIRONMENT, envs)
						if (!args.isNullOrEmpty) put(PROP_PROCESS_ARGS, args)
						// Show terminal view
						workbench.activeWorkbenchWindow.activePage.showView(
							TERMINAL_VIEW_ID
						) as TerminalsView => [
							show(null)
							setFocus
						]
						// and open the terminal
						TerminalServiceFactory.service => [ terminal |
							val props = it
							if (terminal !== null) terminal.openConsole(props, doneCallback)
						]
					]
				} catch (PartInitException e) {
					openError(shell, 'Error opening terminal', e.message)
				}
			}
		})
	}
}
