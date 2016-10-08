/** 
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package io.github.jhipster.jdl.validation

/** 
 * @author Jan Koehnlein - Initial contribution and API
 */
interface IssueCodes {
	String PREFIX = 'org.eclipse.xtext.example.domainmodel.domainmodel.'
	String INVALID_TYPE_NAME = PREFIX + 'InvalidTypeName'
	String INVALID_FEATURE_NAME = PREFIX + 'InvalidFeatureName'
	String MISSING_TYPE = PREFIX + 'MissingType'

	String INVALID_ENTITY_NAME_MSG = 'Entity name should start with a capital'
	String INVALID_ENUM_NAME_MSG = 'Enum name should start with a capital'
	String INVALID_ENUM_VALUE_NAME_MSG = 'Enum value name should start with a capital'
	String FIELD_NAME_LOWERCASE_MSG = 'Field name should start with a lowercase'
	String DUPLICATE_FIELD_DEF_MSG = 'Field with name already defined'
}
