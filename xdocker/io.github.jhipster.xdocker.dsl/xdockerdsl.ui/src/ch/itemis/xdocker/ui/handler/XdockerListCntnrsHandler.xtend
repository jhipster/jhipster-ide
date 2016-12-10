package ch.itemis.xdocker.ui.handler

import ch.itemis.xdocker.ui.job.XdockerJobStatus
import ch.itemis.xdocker.ui.job.XdockerListCntnrsJob
import java.util.Stack
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.commands.IHandler

import static extension ch.itemis.xdocker.ui.job.AbstractXdockerJob.*
import static extension org.eclipse.ui.handlers.HandlerUtil.*
import static extension ch.itemis.xdocker.ui.util.MessageUtil.*
import static org.eclipse.core.runtime.IStatus.*
import static xdockerdsl.ui.internal.XdockerdslActivator.*

/** 
 * Xdocker handler class to handle "List Docker Containers".
 * 
 * @see IHandler
 * @see AbstractHandler
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerListCntnrsHandler extends AbstractHandler {
	private static final String MESSGAE_ERRTITLE = 'Unexpected Error'
	private static final String MESSGAE_ERROR = 'Error list docker containers'
	private static final String CONTAINER_BROWESER_ID = 'ch.itemis.xdocker.ui.view.xdockerContainerBrowserView'

    /* 
     * (non-Javadoc)
     * 
     * @see IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
     */
	override Object execute(ExecutionEvent event) throws ExecutionException {
		val shell = event.activeShell
		val status = new Stack
//		try {
//			XdockerListCntnrsJob.create(#{
//				'listAll' -> true
//			}) => [
//				schedule
//			]
		try {
			event.activeWorkbenchWindow.activePage => [
				showView(CONTAINER_BROWESER_ID)
			]
			return XdockerJobStatus.createJobOkStatus
		} catch (Exception ex) {
			return new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, MESSGAE_ERROR, ex)
		}

//			status.push = XdockerJobStatus.createJobOkStatus
//		} catch (Exception e) {
//			status.push = new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, MESSGAE_ERROR, e)
//			shell.error(MESSGAE_ERRTITLE, e.message)
//		}
//		return status.last
	}
}
