package ch.itemis.xdocker.app.xdockerscout.ui.html.xtext;

import org.eclipse.scout.rt.ui.html.IUiSession;
import org.eclipse.scout.rt.ui.html.json.IJsonAdapter;
import org.eclipse.scout.rt.ui.html.json.JsonProperty;
import org.eclipse.scout.rt.ui.html.json.form.fields.JsonValueField;
import org.json.JSONObject;

import ch.itemis.xdocker.app.xdockerscout.client.xtext.IXtextEditorField;

public class JsonXtextEditorField extends JsonValueField<IXtextEditorField> {

	private String xtextEditorFieldName;

	public JsonXtextEditorField(IXtextEditorField model, IUiSession uiSession, String id, IJsonAdapter<?> parent) {
		super(model, uiSession, id, parent);
	}

	@Override
	public String getObjectType() {
		return getXtextEditorFieldName();
	}

	@Override
	protected void handleUiDisplayTextChangedAfterTyping(String displayText) {
		getModel().setValue(displayText);
	}

	public String getXtextEditorFieldName() {
		return xtextEditorFieldName;
	}

	public void setXtextEditorFieldName(String xtextFieldName) {
		this.xtextEditorFieldName = xtextFieldName;
	}

	@Override
	protected void initJsonProperties(IXtextEditorField model) {
		super.initJsonProperties(model);
		putJsonProperty(new JsonProperty<IXtextEditorField>(IXtextEditorField.PROP_SERVER_URL_PARAMETER, model) {
			@Override
			protected String modelValue() {
				return getModel().getServerUrl();
			}
			@Override
			public Object prepareValueForToJson(Object value) {
				return toJson(value);
			}
		});
	}
	
	private JSONObject toJson(Object modelValue) {
		JSONObject json = new JSONObject();
		if (modelValue != null) {
			json.put("value", modelValue);
		}
		return json;
	}
}
