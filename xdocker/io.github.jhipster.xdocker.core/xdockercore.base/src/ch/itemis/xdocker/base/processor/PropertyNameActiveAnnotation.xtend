/*******************************************************************************
 * Copyright (c) 2015-2021 Arcware GmbH (http://arcware.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.base.processor

import java.lang.annotation.ElementType
import java.lang.annotation.Target
import java.util.HashMap
import java.util.List
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.Visibility

/**
 * Configuration property active annotation.
 * 
 * @author Serano Colameo - Initial contribution and API
 */

@Target(ElementType.FIELD)
@Active(ConfigPropertyProcessor)
annotation ConfigProperty {
	String value = ''
}

/**
 * Configuration property active annotation processor class.
 */
class ConfigPropertyProcessor extends AbstractFieldProcessor {

	override doTransform(List<? extends MutableFieldDeclaration> annotatedfields, extension TransformationContext context) {
		try {
			annotatedfields.head.declaringType => [
				enhanceClass(annotatedfields, context)
			]
		} catch (Exception ex) {
			annotatedfields.forEach[addError('Error processing annotation => ' + ex.message)]
		}
	}

	def private enhanceClass(MutableTypeDeclaration declaringType, List<? extends MutableFieldDeclaration> annotatedfields, extension TransformationContext context) {
		declaringType.addMethod('convert') [
			static = true
			visibility = Visibility.PRIVATE
			val typeParam = addTypeParameter('T')
			returnType = newTypeReference(typeParam)
			addParameter('obj', Object.newTypeReference)
			addParameter('type', typeof(Class).newTypeReference)
			body = '''
				if (obj == null) return null;
				return (T)org.apache.commons.beanutils.ConvertUtils.convert(obj, type);
			'''
			primarySourceElement = it
		]
		
		declaringType.addConstructor[
        	val propsType = typeof(HashMap).newTypeReference(String.newTypeReference, Object.newTypeReference)
		   	addParameter("params", propsType)
			body = '''
				this(
					«FOR field : annotatedfields SEPARATOR ','»
						 convert(params.get("«field.simpleName»"), «field.type.simpleName».class)
					«ENDFOR»
				);
			'''
			primarySourceElement = it
		]

		declaringType.addMethod('getParameters') [
			docComment = 'Returns all parameters annotated with @' + ConfigProperty.simpleName
        	returnType = typeof(HashMap).newTypeReference(String.newTypeReference, Object.newTypeReference)
			body = '''
				«returnType.simpleName» params = new «returnType.name»();
				«FOR field : annotatedfields»
					params.put("«field.propertyName»", get«field.simpleName.toFirstUpper»());
				«ENDFOR»
				return params;
			'''
			primarySourceElement = it
		]
	}

   def private String getPropertyName(MutableFieldDeclaration it) {
   		if (it === null || annotations.isNullOrEmpty) return null
		val propName = annotations.head.getValue('value')?.toString
		return if (propName.isNullOrEmpty) simpleName else propName
   }
}
