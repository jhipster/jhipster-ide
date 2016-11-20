package io.github.jhipster.jdl.validation

import io.github.jhipster.jdl.jdl.JdlCardinality

interface IssueCodes {
	String PREFIX = 'io.github.jhipster.jdl.'
	String INVALID_TYPE_NAME = PREFIX + 'InvalidTypeName'
	String INVALID_FEATURE_NAME = PREFIX + 'InvalidFeatureName'
	String MISSING_TYPE = PREFIX + 'MissingType'
	String INVALID_ENTITY_NAME_MSG = 'Entity name should start with a capital'
	String INVALID_ENUM_NAME_MSG = 'Enum name should start with a capital'
	String INVALID_ENUM_VALUE_NAME_MSG = 'Enum value name should start with a capital'
	String FIELD_NAME_LOWERCASE_MSG = 'Field name should start with a lowercase'
	String DUPLICATE_FIELD_DEF_MSG = 'Field with name already defined'
	(JdlCardinality)=>String REQUIRED_NOT_ALLOWED_MSG = ['''Constraint 'required' on a relationship of type «literal» will be ignored''']
	String INVALID_REQUIRED_OPTION = PREFIX + 'InvalidRequiredOption'
}
