package io.github.jhipster.jdl.renderer

import io.github.jhipster.jdl.jdl.JdlDomainModel

interface IJdlModelViewerRenderer {
	def String render(JdlDomainModel model) 	
}
