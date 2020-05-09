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
package io.github.jhipster.jdl.validation

import io.github.jhipster.jdl.config.JDLOptions
import io.github.jhipster.jdl.jdl.JdlApplicationParameter
import io.github.jhipster.jdl.jdl.JdlDeploymentParameter
import io.github.jhipster.jdl.jdl.JdlParameterValue
import io.github.jhipster.jdl.jdl.JdlParameterVersion
import jbase.config.JDLLanguages
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static io.github.jhipster.jdl.config.JDLOptions.*
import static io.github.jhipster.jdl.jdl.JdlPackage.Literals.*
import static io.github.jhipster.jdl.util.IdentifierUtil.*
import static io.github.jhipster.jdl.validation.IssueCodes.*
import static org.eclipse.xtext.EcoreUtil2.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
@Log
class OptionConfigValidator extends AbstractDeclarativeValidator {

	extension JDLOptions = JDLOptions.INSTANCE
	extension JDLLanguages = JDLLanguages.INSTANCE

	override register(EValidatorRegistrar registrar) {}

	@Check
	def void checkParameterValue(JdlParameterValue paramValue) {
		val paramName = (getContainerOfType(paramValue, JdlApplicationParameter)?.paramName ?:
			getContainerOfType(paramValue, JdlDeploymentParameter)?.paramName).literal
		if (paramName.isNullOrEmpty) return;
		val paramType = paramName.parameterType
		switch (paramType) {
			case Boolean:
				if (!paramValue.identifiers.isNullOrEmpty) {
					val value = paramValue.identifiers.head
					if (!#[
						Boolean.TRUE.toString,
						Boolean.FALSE.toString
					].exists[it == value]) {
						error(INVALID_BOOLEAN_PARAM_MSG, JDL_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX,
							INVALID_PARAM_VALUE)
					}
				}
			case LangIsoCode:
				if (!paramValue.identifiers.isNullOrEmpty) {
					val value = paramValue.identifiers.head
					if (!langCodes.contains(value)) {
						error(INVALID_ISOCODE_PARAM_MSG, JDL_PARAMETER_VALUE__LIST_ELEMENTS, INSIGNIFICANT_INDEX,
							INVALID_PARAM_VALUE)
					}
				}
			case ListOfLangIsoCodes:
				if (!paramValue.listElements.isNullOrEmpty) {
					paramValue.listElements.forEach [ e, i |
						if (!langCodes.contains(e)) {
							error(INVALID_ISOCODE_PARAM_MSG, JDL_PARAMETER_VALUE__LIST_ELEMENTS, i, INVALID_PARAM_VALUE)
						}
					]
				}
			case ListOfLiterals:
				if (!paramValue.listElements.isNullOrEmpty) {
					val expected = getParameters(paramName)
					paramValue.listElements.forEach [ e, i |
						if (!expected.contains(e)) {
							val msg = String.format(INVALID_PARAM_NAME_MSG, e)
							error(msg, JDL_PARAMETER_VALUE__LIST_ELEMENTS, i, INVALID_PARAM_VALUE)
						}
					]
				}
			case ListOfAnyLiterals:
				if (paramValue.listElements.isNullOrEmpty) {
					val msg = String.format(INVALID_PARAM_NAME_MSG, '')
					error(msg, JDL_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX, INVALID_PARAM_VALUE)
				}
			case EnumLiteral:
				if (!paramValue.identifiers.isNullOrEmpty && paramValue.identifiers.size === 1) {
					val value = paramValue.identifiers.head
					val expected = paramName.parameters
					if (!expected.contains(value)) {
						val msg = String.format(INVALID_PARAM_NAME_MSG, value)
						error(msg, JDL_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX, INVALID_PARAM_VALUE)
					}
				}
			case AnyLiteral:
				if (paramValue.identifiers.isNullOrEmpty) {
					val msg = String.format(INVALID_PARAM_NAME_MSG, '')
					error(msg, JDL_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX, INVALID_PARAM_VALUE)
				}
			case String: {
				if (!paramValue.identifiers.isNullOrEmpty || paramValue.stringValue.isNullOrEmpty) {
					error(INVALID_STRING_PARAM_MSG, JDL_PARAMETER_VALUE__STRING_VALUE, INSIGNIFICANT_INDEX,
						INVALID_PARAM_VALUE)
				}
			}
			case Namespace:
				if (!paramValue.identifiers.isNullOrEmpty) {
					if (!isValidJavaIdentifier(paramValue.identifiers.head)) {
						error(INVALID_PACKAGE_PARAM_MSG, JDL_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX,
							INVALID_PARAM_VALUE)
					}
				}
			case Version: {
				if (paramName == JH_VERSION && !isValidJhipsterVersion(paramValue.version)) {
					error(INVALID_JHVERSION_PARAM_MSG, JDL_PARAMETER_VALUE__VERSION, INSIGNIFICANT_INDEX,
						INVALID_PARAM_VALUE)
				}
			}
			case Number: {
				if (paramName == SERVER_PORT && !paramValue.identifiers.isNullOrEmpty ||
					paramValue.stringValue !== null || !paramValue.stringValue.isNullOrEmpty ||
					paramValue.version !== null || !paramValue.listElements.isNullOrEmpty) {
					error(INVALID_PORT_PARAM_MSG, JDL_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX,
						INVALID_PARAM_VALUE)
				}
			}
			case JavaIdentifierLiteral:
				if (paramValue.identifiers.isNullOrEmpty || !isValidJavaIdentifier(paramValue.identifiers.head)) {
					error(INVALID_IDENTIFIER_PARAM_MSG, JDL_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX,
						INVALID_PARAM_VALUE)
				}
			case NumDigitLiteral: {
				val prefixDigitAllowed = !paramValue.stringValue.nullOrEmpty
				val value = if(prefixDigitAllowed) paramValue.stringValue else paramValue.identifiers.head
				if (value.matches('^\\d+.*') && !paramValue.identifiers.isNullOrEmpty) {
					error(INVALID_BASENAME_PARAM_MSG, JDL_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX,
						WRONG_PARAM_VALUE_TYPE)
				} else if (!isValidJavaIdentifier(value, prefixDigitAllowed)) {
					error(INVALID_BASENAME_PARAM_MSG, JDL_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX,
						INVALID_PARAM_VALUE)
				}
			}
			default: LOG.error('''Unknown type «paramType» for «paramName»!''') // we should throw an exception, but let's be permissive here
		}
	}

	def protected isValidJhipsterVersion(JdlParameterVersion version) {
		return !version?.versionTag.isNullOrEmpty
	}

	def protected boolean hasParamValue(JdlApplicationParameter param, String value) {
		if (param?.paramValue?.identifiers.isNullOrEmpty) return false
		val paramValue = param.paramValue.identifiers.last
		return paramValue.equalsIgnoreCase(value)
	}
}
