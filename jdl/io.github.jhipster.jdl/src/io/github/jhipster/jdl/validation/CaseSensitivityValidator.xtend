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
package io.github.jhipster.jdl.validation

import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEntityField
import io.github.jhipster.jdl.jdl.JdlEnum
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static io.github.jhipster.jdl.jdl.JdlPackage.Literals.*
import static io.github.jhipster.jdl.validation.IssueCodes.*
import static io.github.jhipster.jdl.util.IdentifierUtil.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class CaseSensitivityValidator extends AbstractDeclarativeValidator {

	override register(EValidatorRegistrar registrar) {
	}

	@Check
	def checkEntityStartsWithCapital(JdlEntity entity) {
		if (!Character.isUpperCase(entity.name.charAt(0))) {
			warning(INVALID_ENTITY_NAME_MSG, JDL_ENTITY__NAME, INSIGNIFICANT_INDEX, INVALID_TYPE_NAME)
		}
	}

	@Check
	def checkEnumStartsWithCapital(JdlEnum enumeration) {
		if (!Character.isUpperCase(enumeration.name.charAt(0))) {
			warning(INVALID_ENUM_NAME_MSG, JDL_ENUM__NAME, INSIGNIFICANT_INDEX, INVALID_TYPE_NAME)
		}
		for (v : enumeration.values) {
			if (!v.value.toUpperCase.equals(v.value)) {
				error(INVALID_ENUM_VALUE_NAME_MSG, JDL_ENUM__VALUES, enumeration.values.indexOf(v), NOT_UPPER_CASE)
			}
			if (!v.customValue.isNullOrEmpty && !isValidJavaIdentifier(v.customValue)) {
				error(INVALID_ENUM_CUSTOM_VALUE_NAME_MSG, v, JDL_ENUM_VALUE__CUSTOM_VALUE, enumeration.values.indexOf(v))
			}
		}
	}

	@Check
	def checkFieldStartsWithCapital(JdlEntityField field) {
		if (!Character.isLowerCase(field.name.charAt(0))) {
			warning(FIELD_NAME_LOWERCASE_MSG, JDL_ENTITY_FIELD__NAME, INSIGNIFICANT_INDEX, INVALID_FEATURE_NAME)
		}
	}
}
