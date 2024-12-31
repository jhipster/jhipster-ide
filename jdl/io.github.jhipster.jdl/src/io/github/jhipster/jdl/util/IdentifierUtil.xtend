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
package io.github.jhipster.jdl.util

/**
 * @author Serano Colameo - Initial contribution and API
 */
class IdentifierUtil {
	
	def static boolean isValidJavaIdentifier(String identifier) {
		isValidJavaIdentifier(identifier, false)
	}

	def static boolean isValidJavaIdentifier(String id, boolean isPrefixNumAllowed) {
		if (id.isNullOrEmpty || id.matches('^\\d+.*') && !isPrefixNumAllowed) return false
		val idWithoutDigits = id.replaceAll('^\\d+', '')
		val chars = idWithoutDigits.toCharArray
		for (var i = 0; i < chars.length; i++) {
			val c = chars.get(i)
			if ((i == 0 && !Character.isJavaIdentifierStart(c)) ||
				(i > 0 && !Character.isJavaIdentifierPart(c))) return false
		}
		return true
	}
}
