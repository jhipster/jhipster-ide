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
 package io.github.jhipster.jdl.web

import java.net.InetSocketAddress
import org.eclipse.jetty.annotations.AnnotationConfiguration
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.util.log.Slf4jLog
import org.eclipse.jetty.webapp.MetaInfConfiguration
import org.eclipse.jetty.webapp.WebAppContext
import org.eclipse.jetty.webapp.WebInfConfiguration
import org.eclipse.jetty.webapp.WebXmlConfiguration

/**
 * This program starts an HTTP server for testing the web integration of your DSL.
 * Just execute it and point a web browser to http://localhost:8080/
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class ServerLauncher {
	def static void main(String[] args) {
		val server = new Server(new InetSocketAddress('localhost', 18080))
		server.handler = new WebAppContext => [
			resourceBase = 'WebRoot'
			welcomeFiles = #["index.html"]
			contextPath = "/"
			configurations = #[
				new AnnotationConfiguration,
				new WebXmlConfiguration,
				new WebInfConfiguration,
				new MetaInfConfiguration
			]
			setAttribute(WebInfConfiguration.CONTAINER_JAR_PATTERN, '.*/io\\.github\\.jhipster\\.jdl\\.web/.*,.*\\.jar')
			setInitParameter("org.mortbay.jetty.servlet.Default.useFileMappedBuffer", "false")
		]
		val log = new Slf4jLog(ServerLauncher.name)
		try {
			server.start
			log.info('Server started ' + server.getURI + '...')
			new Thread[
				log.info('Press enter to stop the server...')
				val key = System.in.read
				if (key !== -1) {
					server.stop
				} else {
					log.warn('Console input is not available. In order to stop the server, you need to cancel process manually.')
				}
			].start
			server.join
		} catch (Exception exception) {
			log.warn(exception.message)
			System.exit(1)
		}
	}
}
