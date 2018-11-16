/**
 * Copyright 2013-2018 the original author or authors from the JHipster project.
 *
 * This file is part of the JHipster project, see http://www.jhipster.tech/
 * for more information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.jhipster.jdl.config

import com.google.inject.Singleton
import org.eclipse.xtend.lib.annotations.Accessors

import static io.github.jhipster.jdl.config.JdlParameterType.*

/**
 * @author Serano Colameo - Initial contribution and API
 */ 
@Singleton
class JdlDeploymentOptions extends JdlAbstractOptions {
	
	private new() {} // this is a singleton!
	
	public static val JH_VERSION = 'jhipsterVersion'
	public static val SERVER_PORT = 'serverPort'
	
	@Accessors(PUBLIC_GETTER) val static INSTANCE = new JdlDeploymentOptions => [
		addAll(#[
			new JdlOption('deploymentType', #['docker-compose', 'kubernetes', 'openshift', 'rancher-compose']),
			new JdlOption('directoryPath', #['"../"'], AnyLiteral),
			new JdlOption('appsFolders', ListOfAnyLiterals),
			new JdlOption('clusteredDbApps', #[], ListOfAnyLiterals),
			new JdlOption('gatewayType', #['zuul', 'traefik']),
			new JdlOption('monitoring', #['no', 'elk', 'prometheus']),
			new JdlOption('consoleOptions', #['curator', 'zipkin'], ListOfLiterals),
			new JdlOption('serviceDiscoveryType', #['eureka', 'consul', 'no']),
			new JdlOption('dockerRepositoryName', String),
			new JdlOption('dockerPushCommand', #['"docker push"'], AnyLiteral),
			new JdlOption('kubernetesNamespace', #['default'], AnyLiteral),
			new JdlOption('kubernetesServiceType', #['LoadBalancer', 'NodePort', 'Ingress']),
			new JdlOption('ingressDomain', #['"Ingress"'], AnyLiteral),
			new JdlOption('istio', #['no', 'manualInjection', 'autoInjection']),
			new JdlOption('istioRoute', Boolean),
			new JdlOption('openshiftNamespace', Boolean),
			new JdlOption('enableRancherLoadBalancing', Boolean),
			new JdlOption('storageType', #['ephemeral', 'persistent'])
		])
	]
}
