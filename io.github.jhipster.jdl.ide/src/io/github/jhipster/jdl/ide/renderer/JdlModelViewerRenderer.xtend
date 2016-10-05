package io.github.jhipster.jdl.ide.renderer

import java.util.Map
import io.github.jhipster.jdl.ide.renderer.plantuml.JdlToPlantUmlRenderer
import static io.github.jhipster.jdl.ide.renderer.RenderType.*

enum RenderType {
	PlantUml,
	EmfUml2,
	ZestDot
}

class JdlModelViewerRenderer {

	static val Map<RenderType, IJdlModelViewerRenderer> instances = newHashMap => [
		put(PlantUml, new JdlToPlantUmlRenderer)
	]

	def static IJdlModelViewerRenderer get(RenderType renderer) {
		instances.get(renderer)
	}
}