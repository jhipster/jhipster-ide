/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.view;

import static ch.itemis.xdocker.ui.util.MessageUtil.warning;
import static org.apache.commons.lang.StringUtils.isEmpty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.launchConfigurations.LaunchConfigurationDialog;
import org.eclipse.debug.internal.ui.launchConfigurations.LaunchGroupExtension;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.SearchItem;
import com.ocpsoft.pretty.time.PrettyTime;

import ch.itemis.xdocker.ui.job.XdockerJobStatus;
import ch.itemis.xdocker.ui.job.XdockerPullImageJob;
import ch.itemis.xdocker.ui.job.XdockerRemoveImageJob;
import ch.itemis.xdocker.ui.job.XdockerSearchImagesJob;
import ch.itemis.xdocker.ui.launch.shortcut.XdockerRunLaunchConfigData;
import ch.itemis.xdocker.ui.util.ResourceManager;

/**
 * Xdocker Image Browser View
 * 
 * @author Serano Colameo - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XdockerImageBrowserView extends AbstractXdockerBrowserView {
	public static final String ID_IMAGE_BROWSER_VIEW = "ch.itemis.xdocker.ui.view.xdockerImageBrowserView";

	private Table table;
	private Text searchInput;
	private Combo repoCombo;
	private Menu tableMenu;
	private MenuItem runMenu;
	private MenuItem removeMenu;
	private MenuItem selectAllMenu;

	/**
	 * Constructor
	 */
	public XdockerImageBrowserView() {
		setTitleToolTip("Docker Images");
		setContentDescription("Docker Images");
		setTitleImage(ResourceManager.getPluginImage("ch.itemis.xdocker.ui", "icons/docker-solo.gif"));
		setPartName("Docker Images");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.
	 * widgets .Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		setParent(parent);
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));

		ViewForm form = new ViewForm(parent, SWT.BORDER);

		Button searchButton = new Button(form, SWT.CENTER);
		searchButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!isLocal()) {
					if (searchInput.getText().trim().isEmpty()) {
						warning("Search Docker Hub for images", "Please enter a term to search for!");
						return;
					}
				}
				search();
			}
		});

		form.setTopRight(searchButton);
		searchButton.setText("Search");

		table = new Table(form, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		form.setContent(table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setVisible(true);

		addColumn("Repository", 200);
		addColumn("Tag", 400);
		addColumn("Image ID", 50);
		addColumn("Created", 50);
		addColumn("Virtual Size", 50);

		setMenuForLocalImages();
		table.addMenuDetectListener(new MenuDetectListener() {
			@Override
			public void menuDetected(MenuDetectEvent e) {
				runMenu.setEnabled(table.getSelectionCount() == 1);
				selectAllMenu.setEnabled(table.getSelectionCount() < table.getItemCount());
			}
		});

		searchInput = new Text(form, SWT.BORDER | SWT.V_SCROLL | SWT.SEARCH);
		searchInput.setEnabled(true);
		form.setTopLeft(searchInput);
		searchInput.addListener(SWT.DefaultSelection, new Listener() {
			public void handleEvent(Event e) {
				search();
			}
		});

		repoCombo = new Combo(form, SWT.READ_ONLY);
		repoCombo.setItems(new String[] { "Local", "Remote" });
		repoCombo.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				resetResultTable();
			}
		});
		form.setTopCenter(repoCombo);
		repoCombo.select(0);
		repoCombo.pack();

		parent.pack();
	}

	private void resetResultTable() {
		table.removeAll();
		searchInput.setText("");
		if (isLocal()) {
			setLocalColumns();
			setMenuForLocalImages();
		} else {
			setRemoteColumns();
			setMenuForRemoteImages();
		}
	}

	private void setMenuForRemoteImages() {
		Menu tableMenu = new Menu(getParent().getShell(), SWT.POP_UP);
		table.setMenu(tableMenu);
		MenuItem pullMenu = new MenuItem(tableMenu, SWT.PUSH);
		pullMenu.setText("Pull Image");
		pullMenu.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				pullImages();
			}
		});
	}

	private void setMenuForLocalImages() {
		tableMenu = new Menu(getParent().getShell(), SWT.POP_UP);
		table.setMenu(tableMenu);
		runMenu = new MenuItem(tableMenu, SWT.PUSH);
		runMenu.setText("Run...");
		runMenu.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				openLaunchConfigurationDialog();
			}
		});
		removeMenu = new MenuItem(tableMenu, SWT.PUSH);
		removeMenu.setText("Remove");
		removeMenu.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				removeSelectedImages();
			}
		});
		selectAllMenu = new MenuItem(tableMenu, SWT.PUSH);
		selectAllMenu.setText("Select All");
		selectAllMenu.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				table.selectAll();
			}
		});
	}

	private void setRemoteColumns() {
		setColumn(0, "Name", 200);
		setColumn(1, "Description", 400);
		setColumn(2, "Stars", 50);
		setColumn(3, "Official", 50);
		setColumn(4, "Automated", 50);
	}

	private void setLocalColumns() {
		setColumn(0, "Repository", 200);
		setColumn(1, "Tag", 400);
		setColumn(2, "Image ID", 50);
		setColumn(3, "Created", 50);
		setColumn(4, "Virtual Size", 50);
	}

	private TableColumn addColumn(String text, int width) {
		TableColumn column = new TableColumn(table, SWT.NONE);
		column.setWidth(width);
		column.setText(text);
		return column;
	}

	private void setColumn(int index, String text, int width) {
		TableColumn column = table.getColumn(index);
		column.setWidth(width);
		column.setText(text);
	}

	private boolean isLocal() {
		return repoCombo.getSelectionIndex() == 0;
	}

	private void pullImages() {
		List<String> images = getSelectedImages();
		if (!images.isEmpty()) {
			XdockerPullImageJob job = new XdockerPullImageJob(images);
			job.schedule();
		}
	}

	private void removeSelectedImages() {
		if (table.getSelectionIndex() < 0)
			return;
		removeSelectedImages(table.getSelection());
	}

	private void removeSelectedImages(TableItem[] items) {
		List<String> imageIds = new ArrayList<>();
		for (TableItem item : table.getSelection()) {
			String imageId = item.getText(2);
			imageIds.add(imageId);
		}
		XdockerRemoveImageJob job = new XdockerRemoveImageJob(imageIds);
		job.addJobChangeListener(new JobChangeListener(this, job) {
			@Override
			public void done(IJobChangeEvent event) {
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						for (TableItem item : table.getSelection()) {
							int index = table.indexOf(item);
							table.remove(index);
						}
					}
				});
			}
		});
		job.schedule();
	}

	protected void openLaunchConfigurationDialog() {
		String image = getSelectedImage();
		if (isEmpty(image))
			return;
		Shell shell = Display.getDefault().getActiveShell();
		ILaunchConfiguration config = findLaunchConfig(image);
		if (config == null) {
			config = new XdockerRunLaunchConfigData(image, null, null, null, null, null, null, null, null, null, null,
					null, null).createConfiguration();
		}
		LaunchConfigurationDialog dialog = new LaunchConfigurationDialog(shell, config, getLaunchGroup());
		dialog.setInitialSelection(new StructuredSelection(config));
		dialog.setOpenMode(LaunchConfigurationDialog.LAUNCH_CONFIGURATION_DIALOG_OPEN_ON_SELECTION);
		dialog.setDefaultsOnOpen(true);
		dialog.open();
	}

	private List<String> getSelectedImages() {
		List<String> imageIds = new ArrayList<>();
		for (TableItem item : table.getSelection()) {
			String imageId = item.getText(0);
			imageIds.add(imageId);
		}
		return imageIds;
	}

	private String getSelectedImage() {
		if (table.getSelectionIndex() < 0)
			return null;
		TableItem item = table.getItem(table.getSelectionIndex());
		String tag = item.getText(1);
		if (!tag.trim().isEmpty())
			tag = ":" + tag;
		return item != null ? item.getText(0) + tag : null;
	}

	private LaunchGroupExtension getLaunchGroup() {
		return DebugUIPlugin.getDefault().getLaunchConfigurationManager().getDefaultLaunchGroup("Run");
	}

	private ILaunchConfiguration findLaunchConfig(String imageName) {
		ILaunchConfiguration config = null;
		try {
			ILaunchConfiguration[] configs = DebugPlugin.getDefault().getLaunchManager()
					.getLaunchConfigurations(getLaunchConfigurationType());
			for (ILaunchConfiguration c : configs) {
				String cImage = c.getAttribute(XdockerRunLaunchConfigData.ATTR_IMAGE, "");
				if (cImage.equals(imageName)) {
					config = c;
					break;
				}
			}
		} catch (CoreException e) {
			return null;
		}
		return config;
	}

	private ILaunchConfigurationType getLaunchConfigurationType() {
		return DebugPlugin.getDefault().getLaunchManager()
				.getLaunchConfigurationType(XdockerRunLaunchConfigData.CONFIG_TYPE);
	}

	private void search() {
		table.removeAll();
		XdockerSearchImagesJob job = new XdockerSearchImagesJob(isLocal(), searchInput.getText());
		job.schedule();
		job.addJobChangeListener(new JobChangeListener(this, job));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.itemis.xdocker.ui.view.AbstractXdockerBrowserView#processResult(ch
	 * .itemis.xdocker.ui.job.XdockerJobStatus)
	 */
	@Override
	protected void processResult(XdockerJobStatus status) {
		if (status.isOK() && status.getArgument() instanceof List<?>) {
			if (isLocal()) {
				@SuppressWarnings("unchecked")
				List<Image> images = (List<Image>) status.getArgument();
				Locale defLocale = Locale.getDefault();
				try {
					Locale.setDefault(Locale.UK); // we support only English!
					PrettyTime pt = new PrettyTime();
					for (Object obj : images) {
						Image image = obj instanceof Image ? (Image) obj : null;
						if (image == null)
							return;
						TableItem item = new TableItem(table, SWT.NONE);
						List<String> elements = new ArrayList<String>();
						String tagFragment = image.getRepoTags() != null && image.getRepoTags().length > 0
								? image.getRepoTags()[0] : null;
						String[] repoTag = tagFragment != null ? image.getRepoTags()[0].split(":") : null;
						if (repoTag != null) {
							if (repoTag.length > 0)
								elements.add(repoTag[0]);
							if (repoTag.length > 1)
								elements.add(repoTag[1]);
						}
						if (image.getId() != null && image.getId().length() >= 12)
							elements.add(image.getId().substring(0, 12));
						elements.add(pt.format(new Date(image.getCreated() * 1000)));
						elements.add(String.valueOf(image.getVirtualSize()));
						item.setText(elements.toArray(new String[] {}));
					}
				} finally {
					Locale.setDefault(defLocale); // restore to default...
				}
			} else {
				@SuppressWarnings("unchecked")
				List<SearchItem> images = (List<SearchItem>) status.getArgument();
				for (Object obj : images) {
					SearchItem image = obj instanceof SearchItem ? (SearchItem) obj : null;
					if (image == null)
						return;
					TableItem item = new TableItem(table, SWT.NONE);
					List<String> elements = new ArrayList<String>();
					elements.add(image.getName());
					elements.add(image.getDescription());
					elements.add(String.valueOf(image.getStarCount()));
					elements.add(String.valueOf(image.isOfficial()));
					elements.add(String.valueOf(image.isTrusted()));
					item.setText(elements.toArray(new String[] {}));
				}
			}
			// resize columns
			for (int i = 0, n = table.getColumnCount(); i < n; i++) {
				if (isLocal() || i != 1) {
					// skip description because could be too long...
					table.getColumn(i).pack();
				}
			}
		}
	}
}
