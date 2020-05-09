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
package io.github.jhipster.jdl.ide.hover

import io.github.jhipster.jdl.config.JDLOptions
import io.github.jhipster.jdl.jdl.JdlApplicationParameter
import io.github.jhipster.jdl.jdl.JdlDeploymentParameter
import io.github.jhipster.jdl.jdl.JdlParameter
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ide.server.hover.HoverService

import static org.eclipse.xtext.EcoreUtil2.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JDLHoverService extends HoverService {

	extension JDLOptions = JDLOptions.INSTANCE

	override List<String> getContents(EObject eObj) {
		if (eObj === null) return null
		val param = getContainerOfType(eObj, JdlParameter)
		switch param {
			JdlApplicationParameter, JdlDeploymentParameter: getParamNameByReflection(param)?.describe
			default: super.getContents(eObj)
		}
	}
}
