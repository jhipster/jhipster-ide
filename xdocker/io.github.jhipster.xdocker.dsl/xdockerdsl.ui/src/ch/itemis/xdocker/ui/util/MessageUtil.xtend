/** 
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis-schweiz.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ch.itemis.xdocker.ui.util

import org.eclipse.swt.widgets.Shell

import static org.eclipse.jface.dialogs.MessageDialog.openError
import static org.eclipse.jface.dialogs.MessageDialog.openInformation
import static org.eclipse.jface.dialogs.MessageDialog.openWarning

import static ch.itemis.xdocker.ui.dialogs.XdockerScrollableDialog.*

/** 
 * Xdocker Message Extension Util
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class MessageUtil {
	
	def static void info(String title, String message) {
		info(null, title, message)
	}

	def static void info(Shell shell, String title, String message) {
		if (message.nullOrEmpty == false) {
			openInformation(shell, title, message)
		}
	}

	def static void error(Shell shell, String title, String message) {
		if (message.nullOrEmpty == false) {
			openError(shell, title, message)
		}
	}
	
	def static void error(String title, String message) {
		error(null, title, message)
	}

	def static void warning(Shell shell, String title, String message) {
		if (message.nullOrEmpty == false) {
			openWarning(shell, title, message)
		}
	}
	
	def static void warning(String title, String message) {
		warning(null, title, message)
	}


	def static void infoBox(Shell shell, String title, String subTitle, String message) {
		if (message.nullOrEmpty == false) {
			showInfoBox(shell, title, subTitle, message)
		}
	}
}
