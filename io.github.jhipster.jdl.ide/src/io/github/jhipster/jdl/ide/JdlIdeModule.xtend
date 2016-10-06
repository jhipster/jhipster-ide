package io.github.jhipster.jdl.ide

import io.github.jhipster.jdl.ide.renderer.JdlModelViewerRenderer
import io.github.jhipster.jdl.ide.renderer.plantuml.IJdlToPlantUmlRenderer
import io.github.jhipster.jdl.ide.renderer.plantuml.JdlToPlantUmlRenderer
import org.eclipse.xtext.service.AbstractGenericModule

class JdlIdeModule extends AbstractGenericModule {
	
	def Class<? extends JdlModelViewerRenderer> bindJdlModelViewerRenderer() {
		return JdlModelViewerRenderer
	}

	def Class<? extends IJdlToPlantUmlRenderer> bindIJdlToPlantUmlRenderer() {
		return JdlToPlantUmlRenderer
	}
	
}