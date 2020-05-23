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
package io.github.jhipster.jdl.renderer

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import io.github.jhipster.jdl.jdl.JdlApplication
import io.github.jhipster.jdl.jdl.JdlBlobFieldType
import io.github.jhipster.jdl.jdl.JdlBooleanFieldType
import io.github.jhipster.jdl.jdl.JdlConstant
import io.github.jhipster.jdl.jdl.JdlDeployment
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEntityField
import io.github.jhipster.jdl.jdl.JdlEnum
import io.github.jhipster.jdl.jdl.JdlEnumFieldType
import io.github.jhipster.jdl.jdl.JdlFieldType
import io.github.jhipster.jdl.jdl.JdlOption
import io.github.jhipster.jdl.jdl.JdlRelationRole
import io.github.jhipster.jdl.jdl.JdlRelationship
import io.github.jhipster.jdl.jdl.JdlRelationships
import io.github.jhipster.jdl.jdl.JdlStringFieldType
import io.github.jhipster.jdl.jdl.JdlWildcardPredicate
import io.github.jhipster.jdl.util.JdlModelUtil
import java.util.Map
import java.util.Set
import org.eclipse.emf.ecore.EObject

import static io.github.jhipster.jdl.util.PlantUmlUtil.*

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
	@Inject extension JdlModelUtil util

	override render(JdlDomainModel jdl) {
		return jdl.init.toPlantUml
	}

	def private JdlDomainModel init(JdlDomainModel jdl) {
		util = JdlModelUtil.getInstance(jdl)
		entiyOptionMap = toEntiyOptionMap(jdl)
		return jdl
	}
	
	def private String toPlantUml(JdlDomainModel it) '''
 		«toPlantUml.apply('''
			«pragmas»
			«IF it !== null»«content»«ELSE»«USER»«ENDIF»
		''')»
	'''
	
	def protected getPragmas() '''
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

	def protected renderJdlObject(String option, JdlWildcardPredicate predicate) '''
		note top of «option» : «option» applies to «IF predicate.isAll || predicate.isWildcard»all«ENDIF»
	'''

	def dispatch protected renderJdlObject(JdlEnum _enum) '''
		enum «_enum.name» {
			«FOR ev : _enum.values SEPARATOR ","»
				«IF ev.customValue.isNullOrEmpty»«ev.value»«ELSE»«ev.customValue»«ENDIF» 
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
		if (!name.isNullOrEmpty) ''' "«name»«IF !displayField?.name.isNullOrEmpty»(«displayField.name»)«ENDIF»«cardValue»" '''
	}
	
 	def dispatch protected renderJdlObject(JdlEntity entity) '''
 		«val fields = if (entity.fieldDefinition !== null) entity.fieldDefinition.fields else #[]»
		class «entity.name» «IF entity.table.nullOrEmpty == false»<<Table {«entity.table»}>>«ENDIF»«entity.toOptionStereotype(entiyOptionMap)» {
			«fields.map[renderJdlObject].join»
		}
		«FOR e: fields.map[type].filter(JdlEnumFieldType)»
			«entity.name» ..> «e.element.name»
		«ENDFOR»
	'''

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
}
