/**
 * Copyright 2016-2025 the original author or authors from the JHipster project.
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

import io.github.jhipster.jdl.jdl.JdlRelationships
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static io.github.jhipster.jdl.jdl.JdlPackage.Literals.*
import static io.github.jhipster.jdl.validation.IssueCodes.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class CardinalityValidator extends AbstractDeclarativeValidator {

	override register(EValidatorRegistrar registrar) {
	}

	@Check
	def checkRelationsCardinality(JdlRelationships it) {
		val roles = newHashSet
		val rs = relationships
		switch (cardinality) {
			case ONE_TO_MANY : roles += rs.map[target.role]
			case MANY_TO_MANY: roles += rs.map[source.role] + rs.map[target.role] 
			case MANY_TO_ONE : roles += rs.map[source.role] 
			default : return
		}
		roles.filter[isRequired].forEach[ role |
			warning(REQUIRED_NOT_ALLOWED_MSG.apply(cardinality), role, JDL_RELATION_ROLE__REQUIRED, INVALID_REQUIRED_OPTION)			
		]
	}	
}
