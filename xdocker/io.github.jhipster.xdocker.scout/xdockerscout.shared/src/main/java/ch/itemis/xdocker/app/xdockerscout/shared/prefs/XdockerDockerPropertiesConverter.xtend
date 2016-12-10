package ch.itemis.xdocker.app.xdockerscout.shared.prefs

import ch.itemis.xdocker.lib.DockerProperties

class XdockerDockerPropertiesConverter {
	
	def static DockerProperties toDockerProperties(XdockerDockerPreferncesFormData data) {
		return new DockerProperties(
			data.dockerUrl.value,
			data.enableLoggingFilter.value,
			data.dockerCertPath.value,
			data.dockerConfigPath.value,
			data.dockerServerAddress.value,
			data.dockerUserName.value,
			data.dockerPassword.value,
			data.projectPath.value
		)
	}

	def static XdockerDockerPreferncesFormData toXdockerDockerPreferncesFormData(DockerProperties props) {
		return new XdockerDockerPreferncesFormData => [
			dockerUrl.value = props.url
			enableLoggingFilter.value = props.enableLoggingFilter
			dockerCertPath.value = props.dockerCertPath
			dockerConfigPath.value = props.dockerCfgPath
			dockerServerAddress.value = props.serverAddress
			dockerUserName.value = props.username
			dockerPassword.value = props.password
			projectPath.value = props.projectPath
		]
	}
}