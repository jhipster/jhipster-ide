package ch.itemis.xdocker.app.xdockerscout.server.service

import java.util.List
import ch.itemis.xdocker.lib.DockerExtensions
import ch.itemis.xdocker.app.xdockerscout.shared.service.IXdockerSearchService

class XdockerSearchService implements IXdockerSearchService {
	DockerExtensions docker = DockerExtensions.newInstance()

	override List<String> searchImages(String term) {
		docker.search(term)
		return null
	}
	
	override listContainers(String term) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}
