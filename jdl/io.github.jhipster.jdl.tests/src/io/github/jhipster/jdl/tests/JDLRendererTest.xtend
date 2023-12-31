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
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.renderer.JdlToAsciiDocRenderer
import io.github.jhipster.jdl.renderer.JdlToPlantUmlRenderer
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static io.github.jhipster.jdl.util.PlantUmlUtil.*
import static org.apache.commons.lang3.StringUtils.*
import static org.junit.Assert.assertTrue

/**
 * @author Serano Colameo - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(JDLInjectorProvider)
class JDLRendererTest {

	@Inject extension JdlToAsciiDocRenderer adocRenderer
	@Inject extension JdlToPlantUmlRenderer pumlRenderer
	@Inject extension ParseHelper<JdlDomainModel> parseHelper

	val linebreak = "'''"
	val open = '«'
	val close = '»'

	@Test
	def void testPlantUmlRenderer() {
		val actual = pumlRenderer.render('''
			/*
			 * This is the application and entity model for the 21-Points (https://github.com/mraible/21-points) application from Matt Raible 
			 */
			
			application {
				/*
				 * 21-Points Application Configuration
				 */
			  config {
			    /* This applicatrion is a monolith */
			    applicationType monolith
			    /* This is the base name */
			    baseName HealthPoints 
			    /* This is the package name */
			    packageName com.okta.developer
			    /* We use Oauth2 Authentication here */
			    authenticationType oauth2
			    /* PostgreSQL is our DB */
			    prodDatabaseType postgresql
			    buildTool gradle
			    searchEngine elasticsearch
			    testFrameworks [protractor]
			    clientFramework react
			    useSass true
			    enableTranslation true
			    nativeLanguage en
			    languages [en, es]
			  }
			  /*
			  **
			  */
			  entities Points, BloodPressure, Weight, Preferences 
			}
			
			/*
			 * JDL definition for application 'TwentyOnePoints' generated with command 'jhipster export-jdl'
			 */
			entity BloodPressure {
			  timestamp ZonedDateTime required /* test */
			  systolic Integer required
			  diastolic Integer required
			}
			entity Weight {
			  timestamp ZonedDateTime required
			  weight Double required
			}
			entity Points {
			  date LocalDate required
			  exercise Integer
			  meals Integer
			  alcohol Integer
			  notes String maxlength(140)
			}
			entity Preferences {
			  /* Weekly goal */
			  weeklyGoal Integer required min(10) max(21) 
			  /* Weight units */
			  weightUnits Units required 
			}
			
			/**
			 * This Enum is for Units
			 */
			enum Units {
			  /* KG Enum */
			  KG 
			  /* LB Enum */
			  LB 
			}
			
			relationship OneToOne {
			  /* Link to Preference */
			  Preferences{user(login)} to User
			}
			
			relationship ManyToOne {
			  BloodPressure{user(login)} to User
			  Weight{user(login)} to User
			  Points{user(login)} to User
			}
			
			/*
			** Paginate BloodPressure
			*/
			paginate BloodPressure, Weight with infinite-scroll
			
			/*
			** Paginate Points
			*/
			paginate Points with pagination
		'''.parse)
		
		val pragmas = '''
			«IF useJDot»!pragma layout smetana«ENDIF»
			!pragma syntax class
		'''.toString

		val expected = '''
			@startuml
				«pragmas»
				class BloodPressure <<Option {Paginate}>> {
					ZonedDateTime timestamp
					Integer systolic
					Integer diastolic
				}
				class Weight <<Option {Paginate}>> {
					ZonedDateTime timestamp
					Double weight
				}
				class Points <<Option {Paginate}>> {
					LocalDate date
					Integer exercise
					Integer meals
					Integer alcohol
					String notes
				}
				class Preferences  {
					Integer weeklyGoal
					Units weightUnits
				}
				Preferences ..> Units
				enum Units {
					KG, 
					LB 
				}
				Preferences  "user(login) 0..1 " -- "0..1 "  User
				BloodPressure  "user(login) 0..* " o-- "0..1 "  User
				Weight  "user(login) 0..* " o-- "0..1 "  User
				Points  "user(login) 0..* " o-- "0..1 "  User
				class User  {
					String firstName
					String lastName
					String login
					String email
					String imageUrl
					String authorities
				}
			@enduml
		'''
	
		val diffs = difference(actual, expected)
		println(diffs)
		assertTrue(diffs.isEmpty)
	}	

	@Test
	def void testAsciidocRenderer() {
		val actual = adocRenderer.render('''
			/*
			 * This is the application and entity model for the 21-Points (https://github.com/mraible/21-points) application from Matt Raible 
			 */
			
			application {
				/*
				 * 21-Points Application Configuration
				 */
			  config {
			    /* This applicatrion is a monolith */
			    applicationType monolith
			    /* This is the base name */
			    baseName HealthPoints 
			    /* This is the package name */
			    packageName com.okta.developer
			    /* We use Oauth2 Authentication here */
			    authenticationType oauth2
			    /* PostgreSQL is our DB */
			    prodDatabaseType postgresql
			    buildTool gradle
			    searchEngine elasticsearch
			    testFrameworks [protractor]
			    clientFramework react
			    useSass true
			    enableTranslation true
			    nativeLanguage en
			    languages [en, es]
			  }
			  /*
			  **
			  */
			  entities Points, BloodPressure, Weight, Preferences 
			}
			
			/*
			 * JDL definition for application 'TwentyOnePoints' generated with command 'jhipster export-jdl'
			 */
			entity BloodPressure {
			  timestamp ZonedDateTime required /* test */
			  systolic Integer required
			  diastolic Integer required
			}
			entity Weight {
			  timestamp ZonedDateTime required
			  weight Double required
			}
			entity Points {
			  date LocalDate required
			  exercise Integer
			  meals Integer
			  alcohol Integer
			  notes String maxlength(140)
			}
			entity Preferences {
			  /* Weekly goal */
			  weeklyGoal Integer required min(10) max(21) 
			  /* Weight units */
			  weightUnits Units required 
			}
			
			/**
			 * This Enum is for Units
			 */
			enum Units {
			  /* KG Enum */
			  KG 
			  /* LB Enum */
			  LB 
			}
			
			relationship OneToOne {
			  /* Link to Preference */
			  Preferences{user(login)} to User
			}
			
			relationship ManyToOne {
			  BloodPressure{user(login)} to User
			  Weight{user(login)} to User
			  Points{user(login)} to User
			}
			
			/*
			** Paginate BloodPressure
			*/
			paginate BloodPressure, Weight with infinite-scroll
			
			/*
			** Paginate Points
			*/
			paginate Points with pagination
		'''.parse).toString

		println(actual)
		
		val expected = '''
			= __synthetic0
			:toc: left
			
			.Please note
			[NOTE]
			====
			This spec was generated out of ___synthetic0.jdl_.
			====
			<<<
			
			== Specification of __synthetic0
			This is the application and entity model for the 21-Points (https://github.com/mraible/21-points) application from Matt Raible
			
			=== UML Domain Model
			--
			«linebreak»
			[plantuml,align="center",alt="__synthetic0.plantuml"]
			----
			include::__synthetic0.plantuml[]
			----
			---
			--
			
			=== Application Configuration
			21-Points Application Configuration
			
			[options="header, autowidth"]
			|===
			|Option | Value | Comment
			|Application Type |  monolith | This applicatrion is a monolith
			|Base Name |  HealthPoints | This is the base name
			|Package Name |  com.okta.developer | This is the package name
			|Authentication Type |  oauth2 | We use Oauth2 Authentication here
			|Prod Database Type |  postgresql | PostgreSQL is our DB
			|Build Tool |  gradle | 
			|Search Engine |  elasticsearch | 
			|Test Frameworks |  [protractor] | 
			|Client Framework |  react | 
			|Use Sass |  true | 
			|Enable Translation |  true | 
			|Native Language |  en | 
			|Languages |  [en, es] | 
			|===
			=== Entity «open»BloodPressure«close»
			JDL definition for application 'TwentyOnePoints' generated with command 'jhipster export-jdl'
			
			.Fields
			[options="header, autowidth"]
			|===
			|Field Name|Type | Constraint | Comment
			|Timestamp|ZonedDateTime|required | 
			|Systolic|Integer|required | test
			|Diastolic|Integer|required | 
			|===
			
			==== Options
			* [x] Paginate
			 
			=== Entity «open»Weight«close»
			
			.Fields
			[options="header, autowidth"]
			|===
			|Field Name|Type | Constraint | Comment
			|Timestamp|ZonedDateTime|required | 
			|Weight|Double|required | 
			|===
			
			==== Options
			* [x] Paginate
			 
			=== Entity «open»Points«close»
			
			.Fields
			[options="header, autowidth"]
			|===
			|Field Name|Type | Constraint | Comment
			|Date|LocalDate|required | 
			|Exercise|Integer| | 
			|Meals|Integer| | 
			|Alcohol|Integer| | 
			|Notes|String|maxlength(140) | 
			|===
			
			==== Options
			* [x] Paginate
			 
			=== Entity «open»Preferences«close»
			
			.Fields
			[options="header, autowidth"]
			|===
			|Field Name|Type | Constraint | Comment
			|WeeklyGoal|Integer|required min(10) max(21) | Weekly goal
			|WeightUnits|Units|required | Weight units
			|===
			
			=== Entity «open»Authority«close»
			
			.Fields
			[options="header, autowidth"]
			|===
			|Field Name|Type | Constraint | Comment
			|Name|| | 
			|===
			
			=== Relationships
			[options="header, autowidth"]
			|===
			| Source Entity | Cardinality | Target Entity | Comment
			| Preferences | One to One | User | Link to Preference
			| BloodPressure | Many to One | User | 
			| Weight | Many to One | User | 
			| Points | Many to One | User | 
			|===
			=== Enum «open»Units«close»
			This Enum is for Units
			
			.Units
			[options="header, autowidth"]
			|===
			| Name | Comment
			| KG | KG Enum
			| LB | LB Enum
			|===
		'''
		
		val diffs = difference(actual, expected)
		println(diffs)
		assertTrue(diffs.isEmpty)
	}	
}