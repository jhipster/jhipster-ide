/**
 * Copyright 2016-2024 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.formatting2

import com.google.inject.Inject
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEntityField
import io.github.jhipster.jdl.jdl.JdlEntitySelection
import io.github.jhipster.jdl.jdl.JdlEnum
import io.github.jhipster.jdl.jdl.JdlFeature
import io.github.jhipster.jdl.jdl.JdlOption
import io.github.jhipster.jdl.jdl.JdlRelationships
import io.github.jhipster.jdl.services.JDLGrammarAccess
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument

import static io.github.jhipster.jdl.jdl.JdlPackage.Literals.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JDLFormatter extends AbstractFormatter2 {
	
	@Inject extension JDLGrammarAccess

	def dispatch void format(JdlDomainModel jdlDomainModel, extension IFormattableDocument document) {
		jdlDomainModel.prepend[setNewLines(0, 0, 1); noSpace].append[newLine]
		for (JdlFeature element : jdlDomainModel.features) {
			format(element, document);
		}
	}

	def dispatch void format(JdlEnum jdlEnum, extension IFormattableDocument document) {
		val open = jdlEnum.regionFor.keyword('{')
		val close = jdlEnum.regionFor.keyword('}')
		jdlEnum.regionFor.feature(JDL_ENUM__NAME).surround[oneSpace]
		open.append[newLine]
		interior(open, close)[indent]
		jdlEnum.regionFor.keywords(',').forEach[
			append[oneSpace]
		]
		close.prepend[newLine].append[newLine]
	}

	def dispatch void format(JdlEntity entity, extension IFormattableDocument document) {
		val open = entity.regionFor.keyword('{') 
		val close = entity.regionFor.keyword('}')
		entity.regionFor.keyword(jdlEntityAccess.entityKeyword_1).append[oneSpace]
		open.append[newLine]
		interior(open, close)[indent]
		entity.fieldDefinition?.fields.forEach[format]
		entity.regionFor.keywords(',').forEach[
			surround[noSpace].append[newLine]
		]
		close.prepend[newLine].append[newLine]
	}

	def dispatch void format(JdlEntityField field, extension IFormattableDocument document) {
		field.regionFor.assignment(jdlEntityFieldAccess.nameAssignment_1).append[oneSpace]
	}

	def dispatch void format(JdlRelationships relships, extension IFormattableDocument document) {
		val open = relships.regionFor.keyword('{') 
		val close = relships.regionFor.keyword('}')
		open.append[newLine]
		interior(open, close)[indent]
		relships.regionFor.keywords(',').forEach[
			surround[oneSpace]
		]
		close.prepend[newLine].append[newLine]
	}
	
	def dispatch void format(JdlOption option, extension IFormattableDocument document) {
		option.surround[oneSpace].prepend[newLine]
		option.prepend[newLine].append[newLine]
	}
	
	def dispatch void format(JdlEntitySelection selection, extension IFormattableDocument document) {
		selection.regionFor.keywords(',').forEach[
			append[oneSpace]
		]
	}
}
