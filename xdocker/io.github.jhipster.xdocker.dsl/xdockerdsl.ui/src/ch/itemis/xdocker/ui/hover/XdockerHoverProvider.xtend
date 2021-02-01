/*******************************************************************************
 * Copyright (c) 2015-2021 Arcware GmbH (http://arcware.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.hover

import ch.itemis.xdocker.xdocker.FromStatement
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider

/**
 * Xdocker Hover Provider
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerHoverProvider extends DefaultEObjectHoverProvider {

	override protected getFirstLine(EObject it) {
		switch (eContainer) {
			FromStatement: '<b><code>FROM</code></b> &lt;image&gt; | &lt;image&gt;:&lt;tag&gt; | &lt;image&gt;@&lt;digest&gt;'
			default: super.getFirstLine(it)
		}
	}
		
}