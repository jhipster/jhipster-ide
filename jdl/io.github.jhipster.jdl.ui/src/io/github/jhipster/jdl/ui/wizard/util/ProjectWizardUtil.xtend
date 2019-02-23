package io.github.jhipster.jdl.ui.wizard.util

import io.github.jhipster.jdl.ui.wizard.template.JDLTemplateProjectCreator
import java.io.File
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Status
import org.eclipse.jdt.core.JavaCore
import org.eclipse.m2e.core.internal.IMavenConstants
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.util.PluginProjectFactory
import org.eclipse.xtext.ui.wizard.IExtendedProjectInfo
import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate
import org.eclipse.xtext.ui.wizard.template.IProjectGenerator
import org.eclipse.xtext.ui.wizard.template.StringTemplateVariable

class ProjectWizardUtil {
    
//    public static String MAVEN_SOURCE_FOLDER = 'src/main/java'
    public static String MAVEN_SOURCE_FOLDER = 'src'
    public static String MAVEN_MODEL_FOLDER = MAVEN_SOURCE_FOLDER + '/model'
    
    static class GenerateProjectsDelegator extends AbstractProjectTemplate {
        def static void generateProjects(IProjectGenerator generator, PluginProjectFactory it, IExtendedProjectInfo projectInfo, String modeFilelName, String path, String content) {
            new GenerateProjectsDelegator => [
                create(generator, new PluginProjectFactory, projectInfo, modeFilelName, path, content)
            ]
        }
        
        def void create(IProjectGenerator generator, PluginProjectFactory it, IExtendedProjectInfo projectInfo, String modeFilelName, String path, String content) {
            generateProjects(generator, projectInfo, modeFilelName, path) => [
                addFile('''«path»«File.separator»«modeFilelName»''', content) 
            ]
            generator.createFoldersAndSetResult(projectInfo, modeFilelName, path)
        }
        
        override generateProjects(IProjectGenerator generator) {
            // do nothing here...
        }
    }
    
    def static void initialize(PluginProjectFactory it, IExtendedProjectInfo projectInfo, String modeFilelName, String path) {
        projectName = projectInfo.projectName
        location = projectInfo.locationPath
        projectNatures += #[JavaCore.NATURE_ID, 'org.eclipse.pde.PluginNature', XtextProjectHelper.NATURE_ID, IMavenConstants.NATURE_ID]
        builderIds += #[JavaCore.BUILDER_ID, XtextProjectHelper.BUILDER_ID, IMavenConstants.BUILDER_ID]
        folders += MAVEN_SOURCE_FOLDER
//        folders += MAVEN_MODEL_FOLDER
    }
    
    def static validatePath(String path) {
        if (path.matches('[a-z][a-z0-9_]*(/[a-z][a-z0-9_]*)*')) null
        else new Status(IStatus.ERROR, 'Wizard', "'" + path + "' is not a valid package name")
    }

    def static PluginProjectFactory generateProjects(IProjectGenerator generator, IExtendedProjectInfo projectInfo,  String modeFilelName, String path) {
        val factory = new PluginProjectFactory => [
            generator.generate(it => [
                initialize(projectInfo, modeFilelName, path)
            ])
        ]
        return factory
    }

    def static getPath(StringTemplateVariable pkg) {
        return pkg.value.split('\\.').join(File.separator)
    }

    def static IFolder getSourceFolder(IExtendedProjectInfo projectInfo, String path) {
        val root = ResourcesPlugin.workspace.root
        val project  = root.getProject(projectInfo.projectName)
        val folder = project.getFolder(path)
        return folder
    }

    def static IFolder createFolders(IExtendedProjectInfo projectInfo, String path) {
        val root = ResourcesPlugin.workspace.root
        val project  = root.getProject(projectInfo.projectName)
        if (!project.exists) project.create(new NullProgressMonitor)
        val folder = projectInfo.getSourceFolder(path)
        if (folder !== null && !folder.exists) folder.location.toFile.mkdirs
        return folder
    }

    def static void createFoldersAndSetResult(IProjectGenerator generator, IExtendedProjectInfo projectInfo, String modeFilelName, String path) {
        val folder = createFolders(projectInfo, path)
        val creator = generator as JDLTemplateProjectCreator
        creator.result = folder.getFile(modeFilelName) 
    }
}