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
package io.github.jhipster.jdl.generator.lib

import java.lang.annotation.ElementType
import java.lang.annotation.Target
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.Visibility
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.EObject
import io.github.jhipster.jdl.jdl.JdlDomainModel
import java.nio.file.Path
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.EList

/**
 * Extracts an interface for all locally declared public methods.
 * 
 * @author Serano Colameo - Initial contribution and API
 */
@Target(ElementType.TYPE)
@Active(JdlGeneratorProcessor)
annotation JdlGeneratorAnnotation {
}

/**
 * JdlGenerator Class
 */
class JdlGeneratorProcessor extends AbstractClassProcessor {

	override doTransform(MutableClassDeclaration clazz, extension TransformationContext context) {
		
		clazz.addConstructor[
			body = '''
				init();
			'''
		]
		clazz.addMethod('init', [
			body = '''
				try {
					new io.github.jhipster.jdl.JDLStandaloneSetup().createInjectorAndDoEMFRegistration();
				} catch (Exception ex) {
					new «IllegalStateException.newTypeReference»("Could not initialize standalone setup!", ex);
				}
			'''
		]) => [
			it.final = true
			it.visibility = Visibility.PRIVATE
		]
		
		clazz.addMethod('load', [
			primarySourceElement = it
			visibility = Visibility.PUBLIC
			addParameter('jdlFilePath', Path.newTypeReference)
			static = true
			body = '''
				«URI.newTypeReference» uri = «URI».createURI(jdlFilePath.toFile().toURI().toString());
				«Resource.newTypeReference» resource = new «ResourceSetImpl.newTypeReference»().getResource(uri, true);
				«EList.newTypeReference(EObject.newTypeReference)» contents = resource != null ? resource.getContents() : null;
				«EObject.newTypeReference» element = «IterableExtensions.newTypeReference».<EObject>head(contents);
				return (element instanceof JdlDomainModel) ? ((JdlDomainModel) element) : null;
			'''
			returnType = JdlDomainModel.newTypeReference
		])
	}
}
