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

import com.google.inject.Singleton
import java.util.List
import java.util.Map

import static io.github.jhipster.jdl.config.JdlParameterType.*

/**
 * @author Serano Colameo - Initial contribution and API
 */ 
@Singleton
class JdlAbstractOptions {
	
	val Map<String, JdlOption> options = newHashMap
	
	protected new() {} // this is a singleton!
	
	def void add(JdlOption option) {
		options.put(option.name, option)
	}

	def void addAll(JdlOption[] options) {
		options.forEach[add(it)]
	}
	
	def List<String> getNames() {
		return if (options.isEmpty) #[] else options.keySet.toList
	}

	def List<String> getParameters(String name) {
		return if (!options.containsKey(name)) #[] else options.get(name).parameters
	}

	def JdlParameterType getParameterType(String name) {
		return if (!options.containsKey(name)) Undefined else options.get(name).parameterType
	}
}
