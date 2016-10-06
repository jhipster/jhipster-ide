package io.github.jhipster.jdl.ui;

import org.apache.log4j.Logger;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import io.github.jhipster.jdl.ide.JdlIdeModule;

public class JdlActivator extends io.github.jhipster.jdl.ui.internal.JdlActivator {
	private static final Logger logger = Logger.getLogger(JdlActivator.class);

	/*
	 * (non-Javadoc)
	 * @see io.github.jhipster.jdl.ui.internal.JdlActivator#createInjector(java.lang.String)
	 */
	protected Injector createInjector(String language) {
		try {
			Module runtimeModule = getRuntimeModule(language);
			Module sharedStateModule = getSharedStateModule();
			Module uiModule = getUiModule(language);
			Module ideModule = new JdlIdeModule();
			Module mergedModule = Modules2.mixin(runtimeModule, sharedStateModule, uiModule, ideModule);
			return Guice.createInjector(mergedModule);
		} catch (Exception e) {
			logger.error("Failed to create injector for " + language);
			logger.error(e.getMessage(), e);
			throw new RuntimeException("Failed to create injector for " + language, e);
		}
	}	
}
