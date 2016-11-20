/** 
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ch.itemis.xdocker.ui.launch

import ch.itemis.xdocker.ui.dialogs.XdockerFileSelectionDialog
import ch.itemis.xdocker.ui.dialogs.XdockerImageSelectionDialog
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab
import org.eclipse.jdt.ui.JavaElementLabelProvider
import org.eclipse.jface.window.Window
import org.eclipse.swt.events.ModifyEvent
import org.eclipse.swt.events.ModifyListener
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.events.SelectionListener
import org.eclipse.swt.graphics.Image
import org.eclipse.ui.dialogs.ElementListSelectionDialog

import static ch.itemis.xdocker.util.XdockerContants.*

/** 
 * Abstract Xdocker LaunchConfigurationTab Class
 * 
 * @author Serano Colameo - Initial contribution and API
 */
abstract class AbstractXdockerLaunchConfigurationTab extends AbstractLaunchConfigurationTab {
	
	val listener = new ModifyListener {
		override modifyText(ModifyEvent e) {
			launchConfigurationDialog.updateButtons
		}
	}
	
	protected def listener() {
		return listener
	}
	
	protected static abstract class DefaultSelectionListener implements SelectionListener {
		override widgetDefaultSelected(SelectionEvent e) {
			// nothing todo here...
		}
	}
	
	/**
	 * Wrapper Class for Xdocker Projects
	 */
	private static class XdockerProject {
		val IProject project

		new(IProject project) {
			this.project = project
		}

		override String toString() {
			return project.getName()
		}
	}
	
	/**
	 * Label Provider for Xdocker Project
	 */
	private static class XdockerProjectElementLabelProvider extends JavaElementLabelProvider {
		override void dispose() {
			super.dispose()
		}

		override Image getImage(Object element) {
			return switch (element) {
				XdockerProject: super.getImage(element.project)
				default: super.getImage(element)
			}
		}

		override String getText(Object element) {
			return switch (element) {
				XdockerProject: element.toString()
				default: super.getText(element)
			}
		}
	}

	/**
	 * Call this method to choose a project
	 * 
	 * @return selection - IProject 
	 */
	def protected IProject chooseXdockerProject() {
		val dialog = new ElementListSelectionDialog(shell, new XdockerProjectElementLabelProvider) => [
			title = 'Project'
			message = 'Choose Project'
			ResourcesPlugin.workspace.root => [ ws |
				elements = ws.projects.map[new XdockerProject(it)]
			]
		]
		return if (dialog.open === Window.OK && dialog.firstResult instanceof XdockerProject) 
			(dialog.firstResult as XdockerProject).project
	}

	/**
	 * Call this method to choose a project
	 * 
	 * @return selection - IProject 
	 */
	def protected IFile chooseXdockerFile(String projectName) {
		val ws = ResourcesPlugin.workspace.root
		val IProject[] projects = if (projectName.nullOrEmpty) ws.getProjects() else #[ws.getProject(projectName)]
		val dialog = new XdockerFileSelectionDialog(shell, projects, 'Xdocker File', 'Choose Xdocker File', #['*.' + XDOCKER_EXTENSION])
		return if (dialog.open === Window.OK && dialog.firstResult instanceof IFile) dialog.firstResult as IFile
	}
	
	/**
	 * Call this method to choose a project
	 * 
	 * @return selection - IProject 
	 */
	def protected String chooseDockerImage() {
		val dialog = new XdockerImageSelectionDialog(shell, 'Docker Images...', 'Choose a docker image') 
		dialog.initialPattern = '?'
		return if (dialog.open === Window.OK && dialog.firstResult instanceof String) dialog.firstResult as String
	}
}
