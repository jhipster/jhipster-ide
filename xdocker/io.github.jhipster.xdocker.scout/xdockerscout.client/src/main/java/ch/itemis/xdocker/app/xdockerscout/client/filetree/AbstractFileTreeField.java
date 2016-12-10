package ch.itemis.xdocker.app.xdockerscout.client.filetree;

import java.util.Collection;

import org.eclipse.scout.rt.client.ModelContextProxy;
import org.eclipse.scout.rt.client.ModelContextProxy.ModelContext;
import org.eclipse.scout.rt.client.ui.form.fields.AbstractFormField;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.annotations.ConfigOperation;
import org.eclipse.scout.rt.platform.annotations.ConfigProperty;
import org.eclipse.scout.rt.platform.classid.ClassId;

@ClassId("f3ffb50b-e393-4c77-baec-96de6d1c2805")
public abstract class AbstractFileTreeField extends AbstractFormField implements IFileTreeField {

	private IFileTreeFieldUIFacade m_uiFacade;

	@Override
	protected void initConfig() {
		m_uiFacade = BEANS.get(ModelContextProxy.class).newProxy(new P_UIFacade(), ModelContext.copyCurrent());
		super.initConfig();
		setExpandSpeed(getConfiguredExpandSpeed());
		setCollapseSpeed(getConfiguredCollapseSpeed());
		setMultiFolder(getConfiguredMultiFolder());
	}

	@Order(10)
	@ConfigProperty(ConfigProperty.INTEGER)
	protected int getConfiguredExpandSpeed() {
		return 400;
	}

	@Order(20)
	@ConfigProperty(ConfigProperty.INTEGER)
	protected int getConfiguredCollapseSpeed() {
		return 400;
	}

	@Order(30)
	@ConfigProperty(ConfigProperty.BOOLEAN)
	protected boolean getConfiguredMultiFolder() {
		return true;
	}

	@Order(40)
	@ConfigOperation
	protected void execClick(String filePath) {
	}

	@Order(50)
	@ConfigOperation
	protected Collection<FileTreeElement> execLoad(String dir, boolean onlyFolders, boolean onlyFiles,
			boolean multiSelect) {
		return null;
	}

	@Override
	public void setExpandSpeed(int expandSpeed) {
		propertySupport.setPropertyInt(PROP_EXPAND_SPEED, expandSpeed);
	}

	@Override
	public int getExpandSpeed() {
		return propertySupport.getPropertyInt(PROP_EXPAND_SPEED);
	}

	@Override
	public void setCollapseSpeed(int collapseSpeed) {
		propertySupport.setPropertyInt(PROP_COLLAPSE_SPEED, collapseSpeed);
	}

	@Override
	public int getCollapseSpeed() {
		return propertySupport.getPropertyInt(PROP_COLLAPSE_SPEED);
	}

	@Override
	public void setMultiFolder(boolean multiFolder) {
		propertySupport.setPropertyBool(PROP_MULTI_FOLDER, multiFolder);
	}

	@Override
	public boolean isMultiFolder() {
		return propertySupport.getPropertyBool(PROP_MULTI_FOLDER);
	}

	@Override
	public IFileTreeFieldUIFacade getUIFacade() {
		return m_uiFacade;
	}

	@Override
	public void setRootDir(String rootDir) {
		propertySupport.setPropertyString(PROP_ROOT_FOLDER, rootDir);
	}

	@Override
	public String getRootDir() {
		return propertySupport.getPropertyString(PROP_ROOT_FOLDER);
	}

	@Override
	public void handleClick(String filePath) {
		execClick(filePath);
	}

	@Override
	public Collection<FileTreeElement> doLoad(String dir, boolean onlyFolders, boolean onlyFiles, boolean multiSelect) {
		return execLoad(dir, onlyFolders, onlyFiles, multiSelect);
	}

	protected class P_UIFacade implements IFileTreeFieldUIFacade {
		@Override
		public void handleClickFromUI(String filePath) {
			handleClick(filePath);
		}

		@Override
		public Collection<FileTreeElement> handleLoadContentFromUI(String dir, boolean onlyFolders, boolean onlyFiles,
				boolean multiSelect) {
			return doLoad(dir, onlyFolders, onlyFiles, multiSelect);
		}
	}
}
