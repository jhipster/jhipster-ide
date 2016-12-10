package ch.itemis.xdocker.app.xdockerscout.shared.service;

import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;

import ch.itemis.xdocker.app.xdockerscout.shared.service.XdockerEditorFormData;

/**
 * <h3>{@link IXdockerEditorFormService}</h3>
 *
 * @author serano
 */
@TunnelToServer
public interface IXdockerEditorFormService extends IService {
	
	XdockerEditorFormData load(XdockerEditorFormData input);

	XdockerEditorFormData load(XdockerEditorFormData input, String pathToFile);
}
