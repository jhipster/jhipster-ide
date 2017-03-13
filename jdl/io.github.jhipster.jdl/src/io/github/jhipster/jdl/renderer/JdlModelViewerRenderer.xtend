package io.github.jhipster.jdl.renderer

import io.github.jhipster.jdl.jdl.JdlDomainModel
import java.util.Map

import static io.github.jhipster.jdl.renderer.RenderType.*

enum RenderType {
	PlantUml,
	EmfUml2,
	ZestDot
}

interface IJdlModelViewerRenderer {
	def String render(JdlDomainModel model) 	
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
