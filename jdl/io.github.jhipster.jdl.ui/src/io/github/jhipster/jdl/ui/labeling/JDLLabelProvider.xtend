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
package io.github.jhipster.jdl.ui.labeling

import com.google.inject.Inject
import io.github.jhipster.jdl.jdl.JdlApplication
import io.github.jhipster.jdl.jdl.JdlApplicationConfig
import io.github.jhipster.jdl.jdl.JdlApplicationEntitiesSelection
import io.github.jhipster.jdl.jdl.JdlApplicationParameter
import io.github.jhipster.jdl.jdl.JdlDeployment
import io.github.jhipster.jdl.jdl.JdlDeploymentParameter
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlOption
import io.github.jhipster.jdl.jdl.JdlRelation
import io.github.jhipster.jdl.jdl.JdlRelationship
import io.github.jhipster.jdl.jdl.JdlRelationships
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider

import static extension org.apache.commons.lang3.StringUtils.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JDLLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}
	
		
	def text(JdlEntity entity) {
		entity.name
	}

	def text(JdlRelationships rels) {
		rels.cardinality.literal
	}

	def text(JdlRelationship rel) {
		getRelationshipName(rel.source) + ' - ' + getRelationshipName(rel.target)
	}

	def getRelationshipName(JdlRelation rel) {
		return rel.entity.name;	
	}
	
	def text(JdlOption opt) {
		val it = opt.setting
		'Option: ' + switch (it) {
 			case isAngularSuffixOption : 'AngularSuffix'
 			case isDtoOption : 'DTO'
			case isMicroserviceOption : 'Microservice'
 			case isNoFluentMethodOption : 'NoFluentMethod'
 			case isPaginateOption : 'Paginate'
 			case isSearchOption : 'Search'
 			case isServiceOption : 'Service'
 			case isSkipServerOption : 'SkipServer'
 			case isSkipClientOption : 'SkipClient'
 			default : 'Unknown'	
		}
 	}

	def text(JdlApplicationParameter param) {
		try {
			param.paramName.literal.toFirstUpper.splitByCharacterTypeCamelCase.join(' ')
		} catch (Exception exception) {
			super.text(param)
		}
 	}

	def text(JdlApplication it) {
		'Application'
 	}

	def text(JdlApplicationConfig it) {
		'Config'
 	}

	def text(JdlDeployment it) {
		'Deployment'
 	}

	def text(JdlApplicationEntitiesSelection it) {
		'Entities'
 	}

	def text(JdlDeploymentParameter param) {
		try {
			param.paramName.literal.toFirstUpper.splitByCharacterTypeCamelCase.join(' ')
		} catch (Exception exception) {
			super.text(param)
		}
 	}
 	
	def image(EObject eObj) {
		eObj.eClass.name + '.gif'
	}
	
	def image(JdlRelationships rels) {
		val cardinality = rels.cardinality.literal
		switch (cardinality) {
 			case 'OneToMany' : 'one-to-many'
 			case 'ManyToOne' : 'many-to-one'
 			case 'OneToOne' : 'one-to-one'
 			case 'ManyToMany' : 'many-to-many'
 			default : 'Unknown'	
		} +'.gif'
	}
	
}
