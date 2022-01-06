/**
 * Copyright 2016-2022 the original author or authors from the JHipster project.
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

import com.google.inject.Inject
import io.github.jhipster.jdl.jdl.JdlApplicationParameter
import io.github.jhipster.jdl.jdl.JdlDeploymentParameter
import io.github.jhipster.jdl.jdl.JdlDisplayField
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlParameterValue
import io.github.jhipster.jdl.jdl.JdlParameterVersion
import io.github.jhipster.jdl.jdl.JdlRelationRole
import io.github.jhipster.jdl.util.JdlModelUtil
import jbase.config.JDLApplicationOptions
import jbase.config.JDLDeploymentOptions
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor

import static org.eclipse.xtext.EcoreUtil2.*

import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JdlIdeContentProposalProvider extends JdlIdeAbstractContentProposalProvider {

	val applOptions = JDLApplicationOptions.INSTANCE
	val deplOptions = JDLDeploymentOptions.INSTANCE
	
	@Inject extension JdlModelUtil
	@Inject extension JdlIdeTemplateProposalProvider templateProposal
	
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
		model.useITempl ? templateProposal.acceptProposal(context, acceptor)
		addOptions(model, context, acceptor)
		switch (model) {
			JdlApplicationParameter: createParameterProposal(applOptions, model, assignment, context, acceptor)
			JdlDeploymentParameter: createParameterProposal(deplOptions, model, assignment, context, acceptor)
			JdlParameterValue case model.eContainer instanceof JdlApplicationParameter: {
				val param = getContainerOfType(model, JdlApplicationParameter)
				createParameterProposal(applOptions, param, assignment, context, acceptor)
			}
			JdlParameterValue case model.eContainer instanceof JdlDeploymentParameter: {
				val param = getContainerOfType(model, JdlDeploymentParameter)
				createParameterProposal(deplOptions, param, assignment, context, acceptor)
			}
            JdlDisplayField: {
                val relationRole = getContainerOfType(model, JdlRelationRole)
                val opposite = relationRole.opposite
                val entity = opposite.entity
                entity.fieldDefinition.fields.forEach[ addProposal(name, context, acceptor) ]
            }
			JdlParameterVersion: return
			default: super.createProposals(assignment, context, acceptor)
		}
	}

	def private void addOptions(EObject eObj, extension ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		val model = getContainerOfType(eObj, JdlDomainModel)
		if (model === null || model.eResource.allContents.isNullOrEmpty  ||
			getLineAndColumn(eObj?.node, offset).line == 1) {
			OPTION_PROPOSALS.forEach[ prop, desc |
				addProposal(prop, desc, context, acceptor)
			]
		} 	
	}
	
	def private boolean isValid(EObject model) {
		return model === null || !model.hasIssues
	}
	
	def private boolean useITempl(EObject model) {
		return Boolean.getBoolean('itempl') && model.isValid 
	}
}
