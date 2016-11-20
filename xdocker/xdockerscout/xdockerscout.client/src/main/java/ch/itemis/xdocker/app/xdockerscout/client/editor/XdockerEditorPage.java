package ch.itemis.xdocker.app.xdockerscout.client.editor;

import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithNodes;
import org.eclipse.scout.rt.client.ui.form.IForm;
import org.eclipse.scout.rt.platform.Order;

import ch.itemis.xdocker.app.xdockerscout.client.fileinput.XdockerFilePage;
import ch.itemis.xdocker.app.xdockerscout.client.filetree.XdockerFiletreePage;

/**
 * <h3>{@link XdockerEditorPage}</h3>
 *
 * @author serano
 */
public class XdockerEditorPage extends AbstractPageWithNodes {

	private XdockerFiletreePage fileTreePage = new XdockerFiletreePage();
	private XdockerFilePage filePage = new XdockerFilePage();

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
		return "Editor"; // TEXTS.get("XdockerEditor");
	}

	@Override
	protected Class<? extends IForm> getConfiguredDetailForm() {
		return XdockerEditorForm.class;
	}

	@Order(1)
	public class NewMenu extends AbstractMenu {

		@Override
		protected String getConfiguredText() {
			return "New";
		}

		@Override
		protected void execAction() {
			filePage.showFileInput(XdockerEditorPage.this);
		}
	}

	@Order(5)
	public class OpenMenu extends AbstractMenu {

		@Override
		protected String getConfiguredText() {
			return "Open";
		}

		@Override
		protected void execAction() {
			fileTreePage.showFileTree(XdockerEditorPage.this);
		}
	}
}
