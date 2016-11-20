/** 
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ch.itemis.xdocker.ui.dialogs

import java.util.ArrayList
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.jface.viewers.ILabelProvider
import org.eclipse.jface.viewers.ITreeContentProvider
import org.eclipse.jface.viewers.Viewer
import org.eclipse.swt.widgets.Shell
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog
import org.eclipse.ui.dialogs.ISelectionStatusValidator
import org.eclipse.ui.model.WorkbenchLabelProvider

import static xdockerdsl.ui.internal.XdockerdslActivator.*
import static org.eclipse.core.resources.ResourcesPlugin.*

/** 
 * Xdocker File Selection Dialog
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerFileSelectionDialog extends ElementTreeSelectionDialog {
	static final IStatus OK = new Status(IStatus.OK, CH_ITEMIS_XDOCKER_XDOCKER, 0, '', null)
	static final IStatus ERROR = new Status(IStatus.ERROR, CH_ITEMIS_XDOCKER_XDOCKER, 0, '', null)
	
	String[] patterns
	
	static ITreeContentProvider contentProvider = new ITreeContentProvider() {
		override Object[] getChildren(Object element) {
			if (element instanceof IContainer) {
				return element.members
			}
			return null
		}

		override Object getParent(Object element) {
			return (element as IResource).parent
		}

		override boolean hasChildren(Object element) {
			return element instanceof IContainer
		}

		override Object[] getElements(Object input) {
			return input as Object[]
		}

		override void dispose() {
		}

		override void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
	
	/*
	 * Validator
	 */
	ISelectionStatusValidator validator = [ Object[] selection |
		return if(selection.length === 1 && selection.last instanceof IFile &&
				  isAccepted(selection.last as IFile)) OK else ERROR
	]

	new(Shell parent, String title, String message, String[] type) {
		this(parent, workspace.root.projects, title, message, type)
	}

	new(Shell parent, IProject[] projects, String title, String message, String[] type) {
		this(parent, WorkbenchLabelProvider.decoratingWorkbenchLabelProvider, contentProvider)
		this.patterns = type
		setTitle(title)
		setMessage(message)
		setInput(computeInput(projects))
		setValidator(validator)
	}

	new(Shell parent, ILabelProvider labelProvider, ITreeContentProvider contentProvider) {
		super(parent, labelProvider, contentProvider)
	}

	/*
	 * Show projects
	 */
	def private Object[] computeInput(IProject[] projects) {
		/*
		 * Refresh projects tree.
		 */
		for (var int i = 0; i < projects.length; i++) {
			try {
				projects.get(i).refreshLocal(IResource.DEPTH_INFINITE, null)
			} catch (CoreException e) {
				// do not handle exception here
			}
		}
		
		workspace.root.refreshLocal(IResource.DEPTH_ONE, null)
		
		var openProjects = new ArrayList<IProject>(projects.length)
		for (var int i = 0; i < projects.length; i++) {
			if (projects.get(i).isOpen) {
				openProjects.add(projects.get(i))
			}
		}
		return openProjects.toArray
	}

	/*
	 * Check file extension
	 */
	def private boolean isAccepted(IFile it) {
		if (it == null) return false
		return patterns.exists[ p |
			val ext = fileExtension ?: ''
			(p.startsWith('*.') && p.endsWith(ext)) || p.equals(name)
		]
	}
}
