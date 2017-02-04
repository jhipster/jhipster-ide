package io.github.jhipster.jdl.tests

import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Provider
import io.github.jhipster.jdl.JDLStandaloneSetup
import java.io.File
import java.util.Collection
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

import static org.junit.Assert.*

@RunWith(Parameterized)
class JDLFileTest {
	
	@Inject Provider<ResourceSet> resourceSetProvider;
	@Inject IResourceValidator validator;
	@Inject IGenerator2 generator;
	@Inject JavaIoFileSystemAccess fileAccess;

	var ResourceSet resourceSet
	var File jdlFile
	var Injector injector
	
	static List<File> jdlReferencedFiles
	static List<Pair<File, String>> unexpectedIssues
	
	val expectedIssues = #[
		 "complex_jdl.jdl" -> "Couldn't resolve reference to JdlEntity 'User'.",
		 "invalid_field_type.jdl" -> "Couldn't resolve reference to JdlEnum 'NullPointerException'.",
		 "invalid_option.jdl" -> "mismatched input 'wrong' expecting 'mapstruct'",
		 "non_existent_validation.jdl" -> "mismatched input 'min' expecting '}'",
		 "unexistent_entities_for_relationship.jdl" -> "Couldn't resolve reference to JdlEntity 'B'.",
		 "wrong_relationships_jdl.jdl" -> "required (...)+ loop did not match anything at input '}'",
		 "wrong_required_relationships_jdl.jdl" -> "Constraint 'required' on a relationship of type OneToMany will be ignored",
		 "wrong_required_relationships_jdl.jdl" -> "Constraint 'required' on a relationship of type ManyToOne will be ignored",
		 "wrong_required_relationships_jdl.jdl" -> "Constraint 'required' on a relationship of type ManyToMany will be ignored"
	]
	
	new(File jdlFile) {
		this.jdlFile = jdlFile
	}

	@BeforeClass
	def static void initTestCase()  {
		unexpectedIssues = newArrayList
		// put here all JDL definitions which are referenced by other JDLs
		jdlReferencedFiles = #[
// none at the moment
//			new File('./resources/test_files/foobar.jdl')
		]
	}

	@AfterClass
	def static void reportIssues() {
		unexpectedIssues.forEach[ issue |
			System.err.println('''Unexpected issue: «issue.value» in «issue.key» found!''')		
		]
		if (unexpectedIssues.isEmpty == false) fail('Unexpected issues found! Check output...')
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
		jdlReferencedFiles.forEach[
			resourceSet.getResource(URI.createURI(absoluteFile.toURI.toString), true)
		]
		val resource = resourceSet.getResource(URI.createURI(jdlFile.toURI.toString), true)
		// validate the resource
		val issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl)
		issues?.forEach[ issue |
			val expected = expectedIssues.findFirst[
				jdlFile.name.equals(key) && value.startsWith(issue.message)
			]
			if (expected !== null ) println('''Expected issue detected: [«issue»]''') else unexpectedIssues += jdlFile -> issue.message
		]
		// configure and start the generator
		fileAccess.setOutputPath("src-gen/");
		generator.doGenerate(resource, fileAccess, null);
	}
}