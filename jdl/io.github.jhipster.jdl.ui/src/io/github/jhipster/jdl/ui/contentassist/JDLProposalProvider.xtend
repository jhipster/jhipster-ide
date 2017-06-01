package io.github.jhipster.jdl.ui.contentassist

import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext

/**
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist
 * on how to customize the content assistant.
 */
class JDLProposalProvider extends AbstractJDLProposalProvider {
	
	override protected isValidProposal(String proposal, String prefix, ContentAssistContext context) {
		!proposal.isNullOrEmpty
	}
	
}
