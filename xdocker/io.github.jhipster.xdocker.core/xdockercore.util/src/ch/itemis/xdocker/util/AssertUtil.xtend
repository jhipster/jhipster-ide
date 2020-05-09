/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis-schweiz.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.util

import org.eclipse.core.resources.IFile
import java.util.Map

/**
 * Assert Utility Class
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class AssertUtil {
	
	def static assertArguments(extension Map<String, Object> args) {
		assertArgNotNull('args', args)
		keySet.forEach[ val v = get
			switch (v) {
				String: assertArgNotNullOrEmpty(v)
				default: assertArgNotNull(v)
			}
		]
	}
	
	def static assertArgNotNullOrEmpty(String it, Object arg) {
		assertArgNotNull(arg)
		assertArgNotEmpty(arg)
	}	

	def static assertArgNotNull(String name, Object arg) {
		if (arg === null) {
			throw new IllegalArgumentException('''Argument [«name»] cannot be null!''')
		}
	}	

	def static assertArgNotEmpty(String name, Object arg) {
		if (arg === null || arg.toString.nullOrEmpty) {
			throw new IllegalArgumentException('''String argument [«name»] cannot be empty!''')
		}
	}	

	def static assertFileExists(String it, IFile file) {
		assertArgNotNull(file)
		if (file.exists == false) {
			throw new IllegalArgumentException('''File [«file.location.toString»] does not exists!''')
		}
	}
}