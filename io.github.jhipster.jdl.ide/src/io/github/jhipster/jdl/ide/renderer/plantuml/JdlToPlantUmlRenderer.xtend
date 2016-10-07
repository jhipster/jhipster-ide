package io.github.jhipster.jdl.ide.renderer.plantuml

import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEntityField
import io.github.jhipster.jdl.jdl.JdlEnum
import io.github.jhipster.jdl.jdl.JdlEnumFieldType
import io.github.jhipster.jdl.jdl.JdlExceptEntityExclusion
import io.github.jhipster.jdl.jdl.JdlFeature
import io.github.jhipster.jdl.jdl.JdlFieldType
import io.github.jhipster.jdl.jdl.JdlForEntityInclusion
import io.github.jhipster.jdl.jdl.JdlOption
import io.github.jhipster.jdl.jdl.JdlOptionSetting
import io.github.jhipster.jdl.jdl.JdlRelationship
import io.github.jhipster.jdl.jdl.JdlRelationshipName
import io.github.jhipster.jdl.jdl.JdlRelationships
import io.github.jhipster.jdl.jdl.JdlWildcardPredicate
import io.github.jhipster.jdl.jdl.JdlWithEntityInclusion
import java.util.List
import org.eclipse.emf.ecore.EObject

class JdlToPlantUmlRenderer implements IJdlToPlantUmlRenderer {

	override render(JdlDomainModel jdl) {
		jdl.toPlantUml
	}

	def private String toPlantUml(JdlDomainModel model) '''
		«toPlantUml.apply(
			if (model != null) model.features.map[
				renderJdlObject
			].join
		)»
	'''
	
	def dispatch renderJdlObject(JdlDomainModel model) '''
		«model.features.map[
			renderJdlObject
		].join»
	'''

	/**
	 * Manually dispatch features 
	 */
	def dispatch protected renderJdlObject(JdlFeature feature) {
		switch (feature) {
			JdlEntity : renderJdlObject(feature as JdlEntity)
			JdlEnum : renderJdlObject(feature as JdlEnum)
			JdlRelationships : renderJdlObject(feature as JdlRelationships)
			JdlOption : renderJdlObject(feature as JdlOption)
			default : throw new IllegalArgumentException('''Unknown feature «feature.class»''')
		}
	}

	def dispatch protected renderJdlObject(JdlOption opt) {
		opt.setting.renderJdlObject
	}

	def dispatch protected renderJdlObject(extension JdlOptionSetting setting) '''
		abstract class «val option = switch (setting) {
				case isAngularSuffixOption : 'AngularSuffix'
				case isDtoOption : 'DTO'
				case isMicroserviceOption : 'Microservice'
				case isNoFluentMethodOption : 'NoFluentMethod'
				case isPaginateOption : 'Paginate'
				case isSearchOption : 'Search'
				case isServiceOption : 'Service'
				case isSkipServerOption : 'SkipServer'
				case isSkipClientOption : 'SkipClient'
				default : 'Unknown'
			}» «option» <<Option>>
		«option.renderJdlObject(setting.includes)»
	'''

	def protected renderJdlObject(String option, EObject eObj) '''
		«switch (eObj) {
			JdlWithEntityInclusion : option.renderJdlObject(eObj)
			JdlForEntityInclusion : option.renderJdlObject(eObj)
			JdlExceptEntityExclusion : option.renderJdlObject(eObj)
			default: 'Unknown'
		}»
	'''

	def protected renderJdlObject(String option, JdlWithEntityInclusion withInclusion) '''
		«IF (withInclusion.selection != null)»
			«renderJdlObject(option, withInclusion.selection.entities)»
		«ELSEIF (withInclusion.predicate != null)»
			«renderJdlObject(option, withInclusion.predicate)»
		«ENDIF»
	'''

	def protected renderJdlObject(String option, JdlForEntityInclusion forInclusion) '''
		«IF (forInclusion.selection != null)»
			«renderJdlObject(option, forInclusion.selection.entities)»
		«ELSEIF (forInclusion.predicate != null)»
			«renderJdlObject(option, forInclusion.predicate)»
		«ENDIF»
	'''

	def protected renderJdlObject(String option, JdlExceptEntityExclusion exclusion) '''
		«IF (exclusion.selection != null)»
			«renderJdlObject(option, exclusion.selection.entities)»
		«ENDIF»
	'''
	
	def protected renderJdlObject(String option, JdlWildcardPredicate predicate) '''
		note top of «option» : «option» applies to «IF predicate.isAll || predicate.isWildcard»all«ENDIF»
	'''

	def protected renderJdlObject(String option, List<JdlEntity> entities) '''
		«FOR e : entities»
			«option» --> «e.name»
		«ENDFOR»
	'''

	def dispatch protected renderJdlObject(JdlEnum _enum) '''
		enum «_enum.name» {
			«FOR value : _enum.values SEPARATOR ","»
				«value» 
			«ENDFOR»
		}
	'''
	
	def dispatch protected renderJdlObject(JdlRelationships rel) '''
		«rel.relationships.map[if (fromEntity != null && toEntity != null) renderJdlObject].join»
	'''
	
	def dispatch protected renderJdlObject(JdlRelationship rel) '''
		«rel.fromEntity.name» «relationName(rel?.fromName)» -- «relationName(rel?.toName)» «rel.toEntity.name»
	'''
	
	def protected relationName(JdlRelationshipName relName) {
		if (relName != null) '''"«relName?.name»«IF !relName.role.nullOrEmpty»(«relName.role»)«ENDIF»"''' else ''
	}
	
	// *** Note ***
	// Warning message: "Cannot infer type from recursive usage. Type 'Object' is used." is a bug
	// @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=404817
	// The Xtend Compiler works fine and generates the expected java code correctly
 	def dispatch protected renderJdlObject(JdlEntity entity) '''
		class «entity.name» {
			«entity.fields.map[renderJdlObject].join»
		}
		«FOR e: entity.fields.map[type].filter(JdlEnumFieldType)»
			«entity.name» --> «e.element.name»
		«ENDFOR»
	'''
	
	def dispatch protected renderJdlObject(JdlEntityField field) '''
		«field.type.elementType» «field.name»
	'''

	/**
	 * We need to manually dispatch here, as type hierarchy can be inconsistent (e.g. during code completion)
	 */
	def private getElementType(EObject type) {
		switch (type) {
			JdlEnumFieldType : getElement(type)
			JdlFieldType : getElement(type)
			default: "'unknown type'"
		}
	}

	def private getElement(JdlFieldType type) {
		try {
			type.^class.getMethod('getElement', null).invoke(type, null)
		} catch (Exception exception) {
			"'unknown type'"		
		}
	}

	def private getElement(JdlEnumFieldType type) {
		try {
			type.element.name
		} catch (Exception exception) {
			"'unknown type'"		
		}
	}	
}
