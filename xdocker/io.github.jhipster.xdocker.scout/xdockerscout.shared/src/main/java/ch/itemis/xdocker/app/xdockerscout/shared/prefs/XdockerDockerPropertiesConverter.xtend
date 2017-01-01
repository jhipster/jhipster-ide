package ch.itemis.xdocker.app.xdockerscout.shared.prefs

import ch.itemis.xdocker.lib.DockerProperties

class XdockerDockerPropertiesConverter {

	def static DockerProperties toDockerProperties(XdockerDockerPreferncesFormData data) {
		return new DockerProperties(
			newHashMap(
				'enableLoggingFilter' -> data.enableLoggingFilter.value,
				'dockerHost' -> data.dockerUrl.value,
				'dockerCertPath' -> data.dockerCertPath.value,
				'dockerConfig' -> data.dockerConfigPath.value,
				'registryUrl' -> data.dockerServerAddress.value,
				'registryUsername' -> data.dockerUserName.value,
				'registryPassword' -> data.dockerPassword.value,
				'projectPath' -> data.projectPath.value
			)
		)
	}

	def static XdockerDockerPreferncesFormData toXdockerDockerPreferncesFormData(DockerProperties props) {
		return new XdockerDockerPreferncesFormData => [
			dockerUrl.value = props.dockerHost
			enableLoggingFilter.value = props.enableLoggingFilter
			dockerCertPath.value = props.dockerCertPath
			dockerConfigPath.value = props.dockerConfig
			dockerServerAddress.value = props.registryUrl
			dockerUserName.value = props.registryUsername
			dockerPassword.value = props.registryPassword
			projectPath.value = props.projectPath
		]
	}
}
