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
package io.github.jhipster.jdl.plantuml

import io.github.jhipster.jdl.generator.IJdlGenerator
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.renderer.IJdlModelViewerRenderer
import io.github.jhipster.jdl.renderer.JdlModelViewerRenderer
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.util.internal.Log

import static io.github.jhipster.jdl.renderer.RenderType.*
import static io.github.jhipster.jdl.util.PlantUmlUtil.*

import static extension io.github.jhipster.jdl.util.EcorePlatformUtil.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
@Log
class PlantUmlGenerator implements IJdlGenerator {

	extension IJdlModelViewerRenderer = JdlModelViewerRenderer.get(PlantUml)
	
	override generate(JdlDomainModel model, IFileSystemAccess2 fsa, IGeneratorContext context) {
		try {
			val resource = model?.eResource
			if (resource !== null) {
				val isPlantUmlGenOn = Boolean.getBoolean('plantuml.gen')
				val isPngUmlGenOn = Boolean.getBoolean('pnguml.gen')
				model.render => [
					if (isPlantUmlGenOn) createPlantUml(it, resource.toFile('plantuml'))			
					if (isPngUmlGenOn) createImage(it, resource.toFile('png'))
				]
			} else println('Error processing model: ' + model)
		} catch (Exception ex) {
			LOG.error('''Error - could not render model «model?.name» to PlantUML!''', ex)
		}
	}
}
