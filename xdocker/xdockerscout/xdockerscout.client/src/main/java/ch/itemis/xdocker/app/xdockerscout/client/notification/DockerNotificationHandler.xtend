package ch.itemis.xdocker.app.xdockerscout.client.notification

import ch.itemis.xdocker.app.xdockerscout.shared.notification.DockerNotification
import org.eclipse.scout.rt.client.clientnotification.AbstractObservableNotificationHandler
import org.eclipse.scout.rt.client.context.ClientRunContexts
import org.eclipse.scout.rt.client.job.ModelJobs
import org.eclipse.scout.rt.platform.util.concurrent.IRunnable

class DockerNotificationHandler extends AbstractObservableNotificationHandler<DockerNotification> {

	override handleNotification(DockerNotification notification) {
		ModelJobs.schedule(new IRunnable() {
			override run() throws Exception {
				DockerNotificationHandler.super.handleNotification(notification);
			}
		}, ModelJobs.newInput(ClientRunContexts.copyCurrent()));
	}
}
