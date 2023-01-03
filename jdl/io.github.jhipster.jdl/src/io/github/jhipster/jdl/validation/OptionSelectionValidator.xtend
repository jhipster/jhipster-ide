/**
 * Copyright 2016-2023 the original author or authors from the JHipster project.
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
import io.github.jhipster.jdl.jdl.JdlPatternValidator
import java.util.regex.PatternSyntaxException
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static io.github.jhipster.jdl.jdl.JdlPackage.Literals.*
import static io.github.jhipster.jdl.validation.IssueCodes.*

import static extension java.util.regex.Pattern.*
import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class OptionSelectionValidator extends AbstractDeclarativeValidator {

	override register(EValidatorRegistrar registrar) {}

	@Check
	def checkOptionSelection(JdlEntitySelection selection) {
		val option = selection.getContainerOfType(JdlOption)
		val selectedEntities = !option.setting?.includes?.selection?.entities.isNullOrEmpty ? option.setting.includes.selection.entities : #[]
		if (option !== null && option.excludes !== null && !selectedEntities.isNullOrEmpty) {
			val excludedEntites = option.excludes.selection?.entities
			if (!excludedEntites.isNullOrEmpty) {
				selectedEntities.filter[
					excludedEntites.contains(it)
				].forEach[
					warning(USELESS_ENTITY_EXCLUSION_MSG.apply(it), option.excludes.selection, JDL_ENTITY_SELECTION__ENTITIES, excludedEntites.indexOf(it))
					warning(USELESS_ENTITY_SELECTION_MSG.apply(it), selection, JDL_ENTITY_SELECTION__ENTITIES, selectedEntities.indexOf(it))
				]
				excludedEntites.filter[
					!selectedEntities.contains(it)
				].forEach[
					warning(ENTITY_EXCLUDED_NOT_SELECTED_MSG.apply(it), option.excludes.selection, JDL_ENTITY_SELECTION__ENTITIES, excludedEntites.indexOf(it))
				]
			}
		}
	}

	@Check
	def checkPatternRegExp(JdlPatternValidator it) {
	    try {
	        value.compile 
	    } catch (PatternSyntaxException e) {
			error(WRONG_REGEXP_MSG, JDL_PATTERN_VALIDATOR__VALUE, INSIGNIFICANT_INDEX, WRONG_REGEXP)
	    }
	}
}
