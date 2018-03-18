package io.github.jhipster.jdl

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class JDLStandaloneSetup extends JDLStandaloneSetupGenerated {

	def static void doSetup() {
		new JDLStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
