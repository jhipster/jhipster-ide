package io.github.jhipster.jdl

import io.github.jhipster.jdl.generator.JDLGenerator
import io.github.jhipster.jdl.resource.JdlDerivedStateComputer
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
}
