package ch.itemis.xdocker.app.xdockerscout.client.search;

import static ch.itemis.xdocker.app.xdockerscout.client.util.ScoutExtensions.showErrorMessageBox;
import static ch.itemis.xdocker.app.xdockerscout.client.util.ScoutExtensions.showInfoMessageBox;

import java.util.List;
import java.util.Set;

import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.action.menu.IMenuType;
import org.eclipse.scout.rt.client.ui.action.menu.TableMenuType;
import org.eclipse.scout.rt.client.ui.basic.table.ITable;
import org.eclipse.scout.rt.client.ui.basic.table.ITableRow;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.tablefield.AbstractTableField;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.util.CollectionUtility;

import ch.itemis.xdocker.app.xdockerscout.client.search.XdockerImageSearchForm.MainBox.SearchGroupBox.SearchBox.ImageNameField;
import ch.itemis.xdocker.app.xdockerscout.shared.service.IXdockerDockerService;
import ch.itemis.xdocker.app.xdockerscout.shared.service.XdockerDockerServiceException;
import ch.itemis.xdocker.lib.config.DockerRunConfig;

public abstract class XdockerImageSearchTable extends AbstractGroupBox {

	@Override
	protected void execInitField() {
		getLocalImagesTableField().setVisible(true);
		getRemoteImagesTableField().setVisible(false);
	}

	public LocalImagesTableField getLocalImagesTableField() {
		return getFieldByClass(LocalImagesTableField.class);
	}
	
	public RemoteImagesTableField getRemoteImagesTableField() {
		return getFieldByClass(RemoteImagesTableField.class);
	}

	@Override
	protected String getConfiguredLabel() {
		return "Docker Images";
	}

	abstract protected void deleteTableRowsAction(ITable table, List<ITableRow> selectedRows);

	public abstract class AbstractImagesTableField<T extends ITable> extends AbstractTableField<T> {
		@Override
		protected boolean getConfiguredLabelVisible() {
			return false;
		}

		@Override
		protected int getConfiguredGridH() {
			return 6;
		}
	}	
	
	@Order(1000)
	public class LocalImagesTableField extends AbstractImagesTableField<LocalImagesTableField.Table> {
		public class Table extends AbstractSearchTable {
			@Override
			protected boolean getConfiguredAutoResizeColumns() {
				return true;
			}

			@Order(10)
			public class RepositoryColumn extends AbstractStringColumn {
				@Override
				protected String getConfiguredHeaderText() {
					return "Repository";
				}
			}

			@Order(20)
			public class TagColumn extends AbstractStringColumn {
				@Override
				protected String getConfiguredHeaderText() {
					return "Tag";
				}
			}

			@Order(30)
			public class ImageIdCountColumn extends AbstractStringColumn {
				@Override
				protected String getConfiguredHeaderText() {
					return "Image ID";
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
			public class VirtualSizeColumn extends AbstractStringColumn {
				@Override
				protected String getConfiguredHeaderText() {
					return "Virtual Size";
				}
			}

			@Override
			protected void deleteTableRowsAction(ITable table, List<ITableRow> selectedRows) {
				XdockerImageSearchTable.this.deleteTableRowsAction(Table.this, selectedRows);
			}
			
			@Order(81)
			public class RunMenu extends AbstractMenu {
				@Override
				protected Set<? extends IMenuType> getConfiguredMenuTypes() {
					return CollectionUtility.<IMenuType>hashSet(TableMenuType.MultiSelection, TableMenuType.SingleSelection);
				}

				@Override
				protected String getConfiguredText() {
					return "Run"; //TEXTS.get("Run");
				}

				@Override
				protected void execAction() {
					try {
						String imageid = getSelectedRow().getCellValue(2).toString();
						DockerRunConfig cfg = new DockerRunConfig(
							imageid,
							" ",
							true,
							"",
							new String[]{"8080"},
							false,
							false,
							false,
							false,
							false,
							true,
							true
						);
						IXdockerDockerService docker = BEANS.get(IXdockerDockerService.class);
						String containerId = docker.run(imageid, " ", cfg);
						showInfoMessageBox("Container started!", "Image with ID" + imageid + " started with id: " + containerId);
					} catch (XdockerDockerServiceException e) {
						showErrorMessageBox("Run Docker Container...", e);
					}
				}
			}
		}
	}
	
	@Order(1000)
	public class RemoteImagesTableField extends AbstractImagesTableField<RemoteImagesTableField.Table> {
		public class Table extends AbstractSearchTable {
			@Override
			protected boolean getConfiguredAutoResizeColumns() {
				return true;
			}
			
			@Order(10)
			public class NameColumn extends AbstractStringColumn {
				@Override
				protected String getConfiguredHeaderText() {
					return "Name";
				}
			}

			@Order(20)
			public class DescriptionColumn extends AbstractStringColumn {
				@Override
				protected String getConfiguredHeaderText() {
					return "Description";
				}
			}

			@Order(30)
			public class StarCountColumn extends AbstractStringColumn {
				@Override
				protected String getConfiguredHeaderText() {
					return "Star Count";
				}
			}
			
			@Order(40)
			public class OfficialColumn extends AbstractStringColumn {
				@Override
				protected String getConfiguredHeaderText() {
					return "Official";
				}
			}
			
			@Order(50)
			public class AutomatedColumn extends AbstractStringColumn {
				@Override
				protected String getConfiguredHeaderText() {
					return "Automated";
				}
			}

			@Override
			protected void deleteTableRowsAction(ITable table, List<ITableRow> selectedRows) {
				XdockerImageSearchTable.this.deleteTableRowsAction(Table.this, selectedRows);
			}
			
			@Order(60)
			public class PullMenu extends AbstractMenu {
				@Override
				protected Set<? extends IMenuType> getConfiguredMenuTypes() {
					return CollectionUtility.<IMenuType>hashSet(TableMenuType.MultiSelection,
							TableMenuType.SingleSelection);
				}

				@Override
				protected String getConfiguredText() {
					return "Pull"; // TEXTS.get("Run");
				}

				@Override
				protected void execAction() {
					try {
						IXdockerDockerService docker = BEANS.get(IXdockerDockerService.class);
						String image = getSelectedRow().getCell(0).toString();
						docker.pull(image);
					} catch (Exception e) {
						showErrorMessageBox("Pull Docker Image...", e);
					}
				}
			}
		}
	}
}
