package io.github.jhipster.jdl.ui.wizard

import java.io.File
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.util.PluginProjectFactory
import org.eclipse.xtext.ui.wizard.template.IProjectGenerator
import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider
import org.eclipse.xtext.ui.wizard.template.ProjectTemplate
import org.eclipse.xtext.ui.wizard.template.StringTemplateVariable

/**
 * Create a list with all project templates to be shown in the template new project wizard.
 * 
 * Each template is able to generate one or more projects. Each project can be configured such that any number of files are included.
 */
class JDLProjectTemplateProvider implements IProjectTemplateProvider {
	override getProjectTemplates() {
		#[new JHipsterProject]
	}
}

final class ProjectUtil {
    def static validate(String path) {
        if (path.matches('[a-z][a-z0-9_]*(/[a-z][a-z0-9_]*)*'))
            null
        else
            new Status(IStatus.ERROR, "Wizard", "'" + path + "' is not a valid package name")
    }

    def static getPath(StringTemplateVariable pkg) {
        return pkg.value.split('\\.').join(File.separator)
    }
}

@ProjectTemplate(label="JHipster Monolith App", icon="JHipsterProject.gif", description="<p><b>Wizard for Monolith App</b></p>
<p>This is a JHipster project wizard to create a monolith application. You can set a parameter to modify the content in the generated file
and a parameter to set the package.</p>")
final class JHipsterProject {
    extension JDLNewProjectWizardExtension ext = new JDLNewProjectWizardExtension
    
	val group = group("Properties")
	val pkg = text("Package:", "com.mycompany.myapp", "The package path to place the files in", group)
    val baseName = text("Base name:", "myMonolithApp", "The base name", group)
    var jdl = '''
        /**
         * JHipster «baseName»
         */
        
        application {
          config {
            packageName «pkg»
            baseName «baseName»
            applicationType monolith
            databaseType sql
            // more configuration options here
          }
          // filter entities here
          // entities * except C, D
        }
        
        // entity definitions here
        // entity Address { ... }
    '''    

	override protected validate() {
	   return ProjectUtil.validate(path)
	}

    def getPath() {
       return ProjectUtil.getPath(pkg)
    }
    
	override generateProjects(IProjectGenerator generator) {
		generator.generate(new PluginProjectFactory => [
			projectName = projectInfo.projectName
			location = projectInfo.locationPath
			projectNatures += #[JavaCore.NATURE_ID, 'org.eclipse.pde.PluginNature', XtextProjectHelper.NATURE_ID]
			builderIds += #[JavaCore.BUILDER_ID, XtextProjectHelper.BUILDER_ID]
			folders += 'src'
			addFile('''src/«path»«File.separator»Model.jdl''', jdl)
		])
        openJDLPerspective
		projectInfo => [
            openTerminal(projectName, locationPath?.toString)		    
		]
	}
}
