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
package io.github.jhipster.jdl.validation

import io.github.jhipster.jdl.config.JdlApplicationOptions
import io.github.jhipster.jdl.jdl.JdlApplicationParameter
import io.github.jhipster.jdl.jdl.JdlApplicationParameterValue
import io.github.jhipster.jdl.jdl.JdlApplicationParameterVersion
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static io.github.jhipster.jdl.config.JdlApplicationOptions.*
import static io.github.jhipster.jdl.config.JdlLanguages.*
import static io.github.jhipster.jdl.jdl.JdlPackage.Literals.*
import static io.github.jhipster.jdl.validation.IssueCodes.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class ApplicationConfigValidator extends AbstractDeclarativeValidator {

	val JdlApplicationOptions options = JdlApplicationOptions.INSTANCE

	override register(EValidatorRegistrar registrar) {}

	@Check
	def void checkApplicationParameter(JdlApplicationParameterValue paramValue) {
		val param = EcoreUtil2.getContainerOfType(paramValue, JdlApplicationParameter)
		val paramName = param?.paramName?.literal
		if (paramName.isNullOrEmpty) return;
		val paramType = options.getParameterType(paramName)
		switch (paramType) {
			case Boolean: if (!paramValue.identifiers.isNullOrEmpty) {
				val values = paramValue.identifiers
				if (!#[Boolean.FALSE, Boolean.TRUE].exists[values.contains(it.toString)]) {
					error(INVALID_BOOLEAN_PARAM_MSG, JDL_APPLICATION_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX, INVALID_PARAM_VALUE)
				}
			}
			case #[ListOfLangIsoCodes, LangIsoCode].exists[it == paramType]: if (!paramValue.identifiers.isNullOrEmpty) {
				val values = paramValue.identifiers
				values.forEach[ e, i |
					if (!JHipsterIsoLangauges.containsKey(e)) {
						error(INVALID_ISOCODE_PARAM_MSG, JDL_APPLICATION_PARAMETER_VALUE__IDENTIFIERS, i, INVALID_PARAM_VALUE)
					}
				]				
			}
			case #[Literal, ListOfLiterals].exists[it == paramType]: if (!paramValue.identifiers.isNullOrEmpty) {
				val expected = options.getParameters(paramName)
				paramValue.identifiers.forEach[ e, i |
					if (!expected.contains(e)) {
						error(INVALID_PARAM_NAME_MSG, JDL_APPLICATION_PARAMETER_VALUE__IDENTIFIERS, i, INVALID_PARAM_VALUE)
					}
				]				
			}
			case Namespace: if (!paramValue.identifiers.isNullOrEmpty) {
				paramValue.identifiers.forEach[ e, i |
					if (!isValidJavaIdentifier(e)) {
						error(INVALID_PACKAGE_PARAM_MSG, JDL_APPLICATION_PARAMETER_VALUE__IDENTIFIERS, i, INVALID_PARAM_VALUE)
					}
				]
			}
			case Version: {
				if (paramName == JH_VERSION && !isValidJhipsterVersion(paramValue.version)) {
					error(INVALID_JHVERSION_PARAM_MSG, JDL_APPLICATION_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX, INVALID_PARAM_VALUE)
				}
			}
			case Number: {
				if (paramName == SERVER_PORT && !paramValue.identifiers.isNullOrEmpty ||
					paramValue.stringValue !== null || !paramValue.stringValue.isNullOrEmpty ||
					paramValue.version !== null
				) {
					error(INVALID_PORT_PARAM_MSG, JDL_APPLICATION_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX, INVALID_PARAM_VALUE)
				}
			}
			case JavaIdentifierLiteral: if (paramValue.identifiers.isNullOrEmpty || !isValidJavaIdentifier(paramValue.identifiers.head)) {
				error(INVALID_IDENTIFIER_PARAM_MSG, JDL_APPLICATION_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX, INVALID_PARAM_VALUE)
			}
			case NumDigitLiteral: {
				val prefixDigiAllowed = !paramValue.stringValue.nullOrEmpty
				val value = if (prefixDigiAllowed) paramValue.stringValue else paramValue.identifiers?.head
				if (value.matches('^\\d+.*') && !paramValue.identifiers.isNullOrEmpty) {
					error(INVALID_BASENAME_PARAM_MSG, JDL_APPLICATION_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX, WRONG_PARAM_VALUE_TYPE)
				} else if (!isValidJavaIdentifier(value, prefixDigiAllowed)) {
					error(INVALID_BASENAME_PARAM_MSG, JDL_APPLICATION_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX, INVALID_PARAM_VALUE)
				}
			}
		}
	}

	def private isValidJhipsterVersion(JdlApplicationParameterVersion version) {
		return version !== null && !version.versionTag.isNullOrEmpty
	}

	def private isValidJavaIdentifier(String identifier) {
		isValidJavaIdentifier(identifier, false)
	}
	
	def private isValidJavaIdentifier(String id, boolean isPrefixNumAllowed) {
		if (id.isNullOrEmpty || id.matches('^\\d+.*') && !isPrefixNumAllowed) return false
		val idWithoutDigits = id.replaceAll('^\\d+', '') 
		val chars = idWithoutDigits.toCharArray
		for (var i = 0; i<chars.length; i++) {
			val c = chars.get(i)
			if ((i == 0 && !Character.isJavaIdentifierStart(c)) ||
			    (i  > 0 && !Character.isJavaIdentifierPart(c))) return false
		}
		return true
	}
}
