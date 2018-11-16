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

import io.github.jhipster.jdl.config.JdlApplicationOptions
import io.github.jhipster.jdl.config.JdlDeploymentOptions
import io.github.jhipster.jdl.jdl.JdlApplicationParameter
import io.github.jhipster.jdl.jdl.JdlDeploymentParameter
import io.github.jhipster.jdl.jdl.JdlParameterValue
import io.github.jhipster.jdl.jdl.JdlParameterVersion
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JdlIdeContentProposalProvider extends JdlIdeAbstractContentProposalProvider {

	val applOptions = JdlApplicationOptions.INSTANCE
	val deplOptions = JdlDeploymentOptions.INSTANCE
	
	override protected filterKeyword(Keyword keyword, ContentAssistContext context) {
		return keyword.value == 'name' || !keyword.parameterExists(context)
	}

	def private boolean parameterExists(Keyword keyword, ContentAssistContext context) {
		if (keyword.value.isNullOrEmpty) return false
		val params = if (context.isJdlApplication) context.appliactionParameters 
			else if (context.isJdlDeployment) context.deploymentParameters else #[]
		return params.exists[it == keyword.value]
	}

	override protected createProposals(AbstractElement assignment, ContentAssistContext context,
		IIdeContentProposalAcceptor acceptor) {
		val model = context.currentModel
//		if (model.hasIssues) {
//			super.createProposals(assignment, context, acceptor)
//			return
//		}
		switch (model) {
			JdlApplicationParameter: createParameterProposal(applOptions, model, assignment, context, acceptor)
			JdlDeploymentParameter: createParameterProposal(deplOptions, model, assignment, context, acceptor)
			JdlParameterValue case model.eContainer instanceof JdlApplicationParameter: {
				val param = EcoreUtil2.getContainerOfType(model, JdlApplicationParameter)
				createParameterProposal(applOptions, param, assignment, context, acceptor)
			}
			JdlParameterValue case model.eContainer instanceof JdlDeploymentParameter: {
				val param = EcoreUtil2.getContainerOfType(model, JdlDeploymentParameter)
				createParameterProposal(deplOptions, param, assignment, context, acceptor)
			}
			JdlParameterVersion: return
			default: super.createProposals(assignment, context, acceptor)
		}
	}
}
