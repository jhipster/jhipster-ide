package ch.itemis.xdocker.app.xdockerscout.client.filetree;

import java.util.Collection;

public interface IFileTreeFieldUIFacade {
	void handleClickFromUI(String filePath);

	Collection<FileTreeElement> handleLoadContentFromUI(String dir, boolean onlyFolders, boolean onlyFiles,
			boolean multiSelect);
}
