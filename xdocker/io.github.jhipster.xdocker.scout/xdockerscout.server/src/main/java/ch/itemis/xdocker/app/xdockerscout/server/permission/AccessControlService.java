package ch.itemis.xdocker.app.xdockerscout.server.permission;

import java.security.AllPermission;
import java.security.PermissionCollection;
import java.security.Permissions;

import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.shared.security.RemoteServiceAccessPermission;
import org.eclipse.scout.rt.testing.shared.AllAccessControlService;

/**
 * <h3>{@link AccessControlService}</h3>
 *
 * @author serano
 */
@Order(-1)
public class AccessControlService extends AllAccessControlService {
	
// FIXME!!!!!!
//	@Override
//	protected PermissionCollection execLoadPermissions(String userId) {
//	    AllPermission allPermission = new AllPermission();
//	    PermissionCollection permissionCollection = allPermission.newPermissionCollection();
//		Permissions permissions = new Permissions();
//		permissions.add(new RemoteServiceAccessPermission("*.shared.*", "*"));
//	    permissionCollection.add(allPermission);
//	    permissionCollection.setReadOnly();
//		return permissions;
//	}
}
