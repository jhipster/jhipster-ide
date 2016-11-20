package io.github.jhipster.jdl.ui.modelviewer

import io.github.jhipster.jdl.ide.renderer.IJdlModelViewerRenderer
import io.github.jhipster.jdl.ide.renderer.JdlModelViewerRenderer
import io.github.jhipster.jdl.jdl.JdlDomainModel
import net.sourceforge.plantuml.eclipse.utils.AbstractDiagramTextProvider
import org.eclipse.ui.IEditorInput
import org.eclipse.ui.IEditorPart
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.model.XtextDocument

import static io.github.jhipster.jdl.ide.renderer.RenderType.*

class JdlDiagramTextProvider extends AbstractDiagramTextProvider {

	extension IJdlModelViewerRenderer = JdlModelViewerRenderer.get(PlantUml)

	override protected getDiagramText(IEditorPart editorPart, IEditorInput editorInput) {
		val document = (editorPart as XtextEditor).documentProvider.getDocument(editorInput) as XtextDocument
		val model = document?.readOnly [
			val element = contents.head
			if (element instanceof JdlDomainModel) element else null
		]
		render(model)
	}
}
