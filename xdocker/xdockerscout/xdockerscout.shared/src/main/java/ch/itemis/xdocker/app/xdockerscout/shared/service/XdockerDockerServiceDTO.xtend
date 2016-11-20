package ch.itemis.xdocker.app.xdockerscout.shared.service

import java.io.Serializable
import java.util.Map
import org.eclipse.scout.rt.platform.html.IHtmlContent
import org.eclipse.xtend.lib.annotations.Data

interface IImageInfo extends Serializable {
	def boolean isLocal()
}

@Data
class XdockerLocalImageInfo implements IImageInfo {
	static final long serialVersionUID = 100L
	String[] repoTags
	String id
	long created
	long virtualSize

	override boolean isLocal() {
		true
	}
}

@Data
class XdockerRemoteImageInfo implements IImageInfo {
	static final long serialVersionUID = 101L
	String name
	String description
	int starCount
	boolean isOfficial
	boolean isTrusted

	override boolean isLocal() {
		false
	}
}

interface IContainer extends Serializable {
}

@Data
class XdockerContainerInfo implements IContainer {
	static final long serialVersionUID = 102L
	String command
	long created
	String id
	String image
	String status
	String[] names
	Port[] ports
	Map<String, String> labels

	@Data
	static class Port implements Serializable {
		static final long serialVersionUID = 103L
		String ip
		Integer privatePort
		Integer publicPort
		String type
	}
}

@Data
class XdockerInfo implements Serializable {
	static final long serialVersionUID = 104L
	Map<String, String> attributes;
}

