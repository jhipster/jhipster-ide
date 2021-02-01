/*******************************************************************************
 * Copyright (c) 2015-2021 Arcware GmbH (http://arcware.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.handler

import ch.itemis.xdocker.ui.util.XdockerGeneratorHelper
import com.google.inject.Inject
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.IHandler
import org.eclipse.core.resources.IFile
import org.eclipse.jface.text.ITextSelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.xtend.lib.annotations.Accessors

import static extension org.eclipse.ui.handlers.HandlerUtil.*

/**
 * AbstractXdockerHandler Class
 * 
 * @author Serano Colameo - Initial contribution and API
 */
abstract class AbstractXdockerHandler extends AbstractHandler implements IHandler {
	
    @Accessors @Inject extension XdockerGeneratorHelper generator

	/**
	 * Returns the selected dockerfile
	 */
	protected def IFile getDockerfile(ExecutionEvent it) {
		if (it === null) return null
		val selection = currentSelection
		return switch (selection) {
			IStructuredSelection: getFile(selection.firstElement) 
			ITextSelection: getFile(activeEditor?.editorInput?.getAdapter(IFile))
		}
	}
	
	private def IFile getFile(Object file) {
		return if (file instanceof IFile) file else null
	}

	override boolean isEnabled() {
		return true
	}
}
