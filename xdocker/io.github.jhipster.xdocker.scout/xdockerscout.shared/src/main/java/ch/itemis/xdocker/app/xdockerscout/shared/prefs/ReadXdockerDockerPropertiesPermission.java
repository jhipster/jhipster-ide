package ch.itemis.xdocker.app.xdockerscout.shared.prefs;

import java.security.BasicPermission;

public class ReadXdockerDockerPropertiesPermission extends BasicPermission {

	private static final long serialVersionUID = 1L;

	public ReadXdockerDockerPropertiesPermission() {
		super(ReadXdockerDockerPropertiesPermission.class.getSimpleName());
	}
}
