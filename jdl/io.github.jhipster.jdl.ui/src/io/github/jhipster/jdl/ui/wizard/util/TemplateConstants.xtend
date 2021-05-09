/**
 * Copyright 2016-2021 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.ui.wizard.util

/**
 * @author Serano Colameo - Initial contribution and API
 */
class TemplateConstants {
	public static val DEFAULT = '''
		// ==============================
		// Entity definitions starts here
		// ==============================
		
		entity Region {
		    regionName String
		}
		
		entity Country {
		    countryName String
		}
		
		// an ignored comment
		/** not an ignored comment */
		entity Location {
		    streetAddress String
		    postalCode String
		    city String
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
		    title String
		    description String
		}
		
		/**
		 * The Employee entity.
		 */
		entity Employee {
		    /**
		    * The firstname attribute.
		    */
		    firstName String
		    lastName String
		    email String
		    phoneNumber String
		    hireDate ZonedDateTime
		    salary Long
		    commissionPct Long
		}
		
		entity Job {
		    jobTitle String
		    minSalary Long
		    maxSalary Long
		}
		
		entity JobHistory {
		    startDate ZonedDateTime
		    endDate ZonedDateTime
		    language Language
		}
		
		enum Language {
		    FRENCH, ENGLISH, SPANISH
		}
		
		relationship ManyToMany {
		    Job{task(title)} to Task{job}
		}
		
		// defining multiple OneToMany relationships with comments
		relationship OneToMany {
		    Country{region} to Region
		    Location{country} to Country
		    Department{location} to Location
		    Employee{job} to Job
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
		
		// =======
		// Options
		// =======

		// Set pagination options
		paginate JobHistory, Employee with infinite-scroll
		paginate Job with pagination
		
		dto * with mapstruct
		
		// Set service options to all 
		service all with serviceImpl 
		// Set an angular suffix
		angularSuffix * with mySuffix
	'''
}
