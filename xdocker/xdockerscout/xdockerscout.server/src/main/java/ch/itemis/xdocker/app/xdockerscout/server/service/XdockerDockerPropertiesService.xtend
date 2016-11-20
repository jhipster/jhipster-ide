package ch.itemis.xdocker.app.xdockerscout.server.service

import ch.itemis.xdocker.app.xdockerscout.shared.prefs.ReadXdockerDockerPropertiesPermission
import ch.itemis.xdocker.app.xdockerscout.shared.prefs.UpdateXdockerDockerPropertiesPermission
import ch.itemis.xdocker.app.xdockerscout.shared.prefs.XdockerDockerPreferncesFormData
import org.eclipse.scout.rt.platform.exception.VetoException
import org.eclipse.scout.rt.shared.TEXTS
import org.eclipse.scout.rt.shared.services.common.security.ACCESS
import org.slf4j.LoggerFactory

import static ch.itemis.xdocker.app.xdockerscout.shared.prefs.XdockerDockerPropertiesConverter.*
import ch.itemis.xdocker.lib.util.DockerPropertiesUtil
import ch.itemis.xdocker.app.xdockerscout.shared.service.IXdockerDockerPropertiesService

class XdockerDockerPropertiesService implements IXdockerDockerPropertiesService {
	
	static val LOG = LoggerFactory.getLogger(XdockerDockerPropertiesService)
		
	override XdockerDockerPreferncesFormData load() {
		var XdockerDockerPreferncesFormData data = new XdockerDockerPreferncesFormData
		if (!ACCESS.check(new ReadXdockerDockerPropertiesPermission())) {
			throw new VetoException(TEXTS.get("AuthorizationFailed"))
		}
		try {
			LOG.info('Load form data')
			val props = DockerPropertiesUtil.loadFromDisk
			if (props != null) data = toXdockerDockerPreferncesFormData(props)
		} catch (Exception e) {
			LOG.error('Cannot load docker properties!', e)						
		}
		return data
	}

	override void store(XdockerDockerPreferncesFormData input) {
		if (!ACCESS.check(new UpdateXdockerDockerPropertiesPermission())) {
			throw new VetoException(TEXTS.get("AuthorizationFailed"))
		}
		try {
			LOG.info('Store form data')
			val props = toDockerProperties(input)
			DockerPropertiesUtil.saveToDisk(props)
		} catch (Exception e) {
			LOG.error('Cannot store docker properties!', e)						
		}
	}
}
