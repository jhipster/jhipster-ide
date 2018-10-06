package ch.itemis.xdocker.ui.handler

import ch.itemis.xdocker.ui.job.XdockerInfoJob
import ch.itemis.xdocker.ui.job.XdockerJobStatus
import java.util.Stack
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.commands.IHandler
import org.eclipse.swt.widgets.Display

import static org.eclipse.core.runtime.IStatus.*
import static xdockerdsl.ui.internal.XdockerdslActivator.*

import static extension ch.itemis.xdocker.ui.job.AbstractXdockerJob.*
import static extension ch.itemis.xdocker.ui.util.MessageUtil.*
import static extension org.eclipse.ui.handlers.HandlerUtil.*

/** 
 * Xdocker handler class to handle "Docker Info".
 * 
 * @see IHandler
 * @see AbstractHandler
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerDockerInfoHandler extends AbstractHandler {
	static final String MESSGAE_TITLE = 'Docker Info'
	static final String MESSGAE_INFO_TITLE = 'Docker Configuration and Information'
	static final String MESSGAE_ERRTITLE = 'Unexpected Error'
	static final String MESSGAE_ERROR = 'Error getting info from docker'

    /* 
     * (non-Javadoc)
     * 
     * @see IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
     */
	override Object execute(ExecutionEvent event) throws ExecutionException {
		val shell = event.activeShell
		val status = new Stack
		try {
			XdockerInfoJob.create => [
				execute [it, result |
					val info = result.argument?.toString
				    Display.^default.asyncExec(new Runnable {
						override run() {
							if (!info.nullOrEmpty) {
								shell.infoBox(MESSGAE_TITLE, MESSGAE_INFO_TITLE, info)
							}
						}
				    })
				    status.push = result
				]
			]
		} catch (Exception e) {
			status.push = new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, MESSGAE_ERROR, e)
			shell.error(MESSGAE_ERRTITLE, e.message)
		}
		return status.last
	}
}
