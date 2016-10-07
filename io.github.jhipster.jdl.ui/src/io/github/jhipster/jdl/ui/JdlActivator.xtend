package io.github.jhipster.jdl.ui

import org.apache.log4j.Logger
import org.eclipse.xtext.util.Modules2
import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.Module
import io.github.jhipster.jdl.ide.JdlIdeModule

class JdlActivator extends io.github.jhipster.jdl.ui.internal.JdlActivator {
	static final Logger logger = Logger.getLogger(JdlActivator)

	/*
	 * (non-Javadoc)
	 * @see io.github.jhipster.jdl.ui.internal.JdlActivator#createInjector(java.lang.String)
	 */
	override protected Injector createInjector(String language) {
		try {
			var Module runtimeModule = getRuntimeModule(language)
			var Module sharedStateModule = getSharedStateModule()
			var Module uiModule = getUiModule(language)
			var Module ideModule = new JdlIdeModule()
			var Module mergedModule = Modules2.mixin(runtimeModule, sharedStateModule, uiModule, ideModule)
			return Guice.createInjector(mergedModule)
		} catch (Exception e) {
			logger.error('''Failed to create injector for «language»''')
			logger.error(e.getMessage(), e)
			throw new RuntimeException('''Failed to create injector for «language»''', e)
		}

	}
}
