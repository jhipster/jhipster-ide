package ch.itemis.xdocker.app.xdockerscout.ui.html.xdocker;

import org.eclipse.scout.rt.platform.Bean;
import org.eclipse.scout.rt.platform.Order;

import ch.itemis.xdocker.app.xdockerscout.ui.html.xtext.XtextEditorFieldObjectFactory;

@Bean
@Order(100)
public class XdockerEditorFieldObjectFactory extends XtextEditorFieldObjectFactory {

	@Override
	protected String getXtextEditorFieldName() {
		return "XdockerEditorField";
	}
}
