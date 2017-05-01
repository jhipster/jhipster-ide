package io.github.jhipster.jdl.generator

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.plantuml.PlantUmlGenerator
import java.util.Set
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */

@ImplementedBy(PlantUmlGenerator)
interface IJdlGenerator {
	def void generate(JdlDomainModel model, IFileSystemAccess2 fsa, IGeneratorContext context)
}

class JDLGenerator extends AbstractGenerator {

	@Inject Set<IJdlGenerator> generators

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		resource.allContents.filter(JdlDomainModel).forEach[ jdl |
			generators.forEach[
				generate(jdl, fsa, context)
			]
		]
	}	
}
