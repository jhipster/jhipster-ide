package ch.itemis.xdocker.app.xdockerscout.client.search

import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithNodes
import org.eclipse.scout.rt.client.ui.form.IForm

class XdockerImageBrowserPage extends AbstractPageWithNodes {
	
	override protected String getConfiguredTitle() {
		return "Image" // TEXTS.get("XdockerBrowser");
	}

	override protected boolean getConfiguredLeaf() {
		return true
	}

	override protected Class<? extends IForm> getConfiguredDetailForm() {
		return XdockerImageSearchForm
	}
}
