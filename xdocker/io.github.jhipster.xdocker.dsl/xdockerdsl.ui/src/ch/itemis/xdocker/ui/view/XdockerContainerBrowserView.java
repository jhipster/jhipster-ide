/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.view;

import static org.apache.commons.lang.StringUtils.isNotBlank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.ContainerPort;
import com.ocpsoft.pretty.time.PrettyTime;

import ch.itemis.xdocker.ui.job.XdockerJobStatus;
import ch.itemis.xdocker.ui.job.XdockerListCntnrsJob;
import ch.itemis.xdocker.ui.job.XdockerRemoveCntnrJob;
import ch.itemis.xdocker.ui.job.XdockerShowLogsJob;
import ch.itemis.xdocker.ui.job.XdockerStartCntnrJob;
import ch.itemis.xdocker.ui.job.XdockerStopCntnrJob;
import ch.itemis.xdocker.ui.util.ResourceManager;

/**
 * Xdocker Container Browser View
 * 
 * @author Serano Colameo - Initial contribution and API
 */
public class XdockerContainerBrowserView extends AbstractXdockerBrowserView {
	public static final String ID_CONTAINER_BROWSER_VIEW = "ch.itemis.xdocker.ui.view.xdockerContainerBrowserView";

	private Table table;
	private Text searchInput;
	private Button buttonAll;
	private Menu tableMenu;
	private MenuItem removeMenu;
	private MenuItem stopMenu;
	private MenuItem startMenu;
	private MenuItem selectAllMenu;
	private MenuItem logsMenu;

	/**
	 * Constructor
	 */
	public XdockerContainerBrowserView() {
		setTitleToolTip("Docker Containers");
		setContentDescription("Docker Containers");
		setTitleImage(ResourceManager.getPluginImage("ch.itemis.xdocker.ui", "icons/docker-solo.gif"));
		setPartName("Docker Containers");
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

		ViewForm form = new ViewForm(parent, SWT.NONE);

		searchInput = new Text(form, SWT.BORDER | SWT.V_SCROLL | SWT.SEARCH);
		form.setTopLeft(searchInput);
		searchInput.addListener(SWT.DefaultSelection, new Listener() {
			public void handleEvent(Event e) {
				search();
			}
		});

		Button searchButton = new Button(form, SWT.NONE);
		searchButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				search();
			}
		});
		form.setTopRight(searchButton);
		searchButton.setText("Search");

		table = new Table(form, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		form.setContent(table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.addMenuDetectListener(new MenuDetectListener() {
			@Override
			public void menuDetected(MenuDetectEvent e) {
				selectAllMenu.setEnabled(table.getSelectionCount() < table.getItemCount());
			}
		});

		TableColumn nameColumn = new TableColumn(table, SWT.NONE);
		nameColumn.setWidth(100);
		nameColumn.setText("Container Id");

		TableColumn descColumn = new TableColumn(table, SWT.NONE);
		descColumn.setWidth(100);
		descColumn.setText("Image");

		TableColumn starsColumn = new TableColumn(table, SWT.NONE);
		starsColumn.setWidth(200);
		starsColumn.setText("Command");

		TableColumn officialColumn = new TableColumn(table, SWT.NONE);
		officialColumn.setWidth(150);
		officialColumn.setText("Created");

		TableColumn automatedColumn = new TableColumn(table, SWT.NONE);
		automatedColumn.setWidth(200);
		automatedColumn.setText("Status");

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Ports");

		TableColumn tblclmnNames = new TableColumn(table, SWT.NONE);
		tblclmnNames.setWidth(200);
		tblclmnNames.setText("Names");

		tableMenu = new Menu(parent.getShell(), SWT.POP_UP);
		table.setMenu(tableMenu);

		selectAllMenu = new MenuItem(tableMenu, SWT.PUSH);
		selectAllMenu.setText("Select All");
		selectAllMenu.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				table.selectAll();
			}
		});

		startMenu = new MenuItem(tableMenu, SWT.PUSH);
		startMenu.setText("Start");
		startMenu.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				startSelectedContainers();
			}
		});

		stopMenu = new MenuItem(tableMenu, SWT.PUSH);
		stopMenu.setText("Stop");
		stopMenu.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				stopSelectedContainers();
			}
		});

		removeMenu = new MenuItem(tableMenu, SWT.PUSH);
		removeMenu.setText("Remove");
		removeMenu.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				removeSelectedContainers();
			}
		});

		logsMenu = new MenuItem(tableMenu, SWT.PUSH);
		logsMenu.setText("Logs");
		logsMenu.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				logsOfSelectedContainers();
			}
		});

		buttonAll = new Button(form, SWT.CHECK);
		form.setTopCenter(buttonAll);
		buttonAll.setText("All");

		parent.pack();
	}

	private void startSelectedContainers() {
		if (table.getSelectionIndex() < 0)
			return;
		startSelectedContainers(table.getSelection());
	}

	private void startSelectedContainers(TableItem[] items) {
		List<String> containerIds = new ArrayList<>();
		for (TableItem item : table.getSelection()) {
			String containerId = item.getText(0);
			containerIds.add(containerId);
		}
		XdockerStartCntnrJob job = new XdockerStartCntnrJob(containerIds);
		job.addJobChangeListener(new JobChangeListener(this, job) {
			@Override
			public void done(IJobChangeEvent event) {
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						search();
					}
				});
			}
		});
		job.schedule();
	}

	private void stopSelectedContainers() {
		if (table.getSelectionIndex() < 0)
			return;
		stopSelectedContainers(table.getSelection());
	}

	private void stopSelectedContainers(TableItem[] items) {
		List<String> containerIds = new ArrayList<>();
		for (TableItem item : table.getSelection()) {
			String containerId = item.getText(0);
			containerIds.add(containerId);
		}
		XdockerStopCntnrJob job = new XdockerStopCntnrJob(containerIds);
		job.addJobChangeListener(new JobChangeListener(this, job) {
			@Override
			public void done(IJobChangeEvent event) {
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						search();
					}
				});
			}
		});
		job.schedule();
	}

	private void removeSelectedContainers() {
		if (table.getSelectionIndex() < 0)
			return;
		removeSelectedContainers(table.getSelection());
	}

	private void removeSelectedContainers(TableItem[] items) {
		List<String> containerIds = new ArrayList<>();
		for (TableItem item : table.getSelection()) {
			String containerId = item.getText(0);
			containerIds.add(containerId);
		}
		XdockerRemoveCntnrJob job = new XdockerRemoveCntnrJob(containerIds);
		job.addJobChangeListener(new JobChangeListener(this, job) {
			@Override
			public void done(IJobChangeEvent event) {
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						search();
					}
				});
			}
		});
		job.schedule();
	}

	private void logsOfSelectedContainers() {
		if (table.getSelectionIndex() < 0)
			return;
		logsOfSelectedContainers(table.getSelection());
	}

	private void logsOfSelectedContainers(TableItem[] items) {
		List<String> containerIds = new ArrayList<>();
		for (TableItem item : table.getSelection()) {
			String containerId = item.getText(0);
			containerIds.add(containerId);
		}
		XdockerShowLogsJob job = new XdockerShowLogsJob(containerIds);
		job.schedule();
	}

	private void search() {
		table.removeAll();
		XdockerListCntnrsJob job = new XdockerListCntnrsJob(buttonAll.getSelection());
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
			Locale defLocale = Locale.getDefault();
			try {
				Locale.setDefault(Locale.UK); // we support only English!
				PrettyTime pt = new PrettyTime();
				@SuppressWarnings("unchecked")
				List<Container> images = (List<Container>) status.getArgument();
				for (Object obj : images) {
					Container container = obj instanceof Container ? (Container) obj : null;
					if (container == null)
						return; // something is very odd here... go away!
					if (!match(container))
						continue; // skip because unwanted!
					TableItem item = new TableItem(table, SWT.NONE);
					List<String> elements = new ArrayList<String>();
					// elements.add(substring(container.getId(), 0, 12));
					elements.add(container.getId());
					elements.add(container.getImage());
					elements.add(container.getCommand());
					elements.add(pt.format(new Date(container.getCreated() * 1000)));
					elements.add(container.getStatus());
					StringBuffer ports = new StringBuffer();
					for (ContainerPort port : container.getPorts()) {
						boolean hasIP, hasPrivPort;
						if (hasIP = isNotBlank(port.getIp())) {
							ports.append(port.getIp());
						}
						if (hasPrivPort = port.getPrivatePort() != null) {
							if (hasIP) {
								ports.append(":");
							}
							ports.append(String.valueOf(port.getPrivatePort()));
						}
						if (port.getPublicPort() != null) {
							if (hasIP || hasPrivPort) {
								ports.append("->");
							}
							ports.append(String.valueOf(port.getPublicPort()));
						}
						if (port.getType() != null) {
							ports.append("/");
							ports.append(port.getType());
						}
					}
					elements.add(ports.toString());
					elements.add(StringUtils.join(container.getNames()));
					item.setText(elements.toArray(new String[] {}));
				}
				for (int i = 0, n = table.getColumnCount(); i < n; i++) {
					table.getColumn(i).pack();
				}
				table.getColumn(0).setWidth(120);
				table.getColumn(1).setWidth(120);
				table.getColumn(2).setWidth(120);
			} finally {
				Locale.setDefault(defLocale); // restore to default...
			}
		}
	}

	private boolean match(Container container) {
		String term = searchInput.getText();
		if (container == null) {
			return false;
		} else if (term == null || term.trim().isEmpty()) {
			return true;
		} else {
			return term != null && container.getImage() != null
					&& (contains(container.getImage(), term) || contains(container.getCommand(), term)
							|| contains(container.getId(), term) || contains(container.getStatus(), term)
							|| (contains(container.getNames(), term)) || (contains(container.getPorts(), term))
							|| (contains(container.getLabels(), term)));
		}
	}

	private boolean contains(String value, String term) {
		return value != null && value.contains(term);
	}

	private boolean contains(ContainerPort[] values, String term) {
		for (ContainerPort value : values) {
			if (contains(value.toString(), term))
				return true;
		}
		return false;
	}

	private boolean contains(String[] values, String term) {
		return contains(Arrays.asList(values), term);
	}

	private boolean contains(Map<String, String> map, String term) {
		if (map == null)
			return false;
		if (contains(map.values(), term) || contains(map.keySet(), term))
			return true;
		return false;
	}

	private boolean contains(Collection<String> values, String term) {
		if (values == null)
			return false;
		for (String value : values) {
			if (contains(value, term))
				return true;
		}
		return false;
	}
}
