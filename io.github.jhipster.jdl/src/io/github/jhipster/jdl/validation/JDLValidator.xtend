package io.github.jhipster.jdl.validation

import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEntityField
import io.github.jhipster.jdl.jdl.JdlEnum
import org.eclipse.xtext.validation.Check
import io.github.jhipster.jdl.jdl.JdlRelationships

import static io.github.jhipster.jdl.jdl.JdlPackage.Literals.*
import static io.github.jhipster.jdl.validation.IssueCodes.*

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class JDLValidator extends AbstractJDLValidator {

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
			if (Character.isLowerCase(v.charAt(0))) {
				warning(INVALID_ENUM_VALUE_NAME_MSG, JDL_ENUM__VALUES,
				enumeration.values.indexOf(v), INVALID_FEATURE_NAME)
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

	@Check
	def checkRelationsCardinality(JdlRelationships rel) {
		val card = rel.cardinality
		val roles = newHashSet
		val rs = rel.relationships
		switch (card) {
			case ONE_TO_MANY : roles += rs.map[target.role]
			case MANY_TO_MANY: roles += rs.map[source.role] + rs.map[target.role] 
			case MANY_TO_ONE : roles += rs.map[source.role] 
			default : return
		}
		roles.filter[isRequired].forEach[ role |
			warning(REQUIRED_NOT_ALLOWED_MSG.apply(card), role, JDL_RELATION_ROLE__REQUIRED, INVALID_REQUIRED_OPTION)			
		]
	}
	
// @FIXME
//	@Check
//	def checkGreetingStartsWithCapital(JdlRelationRole role) {
//		if (!Character.isUpperCase(role.name.charAt(0))) {
//			warning('Relationship name should start with a capital', 
//					JdlPackage.Literals.JDL_ENTITY__NAME,
//					ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
//					INVALID_TYPE_NAME)
//		}
//	}
}
