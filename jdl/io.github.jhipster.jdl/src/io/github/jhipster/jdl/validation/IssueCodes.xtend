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

import io.github.jhipster.jdl.jdl.JdlCardinality

/**
 * @author Serano Colameo - Initial contribution and API
 */
interface IssueCodes {
	// codes
	String PREFIX = 'io.github.jhipster.jdl.'
	String INVALID_TYPE_NAME = PREFIX + 'InvalidTypeName'
	String INVALID_FEATURE_NAME = PREFIX + 'InvalidFeatureName'
	String NOT_UPPER_CASE = PREFIX + 'NotUpperCase'
	String MISSING_TYPE = PREFIX + 'MissingType'
	String INVALID_REQUIRED_OPTION = PREFIX + 'InvalidRequiredOption'
	String WRONG_REGEXP = PREFIX + 'WrongRegexp'
	String INVALID_PARAM_VALUE = PREFIX + 'InvalidParamValue'
	String WRONG_PARAM_VALUE_TYPE = PREFIX + 'WrongParamValueType'
	String DEPRECATED_PARAMETER = PREFIX + 'DeprecatedParameter'
	String INVALID_AUTH_VALUE_TYPE = PREFIX + 'InvalidAuthParamValueType'
	String INVALID_AUTH_PARAM_TYPE = PREFIX + 'InvalidAuthParamType'
	// messages
	String WRONG_REGEXP_MSG = 'Wrong regexp pattern!'
	String INVALID_ENTITY_NAME_MSG = 'Entity name should start with a capital'
	String INVALID_ENUM_NAME_MSG = 'Enum name should start with a capital'
	String INVALID_ENUM_VALUE_NAME_MSG = 'Enum value name must be upper case'
	String FIELD_NAME_LOWERCASE_MSG = 'Field name should start with a lower case'
	String DUPLICATE_FIELD_DEF_MSG = 'Field with name already defined'
	(JdlCardinality)=>String REQUIRED_NOT_ALLOWED_MSG = ['''Constraint 'required' on a relationship of type «literal» will be ignored''']
	String INVALID_ENTITY_SELECTION_MSG = 'Selection does not contain excluded element'
	String INVALID_PARAM_NAME_MSG = 'Unknown literal [%s]!'
	String INVALID_BOOLEAN_PARAM_MSG = 'Boolean (true/false) value expected!'
	String INVALID_ISOCODE_PARAM_MSG = 'Invalid ISO code!'
	String INVALID_IDENTIFIER_PARAM_MSG = 'Invalid identifier!'
	String INVALID_PACKAGE_PARAM_MSG = 'Invalid package name!'
	String INVALID_BASENAME_PARAM_MSG = 'Invalid base name!'
	String INVALID_JHVERSION_PARAM_MSG = 'Invalid JHipster version number!'
	String INVALID_PORT_PARAM_MSG = 'Invalid server port!'
	String INVALID_PARAM_NOTUNIQUE_MSG = 'Parameter [%s] already defined!'
	String DEPRECATED_PARAM_MSG = 'Deprecated, will be removed in the next major release!'
	String INVALID_AUTH_TYPE_MSG = 'Invalid authentication type!'
	String INVALID_STRING_PARAM_MSG = 'Invalid string value!'
	String EMPTY_VALUE_MSG = 'Empty value not allowed'
}
