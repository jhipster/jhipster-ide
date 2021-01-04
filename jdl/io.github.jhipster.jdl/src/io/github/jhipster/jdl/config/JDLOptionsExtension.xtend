/**
 * Copyright 2016-2021 the original author or authors from the JHipster project.
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
import jbase.jbase.JDLDeploymentParameterName
import org.eclipse.emf.ecore.EObject

/**
 * @author Serano Colameo - Initial contribution and API
 */
@Singleton
final class JDLOptionsExtension {

	public static val JH_VERSION = 'jhipsterVersion'
	public static val SERVER_PORT = 'serverPort'	
	public static val INSTANCE = new JDLOptionsExtension

	val applOptions = JDLApplicationOptions.INSTANCE
	val deplOptions = JDLDeploymentOptions.INSTANCE

	def JDLParameterType getParameterType(String paramName) {
		val result = applOptions.getParameterType(paramName)
		return if (result == JDLParameterType.Undefined) deplOptions.getParameterType(paramName) else result
	}

	def List<String> getParameters(String paramName) {
		val applParams = applOptions.getParameters(paramName)
		return if (applParams.isNullOrEmpty) deplOptions.getParameters(paramName) else applParams
	}

	def getParamNameByReflection(EObject eObj) {
		return try {
			val field = eObj.class.getDeclaredField('paramName')
			field.accessible = true
			val result = field.get(eObj)
			switch (result) {
				JDLApplicationParameterName: result as JDLApplicationParameterName
				JDLDeploymentParameterName: result as JDLDeploymentParameterName
			}
		} catch (Exception ignore) {
			null
		}
	}

	def dispatch describe(JDLApplicationParameterName it) {
		return applOptions.describe(it)
	}

	def dispatch describe(JDLDeploymentParameterName it) {
		return deplOptions.describe(it)
	}

	def dispatch List<String> describe(String it) {
		return if (applOptions.hasOption(it)) applOptions.describe(it)
		  else if (deplOptions.hasOption(it)) deplOptions.describe(it)
		  else newArrayList
	}

	def dispatch String asHtml(JDLApplicationParameterName it) {
		return applOptions.asHtml(it)
	}

	def dispatch String asHtml(JDLDeploymentParameterName it) {
		return deplOptions.asHtml(it)
	}
}
