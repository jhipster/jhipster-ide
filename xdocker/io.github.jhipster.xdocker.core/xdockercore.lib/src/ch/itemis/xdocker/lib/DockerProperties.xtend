/** 
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ch.itemis.xdocker.lib

import ch.itemis.xdocker.base.processor.ConfigProperty
import org.eclipse.xtend.lib.annotations.Data

import static com.github.dockerjava.core.DefaultDockerClientConfig.*

/** 
 * Docker Properties Class
 * 
 * @author Serano Colameo - Initial contribution and API
 */
@Data
final class DockerProperties {
	// Xdocker properties
	@ConfigProperty val Boolean enableLoggingFilter
	@ConfigProperty val String projectPath

	// Docker CLI properties 
	@ConfigProperty(DOCKER_HOST) val String dockerHost
	@ConfigProperty(DOCKER_CERT_PATH) val String dockerCertPath
	@ConfigProperty(DOCKER_CONFIG) val String dockerConfig
	@ConfigProperty(DOCKER_TLS_VERIFY) val String dockerTlsVerify
	@ConfigProperty(REGISTRY_URL) val String registryUrl
	@ConfigProperty(REGISTRY_USERNAME) val String registryUsername
	@ConfigProperty(REGISTRY_PASSWORD) val String registryPassword
	@ConfigProperty(REGISTRY_EMAIL) val String registryEmail
	@ConfigProperty(API_VERSION) val String apiVersion
}
