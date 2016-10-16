package io.github.jhipster.jdl.ide.renderer.plantuml

import io.github.jhipster.jdl.jdl.JdlBlobFieldType
import io.github.jhipster.jdl.jdl.JdlBooleanFieldType
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEntityField
import io.github.jhipster.jdl.jdl.JdlEntitySelection
import io.github.jhipster.jdl.jdl.JdlEnum
import io.github.jhipster.jdl.jdl.JdlEnumFieldType
import io.github.jhipster.jdl.jdl.JdlFieldType
import io.github.jhipster.jdl.jdl.JdlForEntityInclusion
import io.github.jhipster.jdl.jdl.JdlOption
import io.github.jhipster.jdl.jdl.JdlOptionSetting
import io.github.jhipster.jdl.jdl.JdlRelationRole
import io.github.jhipster.jdl.jdl.JdlRelationship
import io.github.jhipster.jdl.jdl.JdlRelationships
import io.github.jhipster.jdl.jdl.JdlStringFieldType
import io.github.jhipster.jdl.jdl.JdlWildcardPredicate
import io.github.jhipster.jdl.jdl.JdlWithEntityInclusion
import java.util.Map
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2

class JdlToPlantUmlRenderer implements IJdlToPlantUmlRenderer {

	var Map<JdlEntity, Set<JdlOption>> entiyOptionMap

	override render(JdlDomainModel jdl) {
		jdl.init.toPlantUml
	}

	def private JdlDomainModel init(JdlDomainModel jdl) {
		entiyOptionMap = newHashMap
		val (JdlOption)=>Iterable<JdlEntity> getEntities = [ o |  
			val predicate = if (o.setting?.includes !== null) switch (o.setting.includes) {
				JdlWithEntityInclusion, JdlForEntityInclusion: valueOf(o.setting.includes, 'getPredicate') as JdlWildcardPredicate
			}
			val isSelectAll = predicate != null && (predicate.isWildcard || predicate.isAll)
			if (isSelectAll) {
				val entitySelection = jdl.eContents.filter(JdlEntity).filter[!isExcluded(o, it)]
				entitySelection ?: #[]
			} else {
				val entitySelection = if (o.setting?.includes !== null) switch (o.setting.includes) {
					JdlWithEntityInclusion, JdlForEntityInclusion: {
						val selection = valueOf(o.setting.includes, 'getSelection') as JdlEntitySelection
					 	selection?.entities
				 	}
				}
				entitySelection ?: #[]
			}
		]
		jdl.eContents.filter(JdlOption).toSet.forEach[ option |
			getEntities.apply(option).forEach[ entity |
				val options = if (entiyOptionMap.containsKey(entity)) entiyOptionMap.get(entity) else newHashSet 
				options.add(option)
				entiyOptionMap.put(entity, options)
			]
		]
		return jdl
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

	def dispatch protected renderJdlObject(JdlOption opt) {
		'' // opt.setting.renderJdlObject
	}

	def private getOptionType(extension JdlOptionSetting setting) {
		 switch (setting) {
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
		}		
	}
	
	def protected renderJdlObject(String option, JdlWildcardPredicate predicate) '''
		note top of «option» : «option» applies to «IF predicate.isAll || predicate.isWildcard»all«ENDIF»
	'''

	def dispatch protected renderJdlObject(JdlEnum _enum) '''
		enum «_enum.name» {
			«FOR value : _enum.values SEPARATOR ","»
				«value» 
			«ENDFOR»
		}
	'''
	
	def dispatch protected renderJdlObject(JdlRelationships rel) '''
		«rel.relationships.map[
			if (source != null && source.entity != null && 
				target != null && target.entity != null
			) renderJdlObject
		].join»
	'''
	
	def dispatch protected renderJdlObject(JdlRelationship it) '''
		«source.entity.name» «relationRole(source.role)» -- «relationRole(target.role)» «target.entity.name»
	'''	

	def protected relationRole(JdlRelationRole it) {
		if (it == null) return ''
		if (!name.isNullOrEmpty) '''"«name»«IF !role.isNullOrEmpty»(«role»)«ENDIF»"''' else ''
	}
	
	// *** Note ***
	// Warning message: "Cannot infer type from recursive usage. Type 'Object' is used." is a bug
	// @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=404817
	// The Xtend Compiler works fine and generates the expected java code correctly
 	def dispatch protected renderJdlObject(JdlEntity entity) '''
		class «entity.name» «IF entity.table.nullOrEmpty == false»<<Table {«entity.table»}>>«ENDIF»«toOptionStereotype(entity)» {
			«entity.fields.map[renderJdlObject].join»
		}
		«FOR e: entity.fields.map[type].filter(JdlEnumFieldType)»
			«entity.name» --> «e.element.name»
		«ENDFOR»
	'''

	def private toOptionStereotype(JdlEntity entity) 
		'''«var opts=entiyOptionMap.get(entity)?.filter[!isExcluded(entity)]»«IF !opts.nullOrEmpty»<<Option {«FOR it : opts SEPARATOR ','»«getOptionType(setting)»«ENDFOR»}>>«ENDIF»'''

	def private boolean isExcluded(JdlOption opt, JdlEntity entity) {
		try {
			(EcoreUtil2.resolve(opt, opt.eResource) as JdlOption).excludes.selection.entities.contains(entity)
		} catch (Exception exception) {
			false
		}
	}
	
	def dispatch protected renderJdlObject(JdlEntityField field) '''
		«field.type.elementType» «field.name»
	'''

	/**
	 * We need to manually dispatch here, as type hierarchy can be inconsistent (e.g. during code completion)
	 */
	def private getElementType(EObject type) {
		val it = valueOf(type, 'getElement')
		switch (type) {
			JdlStringFieldType, JdlBooleanFieldType : valueOf('getElement')
			JdlEnumFieldType, JdlBlobFieldType : valueOf('getName')
			JdlFieldType : it
			default: "'unknown type'"
		}
	}

	def private valueOf(Object type, String methodName) {
		try {
			type.^class.getMethod(methodName, null).invoke(type, null)
		} catch (Exception exception) {
			null		
		}
	}
}
