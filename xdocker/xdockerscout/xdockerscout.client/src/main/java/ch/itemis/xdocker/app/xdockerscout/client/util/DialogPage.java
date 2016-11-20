package ch.itemis.xdocker.app.xdockerscout.client.util;

import org.eclipse.scout.rt.client.dto.Data;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithNodes;
import org.eclipse.scout.rt.client.ui.form.IForm;

@Data(DialogPage.class)
public class DialogPage extends AbstractPageWithNodes {

	private String title;
	
	public DialogPage(String title) {
		this.title = title;
	}

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
		return title; // TEXTS.get("XdockerEditor");
	}

	@Override
	protected Class<? extends IForm> getConfiguredDetailForm() {
		return DialogForm.class;
	}

	public void show(IPageForm page) {
		IPageForm form = (IPageForm) createDetailForm();
		form.setDisplayHint(IForm.DISPLAY_HINT_DIALOG);
		form.setAskIfNeedSave(false);
		form.startPageForm(form);
		form.waitFor();
	}
}
