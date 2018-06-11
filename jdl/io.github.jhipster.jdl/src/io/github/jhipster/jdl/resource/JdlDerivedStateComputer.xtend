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
package io.github.jhipster.jdl.resource

import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlFactory
import io.github.jhipster.jdl.jdl.JdlPackage
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.resource.IDerivedStateComputer

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JdlDerivedStateComputer implements IDerivedStateComputer {

	static val USER_ENTITY = 'User'
	static val USER_FIELD_NAME = 'name'
	static extension val JdlFactory = JdlPackage.eINSTANCE.jdlFactory

	override discardDerivedState(DerivedStateAwareResource resource) {
		// nothing to do here
	}

	override installDerivedState(DerivedStateAwareResource resource, boolean preLinkingPhase) {
		if (!preLinkingPhase && !resource.builtInTypesAlreadyDefined) {
			resource.model -> (
				createJdlEntity => [
					name = USER_ENTITY
					it.fields += createJdlEntityField => [
						it.name = USER_FIELD_NAME
						it.type = createJdlStringFieldType
					]
				]
			) => [
				key?.features += value
			]
		}
	}

	def private getModel(DerivedStateAwareResource resource) {
		try {
			resource.contents.filter(JdlDomainModel).last
		} catch (Exception exception) {
			null
		}
	}

	def private builtInTypesAlreadyDefined(DerivedStateAwareResource resource) {
		try {
			resource.contents.filter(JdlEntity).exists[name.equals(USER_ENTITY)]
		} catch (Exception exception) {
			false
		}
	}
}
