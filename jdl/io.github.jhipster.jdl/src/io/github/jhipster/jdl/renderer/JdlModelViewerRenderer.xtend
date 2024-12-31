/**
 * Copyright 2016-2025 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.renderer

import io.github.jhipster.jdl.jdl.JdlDomainModel
import java.util.Map

import static io.github.jhipster.jdl.renderer.RenderType.*

/**
 * @author Serano Colameo - Initial contribution and API
 */

enum RenderType {
	PlantUml,
	EmfUml2,
	ZestDot
}

interface IJdlModelViewerRenderer {
	def String render(JdlDomainModel model) 	
}

class JdlModelViewerRenderer {

	static val Map<RenderType, IJdlModelViewerRenderer> instances = newHashMap => [
		put(PlantUml, new JdlToPlantUmlRenderer)
	]

	def static IJdlModelViewerRenderer get(RenderType renderer) {
		if (!instances.keySet.contains(renderer)) {
			throw new IllegalArgumentException('''Renderer «renderer» not yet implemented!''')
		}
		instances.get(renderer)
	}
}
