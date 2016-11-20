/** 
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ch.itemis.xdocker.ui.job

import org.eclipse.core.runtime.Status
import org.eclipse.xtend.lib.annotations.Accessors

import static xdockerdsl.ui.internal.XdockerdslActivator.*

/** 
 * XdockerJobStatus Class
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerJobStatus extends Status {

	@Accessors var Object argument

	new(int severity, String pluginId, int code, String message, Throwable exception) {
		super(severity, pluginId, code, message, exception)
		argument = null
	}
	
	new(int severity, String pluginId, int code, String message, Object argument) {
		this(severity, pluginId, code, message, null)
		this.argument = argument
	}
	
	def static XdockerJobStatus createJobOkStatus(Object argument) {
		val status = new XdockerJobStatus(OK, CH_ITEMIS_XDOCKER_XDOCKER, OK, "finished successfully", null)		
		status.argument = argument
		return status
	}

	def static XdockerJobStatus createJobOkStatus() {
		return new XdockerJobStatus(OK, CH_ITEMIS_XDOCKER_XDOCKER, OK, "finished successfully", null)		
	}
}
