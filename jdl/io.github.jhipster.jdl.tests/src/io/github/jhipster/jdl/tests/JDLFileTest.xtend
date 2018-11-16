/**
 * Copyright 2013-2018 the original author or authors from the JHipster project.
 *
 * This file is part of the JHipster project, see http://www.jhipster.tech/
 * for more information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.jhipster.jdl.tests

import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Provider
import io.github.jhipster.jdl.JDLStandaloneSetup
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
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

/**
 * @author Serano Colameo - Initial contribution and API
 */
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
		 "wrong_relationships_jdl.jdl" -> "mismatched input '}' expecting RULE_ID",
		 "wrong_relationships_jdl.jdl" -> "mismatched input '<EOF>' expecting '}'",
		 "wrong_required_relationships_jdl.jdl" -> "Constraint 'required' on a relationship of type OneToMany will be ignored",
		 "wrong_required_relationships_jdl.jdl" -> "Constraint 'required' on a relationship of type ManyToOne will be ignored",
		 "wrong_required_relationships_jdl.jdl" -> "Constraint 'required' on a relationship of type ManyToMany will be ignored",
		 "invalid_option.jdl" -> "missing 'mapstruct' at 'wrong'",
		 "wrong_enum_values.jdl" -> "Enum value name must be upper case",
		 "filtering_wrong.jdl" -> 'Keyword "for" is not allowed anymore!',
		 "for_keyword_notallowed.jdl" -> "mismatched input '<EOF>' expecting '='",
		 "for_keyword_notallowed.jdl" -> "Couldn't resolve reference to JdlEntity 'for'.",
		 "filtering_validation_check.jdl" -> "Selection does not contain excluded elements: [C, D]",
		 "wrong_pattern_definition.jdl" -> "Wrong regexp pattern!",
		 "simple.jdl" -> "Constraint 'required' on a relationship of type OneToMany will be ignored",
		 "application_with_wrong_numprefixed_baseName.jdl" -> "Invalid base name!",
		 "application_with_duplicate_params.jdl" -> "Parameter [enableTranslation] already defined!",
		 "application_with_all_conf_params.jdl" -> "Deprecated, will be removed in the next major release!"
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
		val result = newArrayList
		Files.walk(
			Paths.get('./resources/')
		).filter[
			Files.isDirectory(it)
		].map[
  			it.toFile.listFiles([dir, name | 
  				name.endsWith('.jdl') || name.endsWith('.jh')
  			])
  		].forEach[result.addAll(it)]
  		return result
    }
    
	@Test
	def void testJdlFile() {
		jdlReferencedFiles.forEach[
			resourceSet.getResource(URI.createURI(absoluteFile.toURI.toString), true)
		]
		println('''Load and validate «jdlFile»''')
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
		try {
			generator.doGenerate(resource, fileAccess, null);
		} catch (Exception ex) {
			println('''Error in «jdlFile»''')
			ex.printStackTrace
			throw ex
		}
	}
}