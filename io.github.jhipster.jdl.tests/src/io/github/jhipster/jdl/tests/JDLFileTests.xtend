package io.github.jhipster.jdl.tests

import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Provider
import io.github.jhipster.jdl.JDLStandaloneSetup
import java.io.File
import java.util.Collection
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized)
@InjectWith(JDLInjectorProvider)
class JDLFileTests {
	
	@Inject Provider<ResourceSet> resourceSetProvider;
	@Inject IResourceValidator validator;
	@Inject IGenerator2 generator;
	@Inject JavaIoFileSystemAccess fileAccess;

	var ResourceSet resourceSet
	var File jdlFile
	var Injector injector
	
	new(File jdlFile) {
		this.jdlFile = jdlFile
	}
		
	@Before
	def void setUp() {
		injector = new JDLStandaloneSetup().createInjectorAndDoEMFRegistration()
		injector.injectMembers(this)
		resourceSet = resourceSetProvider.get
	}

	@Parameters
    def static Collection<File> getJdlFiles() {
    	val resources = new File('./resources/test_files')
  		val result = resources.listFiles([File dir, String name | 
  			name.endsWith('.jdl')
  		]).toList
  		return result
    }

	@Test
	def void testJdlFile() {
		val resource = resourceSet.getResource(URI.createURI(jdlFile.absolutePath), true);
		// validate the resource
		val issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl)
		issues?.forEach[ issue |
			System.err.println(issue)
		]
		// configure and start the generator
		fileAccess.setOutputPath("src-gen/");
		generator.doGenerate(resource, fileAccess, null);
	}
}