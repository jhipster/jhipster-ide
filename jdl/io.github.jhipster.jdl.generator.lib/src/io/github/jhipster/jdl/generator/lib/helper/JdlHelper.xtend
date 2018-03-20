/**
 * Copyright 2013-2018 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.generator.lib.helper

import io.github.jhipster.jdl.jdl.JdlBlobFieldType
import io.github.jhipster.jdl.jdl.JdlBooleanFieldType
import io.github.jhipster.jdl.jdl.JdlDateFieldType
import io.github.jhipster.jdl.jdl.JdlEntityType
import io.github.jhipster.jdl.jdl.JdlEnumFieldType
import io.github.jhipster.jdl.jdl.JdlFieldType
import io.github.jhipster.jdl.jdl.JdlNumericFieldType
import io.github.jhipster.jdl.jdl.JdlStringFieldType

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JdlHelper {

	def static String getTypeName(JdlFieldType it) {
		return switch (it) {
			JdlEntityType: element.name
			JdlStringFieldType: element.element
			JdlBooleanFieldType: element.element
			JdlEnumFieldType : element.name
			JdlNumericFieldType: element.literal
			JdlDateFieldType: element.literal
			JdlBlobFieldType: element.literal
			default: eClass.name
		}
	}
}
