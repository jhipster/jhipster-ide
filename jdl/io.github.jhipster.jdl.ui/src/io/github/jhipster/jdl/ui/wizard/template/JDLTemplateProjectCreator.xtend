/**
 * Copyright 2016-2022 the original author or authors from the JHipster project.
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
 package io.github.jhipster.jdl.ui.wizard.template

import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.CoreException
import org.eclipse.xtext.ui.wizard.template.DefaultTemplateProjectCreator

/**
 * @author Serano Colameo - Initial contribution and API
 */
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
