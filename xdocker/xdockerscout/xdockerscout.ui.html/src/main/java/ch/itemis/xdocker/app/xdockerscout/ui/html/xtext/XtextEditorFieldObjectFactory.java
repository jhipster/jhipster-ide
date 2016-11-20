package ch.itemis.xdocker.app.xdockerscout.ui.html.xtext;

import org.eclipse.scout.rt.ui.html.IUiSession;
import org.eclipse.scout.rt.ui.html.json.AbstractJsonObjectFactory;
import org.eclipse.scout.rt.ui.html.json.IJsonAdapter;

import ch.itemis.xdocker.app.xdockerscout.client.xtext.IXtextEditorField;

public abstract class XtextEditorFieldObjectFactory extends AbstractJsonObjectFactory {

	@Override
	public IJsonAdapter<?> createJsonAdapter(Object model, IUiSession session, String id, IJsonAdapter<?> parent) {
		if (model instanceof IXtextEditorField) {
			JsonXtextEditorField xtextField = new JsonXtextEditorField((IXtextEditorField) model, session, id, parent);
			xtextField.setXtextEditorFieldName(getXtextEditorFieldName());
			return xtextField;
		}
		return super.createJsonAdapter(model, session, id, parent);
	}
	
	protected abstract String getXtextEditorFieldName();
}
