/*******************************************************************************
 * Copyright (c) 2015-2021 Arcware GmbH (http://arcware.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.lib.config

import java.io.Serializable
import org.eclipse.xtend.lib.annotations.Data

/**
 * Docker Run Config
 * 
 * @author Serano Colameo - Initial contribution and API
 */
@Data
class DockerRunConfig implements Serializable {
	public static final long serialVersionUID = 6531275118539065177L;	
	val String image
	val String command
	val Boolean hasParams
	val String name
	val String[] portSpecs
	val String[] envs
	val Boolean tty
	val Boolean detached
	val Boolean keepStdinOpen
	val Boolean attachStdout
	val Boolean attachStderr
	val Boolean publishAllPorts
	val Boolean remove
}
