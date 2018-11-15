/**
 * Copyright 2013-2018 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.renderer

import com.google.inject.ImplementedBy
import io.github.jhipster.jdl.jdl.JdlBlobFieldType
import io.github.jhipster.jdl.jdl.JdlBooleanFieldType
import io.github.jhipster.jdl.jdl.JdlComplexAnnotation
import io.github.jhipster.jdl.jdl.JdlConstant
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEntityField
import io.github.jhipster.jdl.jdl.JdlEntitySelection
import io.github.jhipster.jdl.jdl.JdlEnum
import io.github.jhipster.jdl.jdl.JdlEnumFieldType
import io.github.jhipster.jdl.jdl.JdlFactory
import io.github.jhipster.jdl.jdl.JdlFieldType
import io.github.jhipster.jdl.jdl.JdlOption
import io.github.jhipster.jdl.jdl.JdlOptionSelection
import io.github.jhipster.jdl.jdl.JdlOptionSetting
import io.github.jhipster.jdl.jdl.JdlRelationRole
import io.github.jhipster.jdl.jdl.JdlRelationship
import io.github.jhipster.jdl.jdl.JdlRelationships
import io.github.jhipster.jdl.jdl.JdlSimpleAnnotation
import io.github.jhipster.jdl.jdl.JdlStringFieldType
import io.github.jhipster.jdl.jdl.JdlWildcardPredicate
import java.util.Map
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2

import static io.github.jhipster.jdl.util.PlantUmlUtil.*
import io.github.jhipster.jdl.jdl.JdlApplication
import io.github.jhipster.jdl.jdl.JdlDeployment

/**
 * @author Serano Colameo - Initial contribution and API
 */
@ImplementedBy(JdlToPlantUmlRenderer)
interface IJdlToPlantUmlRenderer extends IJdlModelViewerRenderer {

	static (Object)=>String toPlantUml = [ it | '''
		«START_UML»
			«IF it !== null»«toString»«ENDIF»
		«END_UML»
	''']
}

class JdlToPlantUmlRenderer implements IJdlToPlantUmlRenderer {

	var Map<JdlEntity, Set<JdlOption>> entiyOptionMap
	val factory = JdlFactory.eINSTANCE 

	override render(JdlDomainModel jdl) {
		return jdl.init.toPlantUml
	}

	def private JdlDomainModel init(JdlDomainModel jdl) {
		return jdl.initEntiyOptionMap
	}
	
	def private JdlDomainModel initEntiyOptionMap(JdlDomainModel jdl) {
		entiyOptionMap = newHashMap
		if (jdl === null || jdl.eContents.nullOrEmpty) return jdl
		val (JdlOption)=>Iterable<JdlEntity> getEntities = [ o |  
			val predicate = if (o.setting?.includes !== null && o.setting.includes instanceof JdlOptionSelection) {
				valueOf(o.setting.includes, 'getPredicate') as JdlWildcardPredicate
			}
			val isSelectAll = predicate !== null && (predicate.isWildcard || predicate.isAll)
			if (isSelectAll) {
				val entitySelection = jdl.eContents.filter(JdlEntity).filter[!isExcluded(o, it)]
				entitySelection ?: #[]
			} else {
				val entitySelection = if (o.setting?.includes !== null && o.setting.includes instanceof JdlOptionSelection) {
					val selection = valueOf(o.setting.includes, 'getSelection') as JdlEntitySelection
				 	selection?.entities
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
		jdl.eContents.filter(JdlEntity).map[annotations].flatten.forEach[ 
			val entity = eContainer as JdlEntity
			val options = if (entiyOptionMap.containsKey(entity)) entiyOptionMap.get(entity) else newHashSet 
			entiyOptionMap.put(entity, options)
			val aOption = switch (it) {
				JdlComplexAnnotation case isDto: { createOption => [setting.dtoOption = true] }
				JdlComplexAnnotation case isAngularSuffix: { createOption => [setting.angularSuffixOption = true] }
				JdlComplexAnnotation case isClientRootFolder: { createOption => [setting.clientRootFolder = true] }
				JdlComplexAnnotation case isMicroservice: { createOption => [setting.microserviceOption = true] }
				JdlComplexAnnotation case isPaginate: { createOption => [setting.paginateOption = true] }
				JdlComplexAnnotation case isSearch:  { createOption => [setting.searchOption = true] }
				JdlComplexAnnotation case isService: { createOption => [setting.serviceOption = true] }
				JdlSimpleAnnotation case isNoFluentMethod: { createOption => [setting.noFluentMethodOption = true] }
				JdlSimpleAnnotation case isSkipClient: { createOption => [setting.skipClientOption = true] }
				JdlSimpleAnnotation case isSkipServer: { createOption => [setting.skipServerOption = true] }
			}
			if (aOption !== null) options.add(aOption)
		]
		return jdl
	}

	def private JdlOption createOption() {
		val result = factory.createJdlOption => [
			it.setting = factory.createJdlOptionSetting
		]		
		return result
	}

	def private String toPlantUml(JdlDomainModel it) '''
 		«toPlantUml.apply('''
			«options»
			«IF it !== null»«content»«ELSE»«USER»«ENDIF»
		''')»
	'''
	
	def private getOptions() '''
		«IF useJDot»!pragma graphviz_dot jdot«ENDIF»
		!pragma syntax class		
	'''

	def private getContent(JdlDomainModel it) {
		return features.map[renderJdlObject].join
	}
	
	def dispatch renderJdlObject(JdlDomainModel model) '''
		«model.features.map[
			renderJdlObject
		].join»
	'''

	def dispatch protected renderJdlObject(JdlConstant const) {
		'' // for the moment we do not want to render this type
	}

	def dispatch protected renderJdlObject(JdlApplication app) {
		'' // for the moment we do not want to render this type
	}

	def dispatch protected renderJdlObject(JdlDeployment depl) {
		'' // for the moment we do not want to render this type
	}

	def dispatch protected renderJdlObject(JdlOption opt) {
		'' // for the moment we do not want to render this type
	}

	def private getOptionType(JdlOptionSetting setting) {
		val result = setting.class.methods.filter[
			name.startsWith('is') && name.endsWith('Option')
		].filter[
		 	invoke(setting) as Boolean
		]
		if (!result.isNullOrEmpty && result.size == 1) {
			result.last.name.replaceAll('is|Option', '')
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
			if (source !== null && source.entity !== null && 
				target !== null && target.entity !== null
			) renderJdlObject
		].join»
	'''
	
	def dispatch protected renderJdlObject(JdlRelationship it) '''
		«source.entity.name» «toCardinality» «target.entity.name»
	'''	
	
	def private String toCardinality(JdlRelationship rs) {
		val card = (rs?.eContainer as JdlRelationships)?.cardinality
		
		return switch (card) {
			case ONE_TO_ONE: relationRole(rs.source.role, '1') +  '--' + relationRole(rs.target.role, '1')
			case ONE_TO_MANY: relationRole(rs.source.role, '1') + '--o' + relationRole(rs.target.role, '*')
			case MANY_TO_ONE: relationRole(rs.source.role, '*') + 'o--' + relationRole(rs.target.role, '1')
			case MANY_TO_MANY: relationRole(rs.source.role, '*') + 'o--o' + relationRole(rs.target.role, '*')
			default : '--'
		}
	}

	def protected relationRole(JdlRelationRole it, String card) {
		if (it === null) return ''' "0..«card» " '''
		val cardValue = ''' «IF required && card.equals('*')» 1«ELSE»0«ENDIF»..«card» '''
		if (!name.isNullOrEmpty) ''' "«name»«IF !role.isNullOrEmpty»(«role»)«ENDIF»«cardValue»" '''
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
			«entity.name» ..> «e.element.name»
		«ENDFOR»
	'''

	def private toOptionStereotype(JdlEntity entity) 
		'''«var opts=entiyOptionMap.get(entity)?.filter[!isExcluded(entity)]»«IF !opts.nullOrEmpty»<<Option {«FOR it : opts SEPARATOR ','»«setting.optionType»«ENDFOR»}>>«ENDIF»'''

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
			type.^class.getMethod(methodName).invoke(type)
		} catch (Exception exception) {
			null		
		}
	}
}
