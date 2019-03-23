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
package io.github.jhipster.jdl.ui.outline

import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntityField
import io.github.jhipster.jdl.jdl.JdlOption
import io.github.jhipster.jdl.jdl.JdlRelation
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode
import io.github.jhipster.jdl.jdl.JdlDeploymentParameter
import io.github.jhipster.jdl.jdl.JdlApplicationParameter

/**
 * Customization of the default outline structure.
 *
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class JDLOutlineTreeProvider extends DefaultOutlineTreeProvider {
	
	override protected _createChildren(DocumentRootNode parentNode, EObject modelElement) {
		// skip root node
		if (modelElement instanceof JdlDomainModel) {
			for (feature : modelElement.features) {
				createNode(parentNode, feature);
			}
		}
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
