/**
 * Copyright 2016-2023 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.resource

import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlFieldType
import io.github.jhipster.jdl.jdl.JdlNumericTypes
import io.github.jhipster.jdl.jdl.JdlPackage
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.resource.IDerivedStateComputer

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JdlDerivedStateComputer implements IDerivedStateComputer {

	val USER_ENTITY = 'User'
	val AUTHORITY_ENTITY = 'Authority'
	val BUILT_IN_ENTITIES = #{
		USER_ENTITY -> #[
			'firstName' -> stringType,
			'lastName' -> stringType,
			'login' -> stringType,
			'email' -> stringType,
			'imageUrl' -> stringType,
			'authorities' -> stringType
		],
		AUTHORITY_ENTITY -> #[
			'name' -> stringType
		]
	}
	static val factory = JdlPackage.eINSTANCE.jdlFactory

	override discardDerivedState(DerivedStateAwareResource resource) {
		// nothing to do here
	}

	override installDerivedState(DerivedStateAwareResource resource, boolean preLinkingPhase) {
		if (preLinkingPhase || resource === null || !resource.isLoaded) return;
		if (!resource.builtInTypesAlreadyDefined) {
			val model = resource.model
			if (model !== null) {
				model.fullFileName = resource.URI.toFileString
				model.name = resource.modelName
				BUILT_IN_ENTITIES.forEach[name, fields|
					if (!model.hasEntity(name)) {
						model.features += factory.createJdlEntity => [ entity |
							entity.name = name
							entity.builtIn = true
							entity.fieldDefinition = factory.createJdlEntityFieldDefinition
							fields.forEach[entity.addField(key, value)]
						]
					}
				]
			}
		}
	}

	def protected String getModelName(DerivedStateAwareResource resource) {
		return try {
			resource.URI.trimFileExtension.lastSegment
		} catch (Exception exception) {
			null
		}
	}

	def boolType() {
		factory.createJdlBooleanFieldType => [
			it.element = factory.createJdlBooleanType
			it.element.element = 'Boolean'
		]
	}

	def stringType() {
		factory.createJdlStringFieldType => [
			it.element = factory.createJdlStringType
			it.element.element = 'String'
		]
	}

	def numType() {
		factory.createJdlNumericFieldType => [
			it.element = JdlNumericTypes.INTEGER
		]
	}

	def private void addField(JdlEntity entiy, String name, JdlFieldType type) {
		entiy.fieldDefinition.fields.add(
			factory.createJdlEntityField => [
				it.name = name
				it.type = type
			]
		)
	}

	def private JdlDomainModel getModel(DerivedStateAwareResource resource) {
		try {
			val result = resource.contents.filter(JdlDomainModel)
			var model = if (result.size === 1) result.head
			if (model != model.eIsProxy) {
				model = EcoreUtil2.resolve(model, resource) as JdlDomainModel
			}
			return model
		} catch (Exception ex) {
			return null
		}
	}

	def private boolean hasEntity(DerivedStateAwareResource resource, String entiyName) {
		return resource.model.hasEntity(entiyName)
	}

	def private boolean hasEntity(JdlDomainModel model, String entiyName) {
		return try {
			model.features.filter(JdlEntity).filter[it.name == entiyName].isNullOrEmpty == false
		} catch (Exception ex) {
			false
		}
	}

	def private boolean builtInTypesAlreadyDefined(DerivedStateAwareResource it) {
		return try {
			hasEntity(USER_ENTITY) && hasEntity(AUTHORITY_ENTITY)
		} catch (Exception ex) {
			false
		}
	}
}
