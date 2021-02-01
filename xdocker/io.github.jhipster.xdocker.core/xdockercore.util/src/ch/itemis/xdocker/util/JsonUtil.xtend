/** 
 * Copyright (c) 2015-2021 Arcware GmbH (http://arcware.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ch.itemis.xdocker.util

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import java.util.HashMap
import com.fasterxml.jackson.core.type.TypeReference
import java.util.Map

/** 
 * JsonUtil Class to parse json snippet to a Map<?,?>
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class JsonUtil {	
	public static val INSTANCE = new JsonUtil
	
	val factory = new JsonFactory
	val mapper = new ObjectMapper(factory)
    val typeRef = new TypeReference<HashMap<String,String>>() {}

	private new() {
	}

	def static Map<String, String> toMap(String json) {
		val result = <String, String>newHashMap
		try {
			INSTANCE => [
				result.putAll(mapper.readValue(json, typeRef))
			]
		} catch (Exception ignore) {}
		return result
	}
}
