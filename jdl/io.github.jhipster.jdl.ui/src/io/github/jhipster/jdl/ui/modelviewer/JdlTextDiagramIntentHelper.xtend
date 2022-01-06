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
package io.github.jhipster.jdl.ui.modelviewer

import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.renderer.IJdlModelViewerRenderer
import io.github.jhipster.jdl.renderer.JdlModelViewerRenderer
import net.sourceforge.plantuml.text.TextDiagramIntent
import net.sourceforge.plantuml.text.TextDiagramIntentHelper
import net.sourceforge.plantuml.util.ResourceInfo
import org.eclipse.jface.text.IDocument
import org.eclipse.jface.text.TextSelection
import org.eclipse.jface.viewers.ISelection
import org.eclipse.xtext.ui.editor.model.XtextDocument

import static io.github.jhipster.jdl.renderer.RenderType.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JdlTextDiagramIntentHelper extends TextDiagramIntentHelper {

	extension IJdlModelViewerRenderer = JdlModelViewerRenderer.get(PlantUml)

	new(String prefix, String prefixRegex, String suffix, String suffixRegex) {
		super(prefix, prefixRegex, suffix, suffixRegex)
	}

	override getDiagramText(IDocument document) {
		return document  instanceof XtextDocument ? getDiagramText(document as XtextDocument) : super.getDiagramText(document)
	}
	
	def private getDiagramText(XtextDocument document) {
		val content = document.modelText
		if (content.isNullOrEmpty) return super.getDiagramText(document)
		val selections = <ISelection>newArrayList
		selections.add = new TextSelection(0, content.length) {
			override getText() {
				content
			}
		}
		return selections.iterator
	}

	def private getModelText(XtextDocument document) {
		val model = document?.readOnly [
			val element = contents?.head
			if (element instanceof JdlDomainModel) element else null
		]
		return model?.render
	}
	
	override getDiagramInfos(IDocument document, int selectionStart, ResourceInfo resourceInfo) {
		if (document === null) return null
		val intent = new TextDiagramIntent(document, selectionStart, this) {
			override getDiagramText() {
				return document instanceof XtextDocument ? document.modelText
			}
		}
		if (resourceInfo !== null) {
			intent.setResourceInfo(new ResourceInfo(resourceInfo))
		}
		return #[intent]
	}
}
