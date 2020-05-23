/** 
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis-schweiz.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ch.itemis.xdocker.ui.handler

import ch.itemis.xdocker.ui.job.XdockerBuildJob
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.commands.IHandler

import static extension ch.itemis.xdocker.ui.job.AbstractXdockerJob.*

/** 
 * Xdocker Class to handle Menu Context call to "Generate Dockerfile"
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerBuildImageHandler extends AbstractXdockerHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	override Object execute(ExecutionEvent it) throws ExecutionException {
		XdockerBuildJob.create(#{
			'dockerfile' -> dockerfile, 
			'generator' -> generator
		}) => [
			schedule
		]
	}	
}
