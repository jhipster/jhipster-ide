package ch.itemis.xdocker.app.xdockerscout.shared.notification

import java.io.Serializable
import org.eclipse.xtend.lib.annotations.Accessors

class DockerNotification implements Serializable {
	
	@Accessors var String message
	
	new (String message) {
		this.message = message
	}
}
