package ch.itemis.xdocker.app.xdockerscout.client.fileinput;

import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithNodes;
import org.eclipse.scout.rt.client.ui.form.IForm;

import ch.itemis.xdocker.app.xdockerscout.client.editor.XdockerEditorPage;
import ch.itemis.xdocker.app.xdockerscout.client.util.IPageForm;

public class XdockerFilePage extends AbstractPageWithNodes {

	@Override
	protected boolean getConfiguredLeaf() {
		return true;
	}

	@Override
	protected boolean getConfiguredTableVisible() {
		return false;
	}

	@Override
	protected String getConfiguredTitle() {
		return "File Manager"; // TEXTS.get("XdockerEditor");
	}

	@Override
	protected Class<? extends IForm> getConfiguredDetailForm() {
		return XdockerFileForm.class;
	}

	public void showFileInput(XdockerEditorPage page) {
		IPageForm form = (IPageForm) createDetailForm();
		form.setDisplayHint(IForm.DISPLAY_HINT_DIALOG);
		form.setAskIfNeedSave(false);
		form.startPageForm(page.getDetailForm());
		form.waitFor();
	}
}
