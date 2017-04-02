package io.github.jhipster.jdl.ui.wizard

import com.google.inject.Inject
import io.github.jhipster.jdl.ui.wizard.page.JDLOptionWizardPage
import java.io.BufferedOutputStream
import org.eclipse.tm.terminal.view.ui.view.TerminalsView
import org.eclipse.ui.PartInitException
import org.eclipse.xtext.ui.wizard.IProjectCreator

import static org.eclipse.tm.terminal.view.core.TerminalServiceFactory.*
import static org.eclipse.tm.terminal.view.core.interfaces.constants.ITerminalsConnectorConstants.*

class JDLNewProjectWizardExtension extends JDLNewProjectWizard {

	val static TERMINAL_VIEW_ID = 'org.eclipse.tm.terminal.view.ui.TerminalsView'
	val static DELEGATE_ID = 'org.eclipse.tm.terminal.connector.streams.launcher.streams'
	val static TERMINAL_CONNECTOR_ID = 'org.eclipse.tm.terminal.connector.streams.StreamsConnector'
	val static PREVENT_JVM_GC_FINALIZE = 'PREVENT_JVM_GC_FINALIZE'

	var JDLOptionWizardPage optionPage

	@Inject new(IProjectCreator projectCreator) {
		super(projectCreator)
	}

	override addPages() {
		super.addPages
		optionPage = new JDLOptionWizardPage('JHipster Options')
		optionPage.setTitle("Generator Options")
		optionPage.setDescription("JHipster Generator Options")
		addPage(optionPage)
	}

	override performFinish() {
		val result = super.performFinish
		if (optionPage.isCallJhipsterGenerator) openTerminal
		return result
	}

	def private openTerminal() {
		workbench.display.asyncExec(new Runnable {
			override run() {
				try {
					val tout = System.out
					val tin = System.in
					val pty_stream = new BufferedOutputStream(System.out)
					//
					newHashMap => [
						put(PROP_DELEGATE_ID, DELEGATE_ID)
						put(PROP_TERMINAL_CONNECTOR_ID, TERMINAL_CONNECTOR_ID)
						put(PROP_TITLE, "JHipster")
						put(PROP_LOCAL_ECHO, false)
						put(PROP_FORCE_NEW, true)
						put(PROP_STREAMS_STDIN, tout)
						put(PROP_STREAMS_STDOUT, tin)
						put(PROP_DATA, pty_stream)
						put(PREVENT_JVM_GC_FINALIZE, pty_stream)
						workbench.activeWorkbenchWindow.activePage.showView(
							TERMINAL_VIEW_ID
						) as TerminalsView => [
							show(null)
							setFocus
						]
						service.openConsole(it, null)
					]
				} catch (PartInitException e) {
					e.printStackTrace()
				}
			}
		})
	}
}
