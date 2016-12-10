/** 
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ch.itemis.xdocker.lib

import org.eclipse.xtend.lib.annotations.Data

/** 
 * Docker Properties Class
 * 
 * @author Serano Colameo - Initial contribution and API
 */
@Data
final class DockerProperties {
	val String url
	val Boolean enableLoggingFilter
	val String dockerCertPath
	val String dockerCfgPath
	val String serverAddress
	val String username
	val String password
	val String projectPath
}
