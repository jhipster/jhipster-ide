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
package io.github.jhipster.jdl.config

import java.util.Map

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JdlLanguages {

	/**
	 * @see <a href="hhttps://raw.githubusercontent.com/jhipster/generator-jhipster/master/generators/generator-constants.js</a>
	 * 
	 * 	const LANGUAGES = [
	 * 	    { name: 'Arabic (Libya)', dispName: 'العربية', value: 'ar-ly', rtl: true, skipForLocale: true },
	 * 	    { name: 'Armenian', dispName: 'Հայերեն', value: 'hy' },
	 * 	    { name: 'Catalan', dispName: 'Català', value: 'ca' },
	 * 	    { name: 'Chinese (Simplified)', dispName: '中文（简体）', value: 'zh-cn', localeId: 'zh-Hans' },
	 * 	    { name: 'Chinese (Traditional)', dispName: '繁體中文', value: 'zh-tw', localeId: 'zh-Hant' },
	 * 	    { name: 'Czech', dispName: 'Český', value: 'cs' },
	 * 	    { name: 'Danish', dispName: 'Dansk', value: 'da' },
	 * 	    { name: 'Dutch', dispName: 'Nederlands', value: 'nl' },
	 * 	    { name: 'English', dispName: 'English', value: 'en' },
	 * 	    { name: 'Estonian', dispName: 'Eesti', value: 'et' },
	 * 	    { name: 'Farsi', dispName: 'فارسی', value: 'fa', rtl: true },
	 * 	    { name: 'French', dispName: 'Français', value: 'fr' },
	 * 	    { name: 'Galician', dispName: 'Galego', value: 'gl' },
	 * 	    { name: 'German', dispName: 'Deutsch', value: 'de' },
	 * 	    { name: 'Greek', dispName: 'Ελληνικά', value: 'el' },
	 * 	    { name: 'Hindi', dispName: 'हिंदी', value: 'hi' },
	 * 	    { name: 'Hungarian', dispName: 'Magyar', value: 'hu' },
	 * 	    { name: 'Indonesian', dispName: 'Bahasa Indonesia', value: 'id' },
	 * 	    { name: 'Italian', dispName: 'Italiano', value: 'it' },
	 * 	    { name: 'Japanese', dispName: '日本語', value: 'ja' },
	 * 	    { name: 'Korean', dispName: '한국어', value: 'ko' },
	 * 	    { name: 'Marathi', dispName: 'मराठी', value: 'mr' },
	 * 	    { name: 'Polish', dispName: 'Polski', value: 'pl' },
	 * 	    { name: 'Portuguese (Brazilian)', dispName: 'Português (Brasil)', value: 'pt-br', localeId: 'pt' },
	 * 	    { name: 'Portuguese', dispName: 'Português', value: 'pt-pt', localeId: 'pt-PT' },
	 * 	    { name: 'Romanian', dispName: 'Română', value: 'ro' },
	 * 	    { name: 'Russian', dispName: 'Русский', value: 'ru' },
	 * 	    { name: 'Slovak', dispName: 'Slovenský', value: 'sk' },
	 * 	    { name: 'Serbian', dispName: 'Srpski', value: 'sr' },
	 * 	    { name: 'Spanish', dispName: 'Español', value: 'es' },
	 * 	    { name: 'Swedish', dispName: 'Svenska', value: 'sv' },
	 * 	    { name: 'Turkish', dispName: 'Türkçe', value: 'tr' },
	 * 	    { name: 'Tamil', dispName: 'தமிழ்', value: 'ta' },
	 * 	    { name: 'Thai', dispName: 'ไทย', value: 'th' },
	 * 	    { name: 'Ukrainian', dispName: 'Українська', value: 'ua', localeId: 'uk' },
	 * 	    { name: 'Uzbek (latin)', dispName: 'O`zbekcha', value: 'uz-lat', localeId: 'uz' },
	 * 	    { name: 'Vietnamese', dispName: 'Tiếng Việt', value: 'vi' }
	 * 	];
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
