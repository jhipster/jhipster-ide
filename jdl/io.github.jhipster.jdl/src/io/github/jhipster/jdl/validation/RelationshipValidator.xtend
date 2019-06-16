/**
 * Copyright 2013-2019 the original author or authors from the JHipster project.
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

import io.github.jhipster.jdl.jdl.JdlRelationRole
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static io.github.jhipster.jdl.jdl.JdlPackage.Literals.*
import static io.github.jhipster.jdl.validation.IssueCodes.*

import static extension io.github.jhipster.jdl.util.JdlModelUtil.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class RelationshipValidator extends AbstractDeclarativeValidator {

	override register(EValidatorRegistrar registrar) {}

	@Check
	def void checkRelationshipRoleDisplayFields(JdlRelationRole relationRole) {
        val opposite = relationRole.opposite 
	    if (opposite === null || relationRole.displayField?.name.isNullOrEmpty) return;
	    val entity = opposite.entity
        if (!entity.fieldDefinition?.fields.exists[it.name == relationRole.displayField.name]) {
            val msg =  String.format(INVALID_FIELD_SELECTION_MSG, relationRole.displayField.name, entity.name)
            warning(msg, relationRole, JDL_RELATION_ROLE__DISPLAY_FIELD, INSIGNIFICANT_INDEX)
         }
	}
}
