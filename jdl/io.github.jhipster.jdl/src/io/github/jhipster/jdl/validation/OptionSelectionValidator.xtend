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
package io.github.jhipster.jdl.validation

import io.github.jhipster.jdl.jdl.JdlEntitySelection
import io.github.jhipster.jdl.jdl.JdlOption
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static io.github.jhipster.jdl.jdl.JdlPackage.Literals.*
import static io.github.jhipster.jdl.validation.IssueCodes.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class OptionSelectionValidator extends AbstractDeclarativeValidator {

	override register(EValidatorRegistrar registrar) {}

	@Check
	def checkOptionSelection(JdlEntitySelection sel) {
		val option = EcoreUtil2.getContainerOfType(sel, JdlOption)
		if (option !== null && option.excludes !== null && !sel.entities.isNullOrEmpty) {
			val excludedEntites = option.excludes.selection?.entities
			if (!excludedEntites.isNullOrEmpty) {
				val selEntities = newHashSet(sel.entities).flatten.toList
				val exclEntities = newHashSet(excludedEntites).flatten.toList => [ removeAll(selEntities) ]
				if (!exclEntities.isEmpty ) { 
					val msg = INVALID_ENTITY_SELECTION_MSG + '''«IF exclEntities.length>1»s«ENDIF»: «exclEntities.map[name].toList»'''
					exclEntities.forEach[ 
						val i = excludedEntites.indexOf(it) 
						error(msg, option.excludes.selection, JDL_ENTITY_SELECTION__ENTITIES, i)
					]
				}
			}
		}
	}
	
//	@Check
//	def checkOptionSelectionFor(JdlOptionSelection sel) {
//		if (sel !== null && sel.hasFor) {
//			error('Keyword "for" is not allowed anymore!', sel, JDL_OPTION_SELECTION__HAS_FOR, INSIGNIFICANT_INDEX)
//		}
//	}
}
