package ch.itemis.xdocker.app.xdockerscout.client.search;

import static ch.itemis.xdocker.app.xdockerscout.client.util.ScoutExtensions.showErrorMessageBox;

import java.net.URL;
import java.util.List;
import java.util.Set;

import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.action.menu.IMenuType;
import org.eclipse.scout.rt.client.ui.action.menu.TableMenuType;
import org.eclipse.scout.rt.client.ui.basic.table.ITable;
import org.eclipse.scout.rt.client.ui.basic.table.ITableRow;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.desktop.OpenUriAction;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.tablefield.AbstractTableField;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.resource.BinaryResource;
import org.eclipse.scout.rt.platform.util.CollectionUtility;

import ch.itemis.xdocker.app.xdockerscout.client.ClientSession;
import ch.itemis.xdocker.app.xdockerscout.shared.service.IXdockerDockerService;
import ch.itemis.xdocker.lib.DockerProperties;
import ch.itemis.xdocker.lib.util.DockerPropertiesUtil;

/**
 * XdockerContainerSearchTable
 * 
 * @author Serano Colameo - Initial contribution and API
 */
public abstract class XdockerContainerSearchTable extends AbstractGroupBox {

	@Override
	protected void execInitField() {
		getTableField().getTable().getColumns();
	}

	public TableField getTableField() {
		return getFieldByClass(TableField.class);
	}

	@Override
	protected String getConfiguredLabel() {
		return "Docker Containers";
	}

	protected abstract void deleteTableRowsAction(ITable table, List<ITableRow> selectedRows);

	@Order(1000)
	public class TableField extends AbstractTableField<TableField.Table> {
		@Override
		protected boolean getConfiguredLabelVisible() {
			return false;
		}

		@Override
		protected int getConfiguredGridH() {
			return 6;
		}

		public class Table extends AbstractSearchTable {

			@Order(10)
			public class ContainerIdColumn extends AbstractStringColumn {
				@Override
				protected String getConfiguredHeaderText() {
					return "Container Id";
				}
			}

			@Order(20)
			public class ImageColumn extends AbstractStringColumn {
				@Override
				protected String getConfiguredHeaderText() {
					return "Image";
				}
			}

			@Order(30)
			public class CommandColumn extends AbstractStringColumn {
				@Override
				protected String getConfiguredHeaderText() {
					return "Command";
				}
			}

			@Order(40)
			public class CreatedColumn extends AbstractStringColumn {
				@Override
				protected String getConfiguredHeaderText() {
					return "Created";
				}
			}

			@Order(50)
			public class StatusColumn extends AbstractStringColumn {
				@Override
				protected String getConfiguredHeaderText() {
					return "Status";
				}
			}

			@Order(60)
			public class PortsColumn extends AbstractStringColumn {
				@Override
				protected String getConfiguredHeaderText() {
					return "Ports";
				}
			}

			@Order(70)
			public class NamesColumn extends AbstractStringColumn {
				@Override
				protected String getConfiguredHeaderText() {
					return "Names";
				}
			}

			@Override
			protected void deleteTableRowsAction(ITable table, List<ITableRow> selectedRows) {
				XdockerContainerSearchTable.this.deleteTableRowsAction(Table.this, selectedRows);
			}

			@Order(81)
			public class OpenMenu extends AbstractMenu {
				@Override
				protected Set<? extends IMenuType> getConfiguredMenuTypes() {
					return CollectionUtility.<IMenuType>hashSet(TableMenuType.MultiSelection,
							TableMenuType.SingleSelection);
				}

				@Override
				protected String getConfiguredText() {
					return "Open..."; // TEXTS.get("Run");
				}

				@Override
				protected void execAction() {
					try {
						DockerProperties props = DockerPropertiesUtil.loadFromDisk();
						URL url = new URL(props.getDockerHost());
						String[] ports = getSelectedRow().getCellValue(5).toString().split(",");
						String localPort = null;
						for (String port : ports) {
							if (port.contains("->")) {
								localPort = port.split("->")[1];
								System.out.println(localPort);
							}
						}
						if (localPort != null && localPort.isEmpty() == false) {
							String port = localPort.replaceAll("\\D+", "");
							String addr = "http://" + url.getHost() + ":" + port;
							ClientSession.get().getDesktop().openUri(addr, OpenUriAction.NEW_WINDOW);
						}
					} catch (Exception e) {
						showErrorMessageBox("Run Docker Container...", e);
					}
				}
			}

			@Order(91)
			public class LogMenu extends AbstractMenu {
				@Override
				protected Set<? extends IMenuType> getConfiguredMenuTypes() {
					return CollectionUtility.<IMenuType>hashSet(TableMenuType.MultiSelection,
							TableMenuType.SingleSelection);
				}

				@Override
				protected String getConfiguredText() {
					return "Logs..."; // TEXTS.get("Run");
				}

				@Override
				protected void execAction() {
					try {
						IXdockerDockerService docker = BEANS.get(IXdockerDockerService.class);
						String containerId = getSelectedRow().getCell(0).toString();
						StringBuffer logBuffer = docker.logContainer(containerId);
						String logFile = containerId + ".log";
						BinaryResource resource = new BinaryResource(logFile, logBuffer.toString().getBytes());
						ClientSession.get().getDesktop().openUri(resource, OpenUriAction.NEW_WINDOW);
					} catch (Exception e) {
						showErrorMessageBox("Run Docker Container...", e);
					}
				}
			}
		}
	}
}
