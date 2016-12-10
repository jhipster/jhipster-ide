package ch.itemis.xdocker.app.xdockerscout.client.util

import org.eclipse.scout.rt.client.ui.messagebox.MessageBoxes
import org.eclipse.scout.rt.platform.html.IHtmlContent
import org.eclipse.scout.rt.platform.status.IStatus
import org.eclipse.scout.rt.shared.TEXTS

class ScoutExtensions {

	def static infoMessageBox(String title, String msg) {
		return MessageBoxes.createOk()
				.withSeverity(IStatus.INFO)
				.withHeader(TEXTS.get("Info") + ": " + title)
				.withBody(msg)
	}

	def static showHtmlMessageBox(String title, IHtmlContent msg) {
		return MessageBoxes.createOk()
				.withSeverity(IStatus.INFO)
				.withHeader(TEXTS.get("Info") + ": " + title)
				.withHtml(msg).show
	}

	def static showInfoMessageBox(String title, String msg) {
		return infoMessageBox(title, msg).show
	}

	def static okMessageBox(String title, String msg) {
		return MessageBoxes.createOk()
				.withSeverity(IStatus.OK)
				.withHeader(TEXTS.get("Ok") + ": " + title)
				.withBody(msg)
	}

	def static showOkMessageBox(String title, String msg) {
		return okMessageBox(title, msg).show
	}

	def static warnMessageBox(String title, String msg) {
		return MessageBoxes.createOk()
				.withSeverity(IStatus.WARNING)
				.withHeader(TEXTS.get("Warning") + ": " + title)
				.withBody(msg)
	}

	def static showWarnMessageBox(String title, String msg) {
		return warnMessageBox(title, msg).show
	}

	def static errorMessageBox(String title, String msg) {
		return MessageBoxes.createOk()
				.withSeverity(IStatus.ERROR)
				.withHeader(TEXTS.get("Error") + ": " + title)
				.withBody(msg)
	}

	def static showErrorMessageBox(String title, String msg) {
		return errorMessageBox(title, msg).show
	}
	
	def static showErrorMessageBox(String title, Throwable ex) {
		return errorMessageBox(title, "Error: " + ex.message).show
	}
	
}