package io.github.jhipster.jdl.plantuml

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
			val isPlantUmlGenOn = Boolean.getBoolean('plantuml.gen')
			val isPngUmlGenOn = Boolean.getBoolean('pnguml.gen')
			model.render => [
				if (isPlantUmlGenOn) createPlantUml(it, resource.toFile('plantuml'))			
				if (isPngUmlGenOn) createImage(it, resource.toFile('png'))
			]
		} else println('Error processing model: ' + model)
	}
}
