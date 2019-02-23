package io.github.jhipster.jdl.ui.wizard.template

import io.github.jhipster.jdl.ui.wizard.JDLNewProjectWizardExtension
import java.io.File
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.jface.wizard.IWizardPage
import org.eclipse.xtext.ui.wizard.IExtendedProjectInfo
import org.eclipse.xtext.ui.wizard.IProjectInfo
import org.eclipse.xtext.ui.wizard.template.TemplateNewProjectWizard
import org.eclipse.xtext.ui.wizard.template.TemplateProjectInfo

class JDLTemplateNewProjectWizard extends TemplateNewProjectWizard {

    static val TITLE = 'JHipster Project'
    static val DESCR = 'Create a new JHipster project.'
    
    extension JDLNewProjectWizardExtension ext = new JDLNewProjectWizardExtension
    
    override addPages() {
        super.addPages 
        #[
            mainPage, templatePage, templateParameterPage
        ].filter[it !== null].forEach[
            it.title = TITLE
            it.description = DESCR
        ]
    }
    
    override getNextPage(IWizardPage page) {
        return super.getNextPage(page) => [
            if (it !== null) {
                title = TITLE
                description = DESCR
            }
        ]
    }
    
    override IExtendedProjectInfo getProjectInfo() {
        return super.projectInfo => [
            locationPath = mainPage.locationPath.
                           append(File.separator).
                           append(mainPage.projectName)
        ]
    }
    
    override protected doFinish(IProjectInfo projectInfo, IProgressMonitor monitor) {
        super.doFinish(projectInfo, monitor)
        openJDLPerspective
        projectInfo as TemplateProjectInfo => [
            openTerminal(projectName, locationPath?.toString)
        ]
    }  
}
