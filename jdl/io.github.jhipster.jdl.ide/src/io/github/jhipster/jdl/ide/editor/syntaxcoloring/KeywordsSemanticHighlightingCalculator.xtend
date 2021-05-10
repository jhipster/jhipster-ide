/**
 * Copyright 2016-2021 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.ide.editor.syntaxcoloring

import io.github.jhipster.jdl.jdl.JdlAnnotation
import io.github.jhipster.jdl.jdl.JdlApplicationParameter
import io.github.jhipster.jdl.jdl.JdlConstant
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEnum
import io.github.jhipster.jdl.jdl.JdlPackage
import io.github.jhipster.jdl.jdl.JdlRelation
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.util.CancelIndicator

import static io.github.jhipster.jdl.ide.editor.syntaxcoloring.JDLHighlightingStyles.*
import static org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles.*
import static org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class KeywordsSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {

	extension JdlPackage = JdlPackage.eINSTANCE

	override protected boolean highlightElement(EObject eObj, IHighlightedPositionAcceptor it,
		CancelIndicator cancelIndicator) {
		val acc = it
		switch (eObj) {
			JdlConstant: {
				#[jdlConstant_Name -> NAME_ID, jdlConstant_Value -> ENUM_VALUE_ID].forEach[
					acc.highlightFeature(eObj, key, value)
				]
				return true
			}
			JdlApplicationParameter: {
				highlightFeature(eObj, jdlApplicationParameter_ParamName, NAME_ID)
				#[jdlParameterValue_Identifiers, jdlParameterValue_ListElements].forEach[
					highlightListFeature(acc, eObj.paramValue, it, ENUM_VALUE_ID)
				]
				#[jdlParameterValue_StringValue, jdlParameterValue_Version, jdlParameterValue_NumberValue].forEach[
					highlightFeature(acc, eObj.paramValue, it, STRING_ID)
				]
				return true
			}
			JdlEntity: {
				#[jdlCustomAnnotation_Identifier, jdlEntity_Annotations, jdlEntity_Name].forEach[ feature |
					highlightFeature(eObj, feature, NAME_ID)
				]
				eObj.fieldDefinition?.fields?.forEach[ f |
					highlightFeature(f, jdlEntityField_Type, TYPE_ID)
					#[jdlEntityField_Name, jdlCustomAnnotation_Identifier, jdlEntityField_Annotations].forEach[ feature |
						highlightFeature(f, feature, NAME_ID)
					]
				]
				return true
			}
			JdlRelation: {
				highlightFeature(eObj, jdlRelation_Entity, TYPE_ID)
				return true
			}
			JdlEnum: {
				highlightFeature(eObj, jdlEntity_Name, NAME_ID)
				eObj.values.forEach[
					highlightFeature(acc, it, jdlEnumValue_Value, ENUM_VALUE_ID)
				]
				return true
			}
			JdlAnnotation: {
				#[jdlCustomAnnotation_Identifier, jdlCustomAnnotation_Value].forEach[ feature |
					highlightFeature(eObj, feature, KEYWORD_ID)
				]
				return true
			}
			default: return false
		}
	}
	
	def protected void highlightListFeature(
		IHighlightedPositionAcceptor acceptor, EObject eObj, EStructuralFeature feature, String... styleIds
	) {
		findNodesForFeature(eObj, feature)?.forEach[
			highlightNode(acceptor, it, styleIds)
		]
	}
}
