/**
 * Copyright 2013-2020 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.config

import java.util.Map

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JdlLanguages {

	/**
	 * @see <a href="hhttps://raw.githubusercontent.com/jhipster/generator-jhipster/master/generators/generator-constants.js</a>
	 */
	def static Map<String, String> getJHipsterIsoLangauges() {
		return newHashMap(#[
			'ar-ly' -> 'Arabic (Libya)',
			'hy' -> 'Armenian',
	 		'ca' -> 'Catalan',
			'zh-cn' -> 'Chinese (Simplified)',
			'zh-tw' -> 'Chinese (Traditional)',
			'cs' -> 'Czech',
			'da' -> 'Danish',
			'nl' -> 'Dutch',
			'en' -> 'English',
			'et' -> 'Estonian',
			'fa' -> 'Farsi', 
			'fr' -> 'French',
			'gl' -> 'Galician',
			'de' -> 'German', 
			'el' -> 'Greek', 
			'hi' -> 'Hindi',
			'hu' -> 'Hungarian', 
			'id' -> 'Indonesian', 
			'it' -> 'Italian', 
			'ja' -> 'Japanese', 
			'ko' -> 'Korean', 
			'mr' -> 'Marathi', 
			'pl' -> 'Polish', 
			'pt-br' -> 'Portuguese (Brazilian)', 
			'pt-pt' -> 'Portuguese', 
			'ro' -> 'Romanian', 
			'ru' -> 'Russian', 
			'sk' -> 'Slovak', 
			'sr' -> 'Serbian', 
			'es' -> 'Spanish',
			'sv' -> 'Swedish', 
			'tr' -> 'Turkish', 
			'ta' -> 'Tamil', 
			'th' -> 'Thai',
			'ua' -> 'Ukrainian', 
			'uz-lat' -> 'Uzbek (latin)', 
			'vi' -> 'Vietnamese'
		])
	}
}
