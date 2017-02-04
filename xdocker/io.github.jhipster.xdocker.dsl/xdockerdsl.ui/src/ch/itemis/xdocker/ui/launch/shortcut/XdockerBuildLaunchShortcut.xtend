/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.launch.shortcut

import ch.itemis.xdocker.lib.config.DockerBuildImageConfig
import ch.itemis.xdocker.ui.job.XdockerBuildJob
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.CoreException
import org.eclipse.debug.core.DebugPlugin
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.ui.DebugUITools
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.IFileEditorInput
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.ui.editor.XtextEditor

import static ch.itemis.xdocker.ui.util.MessageUtil.*
import static com.google.common.base.CaseFormat.*

import static extension ch.itemis.xdocker.ui.job.AbstractXdockerJob.*

/**
 * Xdocker build launch shortcut allowing to build a Dockerfile from IDE.
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerBuildLaunchShortcut extends AbstractXdockerLaunchShortcut {

	override protected createXdockerJob(IFile dockerfile) {
		XdockerBuildJob.create(#{
			'dockerfile' -> dockerfile, 
			'generator' -> generator
		})		
	}

	override launch(ISelection selection, String mode) {
        if (selection instanceof IStructuredSelection) {
            val dockerfile = selection.firstElement
	        if (dockerfile instanceof IFile) {
				val project = dockerfile.project.name
				val xdocker = dockerfile.projectRelativePath.toString
				val info = new XdockerBuildLaunchConfigData(project, xdocker, null, null, null, null, null, null)
				launch(mode, info)
				return
			}
		} else super.launch(selection, mode)
	}

	override launch(IEditorPart editor, String mode) {
		if (editor instanceof XtextEditor) {
			if (editor.editorInput instanceof IFileEditorInput) {
				val project = (editor.editorInput as IFileEditorInput).file.project.name
				val xdocker = (editor.editorInput as IFileEditorInput).file.projectRelativePath.toString
				val cfgData = new XdockerBuildLaunchConfigData(project, xdocker, null, null, null, null, null, null)
				launch(mode, cfgData)
				return
			}
		}
		error('Wrong Editor!', 'Please open file with Xdocker Editor!')
	}
	
	def launch(String mode, XdockerBuildLaunchConfigData cfgData) {
		if (cfgData.xdockerFileName.nullOrEmpty)
			error('Launch Error', 'Could not determine the Xdocker file that should be executed!')
		else if (cfgData.project.nullOrEmpty)
			error('Launch Error', 'Could not determine the project that should be executed!')
		else try {
			val configs = DebugPlugin.getDefault.launchManager.launchConfigurations
			val config = configs.findFirst[cfgData.configEquals(it)] ?: cfgData.createConfiguration
			DebugUITools.launch(config, mode)
		} catch (CoreException e) {
			error("Problem running xdocker!", e.message)
		}
	}		
}

@Data class XdockerBuildLaunchConfigData {
	val static (String)=>String defAttr = ['''«XdockerBuildLaunchConfigData.package.name».«UPPER_CAMEL.to(UPPER_UNDERSCORE, it)»''']
	
	public val static CONFIG_TYPE = 'ch.itemis.xdocker.ui.XdockerBuildImageLaunchConfigType'
	public val static ATTR_PROJECT = defAttr.apply('project')
	public val static ATTR_XDOCKER = defAttr.apply('xdocker')
	public val static ATTR_PARAMS = defAttr.apply('hasParams')
	public val static ATTR_TAG = defAttr.apply('tag')
	public val static ATTR_NOCACHE = defAttr.apply('noCache')
	public val static ATTR_RM = defAttr.apply('rm')
	public val static ATTR_QUIET = defAttr.apply('quiet')
	public val static ATTR_PULL = defAttr.apply('pull')
	
	val String project
	val String xdockerFileName
	val Boolean hasParams
	val String tag
	val Boolean noCache
	val Boolean rm
	val Boolean quiet
	val Boolean pull
	
	def createConfiguration()  {
		val launchManager = DebugPlugin.getDefault.launchManager
		val configName = launchManager?.generateLaunchConfigurationName(project)
		val configType = launchManager?.getLaunchConfigurationType(CONFIG_TYPE)
		if (configType !== null) {
			configType.newInstance(null, configName) => [
				setAttribute(ATTR_PROJECT, project)
				setAttribute(ATTR_XDOCKER, xdockerFileName)
// Disable refresh by default		
//				setAttribute(RefreshTab.ATTR_REFRESH_SCOPE, "${workspace}")
//				setAttribute(RefreshTab.ATTR_REFRESH_RECURSIVE, true)
				// all other attributes are optional!
				doSave
			]
		} else error('Invalid Configuration', 'Could not find configuration of type: ' + CONFIG_TYPE)
	}

	def configEquals(ILaunchConfiguration it) {
		type.identifier.equals(CONFIG_TYPE) &&
		getAttribute(ATTR_PROJECT, '').equals(project) &&
		getAttribute(ATTR_XDOCKER, '').equals(xdockerFileName)
	}
	
	def isValid() {
		!xdockerFileName.nullOrEmpty && !project.nullOrEmpty
	}
	
	def static toDockerConfig(ILaunchConfiguration it) {
		val project = getAttribute(ATTR_PROJECT, '')
		val xdocker = getAttribute(ATTR_XDOCKER, '')
		val hasParams = getAttribute(ATTR_PARAMS, false)
		val tag = getAttribute(ATTR_TAG, '')
		val noCache = getAttribute(ATTR_NOCACHE, false)
		val rm = getAttribute(ATTR_RM, false)
		val quiet = getAttribute(ATTR_QUIET, false)
		val pull = getAttribute(ATTR_PULL, false)
		return new DockerBuildImageConfig(project, xdocker, hasParams, tag, noCache, rm, quiet, pull)
	}
}