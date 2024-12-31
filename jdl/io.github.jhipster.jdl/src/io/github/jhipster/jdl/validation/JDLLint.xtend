/**
 * Copyright 2016-2025 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.validation

import com.google.inject.Inject
import io.github.jhipster.jdl.jdl.JdlApplicationConfig
import io.github.jhipster.jdl.jdl.JdlDeployment
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEntityFieldDefinition
import io.github.jhipster.jdl.jdl.JdlEnum
import io.github.jhipster.jdl.jdl.JdlRelationships
import io.github.jhipster.jdl.services.JDLGrammarAccess
import io.github.jhipster.jdl.util.JdlModelUtil
import java.util.Collections
import java.util.concurrent.atomic.AtomicBoolean
import java.util.stream.Collectors
import java.util.stream.IntStream
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static io.github.jhipster.jdl.jdl.JdlPackage.Literals.*
import static io.github.jhipster.jdl.validation.IssueCodes.*
import static java.lang.System.lineSeparator
import static org.apache.commons.lang3.StringUtils.*
import static org.eclipse.xtext.EcoreUtil2.*
import static org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JDLLint extends AbstractDeclarativeValidator {

	@Inject JDLGrammarAccess ga
	@Inject extension JdlModelUtil

	override register(EValidatorRegistrar registrar) {
	}

	@Check
	def void checkApplicationParametersUniqueness(JdlApplicationConfig config) {
		if (isLintDisabled(config)) return
		val set = newHashSet
		config.paramters.map [
			it.paramName.literal
		].forEach [ p, i |
			if (!set.add(p))
				error(
					String.format(INVALID_PARAM_NOTUNIQUE_MSG, p),
					JDL_APPLICATION_CONFIG__PARAMTERS, i
				)
		]
	}

	@Check
	def void checkDeploymentParametersUniqueness(JdlDeployment deployment) {
		if (isLintDisabled(deployment)) return
		val set = newHashSet
		deployment.paramters.map [
			it.paramName.literal
		].forEach [ p, i |
			if (!set.add(p))
				error(
					String.format(INVALID_PARAM_NOTUNIQUE_MSG, p),
					JDL_DEPLOYMENT__PARAMTERS, i
				)
		]
	}

	@Check
	def void checkForGroupableRelationships(JdlRelationships relations) {
		if (isLintDisabled(relations)) return
		val set = newHashSet
		set.add(relations.cardinality)
		val model = getContainerOfType(relations, JdlDomainModel)
		val rels = model.features.filter(JdlRelationships).filter[
			it !== relations &&
			it.cardinality === relations.cardinality
		]
		rels.forEach [ r, i |
			if (!set.add(r.cardinality))
				warning(
					String.format(FOUND_GROUPABLE_RELATIONSHIP_MSG, r.cardinality), 
					r, JDL_RELATIONSHIPS__CARDINALITY
				)
		]
	}

 	def void checkRelationshipUniqueness(JdlRelationships relations) {
 		if (isLintDisabled(relations)) return
 		val set = newHashSet
 		relations.relationships.filter [
 			it.source !== null && it.source.entity !== null && it.target !== null && it.target.entity !== null
 		].forEach [ r, i |
 			if (!set.add(r.source.entity -> r.target.entity))
 				error(
 					String.format(
 						INVALID_RELATIONSHIP_NOTUNIQUE_MSG,
 						r.source.entity.name -> r.target.entity.name
 					), JDL_RELATIONSHIPS__RELATIONSHIPS, i
 				)
 		]
 	}
 	
	@Check
	def void checkForDuplicateEnumValues(JdlEnum enumDef) {
		if (isLintDisabled(enumDef)) return
		val duplicates = enumDef.values.stream().distinct().filter(e|Collections.frequency(enumDef.values, e) > 1).
			collect(Collectors.toList());
		if (!duplicates.isNullOrEmpty) {
			val values = enumDef.values
			duplicates.forEach [ e |
				var occurrences = IntStream.range(0, values.size()).boxed().filter [ k |
					values.get(k).equals(e)
				].collect(Collectors.toList)
				if (occurrences.size > 1) {
					occurrences.remove(0)
					occurrences.forEach [ i |
						error(String.format(DUPLICATE_ENUM_VALUE_DEF_MSG, e), JDL_ENUM__VALUES, i)
					]
				}
			]
		}
	}

	@Check
	def void checkUnusedEnums(JdlEnum it) {
		if (isLintDisabled) return
		val model = getContainerOfType(it, JdlDomainModel)
		val AtomicBoolean found = new AtomicBoolean
		findCrossReferences(model, #{it}, [found.set(true)])
		if (!found.get) {
			info(String.format(ENUM_IS_NOT_USED_MSG, model.eResource.URI.lastSegment), JDL_ENUM__NAME)
		}
	}

	@Check
	def void checkForEmptyEntityDef(JdlEntity it) {
		if (isLintDisabled) return;
		if (fieldDefinition?.fields.isNullOrEmpty && containsCurlyBrackets(it)) {
			info(String.format(EMPTY_ENTITY_DEF_MSG, it.name), JDL_ENTITY__NAME)
		}
	}

	@Check
	def void checkTableDef(JdlEntity it) {
		if (isLintDisabled) return;
		if (!table.isNullOrEmpty) {
			var tableName = join(splitByCharacterTypeCamelCase(name), '_').toLowerCase
			if (tableName == table) {
				warning(DEFINITION_HAS_NO_EFFECT_MSG, JDL_ENTITY__TABLE)
			}
		}
	}

	@Check
	def void checkUselessCommas(EObject it) {
		if (isLintDisabled) return;
		switch (it) {
			JdlEntityFieldDefinition: {
				if (containsComma(it)) {
					it.fields.forEach[ f, i |
						warning(USELESS_COMMAS_MSG, f, JDL_ENTITY_FIELD__TYPE, i)
					]
				}
			} 
			JdlApplicationConfig : {
				if (containsComma(it)) {
					it.paramters.forEach[ f, i |
						warning(USELESS_COMMAS_MSG, f, JDL_APPLICATION_PARAMETER__PARAM_NAME, i)
					]
				}
			}
			JdlDeployment : {
				if (containsComma(it)) {
					it.paramters.forEach[ f, i |
						warning(USELESS_COMMAS_MSG, f, JDL_DEPLOYMENT_PARAMETER__PARAM_NAME, i)
					]
				}
			}
		}
	}

	def private boolean containsComma(EObject eObj) {
		val node = findActualNodeFor(eObj)
		if (node === null) return false
		val comma = ga.jdlEntityFieldDefinitionAccess.commaKeyword_1_0.value
		val expression = node.removeComments
		val lines = expression.split(lineSeparator).map[trim].toList
		return lines.exists[startsWith(comma) || endsWith(comma)]
	}

	def private boolean containsCurlyBrackets(EObject eObj) {
		val leftCurl = ga.jdlEntityAccess.leftCurlyBracketKeyword_4_0.value
		val rightCurl = ga.jdlEntityAccess.rightCurlyBracketKeyword_4_2.value
		return containsTerminal(eObj, leftCurl, rightCurl)
	}
	
	def private boolean containsTerminal(EObject eObj, String... terminals) {
		val node = findActualNodeFor(eObj)
		if (node === null) return false
		val expression = node.removeComments
		return !expression.isNullOrEmpty && terminals.forall[expression.contains(it)]
	}
	
	def private removeComments(ICompositeNode it) {
		return text.replaceAll('(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)','')
	}
}
