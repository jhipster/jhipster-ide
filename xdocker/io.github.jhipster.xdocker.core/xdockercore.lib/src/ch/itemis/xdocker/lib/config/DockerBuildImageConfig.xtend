/*******************************************************************************
 * Copyright (c) 2015-2021 Arcware GmbH (http://arcware.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.lib.config

import org.eclipse.xtend.lib.annotations.Data

/**
 * Docker Build Image Config
 * 
 * @author Serano Colameo - Initial contribution and API
 */
@Data
class DockerBuildImageConfig {
	val String project
	val String xdockerFileName
	val Boolean hasParams
	val String tag
	val Boolean noCache
	val Boolean rm
	val Boolean quiet
	val Boolean pull
}