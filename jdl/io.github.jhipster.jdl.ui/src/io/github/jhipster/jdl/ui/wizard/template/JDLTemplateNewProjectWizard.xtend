package io.github.jhipster.jdl.ui.wizard.template

import io.github.jhipster.jdl.ui.wizard.JDLNewProjectWizardExtension
import java.io.File
import org.eclipse.core.resources.FileInfoMatcherDescription
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jface.wizard.IWizardPage
import org.eclipse.xtext.ui.wizard.IExtendedProjectInfo
import org.eclipse.xtext.ui.wizard.IProjectInfo
import org.eclipse.xtext.ui.wizard.template.TemplateNewProjectWizard
import org.eclipse.xtext.ui.wizard.template.TemplateProjectInfo

import static io.github.jhipster.jdl.ui.wizard.util.ProjectWizardUtil.*
import static org.eclipse.core.resources.IResourceFilterDescription.*
import org.eclipse.swt.widgets.Display

class JDLTemplateNewProjectWizard extends TemplateNewProjectWizard {

    static val TITLE = 'JHipster Project'
    static val DESCR = 'Create a new JHipster project.'
    static val FILTER_NAME = 'org.eclipse.ui.ide.multiFilter'
    static val FILTER_ARG = '1.0-name-matches-true-false-node_modules'
    
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
    
    def private void createAndSetupProject() {
        val root = ResourcesPlugin.workspace.root
        val project  = root.getProject(projectInfo.projectName)
        project.getFolder(new Path('bin')) => [
            if (it.exists) it.location.toFile.delete
        ]
        project.createFilter(
            FOLDERS.bitwiseOr(EXCLUDE_ALL), new FileInfoMatcherDescription(
                FILTER_NAME, FILTER_ARG
            ), 0, new NullProgressMonitor
        )
        val javaProject = JavaCore.create(project)
        javaProject.save(new NullProgressMonitor, true)
        val modelFolder = project.getFolder(new Path(MAVEN_MODEL_FOLDER))
        val modelClasspath = JavaCore.newSourceEntry(modelFolder.fullPath)
        val testFolder = project.getFolder(new Path(TEST_SOURCE_FOLDER))
        testFolder.location.toFile.mkdirs
        val testClasspath = JavaCore.newSourceEntry(testFolder.fullPath)
        val buildPath = newArrayList(javaProject.rawClasspath)
        buildPath.add(modelClasspath)
        buildPath.add(testClasspath)
        javaProject.setRawClasspath(buildPath, new NullProgressMonitor)                
    }
    
    override protected doFinish(IProjectInfo projectInfo, IProgressMonitor monitor) {
        super.doFinish(projectInfo, monitor)
        Display.^default.asyncExec([
            createAndSetupProject
            openJDLPerspective
            projectInfo as TemplateProjectInfo => [
                openTerminal(projectName, locationPath?.toString)
            ]
        ])
    }  
}
