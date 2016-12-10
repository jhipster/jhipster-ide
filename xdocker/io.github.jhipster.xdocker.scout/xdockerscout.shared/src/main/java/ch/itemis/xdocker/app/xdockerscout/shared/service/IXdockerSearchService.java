package ch.itemis.xdocker.app.xdockerscout.shared.service;

import java.util.List;

import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;

/**
 * <h3>{@link IXdockerSearchService}</h3>
 *
 * @author serano
 */
@TunnelToServer
public interface IXdockerSearchService extends IService {
	public List<String> searchImages(String term);
	public List<String> listContainers(String term);
	
}
