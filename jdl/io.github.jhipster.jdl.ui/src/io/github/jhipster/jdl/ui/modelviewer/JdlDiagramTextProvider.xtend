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
package io.github.jhipster.jdl.ui.modelviewer

import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.renderer.IJdlModelViewerRenderer
import io.github.jhipster.jdl.renderer.JdlModelViewerRenderer
import net.sourceforge.plantuml.text.AbstractDiagramTextProvider
import org.eclipse.ui.IEditorInput
import org.eclipse.ui.IEditorPart
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.model.XtextDocument

import static io.github.jhipster.jdl.renderer.RenderType.*
import org.eclipse.jface.viewers.ISelection
import java.util.Map

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JdlDiagramTextProvider extends AbstractDiagramTextProvider {

	extension IJdlModelViewerRenderer = JdlModelViewerRenderer.get(PlantUml)

	override protected getDiagramText(IEditorPart editorPart, IEditorInput editorInput, ISelection selection, Map<String, Object> map) {
		if (editorPart instanceof XtextEditor) {
			val document = editorPart.documentProvider.getDocument(editorInput) as XtextDocument
			val model = document?.readOnly [
				val element = contents?.head
				if (element instanceof JdlDomainModel) element else null
			]
			model.render
		}
	}
	
	override supportsSelection(ISelection selection) {
		false
	}

	override supportsEditor(IEditorPart editorPart) {
		true
	}
}
