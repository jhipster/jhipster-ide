package ch.itemis.xdocker.app.xdockerscout.client.editor;

import org.eclipse.scout.rt.platform.config.CONFIG;

import ch.itemis.xdocker.app.xdockerscout.client.config.XdockerServerUrlProperty;
import ch.itemis.xdocker.app.xdockerscout.client.xtext.AbstractXtextEditorField;

public abstract class AbstractXdockerEditorField extends AbstractXtextEditorField {
	
	@Override
	public String getServerUrl() {
		return CONFIG.getPropertyValue(XdockerServerUrlProperty.class);
	}
}
