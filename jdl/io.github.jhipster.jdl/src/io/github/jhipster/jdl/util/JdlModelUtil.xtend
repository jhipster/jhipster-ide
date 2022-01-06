/**
 * Copyright 2016-2022 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.util

import com.google.inject.Inject
import io.github.jhipster.jdl.jdl.JdlApplication
import io.github.jhipster.jdl.jdl.JdlComplexAnnotation
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEntitySelection
import io.github.jhipster.jdl.jdl.JdlFactory
import io.github.jhipster.jdl.jdl.JdlOption
import io.github.jhipster.jdl.jdl.JdlOptionSetting
import io.github.jhipster.jdl.jdl.JdlRelation
import io.github.jhipster.jdl.jdl.JdlRelationRole
import io.github.jhipster.jdl.jdl.JdlRelationship
import io.github.jhipster.jdl.jdl.JdlRelationships
import io.github.jhipster.jdl.jdl.JdlSimpleAnnotation
import io.github.jhipster.jdl.jdl.JdlWildcardPredicate
import java.util.List
import java.util.Map
import java.util.Set
import jbase.jbase.JDLApplicationParameterName
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.resource.XtextResource

import static java.lang.System.*
import static org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JdlModelUtil {

	@Inject IEObjectDocumentationProvider documentationProvider;
	val factory = JdlFactory.eINSTANCE

	def static getInstance(JdlDomainModel jdl) {
		val res = if (jdl !== null) jdl?.eResource as XtextResource
		return res?.resourceServiceProvider?.get(JdlModelUtil)		
	}

	def String getDocumentation(EObject source) {
		if (source === null) return '' // prevent NPE
		val documentation = documentationProvider.getDocumentation(source)
		return documentation;
	}

	def JdlRelation getOpposite(JdlRelationRole relationRole) {
		if(relationRole === null) return null
		val relation = relationRole.eContainer as JdlRelation
		val relship = relationRole.eContainer.getContainerOfType(JdlRelationship)
		val opposite = if(relship.source === relation) relship.target else relship.source
		return opposite
	}

	def static boolean isJdlResource(JdlDomainModel it) {
		return it?.eResource.isJdlResource
	}
	
	def static boolean isJdlResource(Resource resource) {
		val ext = resource?.URI?.fileExtension
		return !ext.isNullOrEmpty && #['jdl', 'jh'].exists[ext == it]
	}
	
	def boolean hasRelation(JdlEntity entity) {
		if (entity === null) return false
		val model = entity.getContainerOfType(JdlDomainModel)
		if (model === null || model.features.isNullOrEmpty) return false
		return model.features.filter(JdlRelationships).map[
			relationships
		].flatten.map[
			#[source?.entity, target?.entity]
		].flatten.filter[it !== null].toList.exists[it == entity]
	}

	def Map<JdlEntity, Set<JdlOption>> toEntiyOptionMap(JdlDomainModel jdl) {
		val result = newHashMap
		if (jdl === null || jdl.eContents.nullOrEmpty) return result
		val (JdlOption)=>Iterable<JdlEntity> getEntities = [ o |
			val predicate = if (o.setting?.includes !== null) {
					valueOf(o.setting.includes, 'getPredicate') as JdlWildcardPredicate
				}
			val isSelectAll = predicate !== null && (predicate.isWildcard || predicate.isAll)
			if (isSelectAll) {
				val entitySelection = jdl.eContents.filter(JdlEntity).filter[!isExcluded(o, it)]
				entitySelection ?: #[]
			} else {
				val entitySelection = if (o.setting?.includes !== null) {
					val selection = valueOf(o.setting.includes, 'getSelection') as JdlEntitySelection
					selection?.entities
				}
				entitySelection ?: #[]
			}
		]
		jdl.eContents.filter(JdlOption).toSet.forEach [ option |
			getEntities.apply(option).forEach [ entity |
				val options = if(result.containsKey(entity)) result.get(entity) else newHashSet
				options.add(option)
				result.put(entity, options)
			]
		]
		jdl.eContents.filter(JdlEntity).map[annotations].flatten.forEach [
			val entity = eContainer as JdlEntity
			val options = if (result.containsKey(entity)) result.get(entity) else newHashSet
			result.put(entity, options)
			val aOption = switch (it) {
				JdlComplexAnnotation case isDto: {
					createOption => [setting.dtoOption = true]
				}
				JdlComplexAnnotation case isAngularSuffix: {
					createOption => [setting.angularSuffixOption = true]
				}
				JdlComplexAnnotation case isClientRootFolder: {
					createOption => [setting.clientRootFolder = true]
				}
				JdlComplexAnnotation case isMicroservice: {
					createOption => [setting.microserviceOption = true]
				}
				JdlComplexAnnotation case isPaginate: {
					createOption => [setting.paginateOption = true]
				}
				JdlComplexAnnotation case isSearch: {
					createOption => [setting.searchOption = true]
				}
				JdlComplexAnnotation case isService: {
					createOption => [setting.serviceOption = true]
				}
				JdlSimpleAnnotation case isNoFluentMethod: {
					createOption => [setting.noFluentMethodOption = true]
				}
				JdlSimpleAnnotation case isSkipClient: {
					createOption => [setting.skipClientOption = true]
				}
				JdlSimpleAnnotation case isSkipServer: {
					createOption => [setting.skipServerOption = true]
				}
			}
			if (aOption !== null) options.add(aOption)
		]
		return result
	}

	def JdlOption createOption() {
		val result = factory.createJdlOption => [
			it.setting = factory.createJdlOptionSetting
		]
		return result
	}

	def getOptionType(JdlOptionSetting setting) {
		val result = setting.class.methods.filter[
			name.startsWith('is') && name.endsWith('Option')
		].filter[
		 	invoke(setting) as Boolean
		]
		if (!result.isNullOrEmpty && result.size == 1) {
			result.last.name.replaceAll('is|Option', '')
		}
	}

	def toOptionStereotype(JdlEntity entity, Map<JdlEntity, Set<JdlOption>> entiyOptionMap) 
		'''«var opts=entity.toOptionText(entiyOptionMap)?.toString»«IF !opts.nullOrEmpty»<<Option {«opts»}>>«ENDIF»'''

	def toOptionText(JdlEntity entity, Map<JdlEntity, Set<JdlOption>> entiyOptionMap) 
		'''«var opts=entiyOptionMap.get(entity)?.filter[!isExcluded(entity)]»«IF !opts.nullOrEmpty»«FOR it : opts SEPARATOR ','»«setting.optionType»«ENDFOR»«ENDIF»'''

	def String getOptionsText(JdlEntity entity) {
		if (entity === null) return ''
		val jdl = entity.getContainerOfType(JdlDomainModel)
		val result = if (jdl !== null) entity.toOptionText(jdl.entiyOptionMap) else ''
		return result?.toString
	}

	def List<String> getOptions(JdlEntity entity) {
		if (entity === null) return #[]
		val jdl = entity.getContainerOfType(JdlDomainModel)
		val result = if (jdl !== null) entity.toOptionText(jdl.entiyOptionMap) else ''
		return result?.toString?.split(',')
	}

	def boolean isExcluded(JdlOption opt, JdlEntity entity) {
		try {
			(opt.resolve(opt.eResource) as JdlOption).excludes.selection.entities.contains(entity)
		} catch (Exception exception) {
			false
		}
	}

	def valueOf(Object type, String methodName) {
		try {
			type.^class.getMethod(methodName).invoke(type)
		} catch (Exception exception) {
			null
		}
	}

	def boolean hasSkipUserManagementEnabled(JdlApplication it) {
		return it !== null && (isSkipUserManagementEnabled ||
			!config?.paramters.isNullOrEmpty && config.paramters.exists[
				paramName !== null && paramValue !== null && 
				!paramValue.identifiers.isNullOrEmpty && 
				paramName == JDLApplicationParameterName.SKIP_USER_MANAGEMENT &&
				Boolean.valueOf(paramValue.identifiers.head)
			]
		)
	}

	def boolean isSkipUserManagementEnabled(EObject it) {
		return hasOptionComment('--skip-user-management', 'skip-user-management')
	}

	def boolean isLintDisabled(EObject it) {
		return hasOptionComment('lint=false', 'no-linting')
	}

	def boolean hasOptionComment(EObject eObj, String ...options) {
		if (eObj === null || options.isNullOrEmpty) return false
		val model = getContainerOfType(eObj, JdlDomainModel)
		val node = findActualNodeFor(model)
		if (node === null) return false
		val lines = node.text.split(lineSeparator)
		val result = #[options].exists[
			exists[lines.head.replaceAll('\\s+', '').contains(it)]
		]
		return result
	}
}
