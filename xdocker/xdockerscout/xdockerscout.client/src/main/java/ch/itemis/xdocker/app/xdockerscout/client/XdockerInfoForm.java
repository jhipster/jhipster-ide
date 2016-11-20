package ch.itemis.xdocker.app.xdockerscout.client;

import org.eclipse.scout.rt.client.services.common.icon.IconLocator;
import org.eclipse.scout.rt.client.services.common.icon.IconSpec;
import org.eclipse.scout.rt.client.ui.form.ScoutInfoForm;
import org.eclipse.scout.rt.platform.html.HTML;
import org.eclipse.scout.rt.platform.html.IHtmlElement;
import org.eclipse.scout.rt.platform.util.StringUtility;

import ch.itemis.xdocker.app.xdockerscout.client.icon.Icons;

public class XdockerInfoForm extends ScoutInfoForm {

	protected IHtmlElement createLogoHtml() {
		IconSpec xtextLogo = IconLocator.instance().getIconSpec(Icons.XdockerIcon);
		if (xtextLogo != null) {
			return HTML.p(HTML.imgByIconId(Icons.XdockerIcon).cssClass("scout-info-form-logo"));
		}
		return null;
	}

	protected IHtmlElement createTitleHtml() {
	    String title = StringUtility.join(" ", getProductName(), " - Serano Colameo - itemis Schweiz GmbH");
	    if (StringUtility.hasText(title)) {
	      return HTML.h2(title);
	    }
		return null;
	}
}
