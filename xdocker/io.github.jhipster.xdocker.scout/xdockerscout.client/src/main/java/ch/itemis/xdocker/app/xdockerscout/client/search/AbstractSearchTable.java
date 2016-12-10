package ch.itemis.xdocker.app.xdockerscout.client.search;

import java.util.List;
import java.util.Set;

import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.action.menu.IMenuType;
import org.eclipse.scout.rt.client.ui.action.menu.TableMenuType;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.ITable;
import org.eclipse.scout.rt.client.ui.basic.table.ITableRow;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.util.CollectionUtility;
import org.eclipse.scout.rt.shared.TEXTS;

public abstract class AbstractSearchTable extends AbstractTable {

	abstract protected void deleteTableRowsAction(ITable table, List<ITableRow> selectedRows);

	@Override
	protected boolean getConfiguredAutoResizeColumns() {
		return true;
	}

	@Order(80)
	public class SelectAllMenu extends AbstractMenu {

		@Override
		protected Set<? extends IMenuType> getConfiguredMenuTypes() {
			return CollectionUtility.<IMenuType>hashSet(TableMenuType.SingleSelection);
		}

		@Override
		protected String getConfiguredText() {
			return "Select All"; //TEXTS.get("");
		}

		@Override
		protected void execAction() {
			selectAllRows();
		}
	}

	@Order(81)
	public class DeleteMenu extends AbstractMenu {

		@Override
		protected Set<? extends IMenuType> getConfiguredMenuTypes() {
			return CollectionUtility.<IMenuType>hashSet(TableMenuType.MultiSelection, TableMenuType.SingleSelection);
		}

		@Override
		protected String getConfiguredText() {
			return "Remove"; //TEXTS.get("Delete");
		}

		@Override
		protected void execAction() {
			List<ITableRow> rows = getSelectedRows();
			if (rows != null && !rows.isEmpty()) {
				deleteTableRowsAction(AbstractSearchTable.this, rows);
			}
		}
	}
}
