/**
 * Copyright 2016-2024 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.ui.editor.syntaxcoloring

import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.RGB
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor
import org.eclipse.xtext.ui.editor.utils.TextStyle

import static io.github.jhipster.jdl.ide.editor.syntaxcoloring.JDLHighlightingStyles.*
import org.apache.commons.lang3.tuple.Triple

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JDLHighlightingConfiguration extends DefaultHighlightingConfiguration {
	
	val highlightConfs = #[
		Triple.of(NAME_ID, NAME_ID, nameStyle),
		Triple.of(TYPE_ID, TYPE_ID, typeStyle),
		Triple.of(ENUM_VALUE_ID, ENUM_VALUE_ID, enumValueStyle)
	]
	
	override void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor)
		highlightConfs.forEach[
			acceptor.acceptDefaultHighlighting(left, middle, right)
		]
	}

	def TextStyle nameStyle() {
		return new TextStyle => [
			color = new RGB(20,10,100)
			style = SWT.BOLD
		]
	}

	def TextStyle enumValueStyle() {
		return new TextStyle => [
			color = new RGB(237,119,19)
			style = SWT.ITALIC
		]
	}
	
	def TextStyle typeStyle() {
		return new TextStyle => [
			color = new RGB(0,72,186)
			style = SWT.BOLD
		]
	}
	
}
