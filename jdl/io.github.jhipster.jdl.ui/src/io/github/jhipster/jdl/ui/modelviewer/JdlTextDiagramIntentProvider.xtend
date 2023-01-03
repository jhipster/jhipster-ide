/**
 * Copyright 2016-2023 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.ui.modelviewer

import net.sourceforge.plantuml.text.AbstractTextDiagramIntentProvider
import net.sourceforge.plantuml.text.TextDiagramIntentHelper
import org.eclipse.jface.text.TextSelection
import org.eclipse.jface.viewers.ISelection
import org.eclipse.ui.IEditorPart
import org.eclipse.xtext.ui.editor.XtextEditor

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JdlTextDiagramIntentProvider extends AbstractTextDiagramIntentProvider {

	JdlTextDiagramIntentHelper textDiagramIntentHelper

	override supportsSelection(ISelection selection) {
		selection instanceof TextSelection
	}

	override supportsEditor(IEditorPart editorPart) {
		editorPart instanceof XtextEditor
	}

	override TextDiagramIntentHelper getTextDiagramIntentHelper() {
		if (textDiagramIntentHelper === null) {
			textDiagramIntentHelper = new JdlTextDiagramIntentHelper(startPlantUml, startPlantUmlRegex,
				endPlantUml, endPlantUmlRegex)
		}
		return textDiagramIntentHelper
	}
}
