package ch.itemis.xdocker.app.xdockerscout.client;

import org.eclipse.scout.rt.client.AbstractClientSession;
//import org.eclipse.scout.rt.client.IClientSession;
import org.eclipse.scout.rt.client.session.ClientSessionProvider;
import org.eclipse.scout.rt.shared.services.common.code.CODES;

/**
 * <h3>{@link ClientSession}</h3>
 *
 * @author serano
 */
public class ClientSession extends AbstractClientSession {

	public ClientSession() {
		super(true);
	}

	/**
	 * @return The {@link IClientSession} which is associated with the current
	 *         thread, or <code>null</code> if not found.
	 */
	public static ClientSession get() {
		return ClientSessionProvider.currentSession(ClientSession.class);
	}

	@Override
	protected void execLoadSession() {
		// pre-load all known code types
		CODES.getAllCodeTypes("ch.itemis.xdocker.app.xdockerscout.shared");
		setDesktop(new Desktop());
	}
}
