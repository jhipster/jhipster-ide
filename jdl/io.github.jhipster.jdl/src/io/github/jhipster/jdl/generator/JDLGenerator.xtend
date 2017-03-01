package io.github.jhipster.jdl.generator

import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.renderer.IJdlModelViewerRenderer
import io.github.jhipster.jdl.renderer.JdlModelViewerRenderer
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

import static io.github.jhipster.jdl.renderer.RenderType.*

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class JDLGenerator extends AbstractGenerator {

	extension IJdlModelViewerRenderer = JdlModelViewerRenderer.get(PlantUml)

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val puml = resource.URI.trimFileExtension.appendFileExtension('plantuml').lastSegment
		resource.allContents.filter(JdlDomainModel).forEach[
			fsa.generateFile(puml.toString, render)
		]
	}
}
