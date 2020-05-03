/**
 * Copyright 2013-2020 the original author or authors from the JHipster project.
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

import io.github.jhipster.jdl.jdl.JdlApplication
import io.github.jhipster.jdl.jdl.JdlApplicationConfig
import io.github.jhipster.jdl.jdl.JdlApplicationParameter
import io.github.jhipster.jdl.jdl.JdlDeployment
import io.github.jhipster.jdl.jdl.JdlDeploymentParameter
import io.github.jhipster.jdl.jdl.JdlParameterValue
import java.util.List
import jbase.config.JDLApplicationOptions
import jbase.config.JDLDeploymentOptions
import jbase.config.JDLLanguages
import jbase.config.JDLParameterType
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode

import static org.eclipse.xtext.EcoreUtil2.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
abstract class JdlIdeAbstractContentProposalProvider extends IdeContentProposalProvider {

	extension JDLLanguages = JDLLanguages.INSTANCE

	def dispatch void createParameterProposal(JDLDeploymentOptions options, JdlDeploymentParameter param, AbstractElement assignment, ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		if (param === null) return
		val paramValue = param.paramValue
		val params = options.getParameters(param.paramName.literal)
		val type = options.getParameterType(param.paramName.literal)
		createParameterProposal(param, paramValue, params, type, assignment, context, acceptor)
	}
	
	def dispatch void createParameterProposal(JDLApplicationOptions options, JdlApplicationParameter param, AbstractElement assignment, ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		if (param === null) return
		val paramValue = param.paramValue
		val params = options.getParameters(param.paramName.literal)
		val type = options.getParameterType(param.paramName.literal)
		createParameterProposal(param, paramValue, params, type, assignment, context, acceptor)
	}

	def private void createParameterProposal(EObject param, JdlParameterValue paramValue, List<String> params, JDLParameterType type, AbstractElement assignment, ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		switch (type) {
			case Boolean : if (!param.isDefined)
				#[Boolean.FALSE, Boolean.TRUE].map[
					proposalCreator.createProposal(it.toString, context)
				].forEach[ entry |
					acceptor.accept(entry, proposalPriorities.getDefaultPriority(entry))
				]
			case ListOfLangIsoCodes : {
				val existingParams = paramValue?.listElements ?: #[]
				if (existingParams.isNullOrEmpty) {
					addProposal('''[«params.join(', ')»]''', context, acceptor)
				} else {
					JHipsterIsoLangauges.filter[
						!existingParams.contains(code)
					].forEach[ 
						addProposal('''«IF !existingParams.isNullOrEmpty», «ENDIF»«code»''', name, context, acceptor)
					]
				}
			}
			case ListOfLiterals : {
				val existingParams = paramValue?.listElements ?: #[]
				if (existingParams.isNullOrEmpty) {
					val text = context.currentNode?.text?.trim
					val brackets = if (text.isNullOrEmpty) #['[',']'] 
									else if (context.currentModel.hasIssues && text == ']') #['[', ''] 
									else if (context.prefix.trim == '[') #['', ']'] 
									else #['', '']
					addProposal('''«brackets.head»«params.join(', ')»«brackets.last»''', context, acceptor)
				} else {
					params.filter[
						!existingParams.contains(it)
					].forEach[
						addProposal(''', «it»''', context, acceptor)
					]
				}
			}
			case ListOfAnyLiterals : addProposal('''[]''', context, acceptor)
			case LangIsoCode : if (!param.isDefined) 
				JHipsterIsoLangauges.forEach[
					addProposal(code, name, context, acceptor)
				]
			case Namespace : if (!param.isDefined) addProposal('io.github.jhipster.myapp', context, acceptor)
			case Version : if (!param.isDefined) addProposal('"0.0.0"', context, acceptor)
			case EnumLiteral,
			case Number,
			case AnyLiteral,
			case JavaIdentifierLiteral : if (!param.isDefined) params.forEach[addProposal(context, acceptor)]
			case String : if (!param.isDefined) addProposal('"undefined"', context, acceptor)
			default : super.createProposals(assignment, context, acceptor) 
		}
	}

	def protected void addProposal(String proposal, ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		addProposal(proposal, null, context, acceptor)
	}
	
	def protected void addProposal(String proposal, String description, ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		val entry = proposalCreator.createProposal(proposal, context)
		if (entry !== null) entry.description = description
		acceptor.accept(entry, proposalPriorities.getDefaultPriority(entry))
	}
	
	def protected boolean hasIssues(EObject model) {
		if (model === null) return true
		val res = (model.eResource as XtextResource)
		val issues = res.resourceServiceProvider.resourceValidator.validate(res, CheckMode.FAST_ONLY, CancelIndicator.NullImpl)
		return !issues.isNullOrEmpty && !(model instanceof JdlApplicationParameter)
	}

	def private boolean isDefined(EObject param) {
		return switch (param) {
			JdlApplicationParameter: param.isDefined
			JdlDeploymentParameter: param.isDefined
			default: false
		}
	}

	def private boolean isDefined(JdlApplicationParameter appParam) {
		return appParam !== null && appParam.paramValue.isDefined
	}

	def private boolean isDefined(JdlDeploymentParameter deplParam) {
		return deplParam !== null && deplParam.paramValue.isDefined
	}
	
	def private boolean isDefined(JdlParameterValue it) {
		return if (it !== null) it.version !== null 
			   || !it.identifiers.isNullOrEmpty || !it.listElements.isNullOrEmpty 
			   || it.numberValue != 0 || !it.stringValue.isNullOrEmpty else false
	}
	
	def protected boolean isJdlApplication(ContentAssistContext context) {
		return getContainerOfType(context.currentModel, JdlApplication) !== null 
	}

	def protected boolean isJdlDeployment(ContentAssistContext context) {
		return getContainerOfType(context.currentModel, JdlDeployment) !== null 
	}
	
	def protected List<String> getDeploymentParameters(ContentAssistContext context) {
		val cfg = getContainerOfType(context.currentModel, JdlDeployment)
		val params = if (cfg !== null && !cfg.paramters.isNullOrEmpty) cfg.paramters.map[paramName] else #[]
		return params.map[literal]
	}

	def protected List<String> getAppliactionParameters(ContentAssistContext context) {
		val cfg = getContainerOfType(context.currentModel, JdlApplicationConfig)
		val params = if (cfg !== null && !cfg.paramters.isNullOrEmpty) cfg.paramters.map[paramName] else #[]
		return params.map[literal]
	}
}
