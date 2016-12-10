package ch.itemis.xdocker.app.xdockerscout.client;

import static ch.itemis.xdocker.app.xdockerscout.client.util.ScoutExtensions.showErrorMessageBox;
import static ch.itemis.xdocker.app.xdockerscout.client.util.ScoutExtensions.showInfoMessageBox;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.eclipse.scout.rt.client.session.ClientSessionProvider;
import org.eclipse.scout.rt.client.ui.action.keystroke.AbstractKeyStroke;
import org.eclipse.scout.rt.client.ui.action.keystroke.IKeyStroke;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.desktop.AbstractDesktop;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutlineViewButton;
import org.eclipse.scout.rt.client.ui.desktop.outline.IOutline;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.util.CollectionUtility;
import org.eclipse.scout.rt.platform.util.SleepUtil;
import org.eclipse.scout.rt.shared.TEXTS;

import ch.itemis.xdocker.app.xdockerscout.client.outline.DockerOutline;
import ch.itemis.xdocker.app.xdockerscout.client.outline.SearchOutline;
import ch.itemis.xdocker.app.xdockerscout.client.outline.SettingsOutline;
import ch.itemis.xdocker.app.xdockerscout.shared.service.IXdockerDockerService;
import ch.itemis.xdocker.app.xdockerscout.shared.service.XdockerInfo;

/**
 * <h3>{@link Desktop}</h3>
 *
 * @author serano
 */
public class Desktop extends AbstractDesktop {
	
	@Override
	protected String getConfiguredTitle() {
		return TEXTS.get("ApplicationTitle");
	}

	@Override
	protected List<Class<? extends IOutline>> getConfiguredOutlines() {
		return CollectionUtility.<Class<? extends IOutline>>arrayList(
				DockerOutline.class, 
				SearchOutline.class,
				SettingsOutline.class);
	}

	@Override
	protected void execGuiAttached() {
		super.execGuiAttached();
		selectFirstVisibleOutline();
	}

	protected void selectFirstVisibleOutline() {
		for (IOutline outline : getAvailableOutlines()) {
			if (outline.isEnabled() && outline.isVisible()) {
				outline.selectFirstNode();
				setOutline(outline);
				break;
			}
		}
	}
	
	@Order(1000)
	public class FileMenu extends AbstractMenu {
		
		@Override
		protected String getConfiguredText() {
			return TEXTS.get("Application");
		}
		
		@Order(1010)
		public class ExitMenu extends AbstractMenu {

			@Override
			protected String getConfiguredText() {
				return TEXTS.get("Exit");
			}

			@Override
			protected void execAction() {
				ClientSessionProvider.currentSession(ClientSession.class).stop();
			}
		}
	}
	
	@Order(2000)
	public class DockerMenu extends AbstractMenu {
		
		@Override
		protected String getConfiguredText() {
			return TEXTS.get("Docker");
		}
		
		@Order(1010)
		public class InfoMenu extends AbstractMenu {

			@Override
			protected String getConfiguredText() {
				return TEXTS.get("Info");
			}

			@Override
			protected void execAction() {
				try {
					SleepUtil.sleepSafe(200, TimeUnit.MILLISECONDS);
					XdockerInfo info = BEANS.get(IXdockerDockerService.class).info();
					if (info != null && info.getAttributes() != null && !info.getAttributes().isEmpty()) {
						Set<String> keys = info.getAttributes().keySet();
						StringBuffer sb = new StringBuffer();
						for (String key : keys) {
							sb.append(key).append(" ").append(info.getAttributes().get(key));
						}
						showInfoMessageBox("Docker Info...", sb.toString());
					}
				} catch (Exception e) {
					showErrorMessageBox("Docker Info...", "Error connecting to docker! Error: " + e.getMessage());
				}
			}
		}
	}

//	@Order(2000)
//	public class BookmarkMenu extends AbstractBookmarkMenu {
//		public BookmarkMenu() {
//			super(Desktop.this);
//		}
//	}

	@Order(3000)
	public class HelpMenu extends AbstractMenu {

		@Override
		protected String getConfiguredText() {
			return TEXTS.get("Help");
		}

		@Order(1000)
		public class AboutMenu extends AbstractMenu {

			@Override
			protected String getConfiguredText() {
				return TEXTS.get("About");
			}

			@Override
			protected void execAction() {
				XdockerInfoForm form = new XdockerInfoForm();
				form.startModify();
			}
		}
	}

	@Order(1000)
	public class RefreshOutlineKeyStroke extends AbstractKeyStroke {

		@Override
		protected String getConfiguredKeyStroke() {
			return IKeyStroke.F5;
		}

		@Override
		protected void execAction() {
			if (getOutline() != null) {
				IPage<?> page = getOutline().getActivePage();
				if (page != null) {
					page.reloadPage();
				}
			}
		}
	}

	@Order(1000)
	public class XdockerOutlineViewButton extends AbstractOutlineViewButton {

		public XdockerOutlineViewButton() {
			this(DockerOutline.class);
		}

		protected XdockerOutlineViewButton(Class<? extends DockerOutline> outlineClass) {
			super(Desktop.this, outlineClass);
		}

		@Override
		protected String getConfiguredKeyStroke() {
			return IKeyStroke.F2;
		}		
	}

	@Order(3000)
	public class SettingsOutlineViewButton extends AbstractOutlineViewButton {

		public SettingsOutlineViewButton() {
			this(SettingsOutline.class);
		}

		protected SettingsOutlineViewButton(Class<? extends SettingsOutline> outlineClass) {
			super(Desktop.this, outlineClass);
		}

		@Override
		protected DisplayStyle getConfiguredDisplayStyle() {
			return DisplayStyle.TAB;
		}

		@Override
		protected String getConfiguredKeyStroke() {
			return IKeyStroke.F10;
		}
	}
	
	@Order(2000)
	public class SearchOutlineViewButton extends AbstractOutlineViewButton {

		public SearchOutlineViewButton() {
			this(SearchOutline.class);
		}

		protected SearchOutlineViewButton(Class<? extends SearchOutline> outlineClass) {
			super(Desktop.this, outlineClass);
		}

		@Override
		protected DisplayStyle getConfiguredDisplayStyle() {
			return DisplayStyle.TAB;
		}

		@Override
		protected String getConfiguredKeyStroke() {
			return IKeyStroke.F3;
		}
	}
}
