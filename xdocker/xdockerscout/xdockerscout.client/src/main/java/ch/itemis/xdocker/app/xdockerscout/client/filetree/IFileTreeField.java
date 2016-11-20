package ch.itemis.xdocker.app.xdockerscout.client.filetree;

import java.util.Collection;

import org.eclipse.scout.rt.client.ui.form.fields.IFormField;

public interface IFileTreeField extends IFormField {

  String PROP_EXPAND_SPEED = "expandSpeed";
  String PROP_COLLAPSE_SPEED = "collapseSpeed";
  String PROP_MULTI_FOLDER = "multiFolder";
  String PROP_ROOT_FOLDER = "rootFolder";

  IFileTreeFieldUIFacade getUIFacade();

  void setExpandSpeed(int expandSpeed);

  int getExpandSpeed();

  void setCollapseSpeed(int collapseSpeed);

  int getCollapseSpeed();

  void setMultiFolder(boolean multiFolder);

  boolean isMultiFolder();

  void handleClick(String filePath);

  void setRootDir(String rootDir);

  String getRootDir();

  Collection<FileTreeElement> doLoad(String dir, boolean onlyFolders, boolean onlyFiles, boolean multiSelect);
}
