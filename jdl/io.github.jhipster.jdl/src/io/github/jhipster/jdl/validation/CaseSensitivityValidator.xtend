package io.github.jhipster.jdl.validation

import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEntityField
import io.github.jhipster.jdl.jdl.JdlEnum
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check

import static io.github.jhipster.jdl.jdl.JdlPackage.Literals.*
import static io.github.jhipster.jdl.validation.IssueCodes.*
import org.eclipse.xtext.validation.EValidatorRegistrar

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
			if (!v.toUpperCase.equals(v)) {
				error(INVALID_ENUM_VALUE_NAME_MSG, JDL_ENUM__VALUES,
				enumeration.values.indexOf(v), NOT_UPPER_CASE)
			}
		}
	}
	
	@Check
	def checkFieldStartsWithCapital(JdlEntityField field) {
		if (!Character.isLowerCase(field.name.charAt(0))) {
			warning(FIELD_NAME_LOWERCASE_MSG, JDL_ENTITY_FIELD__NAME, INSIGNIFICANT_INDEX, INVALID_FEATURE_NAME)
		}
		val entity = field.eContainer as JdlEntity
		if (entity.fields.exists[it != field && name.equals(field.name)]) {
			error(DUPLICATE_FIELD_DEF_MSG, JDL_ENTITY_FIELD__NAME)			
		}
	}
}
