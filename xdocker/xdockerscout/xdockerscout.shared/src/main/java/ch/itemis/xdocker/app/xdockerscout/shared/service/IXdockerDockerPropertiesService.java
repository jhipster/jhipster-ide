package ch.itemis.xdocker.app.xdockerscout.shared.service;

import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;

import ch.itemis.xdocker.app.xdockerscout.shared.prefs.XdockerDockerPreferncesFormData;

@TunnelToServer
public interface IXdockerDockerPropertiesService extends IService {

	XdockerDockerPreferncesFormData load();

	void store(XdockerDockerPreferncesFormData input);
}
