package ch.itemis.xdocker.app.xdockerscout.client.outline;

import java.util.List;

import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutline;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.platform.Order;

import ch.itemis.xdocker.app.xdockerscout.client.search.XdockerContainerBrowserPage;
import ch.itemis.xdocker.app.xdockerscout.client.search.XdockerImageBrowserPage;
import ch.itemis.xdocker.app.xdockerscout.shared.Icons;

/**
 * <h3>{@link SearchOutline}</h3>
 *
 * @author serano
 */
@Order(2000)
public class SearchOutline extends AbstractOutline {

	@Override
	protected String getConfiguredTitle() {
		return "Search"; // TEXTS.get("Docker");
	}

	@Override
	protected String getConfiguredIconId() {
		return Icons.Search;
	}
	
	@Override
	protected void execCreateChildPages(List<IPage<?>> pageList) {
		super.execCreateChildPages(pageList);
		pageList.add(new XdockerContainerBrowserPage());
		pageList.add(new XdockerImageBrowserPage());
	}	
}
