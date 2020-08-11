/* Copyright 2013-2020 the original author or authors from the JHipster project.
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

import io.github.jhipster.jdl.jdl.JdlApplication
import io.github.jhipster.jdl.jdl.JdlApplicationConfig
import io.github.jhipster.jdl.jdl.JdlApplicationParameter
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEntityField
import io.github.jhipster.jdl.jdl.JdlEntityFieldDefinition
import io.github.jhipster.jdl.jdl.JdlEnum
import io.github.jhipster.jdl.jdl.JdlEnumValue
import io.github.jhipster.jdl.jdl.JdlRelationship
import io.github.jhipster.jdl.jdl.JdlRelationships
import java.nio.file.Paths

import static extension io.github.jhipster.jdl.util.JdlModelUtil.*
import static extension org.apache.commons.lang3.StringUtils.*
import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JdlToAsciiDocRenderer extends AbstractJdlRenderer implements IJdlModelViewerRenderer {
	
	val linebreak = "'''"
	val open = '«'
	val close = '»'
	val tableheader = '[options="header, autowidth"]'
	
	override render(JdlDomainModel jdl) {
		return jdl.isJdlResource ? jdl.init.toAscidoc
	}
	
	def private String toAscidoc(JdlDomainModel model) {
		if (model.name.isNullOrEmpty || model.fullFileName.isNullOrEmpty) return ''
		val apps = model.features.filter(JdlApplication)
		val entities = model.features.filter(JdlEntity).filter[it.name != 'User']
		val relationships = model.features.filter(JdlRelationships)
		val enums = model.features.filter(JdlEnum)
		val jdlFile = Paths.get(model.fullFileName).toFile
		return '''
			= «model.name.toFirstUpper»
			:toc: left
			
			.Please note
			[NOTE]
			====
			This spec was generated out of _«jdlFile.name»_.
			====
			<<<
			
			== Specification of «model.name.toFirstUpper»
			«model.documentation ?: ''»
			
			=== UML Domain Model
			--
			«linebreak»
			[plantuml,align="center",alt="«model.name».plantuml"]
			----
			include::«model.name».plantuml[]
			----
			---
			--
			
			«apps.compileApplications»
			«entities.compileEntities»
			«relationships.compileRelationships»
			«enums.compileEnums»
		'''
	}
	
	def compileApplications(Iterable<JdlApplication> it) '''
		«IF !it.isNullOrEmpty»
			=== Application Configuration«IF size>1»s«ENDIF»
			«map[compile].join»
		«ENDIF»
	'''

	def compileEntities(Iterable<JdlEntity> entities) {
		entities.map[compile].join
	}

	def compileRelationships(Iterable<JdlRelationships> it) '''
		«IF !it.isNullOrEmpty»
			=== Relationship«IF size>1»s«ENDIF»
			«tableheader»
			|===
			| Source Entity | Cardinality | Target Entity | Comment
			«map[compile].join»
			|===
		«ENDIF»
	'''

	def compileEnums(Iterable<JdlEnum> enums) {
		enums.map[compile].join
	}

	def dispatch compile(JdlEnum it) '''	
		=== Enum «open»«name»«close»
		«documentation»
		
		.«name»
		«tableheader»
		|===
		| Name | Comment
		«values.map[compile].join»
		|===
	'''

	def dispatch compile(JdlEnumValue it) '''
		| «value» | «documentation»
	'''

	def dispatch compile(JdlApplication it) '''
		«config.compile»
	'''

	def dispatch compile(JdlApplicationConfig it) '''
		«documentation»

		«tableheader»
		|===
		|Option | Value | Comment
		«FOR it:paramters»«compile»«ENDFOR»
		|===
	'''
	
	def dispatch compile(JdlApplicationParameter it) '''
		|«paramName.literal.toFirstUpper.splitByCharacterTypeCamelCase.join(' ')» | «paramValue.node.text» | «documentation»
	'''

	def dispatch compile(JdlEntity it) '''	
		=== Entity «open»«name»«close»
		«documentation»
		«val entity=it»
		«val options = entiyOptionMap.get(entity)?.filter[!isExcluded(entity)]»
		
		«IF fieldDefinition !== null»
			.Fields
			«fieldDefinition.compile»
		«ENDIF»
		
		«IF !options.isNullOrEmpty»
			==== Options
			«FOR it:options»
				* [x] «setting.optionType»
			«ENDFOR»
			 
		«ENDIF»
	'''

	def dispatch compile(JdlEntityFieldDefinition it) '''
		«tableheader»
		|===
		|Field Name|Type | Constraint | Comment
		«FOR it:fields»«compile»«ENDFOR»
		|===
	'''

	def dispatch compile(JdlEntityField it) '''
		«val typeNode = type.node»
		«val typeText = typeNode?.text?.trim ?: ''»
		«val constraints = if (typeText.contains(' ')) typeText.substring(typeText.indexOf(' ')).trim else ''»
		|«name.toFirstUpper»|«typeText?.split(' ')?.head»|«constraints» | «documentation»
	'''

	def dispatch compile(JdlRelationships it) '''
		«relationships.map[ 
			if (source !== null && source.entity !== null && 
				target !== null && target.entity !== null
			) compile
		].join»
	'''

	def dispatch compile(JdlRelationship it) '''
		| «source.entity.name» | «toCardinality» | «target.entity.name» | «documentation»
	'''
	def private String toCardinality(JdlRelationship rs) {
		val card = (rs?.eContainer as JdlRelationships)?.cardinality
		return if (card !== null) {
			val it = card.name().toLowerCase.split('_')
			'''«get(0).toFirstUpper» «get(1)» «get(2).toFirstUpper»'''
		}
	}
}