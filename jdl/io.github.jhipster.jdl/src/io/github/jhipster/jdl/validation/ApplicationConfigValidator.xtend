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
import io.github.jhipster.jdl.config.JdlDeploymentOptions
import io.github.jhipster.jdl.config.JdlParameterType
import io.github.jhipster.jdl.jdl.JdlApplicationConfig
import io.github.jhipster.jdl.jdl.JdlApplicationParameter
import io.github.jhipster.jdl.jdl.JdlApplicationParameterName
import io.github.jhipster.jdl.jdl.JdlDeploymentParameter
import io.github.jhipster.jdl.jdl.JdlParameterValue
import io.github.jhipster.jdl.jdl.JdlParameterVersion
import java.util.List
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static io.github.jhipster.jdl.config.JdlApplicationOptions.*
import static io.github.jhipster.jdl.config.JdlLanguages.*
import static io.github.jhipster.jdl.jdl.JdlPackage.Literals.*
import static io.github.jhipster.jdl.validation.IssueCodes.*
import static org.eclipse.xtext.EcoreUtil2.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class ApplicationConfigValidator extends AbstractDeclarativeValidator {

	val JdlApplicationOptions applOptions = JdlApplicationOptions.INSTANCE
	val JdlDeploymentOptions deplOptions = JdlDeploymentOptions.INSTANCE

	override register(EValidatorRegistrar registrar) {}

	@Check
	def void checkApplicationParametersUniqueness(JdlApplicationConfig config) {
		val set = newHashSet
		config.paramters.map[
			it.paramName.literal
		].forEach[ p, i |
			if (!set.add(p)) error(
				String.format(INVALID_PARAM_NOTUNIQUE_MSG, p), JDL_APPLICATION_CONFIG__PARAMTERS, i
			)
		]
	}
	
	@Check
	def void checkDeprecatedApplicationParameter(JdlApplicationConfig config) {
		config.paramters.forEach[ it, i |
			if (paramName === JdlApplicationParameterName.JHIPSTER_VERSION) {
				warning(DEPRECATED_PARAM_MSG, JDL_APPLICATION_CONFIG__PARAMTERS, i, DEPRECATED_PARAMETER)
			}
		]
	}

// FIXME: keep not clear how logic is really implemented in generator
//
//	@Check
//	def void checkApplicationAndAuthenticationTypeCombination(JdlApplicationParameter param) {
//		if (param.paramName !== JdlApplicationParameterName.AUTHENTICATION_TYPE) return
//		val config = EcoreUtil2.getContainerOfType(param, JdlApplicationConfig) 
//		val appType = config.paramters.findFirst[it.paramName == JdlApplicationParameterName.APPLICATION_TYPE]
//		val isUaaAppType = appType.hasParamValue('uaa')
//		if (isUaaAppType && !param.hasParamValue('uaa')) {
//			error(INVALID_AUTH_TYPE_MSG, JDL_APPLICATION_PARAMETER__PARAM_VALUE, INSIGNIFICANT_INDEX, INVALID_AUTH_VALUE_TYPE)
//		} else if (!isUaaAppType && param.hasParamValue('uaa')) {
//			error(INVALID_AUTH_TYPE_MSG, JDL_APPLICATION_PARAMETER__PARAM_VALUE, INSIGNIFICANT_INDEX, INVALID_AUTH_PARAM_TYPE)
//		}
//	}

	@Check
	def void checkParameterValue(JdlParameterValue paramValue) {
		val paramName = (getContainerOfType(paramValue, JdlApplicationParameter)?.paramName ?:
			getContainerOfType(paramValue, JdlDeploymentParameter)?.paramName).literal
		if (paramName.isNullOrEmpty) return;
		val paramType = getParameterType(paramName)
		switch (paramType) {
			case Boolean: if (!paramValue.identifiers.isNullOrEmpty) {
				val value = paramValue.identifiers.head
				if (!#[Boolean.FALSE, Boolean.TRUE].exists[value.contains(it.toString)]) {
					error(INVALID_BOOLEAN_PARAM_MSG, JDL_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX, INVALID_PARAM_VALUE)
				}
			}
			case LangIsoCode: if (!paramValue.identifiers.isNullOrEmpty) {
				val value = paramValue.identifiers.head
				if (!JHipsterIsoLangauges.containsKey(value)) {
					error(INVALID_ISOCODE_PARAM_MSG, JDL_PARAMETER_VALUE__LIST_ELEMENTS, INSIGNIFICANT_INDEX, INVALID_PARAM_VALUE)
				}
			}
			case ListOfLangIsoCodes: if (!paramValue.listElements.isNullOrEmpty) {
				paramValue.listElements.forEach[ e, i |
					if (!JHipsterIsoLangauges.containsKey(e)) {
						error(INVALID_ISOCODE_PARAM_MSG, JDL_PARAMETER_VALUE__IDENTIFIERS, i, INVALID_PARAM_VALUE)
					}
				]				
			}
			case ListOfLiterals: if (!paramValue.listElements.isNullOrEmpty) {
				val expected = getParameters(paramName)
				paramValue.listElements.forEach[ e, i |
					if (!expected.contains(e)) {
						val msg = String.format(INVALID_PARAM_NAME_MSG, e)
						error(msg, JDL_PARAMETER_VALUE__IDENTIFIERS, i, INVALID_PARAM_VALUE)
					}
				]				
			} 
			case Literal: if (!paramValue.identifiers.isNullOrEmpty && paramValue.identifiers.size === 1) {
				val value = paramValue.identifiers.head
				val expected = getParameters(paramName)
				if (!expected.contains(value)) {
					val msg = String.format(INVALID_PARAM_NAME_MSG, value)
					error(msg, JDL_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX, INVALID_PARAM_VALUE)
				}
			}
			case String: {
				if (!paramValue.identifiers.isNullOrEmpty || paramValue.stringValue.isNullOrEmpty) {
					error(INVALID_STRING_PARAM_MSG, JDL_PARAMETER_VALUE__STRING_VALUE, INSIGNIFICANT_INDEX, INVALID_PARAM_VALUE)
				}
			}
			case Namespace: if (!paramValue.identifiers.isNullOrEmpty) {
				if (!isValidJavaIdentifier(paramValue.identifiers.head)) {
					error(INVALID_PACKAGE_PARAM_MSG, JDL_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX, INVALID_PARAM_VALUE)
				}
			}
			case Version: {
				if (paramName == JH_VERSION && !isValidJhipsterVersion(paramValue.version)) {
					error(INVALID_JHVERSION_PARAM_MSG, JDL_PARAMETER_VALUE__VERSION, INSIGNIFICANT_INDEX, INVALID_PARAM_VALUE)
				}
			}
			case Number: {
				if (paramName == SERVER_PORT && !paramValue.identifiers.isNullOrEmpty ||
					paramValue.stringValue !== null || !paramValue.stringValue.isNullOrEmpty ||
					paramValue.version !== null || !paramValue.listElements.isNullOrEmpty
				) {
					error(INVALID_PORT_PARAM_MSG, JDL_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX, INVALID_PARAM_VALUE)
				}
			}
			case JavaIdentifierLiteral: if (paramValue.identifiers.isNullOrEmpty || !isValidJavaIdentifier(paramValue.identifiers.head)) {
				error(INVALID_IDENTIFIER_PARAM_MSG, JDL_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX, INVALID_PARAM_VALUE)
			}
			case NumDigitLiteral: {
				val prefixDigiAllowed = !paramValue.stringValue.nullOrEmpty
				val value = if (prefixDigiAllowed) paramValue.stringValue else paramValue.identifiers.head
				if (value.matches('^\\d+.*') && !paramValue.identifiers.isNullOrEmpty) {
					error(INVALID_BASENAME_PARAM_MSG, JDL_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX, WRONG_PARAM_VALUE_TYPE)
				} else if (!isValidJavaIdentifier(value, prefixDigiAllowed)) {
					error(INVALID_BASENAME_PARAM_MSG, JDL_PARAMETER_VALUE__IDENTIFIERS, INSIGNIFICANT_INDEX, INVALID_PARAM_VALUE)
				}
			}
			default: {
				// nothing to do here
			}
		}
	}
	
	def private JdlParameterType getParameterType(String paramName) {
		val result = applOptions.getParameterType(paramName) 
		return if (result == JdlParameterType.Undefined) deplOptions.getParameterType(paramName)
	}

	def private List<String> getParameters(String paramName) {
		val applParams = applOptions.getParameters(paramName)
		return if (applParams.isNullOrEmpty) deplOptions.getParameters(paramName)
	}

	def protected isValidJhipsterVersion(JdlParameterVersion version) {
		return version !== null && !version.versionTag.isNullOrEmpty
	}

	def protected isValidJavaIdentifier(String identifier) {
		isValidJavaIdentifier(identifier, false)
	}
	
	def protected isValidJavaIdentifier(String id, boolean isPrefixNumAllowed) {
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

	def protected boolean hasParamValue(JdlApplicationParameter param, String value) {
		if (param?.paramValue?.identifiers.isNullOrEmpty) return false
		val paramValue = param.paramValue.identifiers.last
		return paramValue.equalsIgnoreCase(value)
	}
}
