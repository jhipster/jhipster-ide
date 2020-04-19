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
package io.github.jhipster.jdl.config

import com.google.inject.Singleton
import java.util.List
import jbase.config.JDLApplicationOptions
import jbase.config.JDLDeploymentOptions
import jbase.config.JDLParameterType
import jbase.jbase.JDLApplicationParameterName

/**
 * @author Serano Colameo - Initial contribution and API
 */
@Singleton
final class JDLOptions {

	public static JDLOptions INSTANCE = new JDLOptions

	val applOptions = JDLApplicationOptions.INSTANCE
	val deplOptions = JDLDeploymentOptions.INSTANCE

	def JDLParameterType getParameterType(String paramName) {
		val result = applOptions.getParameterType(paramName)
		return if(result == JDLParameterType.Undefined) deplOptions.getParameterType(paramName) else result
	}

	def List<String> getParameters(String paramName) {
		val applParams = applOptions.getParameters(paramName)
		return if(applParams.isNullOrEmpty) deplOptions.getParameters(paramName) else applParams
	}

	def describe(JDLApplicationParameterName it) {
		return if (applOptions.options.containsKey(it.literal))
			applOptions.describe(it)
		else
			deplOptions.describe(it)
	}

	def List<String> describe(String it) {
		return if (applOptions.options.containsKey(it))
			applOptions.describe(it)
		else
			deplOptions.describe(it)
	}
	
	def String asHtml(JDLApplicationParameterName it) {
		return if (applOptions.options.containsKey(it.literal))
			applOptions.asHtml(it)
		else
			deplOptions.asHtml(it)
	}
}
