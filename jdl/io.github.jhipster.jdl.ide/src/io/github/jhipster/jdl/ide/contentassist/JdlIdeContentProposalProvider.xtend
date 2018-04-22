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
package io.github.jhipster.jdl.ide.contentassist

import io.github.jhipster.jdl.jdl.JdlApplicationParameter
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities
import com.google.inject.Inject
import io.github.jhipster.jdl.jdl.JdlApplicationConfig
import org.eclipse.xtext.EcoreUtil2
import io.github.jhipster.jdl.jdl.JdlApplication

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JdlIdeContentProposalProvider extends IdeContentProposalProvider {

	@Inject IdeContentProposalPriorities proposalPriorities

	override protected createProposals(AbstractElement assignment, ContentAssistContext context,
		IIdeContentProposalAcceptor acceptor) {
		val model = context.currentModel
		val application = EcoreUtil2.getContainerOfType(model, JdlApplication)
		switch (model) {
			JdlApplicationConfig: {
				val entry = proposalCreator.createProposal("param", context)
				acceptor.accept(
					entry, proposalPriorities.getDefaultPriority(entry)
				)
			}
			JdlApplicationParameter: {
				val entry = proposalCreator.createProposal("foobar", context)
				acceptor.accept(
					entry, proposalPriorities.getDefaultPriority(entry)
				)
			}
			default : super.createProposals(assignment, context, acceptor)
		}
	}
}
