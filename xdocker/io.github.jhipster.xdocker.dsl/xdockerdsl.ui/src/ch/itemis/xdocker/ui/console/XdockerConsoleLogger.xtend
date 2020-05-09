/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis-schweiz.ch) and others.
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

	XdockerConsole console

	@Accessors(PUBLIC_GETTER) ProgressBarRotating progressBar
	@Accessors(PRIVATE_SETTER, PUBLIC_GETTER) val static INSTANCE = new XdockerConsoleLogger

	private new() {
		initialize
	}

	private def initialize() {
		console = XdockerConsole.INSTANCE
		if (console === null) {
			throw new IllegalStateException('Could not initialize console!')
		}
//		redirect
//		console.showConsoleView
	}

	override log(String message) {
		log(message, true)
	}

	override log(String message, boolean newLine) {
		if (newLine && !message?.trim.isNullOrEmpty) console.println(message) else console.print(message)
	}

	static class ProgressBarRotating extends Thread {
		boolean _showProgress = true
		extension XdockerConsoleLogger logger

		new(XdockerConsoleLogger logger) {
			this.logger = logger
		}

		def static start(XdockerConsoleLogger logger) {
			val instance = new ProgressBarRotating(logger)
			instance.run
			return instance
		}

		def void showProgress() {
			_showProgress = true
		}

		def void hideProgress() {
			_showProgress = false
		}

		def boolean isShowProgress() {
			return _showProgress
		}

		def void stopProgress() {
			hideProgress
		}

		override void run() {
			val anim = "|/-\\"
			var x = 0;
			while (isShowProgress) {
				log('\r', false)
				log('Processing ' + anim.charAt(x++ % anim.length), false)
				try {
					Thread.sleep(100);
				} catch (Exception e) { /* nothing to handle here */}
			}
		}
	}

	override void progressBar(boolean start) {
		if (start) {
			if (progressBar === null) progressBar = ProgressBarRotating.start(this) 
			progressBar.showProgress()
		} else if (progressBar !== null) progressBar.stopProgress()
	}

	override clearConsole() {
		console.clearConsole
	}

	protected def void redirect() {
		val xdockerAppender = new WriterAppender(new PatternLayout, new XdockerStream(this))
		Logger.rootLogger.addAppender(xdockerAppender)
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
