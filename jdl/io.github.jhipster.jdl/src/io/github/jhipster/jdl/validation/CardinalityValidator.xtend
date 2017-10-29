package io.github.jhipster.jdl.validation

import io.github.jhipster.jdl.jdl.JdlRelationships
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check

import static io.github.jhipster.jdl.jdl.JdlPackage.Literals.*
import static io.github.jhipster.jdl.validation.IssueCodes.*
import org.eclipse.xtext.validation.EValidatorRegistrar

class CardinalityValidator extends AbstractDeclarativeValidator {

	override register(EValidatorRegistrar registrar) {
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
}
