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
package io.github.jhipster.jdl

import com.google.inject.Provides
import io.github.jhipster.jdl.generator.IJdlGenerator
import io.github.jhipster.jdl.generator.JDLGenerator
import io.github.jhipster.jdl.generator.JDLOutputConfigurationProvider
import io.github.jhipster.jdl.plantuml.PlantUmlGenerator
import io.github.jhipster.jdl.renderer.IJdlToPlantUmlRenderer
import io.github.jhipster.jdl.renderer.JdlToPlantUmlRenderer
import io.github.jhipster.jdl.resource.JdlDerivedStateComputer
import java.util.Set
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager
import org.eclipse.xtext.resource.IDerivedStateComputer
import org.eclipse.xtext.resource.IResourceDescription
import io.github.jhipster.jdl.naming.JdlQualifiedNameProvider
import org.eclipse.xtext.validation.INamesAreUniqueValidationHelper
import io.github.jhipster.jdl.validation.JDLNamesAreUniqueValidationHelper

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JDLRuntimeModule extends AbstractJDLRuntimeModule {

	override bindIGenerator2() {
		JDLGenerator
	}

	override bindXtextResource() {
		return DerivedStateAwareResource
	}

	def Class<? extends IDerivedStateComputer> bindIDerivedStateComputer() {
		JdlDerivedStateComputer
	}

	def Class<? extends IResourceDescription.Manager> bindIResourceDescriptionManager() {
		DerivedStateAwareResourceDescriptionManager
	}
	
	def Class<? extends IJdlToPlantUmlRenderer> bindIJdlToPlantUmlRenderer() {
		return JdlToPlantUmlRenderer
	}
	
	def Class<? extends IJdlGenerator> bindPlantUmlGenerator() {
		return PlantUmlGenerator
	}

	@Provides
	def Set<IJdlGenerator> jdlGenerators() {
		#{new PlantUmlGenerator}
	}
	
	def Class<? extends IOutputConfigurationProvider> bindIOutputConfigurationProvider() {
		return JDLOutputConfigurationProvider
	}
	
	override bindIQualifiedNameProvider() {
		JdlQualifiedNameProvider
	}
	
	def Class<? extends INamesAreUniqueValidationHelper> bindIINamesAreUniqueValidationHelper() {
		return JDLNamesAreUniqueValidationHelper
	}
}
