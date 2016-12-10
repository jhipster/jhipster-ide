package ch.itemis.xdocker.app.xdockerscout.client.xtext;

import org.eclipse.scout.rt.client.ui.form.fields.IValueField;

public interface IXtextEditorField extends IValueField<String> {

	public final static String PROP_SERVER_URL_PARAMETER = "serverUrl";
	
	public String getServerUrl();
}
