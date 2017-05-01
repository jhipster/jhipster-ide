package io.github.jhipster.jdl

import com.google.inject.Provides
import io.github.jhipster.jdl.generator.IJdlGenerator
import io.github.jhipster.jdl.generator.JDLGenerator
import io.github.jhipster.jdl.plantuml.PlantUmlGenerator
import io.github.jhipster.jdl.renderer.IJdlToPlantUmlRenderer
import io.github.jhipster.jdl.renderer.JdlToPlantUmlRenderer
import io.github.jhipster.jdl.resource.JdlDerivedStateComputer
import java.util.Set
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager
import org.eclipse.xtext.resource.IDerivedStateComputer
import org.eclipse.xtext.resource.IResourceDescription

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class JDLRuntimeModule extends AbstractJDLRuntimeModule {

	override bindIGenerator2() {
		JDLGenerator
	}

	override bindXtextResource() {
		return DerivedStateAwareResource
	}

	def Class<? extends IDerivedStateComputer> bindIDerivedStateComputer() {
		JdlDerivedStateComputer
	}

	def Class<? extends IResourceDescription.Manager> bindIResourceDescriptionManager() {
		DerivedStateAwareResourceDescriptionManager
	}
	
	def Class<? extends IJdlToPlantUmlRenderer> bindIJdlToPlantUmlRenderer() {
		return JdlToPlantUmlRenderer
	}
	
	def Class<? extends IJdlGenerator> bindPlantUmlGenerator() {
		return PlantUmlGenerator
	}

	@Provides
	def Set<IJdlGenerator> jdlGenerators() {
		#{new PlantUmlGenerator}
	}
}
