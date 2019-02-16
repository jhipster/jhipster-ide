package io.github.jhipster.jdl.ui.wizard.template

import org.eclipse.xtext.ui.wizard.template.DefaultTemplateProjectCreator
import org.eclipse.core.resources.IFile

class JDLTemplateProjectCreator extends DefaultTemplateProjectCreator {
    
    var  IFile result

    override getResult() {
        return result
    }

    def void setResult(IFile result) {
        this.result = result
    }
}