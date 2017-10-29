package io.github.jhipster.jdl.validation

import io.github.jhipster.jdl.jdl.JdlEntitySelection
import io.github.jhipster.jdl.jdl.JdlOption
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static io.github.jhipster.jdl.jdl.JdlPackage.Literals.*
import static io.github.jhipster.jdl.validation.IssueCodes.*

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
}
