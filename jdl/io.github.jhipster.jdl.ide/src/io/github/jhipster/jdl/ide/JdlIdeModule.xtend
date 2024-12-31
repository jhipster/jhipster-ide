/**
 * Copyright 2016-2025 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.ide

import io.github.jhipster.jdl.ide.contentassist.JdlContentAssistService
import io.github.jhipster.jdl.ide.contentassist.JdlIdeContentProposalProvider
import io.github.jhipster.jdl.ide.editor.syntaxcoloring.KeywordsSemanticHighlightingCalculator
import io.github.jhipster.jdl.ide.service.CommandService
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.ide.server.commands.IExecutableCommandService
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService
import org.eclipse.xtext.ide.server.hover.HoverService
import io.github.jhipster.jdl.ide.hover.JDLHoverService
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities
import io.github.jhipster.jdl.ide.contentassist.JdlIdeContentProposalPriorities
import org.eclipse.xtext.ide.editor.contentassist.AbstractIdeTemplateProposalProvider
import io.github.jhipster.jdl.ide.contentassist.JdlIdeTemplateProposalProvider

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JdlIdeModule extends AbstractJDLIdeModule {

	def Class<? extends IdeContentProposalProvider> bindIdeContentProposalProvider() {
		return JdlIdeContentProposalProvider
	}

	def Class<? extends IExecutableCommandService> bindIExecutableCommandService() {
		return CommandService
	}
	
	def Class<? extends ContentAssistService> bindContentAssistService() {
		return JdlContentAssistService
	}
	
	def Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator () {
        return KeywordsSemanticHighlightingCalculator
    }
    
    def Class<? extends HoverService> bindHoverService() {
		return JDLHoverService
	}

    def Class<? extends IdeContentProposalPriorities> bindIdeContentProposalPriorities() {
		return JdlIdeContentProposalPriorities
	}

    def Class<? extends AbstractIdeTemplateProposalProvider> bindJdlIdeTemplateProposalProvider() {
		return JdlIdeTemplateProposalProvider
	}
}
