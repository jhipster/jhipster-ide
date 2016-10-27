package io.github.jhipster.jdl.resource

import io.github.jhipster.jdl.jdl.JdlPackage
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.resource.IDerivedStateComputer
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlDomainModel

class JdlDerivedStateComputer implements IDerivedStateComputer {

	static val factory = JdlPackage.eINSTANCE.jdlFactory

	override discardDerivedState(DerivedStateAwareResource resource) {
		// nothing to do here
	}

	override installDerivedState(DerivedStateAwareResource resource, boolean preLinkingPhase) {
		if (!preLinkingPhase && !resource.builtInTypesAlreadyDefined) {
			val user = factory.createJdlEntity => [
				name = 'User'
			]
			val model = resource.model
			if (model != null) model.features += user 
			// else resource.contents += user // FIXME: we cannot have multiple roots in a model!
		}
	}

	def private getModel(DerivedStateAwareResource resource) {
		try {
			resource.contents.filter(JdlDomainModel).last
		} catch (Exception exception) {
			null
		}
	}

	def private builtInTypesAlreadyDefined(DerivedStateAwareResource resource) {
		try {
			resource.contents.filter(JdlEntity).findFirst[name.equals('User')] != null
		} catch (Exception exception) {
			false
		}
	}
}
