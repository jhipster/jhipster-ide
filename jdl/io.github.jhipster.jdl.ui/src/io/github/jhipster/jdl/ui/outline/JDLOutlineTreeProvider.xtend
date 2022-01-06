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
package io.github.jhipster.jdl.ui.outline

import com.google.inject.Inject
import io.github.jhipster.jdl.jdl.JdlApplicationParameter
import io.github.jhipster.jdl.jdl.JdlDeploymentParameter
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEntityField
import io.github.jhipster.jdl.jdl.JdlEntityFieldDefinition
import io.github.jhipster.jdl.jdl.JdlOption
import io.github.jhipster.jdl.jdl.JdlRelation
import io.github.jhipster.jdl.util.JdlModelUtil
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JDLOutlineTreeProvider extends DefaultOutlineTreeProvider {

	@Inject extension JdlModelUtil util

	override protected _createChildren(DocumentRootNode parentNode, EObject modelElement) {
		if (modelElement instanceof JdlDomainModel) {
			modelElement.features.filter[
				!(it instanceof JdlEntity && (it as JdlEntity).isBuiltIn && isSkipUserManagementEnabled)
			].forEach[ 
				createNode(parentNode, it)
			]
		} 
	}
	
	override protected void createNode(IOutlineNode parentNode, EObject modelElement) {
		if (modelElement instanceof JdlEntityFieldDefinition) {
			modelElement.fields.forEach[ field |
				super.createNode(parentNode, field)
			]
		} else super.createNode(parentNode, modelElement)
	}

	def protected _isLeaf(JdlOption it) {
		true
	}

	def protected _isLeaf(JdlEntityField it) {
		true
	}

	def protected _isLeaf(JdlRelation it) {
		true
	}

	def protected _isLeaf(JdlDeploymentParameter it) {
		true
	}

	def protected _isLeaf(JdlApplicationParameter it) {
		true
	}
}
