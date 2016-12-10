package ch.itemis.xdocker.app.xdockerscout.shared.prefs;

import java.security.BasicPermission;

public class UpdateXdockerDockerPropertiesPermission extends BasicPermission {

	private static final long serialVersionUID = 1L;

	public UpdateXdockerDockerPropertiesPermission() {
		super(UpdateXdockerDockerPropertiesPermission.class.getSimpleName());
	}
}
