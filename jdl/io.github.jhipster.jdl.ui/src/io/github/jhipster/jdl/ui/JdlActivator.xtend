/**
 * Copyright 2016-2025 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.ui

import com.google.inject.Guice
import com.google.inject.Injector
import io.github.jhipster.jdl.ide.JdlIdeModule
import io.github.jhipster.jdl.ui.util.SWTResourceManager
import org.apache.log4j.Logger
import org.eclipse.xtext.util.Modules2
import org.osgi.framework.BundleContext

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JdlActivator extends io.github.jhipster.jdl.ui.internal.JdlActivator {
	static final Logger logger = Logger.getLogger(JdlActivator)

	/*
	 * (non-Javadoc)
	 * @see io.github.jhipster.jdl.ui.internal.JdlActivator#createInjector(java.lang.String)
	 */
	override protected Injector createInjector(String language) {
		try {
			val runtimeModule = getRuntimeModule(language)
			val sharedStateModule = getSharedStateModule()
			val uiModule = getUiModule(language)
			val ideModule = new JdlIdeModule()
			val mergedModule = Modules2.mixin(runtimeModule, sharedStateModule, uiModule, ideModule)
			return Guice.createInjector(mergedModule)
		} catch (Exception e) {
			logger.error('''Failed to create injector for «language»''')
			logger.error(e.getMessage(), e)
			throw new RuntimeException('''Failed to create injector for «language»''', e)
		}
	}
	
	override stop(BundleContext context) throws Exception {
		super.stop(context)
		SWTResourceManager.dispose
	}
}
