package ch.itemis.xdocker.app.xdockerscout.client.xtext;

import org.eclipse.scout.rt.client.ui.form.fields.AbstractValueField;

public abstract class AbstractXtextEditorField extends AbstractValueField<String> implements IXtextEditorField {
	
	public AbstractXtextEditorField() {
		super();
	}

	public AbstractXtextEditorField(boolean callInitializer) {
		super(callInitializer);
	}
}
