/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis-schweiz.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.launch.shortcut

import ch.itemis.xdocker.ui.job.XdockerGenerateJob
import org.eclipse.core.resources.IFile

import static extension ch.itemis.xdocker.ui.job.AbstractXdockerJob.*

/**
 * Xdocker generate launch shortcut allowing to generate a Dockerfile from IDE.
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerGenerateLaunchShortcut extends AbstractXdockerLaunchShortcut {

	override protected createXdockerJob(IFile dockerfile) {
		XdockerGenerateJob.create(#{
			'dockerfile' -> dockerfile, 
			'generator' -> generator
		})
	}	
}
