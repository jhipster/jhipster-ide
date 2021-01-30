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
package io.github.jhipster.jdl.scoping

import com.google.inject.Inject
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.util.JdlModelUtil
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference

import static io.github.jhipster.jdl.jdl.JdlPackage.Literals.*
import static org.eclipse.xtext.scoping.Scopes.*

import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JDLScopeProvider extends AbstractJDLScopeProvider {

	@Inject extension JdlModelUtil

	override getScope(EObject ctx, EReference ref) {
		val model = ref == JDL_RELATION__ENTITY ? ctx?.getContainerOfType(JdlDomainModel)
		return if (model !== null) {
			model.entityScope
		} else {
			super.getScope(ctx, ref)
		}
	}

	def private entityScope(JdlDomainModel model) {
		return scopeFor(model.features.filter(JdlEntity).filter[
			!builtIn || builtIn && !model.isSkipUserManagementEnabled
		])
	}
}
