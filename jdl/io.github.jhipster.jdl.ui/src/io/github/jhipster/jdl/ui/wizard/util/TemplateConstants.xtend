 /*************************************************************************
 * 
 * ATcode.io CONFIDENTIAL
 * __________________
 * 
 *  [2020] ATcode.io
 *  All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of ATcode.io and its suppliers, if any.  
 * The intellectual and technical concepts contained
 * herein are proprietary to ATcode.io and its suppliers and may be 
 * covered by US, EU and Foreign Patents, patents in process, and are 
 * protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from ATcode.io.
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
