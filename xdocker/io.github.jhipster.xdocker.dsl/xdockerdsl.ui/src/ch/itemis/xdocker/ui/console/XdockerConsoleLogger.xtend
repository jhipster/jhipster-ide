/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.console

import java.io.PrintStream
import org.apache.log4j.Logger
import org.apache.log4j.PatternLayout
import org.apache.log4j.WriterAppender
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Xdocker Console Logger Class
 * 
 * @author Serano Colameo - Initial contribution and API
 */
final class XdockerConsoleLogger implements IConsoleLogger {

	private var XdockerConsole console 

	@Accessors private val static INSTANCE = new XdockerConsoleLogger

	private new() {
		initialize
	}

	private def initialize() {
		console = XdockerConsole.INSTANCE
		redirect
//		console.showConsoleView		
	}

	override log(String message) {
		console.println(message)
	}

	def clearConsole() {
		console.clearConsole
	}

	private def void redirect() {
		val xdockerAppender = new WriterAppender(new PatternLayout, new XdockerStream(INSTANCE))
		Logger.getRootLogger().addAppender(xdockerAppender)
		if (System.properties.containsKey('xdocker.log.stdout')) {
			System.setOut(createLoggingProxy(System.out))
			System.setErr(createLoggingProxy(System.err))
		}
	}

	def PrintStream createLoggingProxy(PrintStream stream) {
		return new PrintStream(stream) {
			override void print(String message) {
				message?.log
			}
		}
	}
}