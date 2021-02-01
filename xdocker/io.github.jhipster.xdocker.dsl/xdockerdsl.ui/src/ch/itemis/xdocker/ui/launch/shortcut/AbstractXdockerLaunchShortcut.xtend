/*******************************************************************************
 * Copyright (c) 2015-2021 Arcware GmbH (http://arcware.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.launch.shortcut

import ch.itemis.xdocker.ui.util.XdockerGeneratorHelper
import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.debug.ui.ILaunchShortcut
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.IEditorPart
import xdockerdsl.ui.internal.XdockerdslActivator

/**
 * Abstract Xdocker Class for launch shortcut allowing to launch Docker commands from IDE.
 * 
 * @author Serano Colameo - Initial contribution and API
 */
abstract class AbstractXdockerLaunchShortcut implements ILaunchShortcut {

    @Inject protected XdockerGeneratorHelper generator

    new() {
		val injector = XdockerdslActivator.getInstance().getInjector(XdockerdslActivator.CH_ITEMIS_XDOCKER_XDOCKER)
		if (injector !== null) injector.injectMembers(this)
    }	

    protected def void launch(IFile it) {
		createXdockerJob.schedule
    }

    override void launch(ISelection selection, String mode) {
        if (selection instanceof IStructuredSelection) {
            val dockerfile = selection.firstElement
	        if (dockerfile instanceof IFile) dockerfile.launch
        } // TODO else error here
    }

    override void launch(IEditorPart editor, String mode) {
        val dockerfile = editor?.editorInput?.getAdapter(IFile)
        if (dockerfile instanceof IFile) {
        	dockerfile.launch
        } // TODO else error here
    }

	protected abstract def Job createXdockerJob(IFile dockerfile)
}
