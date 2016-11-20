package ch.itemis.xdocker.app.xdockerscout.client.outline;

import java.util.List;

import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutline;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.shared.TEXTS;

import ch.itemis.xdocker.app.xdockerscout.client.prefs.XdockerDockerSettingsPage;
import ch.itemis.xdocker.app.xdockerscout.shared.Icons;

/**
 * <h3>{@link SettingsOutline}</h3>
 *
 * @author serano
 */
@Order(3000)
public class SettingsOutline extends AbstractOutline {

	@Override
	protected String getConfiguredTitle() {
		return TEXTS.get("Settings");
	}

	@Override
	protected String getConfiguredIconId() {
		return Icons.Gear;
	}
	
	@Override
	protected void execCreateChildPages(List<IPage<?>> pageList) {
		super.execCreateChildPages(pageList);
		pageList.add(new XdockerDockerSettingsPage());
	}	
}
