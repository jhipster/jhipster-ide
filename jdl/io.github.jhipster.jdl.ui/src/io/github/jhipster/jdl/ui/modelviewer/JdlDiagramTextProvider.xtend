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

class JdlDiagramTextProvider extends AbstractDiagramTextProvider {

	extension IJdlModelViewerRenderer = JdlModelViewerRenderer.get(PlantUml)

	override protected getDiagramText(IEditorPart editorPart, IEditorInput editorInput, ISelection selection) {
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
