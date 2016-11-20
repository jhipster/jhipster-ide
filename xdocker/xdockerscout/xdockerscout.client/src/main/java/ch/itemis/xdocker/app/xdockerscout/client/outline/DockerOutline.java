package ch.itemis.xdocker.app.xdockerscout.client.outline;

import java.util.List;

import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutline;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.platform.Order;

import ch.itemis.xdocker.app.xdockerscout.client.editor.XdockerEditorPage;
import ch.itemis.xdocker.app.xdockerscout.shared.Icons;

/**
 * <h3>{@link DockerOutline}</h3>
 *
 * @author serano
 */
@Order(1000)
public class DockerOutline extends AbstractOutline {

	@Override
	protected void execCreateChildPages(List<IPage<?>> pageList) {
		super.execCreateChildPages(pageList);
		pageList.add(new XdockerEditorPage());
	}

	@Override
	protected String getConfiguredTitle() {
		return "Docker"; // TEXTS.get("Docker");
	}

	@Override
	protected String getConfiguredIconId() {
		return Icons.Pencil;
	}

//	@Override
//	protected Class<? extends IForm> getConfiguredDefaultDetailForm() {
//		return XdockerEditorForm.class;
//	}	
}
