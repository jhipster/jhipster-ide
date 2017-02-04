package ch.itemis.xdocker.tests

import ch.itemis.xdocker.xdocker.Xdocker
import com.google.inject.Inject
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.util.ParseHelper

@RunWith(XtextRunner)
@InjectWith(XdockerInjectorProvider)
class XdockerParsingTest{

	@Inject
	ParseHelper<Xdocker> parseHelper

	@Test 
	def void loadModel() {
		val result = parseHelper.parse('''
			FROM ubuntu:latest
		''')
		Assert.assertNotNull(result)
	}

}
