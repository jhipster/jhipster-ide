/**
 * Copyright 2013-2018 the original author or authors from the JHipster project.
 *
 * This file is part of the JHipster project, see http://www.jhipster.tech/
 * for more information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
 * 
 * @author Serano Colameo - Initial contribution and API
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
