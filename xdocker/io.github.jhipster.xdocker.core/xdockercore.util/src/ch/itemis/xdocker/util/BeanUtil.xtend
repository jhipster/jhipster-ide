/*******************************************************************************
 * Copyright (c) 2015-2021 Arcware GmbH (http://arcware.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.util

import static extension org.apache.commons.beanutils.BeanUtils.*
import org.apache.commons.beanutils.ConvertUtils

/**
 * Bean Utility Class
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class BeanUtil {

	def static Object value(Object it, String name) {
		getProperty(name)
	}

	def static <T> T convert(Object obj, Class<?> type) {
		return ConvertUtils.convert(obj, type) as T
	}
}
