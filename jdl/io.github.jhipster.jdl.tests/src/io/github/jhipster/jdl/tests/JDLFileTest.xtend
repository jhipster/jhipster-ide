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
import java.util.Set
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

	static Set<File> jdlReferencedFiles
	static Set<Pair<File, String>> unexpectedIssues

	val expectedIssues = #[
		"microservice-ecommerce-store-k8s.jdl" -> "Duplicate JdlRelationRole 'order'",
		"unexistent_entities_for_relationship.jdl" -> "Couldn't resolve reference to JdlEntity 'B'.",
		"non_existent_validation.jdl" -> "mismatched input 'min' expecting '}'",
		"online-shop.jh" -> "Duplicate JdlRelationRole 'product'",
		"microservice-ecommerce-store-k8s.jdl" -> "Duplicate JdlRelationRole 'product'",
		"for_keyword_notallowed.jdl" -> "Couldn't resolve reference to JdlEntity 'for'.",
		"wrong_displayfield_in_target.jdl" -> "Field [jobTitle1] does not exist in entity [Job]",
		"filtering_validation_check.jdl" -> "Selection does not contain excluded elements: [C, D]",
		"ex10.jdl" -> "Duplicate JdlRelationRole 'c'",
		"big_sample.jdl" -> "Duplicate JdlRelationRole 'emp'",
		"wrong_displayfield_in_source.jdl" -> "Duplicate JdlRelationRole 'department'",
		"invalid_option.jdl" -> "missing 'mapstruct' at 'wrong'",
		"wrong_displayfield_in_source.jdl" -> "Duplicate JdlRelationRole 'job'",
		"wrong_required_relationships_jdl.jdl" -> "Duplicate JdlRelationRole 'c'",
		"Model.jdl" -> "Duplicate JdlEntityField 'a' in JdlEntity 'Aasas1'",
		"21-points.jh" -> "Duplicate JdlDisplayField 'login' in JdlRelationRole 'user'",
		"duplicate_entities.jdl" -> "Duplicate JdlFeature 'A'",
		"microservice-ecommerce-store-4-apps.jdl" -> "Duplicate JdlRelationRole 'product'",
		"big_sample.jdl" -> "Duplicate JdlDisplayField 'employee' in JdlRelationRole 'emp'",
		"big_sample.jdl" -> "Field [JobTitle] does not exist in entity [Job]",
		"application_with_duplicate_params.jdl" -> "Parameter [enableTranslation] already defined!",
		"for_keyword_notallowed.jdl" -> "Duplicate JdlFeature 'Region'",
		"wrong_displayfield_in_source.jdl" -> "Duplicate JdlRelationRole 'employee'",
		"big_sample.jdl" -> "Field [employee] does not exist in entity [Employee]",
		"wrong_displayfield_in_source.jdl" -> "Field [title1] does not exist in entity [Task]",
		"wrong_required_relationships_jdl.jdl" -> "Duplicate JdlRelationRole 'b'",
		"big_sample.jdl" -> "Duplicate JdlRelationRole 'department'",
		"Oracle-Human-Resources-sample.jdl" -> "Duplicate JdlRelationRole 'employee'",
		"complex_jdl.jdl" -> "Duplicate JdlRelationRole 'employee'",
		"duration_type.jdl" -> "Duplicate JdlRelationRole 'employee'",
		"duplicate_entities.jdl" -> "Duplicate JdlFeature 'B'",
		"user_entity_to_relationship.jdl" -> "Duplicate JdlRelationRole 'user'",
		"wrong_pattern_definition.jdl" -> "Wrong regexp pattern!",
		"duplicate_fields.jdl" -> "Duplicate JdlEntityField 'cc' in JdlEntity 'B'",
		"for_keyword_notallowed.jdl" -> "mismatched input '<EOF>' expecting '='",
		"ex10.jdl" -> "Duplicate JdlRelationRole 'a'",
		"intant_type.jdl" -> "Duplicate JdlRelationRole 'department'",
		"intant_type.jdl" -> "Duplicate JdlRelationRole 'job'",
		"wrong_displayfield_in_target.jdl" -> "Duplicate JdlRelationRole 'department'",
		"wrong_displayfield_in_target.jdl" -> "Duplicate JdlRelationRole 'job'",
		"complex_jdl.jdl" -> "Duplicate JdlRelationRole 'job'",
		"duration_type.jdl" -> "Duplicate JdlRelationRole 'department'",
		"microservice-ecommerce-store.jdl" -> "Duplicate JdlRelationRole 'order'",
		"duplicate_enums.jdl" -> "Duplicate JdlFeature 'A'",
		"complex_jdl.jdl" -> "Duplicate JdlRelationRole 'department'",
		"duration_type.jdl" -> "Duplicate JdlRelationRole 'job'",
		"wrong_relationships_jdl.jdl" -> "mismatched input '}' expecting RULE_ID",
		"big_sample.jdl" -> "Duplicate JdlRelationRole 'employee'",
		"Oracle-Human-Resources-sample.jdl" -> "Duplicate JdlRelationRole 'job'",
		"online-shop.jh" -> "Duplicate JdlDisplayField 'title' in JdlRelationRole 'product'",
		"21-points.jh" -> "Duplicate JdlRelationRole 'user'",
		"online-shop.jh" -> "Duplicate JdlRelationRole 'customer'",
		"wrong_relationships_jdl.jdl" -> "mismatched input '<EOF>' expecting '}'",
		"big_sample.jdl" -> "Field [region] does not exist in entity [Region]",
		"microservice-ecommerce-store.jdl" -> "Duplicate JdlRelationRole 'product'",
		"ex10.jdl" -> "Duplicate JdlRelationRole 'd'",
		"online-shop.jh" -> "Duplicate JdlRelationRole 'wishList'",
		"realistic_sample.jdl" -> "Duplicate JdlRelationRole 'product'",
		"duplicate_fields.jdl" -> "Duplicate JdlEntityField 'aa' in JdlEntity 'B'",
		"invalid_field_type.jdl" -> "Couldn't resolve reference to JdlEnum 'NullPointerException'.",
		"bug-tracker.jh" -> "Duplicate JdlRelationRole 'ticket'",
		"wrong_required_relationships_jdl.jdl" -> "Duplicate JdlRelationRole 'd'",
		"intant_type.jdl" -> "Duplicate JdlRelationRole 'employee'",
		"wrong_enum_values.jdl" -> "Enum value name must be upper case",
		"wrong_displayfield_in_target.jdl" -> "Duplicate JdlRelationRole 'employee'",
		"duplicate_enums.jdl" -> 'Duplicate enum value "BA"',
		"duplicate_enums.jdl" -> "Duplicate JdlFeature 'A' in JdlDomainModel 'duplicate_enums'",
		"bug-tracker.jh" -> 'Useless commas can be removed',
		"blob_jdl.jdl" -> 'Useless commas can be removed',
		"wrong_displayfield_in_source.jdl" -> 'Useless commas can be removed',
		"wrong_enum_values.jdl" -> 'Useless commas can be removed',
		"unique.jdl" -> 'Useless commas can be removed',
		"useless_entity_curly_braces.jdl" -> 'Entity declaration can be shorten to "entity B"',
		"ex12.jdl" -> 'Useless commas can be removed',
		"duplicate_relationships.jdl" -> 'Relationship [A->B] already defined!',
		"unused_enums.jdl" -> 'Unused enum definition in "unused_enums.jdl"',
		"enum.jdl" -> 'Useless commas can be removed',
		"duplicate_enums.jdl" -> 'Unused enum definition in "duplicate_enums.jdl"',
		"two_microservices.jdl" -> 'Definition has no effect. Remove superfluous table name or define a different name.',
		"ex21.jdl" -> 'Entity declaration can be shorten to "entity MySecondEntity"',
		"valid_jdl.jdl" -> 'Entity declaration can be shorten to "entity B"',
		"invalid_field_type.jdl" -> 'Useless commas can be removed',
		"wrong_pattern_definition.jdl" -> 'Useless commas can be removed',
		"useless_commas_fields.jdl" -> 'Useless commas can be removed',
		"table.jdl" -> 'Useless commas can be removed',
		"Model.jdl" -> 'Entity declaration can be shorten to "entity Aasas0"',
		"21-points.jh" -> 'Useless commas can be removed',
		"mongo_jdl.jdl" -> 'Useless commas can be removed',
		"simple-online-shop.jh" -> 'Useless commas can be removed',
		"complex_jdl_2.jdl" -> 'Useless commas can be removed',
		"duplicate_entities.jdl" -> "Duplicate JdlFeature 'A' in JdlDomainModel 'duplicate_entities'",
		"cassandra_with_relationships.jdl" -> 'Useless commas can be removed',
		"ex24.jdl" -> 'Useless commas can be removed',
		"jdl2.jdl" -> 'Unused enum definition in "jdl2.jdl"',
		"microservices-blog-store.jh" -> 'Useless commas can be removed',
		"no_comma_support.jdl" -> 'Entity declaration can be shorten to "entity E"',
		"intant_type.jdl" -> 'Useless commas can be removed',
		"good_pattern_definition.jdl" -> 'Useless commas can be removed',
		"wrong_displayfield_in_target.jdl" -> 'Useless commas can be removed',
		"id_field.jdl" -> 'Useless commas can be removed',
		"big_sample.jdl" -> 'Useless commas can be removed',
		"couchbase_jdl.jdl" -> 'Useless commas can be removed',
		"complex_jdl_2.jdl" -> 'Entity declaration can be shorten to "entity B"',
		"duplicate_entities.jdl" -> "Duplicate JdlFeature 'B' in JdlDomainModel 'duplicate_entities'",
		"for_keyword_notallowed.jdl" -> 'Useless commas can be removed',
		"blog.jh" -> 'Useless commas can be removed',
		"pattern_validation_with_quote.jdl" -> 'Useless commas can be removed',
		"cassandra_jdl.jdl" -> 'Useless commas can be removed',
		"simple.jdl" -> 'Useless commas can be removed',
		"no_comma_support.jdl" -> 'Entity declaration can be shorten to "entity B"',
		"duplicate_application_params.jdl" -> 'Parameter [devDatabaseType] already defined!',
		"multiple_jdl_comments.jdl" -> 'Useless commas can be removed',
		"Oracle-Human-Resources-sample.jdl" -> 'Useless commas can be removed',
		"complex_jdl.jdl" -> 'Useless commas can be removed',
		"duration_type.jdl" -> 'Useless commas can be removed',
		"online-shop.jh" -> 'Useless commas can be removed',
		"useless_table_names.jdl" -> 'Definition has no effect. Remove superfluous table name or define a different name.',
		"complex_jdl_2.jdl" -> 'Entity declaration can be shorten to "entity E"',
		"for_keyword_notallowed.jdl" -> "Duplicate JdlFeature 'Region' in JdlDomainModel 'for_keyword_notallowed'",
		"duplicate_deployments.jdl" -> 'Parameter [deploymentType] already defined!',
		"following_comments.jdl" -> 'Useless commas can be removed',
		"" -> "" // empty
	]

	new(File jdlFile) {
		this.jdlFile = jdlFile
	}

	@BeforeClass
	def static void initTestCase() {
		unexpectedIssues = newHashSet
		// put here all JDL definitions which are referenced by other JDLs
		jdlReferencedFiles = #{
			new File('./resources/test_files/jdl2.jdl')
		}
	}

	@AfterClass
	def static void reportIssues() {
		unexpectedIssues.forEach [ issue |
			val msgtoken = if(issue.value.contains("'")) '"' else "'"
			System.err.println('''"«issue.key.name»" -> «msgtoken»«issue.value»«msgtoken»,''')
		]
		if(unexpectedIssues.isEmpty == false) fail('Unexpected issues found! Check output...')
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
		).filter [
			Files.isDirectory(it)
		].map [
			it.toFile.listFiles([ dir, name |
				name.endsWith('.jdl') || name.endsWith('.jh')
			])
		].forEach[result.addAll(it)]
		return result
	}

	@Test
	def void testJdlFile() {
		jdlReferencedFiles.forEach [
			resourceSet.getResource(URI.createURI(absoluteFile.toURI.toString), true)
		]
		println('''Load and validate «jdlFile»''')
		val resource = resourceSet.getResource(URI.createURI(jdlFile.toURI.toString), true)
		// validate the resource
		val issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl)
		issues?.forEach [ issue |
			val expected = expectedIssues.findFirst [
				jdlFile.name.equals(key) && value.startsWith(issue.message)
			]
			if (expected !== null)
				println('''Expected issue detected: [«issue»]''')
			else
				unexpectedIssues += jdlFile -> issue.message
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
