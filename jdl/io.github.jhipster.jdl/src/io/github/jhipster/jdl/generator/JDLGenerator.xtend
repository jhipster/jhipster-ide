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
package io.github.jhipster.jdl.generator

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.plantuml.PlantUmlGenerator
import java.util.Set
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

/**
 * @author Serano Colameo - Initial contribution and API
 */

@ImplementedBy(PlantUmlGenerator)
interface IJdlGenerator {
	def void generate(JdlDomainModel model, IFileSystemAccess2 fsa, IGeneratorContext context)
}

class JDLGenerator extends AbstractGenerator {

	@Inject Set<IJdlGenerator> generators

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		resource.allContents.filter(JdlDomainModel).forEach[ jdl |
			generators.forEach[
				generate(jdl, fsa, context)
			]
		]
	}	
}
