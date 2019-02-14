package io.github.jhipster.jdl.ui.wizard.template

import org.eclipse.jface.wizard.IWizardPage
import org.eclipse.xtext.ui.wizard.template.TemplateNewProjectWizard
import org.eclipse.xtext.ui.wizard.IExtendedProjectInfo
import java.io.File

class JDLTemplateNewProjectWizard extends TemplateNewProjectWizard {

    static val TITLE = 'JHipster Project'
    static val DESCR = 'Create a new JHipster project.'
    
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
                            append(File.separator).append(mainPage.projectName)
        ]
    }
}
