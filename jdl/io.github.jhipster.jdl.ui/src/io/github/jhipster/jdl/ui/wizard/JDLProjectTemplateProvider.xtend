package io.github.jhipster.jdl.ui.wizard

import org.eclipse.xtext.ui.util.PluginProjectFactory
import org.eclipse.xtext.ui.wizard.template.IProjectGenerator
import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider
import org.eclipse.xtext.ui.wizard.template.ProjectTemplate

import static extension io.github.jhipster.jdl.ui.wizard.util.ProjectWizardUtil.*
import static extension io.github.jhipster.jdl.ui.wizard.util.ProjectWizardUtil.GenerateProjectsDelegator.*

/**
 * Create a list with all project templates to be shown in the template new project wizard.
 * 
 * Each template is able to generate one or more projects. Each project can be configured such that any number of files are included.
 */
class JDLProjectTemplateProvider implements IProjectTemplateProvider {
	override getProjectTemplates() {
		#[new JHipsterProjectFromCli, new JHipsterMonolithProject, new JHipsterMicroserviceProject, new JHipsterGatewayProject]
	}
}

@ProjectTemplate(label='JHipster Application from CLI', icon='JHipsterProject.gif', description='<p><b>Wizard for bootstrapping an Application from command line</b></p>
<p>This is a JHipster project wizard to create an application from command line interface. You can select parameters from CLI options.</p>')
final class JHipsterProjectFromCli {
    val group = group('Properties')
    val pkg = text('Package:', 'com.mycompany.myapp', 'The package path to place the files in', group)
    val baseName = text('Base name:', 'myApp', 'The base name', group)

    var template = '''
        /**
         * JHipster JDL model for myApp
         */
         
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
        
        // Set pagination options
        paginate JobHistory, Employee with infinite-scroll
        paginate Job with pagination
        
        dto * with mapstruct
        
        // Set service options to all 
        service all with serviceImpl 
        // Set an angular suffix
        angularSuffix * with mySuffix
    '''    

    override protected validate() {
       return validatePath(pkg.path)
    }

    override generateProjects(IProjectGenerator it) {
        generateProjects(
            new PluginProjectFactory, projectInfo, '''«baseName».jdl''', RESOURCE_MODEL_FOLDER, template
        )
    }
}

@ProjectTemplate(label='JHipster Monolith App', icon='JHipsterProject.gif', description='<p><b>Wizard for Monolith App</b></p>
<p>This is a JHipster project wizard to create a monolith application. You can set a parameter to modify the content in the generated file
and a parameter to set the package.</p>')
final class JHipsterMonolithProject {
	val group = group('Properties')
	val pkg = text('Package:', 'com.mycompany.app', 'The package path to place the files in', group)
    val baseName = text('Base name:', 'myMonolithApp', 'The base name', group)
    var template = '''
        /**
         * JHipster JDL model for «baseName»
         */
        
        application {
          config {
            packageName «pkg»
            baseName «baseName»
            applicationType monolith
            databaseType sql
            // more configuration options goes here
          }
          // filter entities here
          // entities * except EntityA
        }
        
        // entity definitions here
        entity EntityA { 
            myFieldA String 
        }
        
        /**
         * Entity B
         * @author Generated by JHipster
         */
        entity EntityB { 
            myFieldB String required
        }
    '''    

	override protected validate() {
	   return validatePath(pkg.path)
	}

	override generateProjects(IProjectGenerator it) {
        generateProjects(                                                 
            new PluginProjectFactory, projectInfo, '''«baseName».jdl''', RESOURCE_MODEL_FOLDER, template
        )
	}
}

@ProjectTemplate(label='JHipster Microservice', icon='JHipsterProject.gif', description='<p><b>Wizard for a Microservice</b></p>
<p>This is a JHipster project wizard to create a microservice. You can set a parameter to modify the content in the generated file
and a parameter to set the package.</p>')
final class JHipsterMicroserviceProject {
    val group = group('Properties')
    val pkg = text('Package:', 'com.mycompany.myservice', 'The package path to place the files in', group)
    val baseName = text('Base name:', 'myMicroservice', 'The base name', group)
    var template = '''
        /**
         * JHipster JDL model for «baseName»
         */
        
        application {
          config {
            packageName «pkg»
            baseName «baseName»
            applicationType microservice
            // more configuration options goes here
          }
          // filter entities here
          // entities * except EntityA
        }
        
        // entity definitions here
        entity EntityA { 
            myFieldA String 
        }
        
        /**
         * Entity B
         * @author Generated by JHipster
         */
        entity EntityB { 
            myFieldB String required
        }
    '''    

    override protected validate() {
       return validatePath(pkg.path)
    }

    override generateProjects(IProjectGenerator it) {
        generateProjects(                                                 
            new PluginProjectFactory, projectInfo, '''«baseName».jdl''', RESOURCE_MODEL_FOLDER, template
        )
    }
}

@ProjectTemplate(label='JHipster Gateway App', icon='JHipsterProject.gif', description='<p><b>Wizard for a Gateway App</b></p>
<p>This is a JHipster project wizard to create a gateway app. You can set a parameter to modify the content in the generated file
and a parameter to set the package.</p>')
final class JHipsterGatewayProject {
    val group = group('Properties')
    val pkg = text('Package:', 'com.mycompany.gateway', 'The package path to place the files in', group)
    val baseName = text('Base name:', 'myGateway', 'The base name', group)
    var template = '''
        /**
         * JHipster JDL model for «baseName»
         */
        
        application {
          config {
            packageName «pkg»
            baseName «baseName»
            applicationType gateway
            // more configuration options goes here
          }
          // filter entities here
          // entities * except EntityA
        }
        
        // entity definitions here
        entity EntityA { 
            myFieldA String 
        }
        
        /**
         * Entity B
         * @author Generated by JHipster
         */
        entity EntityB { 
            myFieldB String required
        }
    '''    

    override protected validate() {
       return validatePath(pkg.path)
    }

    override generateProjects(IProjectGenerator it) {
        generateProjects(
            new PluginProjectFactory, projectInfo, '''«baseName».jdl''', RESOURCE_MODEL_FOLDER, template
        )
    }
}
