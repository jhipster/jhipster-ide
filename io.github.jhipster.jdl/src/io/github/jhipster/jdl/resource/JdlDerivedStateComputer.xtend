package io.github.jhipster.jdl.resource

import io.github.jhipster.jdl.jdl.JdlPackage
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.resource.IDerivedStateComputer
import io.github.jhipster.jdl.jdl.JdlEntity

class JdlDerivedStateComputer implements IDerivedStateComputer {
	
	static val factory = JdlPackage.eINSTANCE.jdlFactory	

	override discardDerivedState(DerivedStateAwareResource resource) {
		// nothing to do here
	}
	
	override installDerivedState(DerivedStateAwareResource resource, boolean preLinkingPhase) {
		if (!preLinkingPhase && !resource.builtInTypesDefined) {
			val user = factory.createJdlEntity => [
				name = 'User'
			]
			resource.contents += user
		}
	}
	
	def builtInTypesDefined(DerivedStateAwareResource resource) {
		try {
			resource.contents.filter(JdlEntity).findFirst[name.equals('User')] != null
		} catch (Exception exception) {
			false
		}
	}
}
