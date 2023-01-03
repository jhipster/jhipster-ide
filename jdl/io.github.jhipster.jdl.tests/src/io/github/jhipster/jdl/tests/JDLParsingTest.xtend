/**
 * Copyright 2016-2023 the original author or authors from the JHipster project.
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
import io.github.jhipster.jdl.jdl.JdlCardinality
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEnum
import io.github.jhipster.jdl.jdl.JdlOption
import io.github.jhipster.jdl.jdl.JdlRelationships
import io.github.jhipster.jdl.util.JdlModelUtil
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(JDLInjectorProvider)
class JDLParsingTest{

	@Inject extension ParseHelper<JdlDomainModel> parseHelper
	@Inject extension ValidationTestHelper
	@Inject extension JdlModelUtil

	@Test 
	def void loadModel() {
		val model = '''
			entity Region {
				regionName String
			}
			
			entity Country {
				countryName String
			}
			
			// an ignored comment
			/** not an ignored comment */
			entity Location {
				streetAddress String,
				postalCode String,
				city String,
				stateProvince String
			}
			
			entity Department {
				departmentName String required
			}
			
			/**
			 * Task entity.
			 * @author The JHipster team.
			 */
			entity Task {
				title String,
				description String
			}
			
			/**
			 * The Employee entity.
			 */
			entity Employee {
				/**
				* The firstname attribute.
				*/
				firstName String,
				lastName String,
				email String,
				phoneNumber String,
				hireDate ZonedDateTime,
				salary Long,
				commissionPct Long
			}
			
			entity Job {
				jobTitle String,
				minSalary Long,
				maxSalary Long
			}
			
			entity JobHistory {
				startDate ZonedDateTime,
				endDate ZonedDateTime,
				language Language
			}
			
			enum Language {
			    FRENCH, ENGLISH, SPANISH
			}
			
			relationship OneToOne {
				Country{region} to Region
			}
			
			relationship OneToOne {
				Location{country} to Country
			}
			
			relationship OneToOne {
				Department{location} to Location
			}
			
			relationship ManyToMany {
				Job{task(title)} to Task{job}
			}
			
			// defining multiple OneToMany relationships with comments
			relationship OneToMany {
				Employee{job} to Job,
				/**
				* A relationship
				*/
				Department{employee} to
				/**
				* Another side of the same relationship
				*/
				Employee
			}
			
			relationship ManyToOne {
				Employee{manager} to Employee
			}
			
			// defining multiple oneToOne relationships
			relationship OneToOne {
				JobHistory{job} to Job,
				JobHistory{department} to Department,
				JobHistory{employee} to Employee
			}
			
			// Set pagination options
			paginate JobHistory, Employee with infinite-scroll
			paginate Job with pagination
			
			dto * with mapstruct
			
			// Set service options to all except few
			service all with serviceImpl except Employee, Job
			// Set an angular suffix
			angularSuffix * with mySuffix
		'''.parse
		
		assertNotNull(model)
		
		model.features => [
			filter(JdlEntity) => [
				assertFalse(isNullOrEmpty)
				assertTrue(size == 10) // 8 + 1 User + 2 Authority (built-in entities)
				filter[name.equals('JobHistory')].last => [
					assertNotNull(it)
					assertNotNull(fieldDefinition)
					assertFalse(fieldDefinition.fields.isNullOrEmpty)
					assertTrue(fieldDefinition.fields.size == 3)
					assertTrue(fieldDefinition.fields.map[name].containsAll(#['startDate', 'endDate', 'language']))
				]
				filter[name.equals('Employee')].last => [
					assertNotNull(it)
					assertEquals('The Employee entity.'.toString, it.documentation)					
				]
			]
			filter(JdlEnum) => [
				assertFalse(isNullOrEmpty)
				assertTrue(size == 1)
				last => [
					assertEquals('Language', name)
					assertFalse(values.isNullOrEmpty)
					assertTrue(values.size == 3)
				]
			]
			filter(JdlRelationships) => [
				assertFalse(isNullOrEmpty)
				assertTrue(size == 7)
				assertTrue(filter[cardinality == JdlCardinality.ONE_TO_ONE].size == 4)
				assertTrue(filter[cardinality == JdlCardinality.MANY_TO_MANY].size == 1)
				assertTrue(filter[cardinality == JdlCardinality.ONE_TO_MANY].size == 1)
				assertTrue(filter[cardinality == JdlCardinality.MANY_TO_ONE].size == 1)
			]
			filter(JdlOption) => [
				assertFalse(isNullOrEmpty)
				assertTrue(size == 5)
				assertFalse(findFirst[setting.isDtoOption] === null)
				assertFalse(findFirst[setting.isServiceOption] === null)
				assertFalse(findFirst[setting.isAngularSuffixOption] === null)
				assertTrue(filter[setting.isPaginateOption].size == 2)
			]
			filter(JdlEntity).filter[it.name == 'Authority'] => [
				assertFalse(isNullOrEmpty)
				assertTrue(size == 1)
			]
		]
	}
	
	@Test
	def void testParsingAndLinking() {
		'''
			entity A
			entity B {}
			entity C {
			  name String required
			}
			entity D {
			  myValue Integer min(42)
			}
			
			relationship OneToOne {
			  A{a} to B{b},
			  C{c} to D{d}
			}
			
			dto * with mapstruct except A
		'''.parse.assertNoErrors
	}
	
	@Test
	def void testBuiltInEntities() {
		val model = '''
			entity A
		'''.parse
		assertNotNull(model)
		
		val expected = #['Authority', 'User']
		model.features => [
			val actual = filter(JdlEntity).filter[
				expected.contains(it.name)
			].map[name].toList
			println(actual)
			assertEquals(expected, actual)
		]
	}
}
