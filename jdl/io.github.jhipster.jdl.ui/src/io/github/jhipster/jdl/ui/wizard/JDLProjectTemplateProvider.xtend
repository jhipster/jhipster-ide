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
package io.github.jhipster.jdl.ui.wizard

import org.eclipse.xtext.ui.util.PluginProjectFactory
import org.eclipse.xtext.ui.wizard.template.IProjectGenerator
import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider
import org.eclipse.xtext.ui.wizard.template.ProjectTemplate

import static io.github.jhipster.jdl.ui.wizard.util.TemplateConstants.*

import static extension io.github.jhipster.jdl.ui.wizard.util.ProjectWizardUtil.*
import static extension io.github.jhipster.jdl.ui.wizard.util.ProjectWizardUtil.GenerateProjectsDelegator.*

/**
 * @author Serano Colameo - Initial contribution and API
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
	 * JHipster JDL model for «baseName»
	 */

	«DEFAULT»
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
	  }
	  entities *
	}

	«DEFAULT»
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
	  }
	  entities * 
	}

	«DEFAULT»
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
	  }
	  entities *
	}

	«DEFAULT»
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
