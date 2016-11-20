package ch.itemis.xdocker.app.xdockerscout.client.prefs

import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithNodes
import org.eclipse.scout.rt.client.ui.form.IForm

class XdockerDockerSettingsPage extends AbstractPageWithNodes {
	
	override protected String getConfiguredTitle() {
		return "Docker Properties" // TEXTS.get("XdockerBrowser");
	}

	override protected boolean getConfiguredLeaf() {
		return true
	}

	override protected Class<? extends IForm> getConfiguredDetailForm() {
		return XdockerDockerSettingsForm
	}
}
