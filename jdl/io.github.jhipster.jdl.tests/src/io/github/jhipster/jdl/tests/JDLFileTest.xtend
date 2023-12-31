/**
 * Copyright 2016-2024 the original author or authors from the JHipster project.
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
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.validation.Issue
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

import static org.eclipse.xtext.diagnostics.Severity.*
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
	static Set<Pair<File, Issue>> unexpectedIssues
	
	@Data
	private static class JdlIssue {
		String message
		Severity sevirity
	}
	
	val expectedIssues = #[
		"21-points.jh" -> new JdlIssue('Useless commas can be removed', WARNING),
		"Model.jdl" -> new JdlIssue("Duplicate JdlEntityField 'a'", ERROR),
		"Model.jdl" -> new JdlIssue('Entity declaration can be shorten to "entity Aasas0"', INFO),
		"Oracle-Human-Resources-sample.jdl" -> new JdlIssue('Found groupable relationship "OneToOne"', WARNING),
		"Oracle-Human-Resources-sample.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"application_with_duplicate_params.jdl" -> new JdlIssue('Parameter [enableTranslation] already defined!', ERROR),
		"applications2.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"applications3.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"big_sample.jdl" -> new JdlIssue('Field [JobTitle] does not exist in entity [Job]', WARNING),
		"big_sample.jdl" -> new JdlIssue('Field [employee] does not exist in entity [Employee]', WARNING),
		"big_sample.jdl" -> new JdlIssue('Field [region] does not exist in entity [Region]', WARNING),
		"big_sample.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"blob_jdl.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"blog.jh" -> new JdlIssue('Useless commas can be removed', WARNING),
		"bug-tracker.jh" -> new JdlIssue('Useless commas can be removed', WARNING),
		"cassandra_jdl.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"cassandra_with_relationships.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"complex_jdl.jdl" -> new JdlIssue('Found groupable relationship "ManyToOne"', WARNING),
		"complex_jdl.jdl" -> new JdlIssue('Found groupable relationship "OneToMany"', WARNING),
		"complex_jdl.jdl" -> new JdlIssue('Found groupable relationship "OneToOne"', WARNING),
		"complex_jdl.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"complex_jdl_2.jdl" -> new JdlIssue('Entity declaration can be shorten to "entity B"', INFO),
		"complex_jdl_2.jdl" -> new JdlIssue('Entity declaration can be shorten to "entity E"', INFO),
		"complex_jdl_2.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"couchbase_jdl.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"deployments.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"duplicate_application_params.jdl" -> new JdlIssue('Parameter [devDatabaseType] already defined!', ERROR),
		"duplicate_deployments.jdl" -> new JdlIssue('Parameter [deploymentType] already defined!', ERROR),
		"duplicate_deployments.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"duplicate_entities.jdl" -> new JdlIssue("Duplicate JdlFeature 'A' in JdlDomainModel 'duplicate_entities'", ERROR),
		"duplicate_entities.jdl" -> new JdlIssue("Duplicate JdlFeature 'B' in JdlDomainModel 'duplicate_entities'", ERROR),
		"duplicate_enums.jdl" -> new JdlIssue("Duplicate JdlFeature 'A' in JdlDomainModel 'duplicate_enums'", ERROR),
		"duplicate_enums.jdl" -> new JdlIssue('Unused enum definition in "duplicate_enums.jdl"', INFO),
		"duplicate_fields.jdl" -> new JdlIssue("Duplicate JdlEntityField 'aa'", ERROR),
		"duplicate_fields.jdl" -> new JdlIssue("Duplicate JdlEntityField 'cc'", ERROR),
		"duration_type.jdl" -> new JdlIssue('Found groupable relationship "ManyToOne"', WARNING),
		"duration_type.jdl" -> new JdlIssue('Found groupable relationship "OneToMany"', WARNING),
		"duration_type.jdl" -> new JdlIssue('Found groupable relationship "OneToOne"', WARNING),
		"duration_type.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"enum.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"enumWithStringLiterals.jdl" -> new JdlIssue("no viable alternative at input '-1'", ERROR),
		"enumWithStringLiterals.jdl" -> new JdlIssue('Unused enum definition in "enumWithStringLiterals.jdl"', INFO),
		"ex12.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"ex21.jdl" -> new JdlIssue('Entity declaration can be shorten to "entity MySecondEntity"', INFO),
		"ex24.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"ex26.jdl" -> new JdlIssue('Found groupable relationship "OneToOne"', WARNING),
		"file1.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"file2.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"filtering_validation_check.jdl" -> new JdlIssue('Selection does not contain excluded elements: [C, D]', ERROR),
		"following_comments.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"for_keyword_notallowed.jdl" -> new JdlIssue("Couldn't resolve reference to JdlEntity 'for'.", ERROR),
		"for_keyword_notallowed.jdl" -> new JdlIssue("Duplicate JdlFeature 'Region' in JdlDomainModel 'for_keyword_notallowed'", ERROR),
		"for_keyword_notallowed.jdl" -> new JdlIssue("mismatched input '<EOF>' expecting '='", ERROR),
		"for_keyword_notallowed.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"good_pattern_definition.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"id_field.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"intant_type.jdl" -> new JdlIssue('Found groupable relationship "ManyToOne"', WARNING),
		"intant_type.jdl" -> new JdlIssue('Found groupable relationship "OneToMany"', WARNING),
		"intant_type.jdl" -> new JdlIssue('Found groupable relationship "OneToOne"', WARNING),
		"intant_type.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"invalid_field_type.jdl" -> new JdlIssue("Couldn't resolve reference to JdlEnum 'NullPointerException'.", ERROR),
		"invalid_field_type.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"invalid_option.jdl" -> new JdlIssue("missing 'mapstruct' at 'wrong'", ERROR),
		"issue_347_warn.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"jdl2.jdl" -> new JdlIssue('Unused enum definition in "jdl2.jdl"', INFO),
		"microservice-ecommerce-store-4-apps.jdl" -> new JdlIssue('Found groupable relationship "OneToMany"', WARNING),
		"microservice-ecommerce-store-4-apps.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"microservice-ecommerce-store-k8s.jdl" -> new JdlIssue('Found groupable relationship "OneToMany"', WARNING),
		"microservice-ecommerce-store-k8s.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"microservice-ecommerce-store.jdl" -> new JdlIssue('Found groupable relationship "OneToMany"', WARNING),
		"microservice-ecommerce-store.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"microservices-blog-store.jh" -> new JdlIssue('Useless commas can be removed', WARNING),
		"mongo_jdl.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"multiple_jdl_comments.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"no_comma_support.jdl" -> new JdlIssue('Entity declaration can be shorten to "entity B"', INFO),
		"no_comma_support.jdl" -> new JdlIssue('Entity declaration can be shorten to "entity E"', INFO),
		"non_existent_validation.jdl" -> new JdlIssue("no viable alternative at input '('", ERROR),
		"online-shop.jh" -> new JdlIssue('Useless commas can be removed', WARNING),
		"pattern_validation_with_quote.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"realistic_sample.jdl" -> new JdlIssue('Found groupable relationship "OneToMany"', WARNING),
		"realistic_sample.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"simple-online-shop.jh" -> new JdlIssue('Useless commas can be removed', WARNING),
		"simple.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"skip-user-management-option.jdl" -> new JdlIssue("Couldn't resolve reference to JdlEntity 'Authority'.", ERROR),
		"skip-user-management-option.jdl" -> new JdlIssue("Couldn't resolve reference to JdlEntity 'User'.", ERROR),
		"skip-user-management.jdl" -> new JdlIssue("Couldn't resolve reference to JdlEntity 'Authority'.", ERROR),
		"skip-user-management.jdl" -> new JdlIssue("Couldn't resolve reference to JdlEntity 'User'.", ERROR),
		"table.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"two_microservices.jdl" -> new JdlIssue('Definition has no effect. Remove superfluous table name or define a different name.', WARNING),
		"uaa_with_user_management_skipped.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"uaa_with_user_management_skipped.jdl" -> new JdlIssue('Unknown literal [uaa]!', ERROR),
		"underscore_application_name.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"unexistent_entities_for_relationship.jdl" -> new JdlIssue("Couldn't resolve reference to JdlEntity 'B'.", ERROR),
		"ungrouped_relationships.jdl" -> new JdlIssue('Found groupable relationship "OneToMany"', WARNING),
		"unique.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"unused_enums.jdl" -> new JdlIssue('Unused enum definition in "unused_enums.jdl"', INFO),
		"useless_commas_fields.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"useless_entity_curly_braces.jdl" -> new JdlIssue('Entity declaration can be shorten to "entity B"', INFO),
		"useless_table_names.jdl" -> new JdlIssue('Definition has no effect. Remove superfluous table name or define a different name.', WARNING),
		"valid_jdl.jdl" -> new JdlIssue('Entity declaration can be shorten to "entity B"', INFO),
		"wrong_displayfield_in_source.jdl" -> new JdlIssue('Field [title1] does not exist in entity [Task]', WARNING),
		"wrong_displayfield_in_source.jdl" -> new JdlIssue('Found groupable relationship "ManyToOne"', WARNING),
		"wrong_displayfield_in_source.jdl" -> new JdlIssue('Found groupable relationship "OneToMany"', WARNING),
		"wrong_displayfield_in_source.jdl" -> new JdlIssue('Found groupable relationship "OneToOne"', WARNING),
		"wrong_displayfield_in_source.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"wrong_displayfield_in_target.jdl" -> new JdlIssue('Field [jobTitle1] does not exist in entity [Job]', WARNING),
		"wrong_displayfield_in_target.jdl" -> new JdlIssue('Found groupable relationship "ManyToOne"', WARNING),
		"wrong_displayfield_in_target.jdl" -> new JdlIssue('Found groupable relationship "OneToMany"', WARNING),
		"wrong_displayfield_in_target.jdl" -> new JdlIssue('Found groupable relationship "OneToOne"', WARNING),
		"wrong_displayfield_in_target.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"wrong_enum_values.jdl" -> new JdlIssue('Enum value name must be upper case', ERROR),
		"wrong_enum_values.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"wrong_pattern_definition.jdl" -> new JdlIssue('Useless commas can be removed', WARNING),
		"wrong_pattern_definition.jdl" -> new JdlIssue('Wrong regexp pattern!', ERROR),
		"wrong_relationships_jdl.jdl" -> new JdlIssue("mismatched input '<EOF>' expecting '}'", ERROR),
		"wrong_relationships_jdl.jdl" -> new JdlIssue("mismatched input '}' expecting RULE_ID", ERROR),
		"complex_jdl_2.jdl" -> new JdlIssue('Excluded element D is in selection - useless definition!', WARNING),
		"complex_jdl_2.jdl" -> new JdlIssue('Selected element D gets excluded - useless definition!', WARNING),
		"no_comma_support.jdl" -> new JdlIssue('Excluded element D is in selection - useless definition!', WARNING),
		"no_comma_support.jdl" -> new JdlIssue('Selected element D gets excluded - useless definition!', WARNING),
		"filtering_validation_check.jdl" -> new JdlIssue('Excluded element B is in selection - useless definition!', WARNING),
		"filtering_validation_check.jdl" -> new JdlIssue('Excluded element C is not in selection!', WARNING),
		"filtering_validation_check.jdl" -> new JdlIssue('Excluded element D is not in selection!', WARNING),
		"filtering_validation_check.jdl" -> new JdlIssue('Selected element B gets excluded - useless definition!', WARNING)	
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
		val Set<String> reportedIssues = newHashSet
		unexpectedIssues.forEach [ issue |
			val msgtoken = if (issue.value.message.contains("'")) '"' else "'"
			val unexpectedIssue = '''@line[«issue.value.lineNumber»]: "«issue.key.name»" -> new JdlIssue(«msgtoken»«issue.value.message»«msgtoken», «issue.value.severity»),'''
			reportedIssues += unexpectedIssue
		]
		reportedIssues.sort.forEach[
			System.err.println(it)
		]
		if (unexpectedIssues.isEmpty == false) fail('Unexpected issues found! Check output...')
	}

	@Before
	def void setUp() {
		injector = new JDLStandaloneSetup().createInjectorAndDoEMFRegistration
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
				(name.endsWith('.jdl') || name.endsWith('.jh'))
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
				jdlFile.name.equals(key) && value.message.startsWith(issue.message) && value.sevirity == issue.severity
			]
			if (expected !== null)
				println('''Expected issue detected: [«issue»]''')
			else
				unexpectedIssues += jdlFile -> issue
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
