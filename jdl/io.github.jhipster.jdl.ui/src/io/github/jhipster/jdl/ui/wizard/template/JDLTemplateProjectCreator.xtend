package io.github.jhipster.jdl.ui.wizard.template

import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.CoreException
import org.eclipse.xtext.ui.wizard.template.DefaultTemplateProjectCreator

class JDLTemplateProjectCreator extends DefaultTemplateProjectCreator {

    var IFile result

    override getResult() {
        return result
    }

    def void setResult(IFile result) {
        this.result = result
    }

    def protected String getModelFolderName() {
        return 'src'
    }

    def protected String getPrimaryModelFileExtension() {
        return 'jdl'
    }

    def IFile getModelFile(IProject project) throws CoreException {
        var IFolder srcFolder = project.getFolder(getModelFolderName())
        val String expectedExtension = getPrimaryModelFileExtension()
        val IFile[] result = newArrayOfSize(1)
        srcFolder.accept([ IResource resource |
            if (IResource.FILE === resource.type && expectedExtension.equals(resource.fileExtension)) {
                result.set(0, resource as IFile)
                return false
            }
            return IResource.FOLDER === resource.type
        ])
        return result.get(0)
    }
}
