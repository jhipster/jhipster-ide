/**
 * Copyright 2016-2021 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.ide.editor.syntaxcoloring

import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles

/**
 * @author Serano Colameo - Initial contribution and API
 */
interface JDLHighlightingStyles extends HighlightingStyles {
	val static String NAME_ID = "Name";
	val static String TYPE_ID = "Type";
	val static String ENUM_VALUE_ID = "Enum Value";
}