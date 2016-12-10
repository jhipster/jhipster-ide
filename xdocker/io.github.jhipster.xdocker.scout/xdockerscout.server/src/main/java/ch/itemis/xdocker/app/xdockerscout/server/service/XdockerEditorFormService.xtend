package ch.itemis.xdocker.app.xdockerscout.server.service

import ch.itemis.xdocker.app.xdockerscout.server.ServerSession
import ch.itemis.xdocker.app.xdockerscout.shared.service.XdockerEditorFormData
import ch.itemis.xdocker.app.xdockerscout.shared.service.IXdockerEditorFormService

/** 
 * <h3>{@link XdockerFormService}</h3>
 * @author serano
 */
class XdockerEditorFormService implements IXdockerEditorFormService {

	override XdockerEditorFormData load(XdockerEditorFormData input) {
		load(input, null)
	}
	
	override XdockerEditorFormData load(XdockerEditorFormData input, String pathToFile) {
		var StringBuilder msg = new StringBuilder()
		msg.append("# Hello ").append(ServerSession.get().getUserId()).append("!\n")
		// msg.append("FROM tomcat:latest\n");
		// msg.append("CMD catalina.sh run\n");
		input.getXdockerEditor().setValue(msg.toString())
		return input
	}
}
