package io.github.jhipster.jdl.web

import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.eclipse.xtext.util.DisposableRegistry
import org.eclipse.xtext.web.servlet.XtextServlet

/**
 * Deploy this class into a servlet container to enable DSL-specific services.
 */
@WebServlet(name = 'XtextServices', urlPatterns = '/xtext-service/*')
class JDLServlet extends XtextServlet {

	DisposableRegistry disposableRegistry

	override init() {
		super.init()
		val injector = new JDLWebSetup().createInjectorAndDoEMFRegistration()
		disposableRegistry = injector.getInstance(DisposableRegistry)
	}
	
	override destroy() {
		if (disposableRegistry !== null) {
			disposableRegistry.dispose()
			disposableRegistry = null
		}
		super.destroy()
	}
	
	override protected service(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
		rsp.setHeader('Access-Control-Allow-Origin', '*')
		rsp.setHeader('Access-Control-Allow-Methods', 'POST, PUT, GET, OPTIONS, HEAD')
		super.service(req, rsp)
	}	
}
