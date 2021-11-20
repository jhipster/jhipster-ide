package ch.itemis.xdocker.ui.handler

import ch.itemis.xdocker.ui.job.XdockerJobStatus
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.commands.IHandler

import static org.eclipse.core.runtime.IStatus.*
import static xdockerdsl.ui.internal.XdockerdslActivator.*

import static extension org.eclipse.ui.handlers.HandlerUtil.*

/** 
 * Xdocker handler class to search Docker images.
 * 
 * @see IHandler
 * @see AbstractHandler
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerSearchImagesHandler extends AbstractHandler {
	static final String ERR_SEARCHING_IMAGE = 'Error opening search image browser'
	static final String IMAGE_BROWESER_ID = 'ch.itemis.xdocker.ui.view.xdockerImageBrowserView'

    /* 
     * (non-Javadoc)
     * 
     * @see IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
     */
	override Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			event.activeWorkbenchWindow.activePage => [
				showView(IMAGE_BROWESER_ID)
			]
			return XdockerJobStatus.createJobOkStatus
		} catch (Exception ex) {
			return new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, ERR_SEARCHING_IMAGE, ex)
		}
	}
}
