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
		if (!instances.keySet.contains(renderer)) {
			throw new IllegalArgumentException('''Renderer «renderer» not yet implemented!''')
		}
		instances.get(renderer)
	}
}