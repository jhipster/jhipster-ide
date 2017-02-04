/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.console

import org.eclipse.ui.console.ConsolePlugin
import org.eclipse.ui.console.IConsoleFactory
import org.eclipse.ui.console.IOConsole
import org.eclipse.ui.console.IOConsoleOutputStream
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Xdocker Console Implementation
 * 
 * @author Serano Colameo - Initial contribution and API
 */
final class XdockerConsole extends IOConsole {
	
	@Accessors private static var XdockerConsole INSTANCE = new XdockerConsole
	@Accessors private var IOConsoleOutputStream outStream
	
	new() { 
		super('Xdocker Console', 'XdockerConsole', null, true)
		initStream()
		consoleManager?.addConsoles(#[this])
	}

	static class Factory implements IConsoleFactory {
		override void openConsole() {
			INSTANCE.showConsoleView
		}
		
	}

	def static consoleManager() {
		return ConsolePlugin.^default.consoleManager
	}
	
	def showConsoleView() {
		consoleManager.showConsoleView(this)		
	}
	
	private def void initStream() {
		outStream = newOutputStream
		outStream.activateOnWrite = true
	}
	
	package def println(String message) {
		if (message !== null) {
			print(message)
			outStream.write('\n')
			outStream.flush
		}
	}
	
	package def print(String message) {
		if (message !== null) outStream.write(message)
	}
}
