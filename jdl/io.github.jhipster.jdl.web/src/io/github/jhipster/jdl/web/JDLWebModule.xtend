package io.github.jhipster.jdl.web

import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider
import io.github.jhipster.jdl.ide.contentassist.JdlIdeContentProposalProvider

/**
 * Use this class to register additional components to be used within the web application.
 */
class JDLWebModule extends AbstractJDLWebModule {
	
	def Class<? extends IdeContentProposalProvider> bindIdeContentProposalProvider() {
		return JdlIdeContentProposalProvider
	}
}
