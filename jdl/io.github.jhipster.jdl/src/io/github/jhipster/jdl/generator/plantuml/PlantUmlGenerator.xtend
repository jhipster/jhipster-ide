package io.github.jhipster.jdl.generator.plantuml

import io.github.jhipster.jdl.generator.IJdlGenerator
import io.github.jhipster.jdl.jdl.JdlDomainModel
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import io.github.jhipster.jdl.renderer.IJdlModelViewerRenderer
import io.github.jhipster.jdl.renderer.JdlModelViewerRenderer

import static io.github.jhipster.jdl.renderer.RenderType.*
import static io.github.jhipster.jdl.util.PlantUmlUtil.*
import static extension io.github.jhipster.jdl.util.EcorePlatformUtil.*

class PlantUmlGenerator implements IJdlGenerator {

	extension IJdlModelViewerRenderer = JdlModelViewerRenderer.get(PlantUml)
	
	override generate(JdlDomainModel model, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val resource = model?.eResource
		if (resource !== null) {
			model.render => [
				if (System.getProperty('plantuml.gen') == 'true') {
					createPlantUml(it, resource.toFile('plantuml'));			
				}					
				if (System.getProperty('pnguml.gen') == 'true') {
					createImage(it, resource.toFile('png'))
				}					
			]
		} else println('Error processing model: ' + model)
	}
}