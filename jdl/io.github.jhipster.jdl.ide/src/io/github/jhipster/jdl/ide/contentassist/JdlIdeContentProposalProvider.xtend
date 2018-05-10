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

import com.google.inject.Inject
import io.github.jhipster.jdl.jdl.JdlApplication
import io.github.jhipster.jdl.jdl.JdlApplicationConfig
import io.github.jhipster.jdl.jdl.JdlApplicationParameter
import io.github.jhipster.jdl.jdl.JdlApplicationParameterValue
import io.github.jhipster.jdl.model.JdlApplicationOptions
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode

import static io.github.jhipster.jdl.model.JdlLanguages.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JdlIdeContentProposalProvider extends IdeContentProposalProvider {

	@Inject IdeContentProposalPriorities proposalPriorities
	
	val options = JdlApplicationOptions.INSTANCE
	
	override protected createProposals(AbstractElement assignment, ContentAssistContext context,
		IIdeContentProposalAcceptor acceptor) {
		val model = context.currentModel
		if (model.hasIssues && (
			model instanceof JdlApplication // || model instanceof JdlApplicationConfig
		)) {
			super.createProposals(assignment, context, acceptor)
			return
		}
		switch (model) {
			JdlApplicationConfig: {
				val existingParamNames = if (!model.paramters.isNullOrEmpty) model.paramters.map[it.paramName] else #[]
				options.names.filter[!existingParamNames.contains(it)].forEach[addProposal(context, acceptor)]
			}
			JdlApplicationParameter: createParameterProposal(model, assignment, context, acceptor)
			JdlApplicationParameterValue: {
				val param = EcoreUtil2.getContainerOfType(model, JdlApplicationParameter)
				createParameterProposal(param, assignment, context, acceptor)
			}
		}
	}
	
	def private createParameterProposal(JdlApplicationParameter param, AbstractElement assignment, ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		if (param === null) return
		val paramValue = param.paramValue
		val params = options.getParameters(param.paramName)
		val type = options.getParameterType(param.paramName)
		switch (type) {
			case Boolean : if (paramValue === null || paramValue.identifiers.isNullOrEmpty)
				#[Boolean.FALSE, Boolean.TRUE].map[
					proposalCreator.createProposal(it.toString, context)
				].forEach[ entry |
					acceptor.accept(entry, proposalPriorities.getDefaultPriority(entry))
				]
			case ListOfLangIsoCodes : {
				val existingParams = paramValue?.identifiers ?: #[]
				if (existingParams.isNullOrEmpty) {
					addProposal('''[«params.join(', ')»]''', context, acceptor)
				} else {
					JHipsterIsoLangauges.filter[ String k, String v |
						!existingParams.contains(k)
					].forEach[ String k, String v |
						addProposal('''«IF !existingParams.isNullOrEmpty», «ENDIF»«k»''', v, context, acceptor)
					]
				}
			}
			case ListOfLiterals : {
				val existingParams = paramValue?.identifiers ?: #[]
				if (existingParams.isNullOrEmpty) {
					addProposal('''[«params.join(', ')»]''', context, acceptor)
				} else {
					params.filter[
						!existingParams.contains(it)
					].forEach[
						addProposal(''', «it»''', context, acceptor)
					]
				}
			}
			case LangIsoCode : if (paramValue === null || paramValue.identifiers.isNullOrEmpty) 
				JHipsterIsoLangauges.forEach[ String key, String value |
					addProposal(key, value, context, acceptor)
				]
			case Namespace : addProposal('io.github.jhipster.myapp', context, acceptor)
			case Version : addProposal('0.0.0', context, acceptor)
			case Literal :  params.forEach[addProposal(context, acceptor)]
			default : super.createProposals(assignment, context, acceptor) 
		}
	}
	
	def private void addProposal(String proposal, ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		addProposal(proposal, null, context, acceptor)
	}
	
	def private void addProposal(String proposal, String description, ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		val entry = proposalCreator.createProposal(proposal, context)
		if (entry !== null) entry.description = description
		acceptor.accept(entry, proposalPriorities.getDefaultPriority(entry))
	}
	
	def private boolean hasIssues(EObject model) {
		if (model === null) return true
		val res = (model.eResource as XtextResource)
		val issues = res.resourceServiceProvider.resourceValidator.validate(res, CheckMode.FAST_ONLY, CancelIndicator.NullImpl)
		return !issues.isNullOrEmpty && !(model instanceof JdlApplicationParameter)
	}
}
