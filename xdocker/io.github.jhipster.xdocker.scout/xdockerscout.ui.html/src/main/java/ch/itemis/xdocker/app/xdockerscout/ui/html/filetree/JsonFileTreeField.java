package ch.itemis.xdocker.app.xdockerscout.ui.html.filetree;

import java.util.Collection;

import org.eclipse.scout.rt.ui.html.IUiSession;
import org.eclipse.scout.rt.ui.html.json.IJsonAdapter;
import org.eclipse.scout.rt.ui.html.json.JsonEvent;
import org.eclipse.scout.rt.ui.html.json.JsonProperty;
import org.eclipse.scout.rt.ui.html.json.form.fields.JsonFormField;
import org.json.JSONArray;
import org.json.JSONObject;

import ch.itemis.xdocker.app.xdockerscout.client.filetree.FileTreeElement;
import ch.itemis.xdocker.app.xdockerscout.client.filetree.IFileTreeField;

public class JsonFileTreeField extends JsonFormField<IFileTreeField> {

	private static final String EVENT_FOLDER_LOADED = "folderLoaded";

	public JsonFileTreeField(IFileTreeField model, IUiSession uiSession, String id, IJsonAdapter<?> parent) {
		super(model, uiSession, id, parent);
	}

	@Override
	public String getObjectType() {
		return "FileTreeField";
	}

	@Override
	protected void initJsonProperties(IFileTreeField model) {
		super.initJsonProperties(model);
		putJsonProperty(new JsonProperty<IFileTreeField>(IFileTreeField.PROP_EXPAND_SPEED, model) {
			@Override
			protected Integer modelValue() {
				return getModel().getExpandSpeed();
			}
		});
		putJsonProperty(new JsonProperty<IFileTreeField>(IFileTreeField.PROP_COLLAPSE_SPEED, model) {
			@Override
			protected Integer modelValue() {
				return getModel().getCollapseSpeed();
			}
		});
		putJsonProperty(new JsonProperty<IFileTreeField>(IFileTreeField.PROP_MULTI_FOLDER, model) {
			@Override
			protected Boolean modelValue() {
				return getModel().isMultiFolder();
			}
		});
		putJsonProperty(new JsonProperty<IFileTreeField>(IFileTreeField.PROP_ROOT_FOLDER, model) {
			@Override
			protected String modelValue() {
				return getModel().getRootDir();
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

	@Override
	protected void attachModel() {
		super.attachModel();
	}

	@Override
	protected void detachModel() {
		super.detachModel();
	}

	@Override
	public void handleUiEvent(JsonEvent event) {
		if ("fileClicked".equals(event.getType())) {
			handleUiFileClicked(event);
		} else if ("folderClicked".equals(event.getType())) {
			handleUiFolderClicked(event);
		} else {
			super.handleUiEvent(event);
		}
	}

	protected void handleUiFolderClicked(JsonEvent event) {
		String dir = event.getData().getString("dir");
		boolean onlyFolders = event.getData().getBoolean("onlyFolders");
		boolean onlyFiles = event.getData().getBoolean("onlyFiles");
		boolean multiSelect = event.getData().getBoolean("multiSelect");

		Collection<FileTreeElement> content = getModel().getUIFacade().handleLoadContentFromUI(dir, onlyFolders,
				onlyFiles, multiSelect);
		JSONArray arr = new JSONArray();
		if (content != null && !content.isEmpty()) {
			for (FileTreeElement element : content) {
				arr.put(fileTreeElementToJson(element));
			}
		}

		JSONObject json = new JSONObject();
		putProperty(json, "dir", dir);
		putProperty(json, "content", arr);
		addActionEvent(EVENT_FOLDER_LOADED, json);
	}

	protected JSONObject fileTreeElementToJson(FileTreeElement src) {
		JSONObject result = new JSONObject();
		putProperty(result, "isDir", src.isDirectory());
		putProperty(result, "isCollapsed", src.isCollapsed());
		putProperty(result, "name", src.getName());
		putProperty(result, "path", src.getPath().replace('\\', '/'));
		return result;
	}

	protected void handleUiFileClicked(JsonEvent event) {
		String filePath = event.getData().getString("path");
		getModel().getUIFacade().handleClickFromUI(filePath);
	}
}
