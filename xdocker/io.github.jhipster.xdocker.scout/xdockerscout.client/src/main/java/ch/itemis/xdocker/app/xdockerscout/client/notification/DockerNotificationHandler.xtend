package ch.itemis.xdocker.app.xdockerscout.client.notification

import ch.itemis.xdocker.app.xdockerscout.shared.notification.DockerNotification
import org.eclipse.scout.rt.client.clientnotification.AbstractObservableNotificationHandler
import org.eclipse.scout.rt.client.context.ClientRunContexts
import org.eclipse.scout.rt.client.job.ModelJobs
import org.eclipse.scout.rt.platform.util.concurrent.IRunnable
import org.eclipse.scout.rt.shared.clientnotification.IClientNotificationAddress

class DockerNotificationHandler extends AbstractObservableNotificationHandler<DockerNotification> {

	override handleNotification(DockerNotification notification, IClientNotificationAddress address) {
		ModelJobs.schedule(new IRunnable() {
			override run() throws Exception {
				DockerNotificationHandler.super.handleNotification(notification, address);
			}
		}, ModelJobs.newInput(ClientRunContexts.copyCurrent()));
	}
}
