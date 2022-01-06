/** 
 * Copyright 2016-2022 the original author or authors from the JHipster project.
 * This file is part of the JHipster project, see http://www.jhipster.tech/
 * for more information.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.jhipster.jdl.ide.contentassist

import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.ide.editor.contentassist.AbstractIdeTemplateProposalProvider
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JdlIdeTemplateProposalProvider extends AbstractIdeTemplateProposalProvider {

	val StringConcatenationClient entityTemplate = '''
		/**
		 * «variable('EntityName')»
		 */
		entity «variable('EntityName')» {
			«cursor»
		}
	'''

	val StringConcatenationClient fieldTemplate = '''
		«variable('fieldName')» «cursor»
	'''

	val StringConcatenationClient applicationTemplate = '''
		application {
			config {
				«cursor»
			}
		}
	'''

	val Map<List<String>, Map<String, Pair<String, StringConcatenationClient>>> templates = #{
		#[JdlDomainModel.simpleName] -> #{
			'Entity' -> ('Entity definition' -> entityTemplate),
			'Application' -> ('Application definition' -> applicationTemplate)
		},
		#[JdlEntity.simpleName, 'Jdl.*FieldType'] -> #{
			'Field' -> ('Field definition' -> fieldTemplate)
		}
	}

	def Map<String, Pair<String, StringConcatenationClient>> getTemplate(String name) {
		val template = if (!name.isNullOrEmpty) templates.entrySet.findFirst[
			key.exists[
				name.matches(it)
			]
		]?.value
		return template ?: #{}
	}

	def dispatch boolean hasTemplateFor(String name) {
		return !name.template.isEmpty
	}

	def dispatch boolean hasTemplateFor(EObject eObj) {
		val model = eObj?.eClass?.name
		return !model.isNullOrEmpty && hasTemplateFor(model)
	}

	def void acceptProposal(ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		val model = context.currentModel?.eClass?.name
		if (model === null) {
			getTemplate(JdlDomainModel.simpleName).forEach[name, extension temp|
				super.acceptProposal(name, key, value, context, acceptor)
			]
		} else {
			if (hasTemplateFor(model)) {
				getTemplate(model).forEach[name, extension temp|
					super.acceptProposal(name, key, value, context, acceptor)
				]
			}
		}
	}	
}
