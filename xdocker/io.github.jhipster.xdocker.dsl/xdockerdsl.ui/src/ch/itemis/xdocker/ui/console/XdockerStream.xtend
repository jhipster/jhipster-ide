/** 
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ch.itemis.xdocker.ui.console

import java.io.IOException
import java.io.OutputStream
import java.util.ArrayList
import java.util.List

/** 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerStream extends OutputStream {
	private IConsoleLogger logger
	private val List<String> buffer = new ArrayList

	new(IConsoleLogger logger) {
		if (logger === null) {
			throw new IllegalArgumentException('argument "logger" cannot be null!')
		}
		this.logger = logger
	}

	def public print(String message) {
		buffer.add(message)
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see OutputStream#write(int)
	 */
	override void write(int b) throws IOException {
		buffer.add(Character.toString(b as char))
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see OutputStream#flush()
	 */
	override void flush() throws IOException {
		val sb = new StringBuffer().append(buffer)
		logger.log(sb.toString)
		buffer.clear
	}
}
