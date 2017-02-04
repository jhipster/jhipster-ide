package io.github.jhipster.jdl.ui.tests

import io.github.jhipster.jdl.ui.internal.JdlActivator
import org.eclipse.xtext.junit4.ui.AbstractOutlineTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

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
				User
			'''
		)
	}
}
