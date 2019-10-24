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
package io.github.jhipster.jdl.ide.editor.syntaxcoloring

import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEntityField
import io.github.jhipster.jdl.jdl.JdlEnumValue
import io.github.jhipster.jdl.jdl.JdlPackage
import io.github.jhipster.jdl.jdl.JdlRelation
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.util.CancelIndicator

import static io.github.jhipster.jdl.ide.editor.syntaxcoloring.JDLHighlightingStyles.*
import io.github.jhipster.jdl.jdl.JdlEnum

/**
 * @author Serano Colameo - Initial contribution and API
 */
class KeywordsSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {

	extension JdlPackage = JdlPackage.eINSTANCE

	override protected boolean highlightElement(EObject eObj, IHighlightedPositionAcceptor it,
		CancelIndicator cancelIndicator) {
		switch (eObj) {
			JdlEntity: highlightFeature(eObj, jdlEntity_Name, NAME_ID)
			JdlEntityField: highlightFeature(eObj, jdlEntityField_Type, TYPE_ID)
			JdlRelation: highlightFeature(eObj, jdlRelation_Entity, TYPE_ID)
			JdlEnum: highlightFeature(eObj, jdlEntity_Name, NAME_ID)
			JdlEnumValue: highlightFeature(eObj, jdlEnumValue_Value, ENUM_VALUE_ID)
		}
		return false
	}
}
