/**
 * Copyright 2016-2022 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.ui.tests

import io.github.jhipster.jdl.ui.internal.JdlActivator
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractOutlineTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Serano Colameo - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(JDLUiInjectorProvider))
class OutlineTest extends AbstractOutlineTest {

	override protected getEditorId() {
		JdlActivator.IO_GITHUB_JHIPSTER_JDL_JDL
	}

	@Test def void testOutline() {
		'''
			entity Address {
			  street String required,
			  streetNr Integer required
			}
			
			entity Person {
			  firstName String required,
			  lastName String required
			}

			relationship OneToMany {
			  Address to Person
			}
			
			dto * with mapstruct except A
		'''.assertAllLabels(
			'''
				Address
				  street
				  streetNr
				Person
				  firstName
				  lastName
				OneToMany
				  Address - Person
				Option: DTO
				Authority
				  name
				User
				  firstName
				  lastName
				  login
				  email
				  imageUrl
				  authorities
			'''
		)
	}

	@Test def void testOutlineWithSkipUserManagement() {
		''' // skip-user-management
			entity Address {
			  street String required,
			  streetNr Integer required
			}
			
			entity Person {
			  firstName String required,
			  lastName String required
			}

			relationship OneToMany {
			  Address to Person
			}
			
			dto * with mapstruct except A
		'''.assertAllLabels(
			'''
				Address
				  street
				  streetNr
				Person
				  firstName
				  lastName
				OneToMany
				  Address - Person
				Option: DTO
			'''
		)
	}
}
