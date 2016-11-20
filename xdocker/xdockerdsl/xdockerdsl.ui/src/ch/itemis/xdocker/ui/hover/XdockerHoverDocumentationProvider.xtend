/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.hover

import org.eclipse.xtext.ui.editor.hover.html.DefaultHoverDocumentationProvider
import org.eclipse.emf.ecore.EObject
import ch.itemis.xdocker.xdocker.FromStatement

/**
 * @author Serano Colameo - Initial contribution and API
 *
 */
class XdockerHoverDocumentationProvider extends DefaultHoverDocumentationProvider {
	
	override getDocumentation(EObject it) {
		switch (eContainer) {
			FromStatement: '''
				The <code>FROM</code> instruction sets the Base Image for subsequent instructions.
				As such, a valid Dockerfile must have <code>FROM</code> as its first instruction.
				The image can be any valid image – it is especially easy to start by
				pulling an image from the Public Repositories. <code>FROM</code> must be the first
				non-comment instruction in the Dockerfile.
				<code>FROM</code> can appear multiple times within a single Dockerfile in order to
				create multiple images. Simply make a note of the last image ID output
				by the commit before each new <code>FROM</code> command. The tag or digest values
				are optional. If you omit either of them, the builder assumes a latest
				by default. The builder returns an error if it cannot match the tag
				value.
			'''.toString
			default: super.getDocumentation(it)
		}
	}
	
}