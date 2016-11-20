/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.launch.shortcut

import ch.itemis.xdocker.lib.config.DockerRunConfig
import ch.itemis.xdocker.ui.job.XdockerBuildJob
import java.util.List
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.CoreException
import org.eclipse.debug.core.DebugPlugin
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.ui.DebugUITools
import org.eclipse.xtend.lib.annotations.Data

import static ch.itemis.xdocker.ui.util.MessageUtil.*
import static com.google.common.base.CaseFormat.*

import static extension ch.itemis.xdocker.ui.job.AbstractXdockerJob.*

/**
 * Xdocker run launch shortcut allowing to build a Dockerfile from IDE.
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerRunLaunchShortcut extends AbstractXdockerLaunchShortcut {

	override protected createXdockerJob(IFile dockerfile) {
		XdockerBuildJob.create(#{
			'dockerfile' -> dockerfile, 
			'generator' -> generator
		})		
	}
	
	def launch(String mode, XdockerRunLaunchConfigData cfgData) {
		if (cfgData.image.nullOrEmpty)
			error('Launch Error', 'Could not determine the Docker image that should be executed!')
		else if (cfgData.command.nullOrEmpty)
			error('Launch Error', 'Could not determine the command that should be executed!')
		else try {
			val configs = DebugPlugin.getDefault.launchManager.launchConfigurations
			val config = configs.findFirst[cfgData.configEquals(it)] ?: cfgData.createConfiguration
			DebugUITools.launch(config, mode)
		} catch (CoreException e) {
			error("Problem running xdocker!", e.message)
		}
	}		
}

@Data class XdockerRunLaunchConfigData {
	static val (String)=>String defAttr = ['''«XdockerRunLaunchConfigData.package.name».«UPPER_CAMEL.to(UPPER_UNDERSCORE, it)»''']
	
	public static val CONFIG_TYPE = 'ch.itemis.xdocker.ui.XdockerRunLaunchConfigType'
	public static val ATTR_IMAGE = defAttr.apply('image')
	public static val ATTR_CMD = defAttr.apply('command')
	public static val ATTR_PARAMS = defAttr.apply('hasParams')
	public static val ATTR_NAME = defAttr.apply('name')
	public static val ATTR_PORT_SPEC = defAttr.apply('port_spec')
	public static val ATTR_TTY = defAttr.apply('tty')
	public static val ATTR_DETACHED = defAttr.apply('detached')
	public static val ATTR_STDIN = defAttr.apply('stdin')
	public static val ATTR_ATTACH_STDOUT = defAttr.apply('attach_stdout')
	public static val ATTR_ATTACH_STDERR = defAttr.apply('attach_stderr')
	public static val ATTR_PUPLISH_PORTS = defAttr.apply('publish_ports')
	public static val ATTR_REMOVE = defAttr.apply('remove')
	
	val String image
	val String command
	val Boolean hasParams
	val String name
	val String[] portSpecs
	val Boolean tty
	val Boolean detached
	val Boolean stdin
	val Boolean attachStdout
	val Boolean attachStderr
	val Boolean publishPorts
	val Boolean remove
	
	def createConfiguration()  {
		val launchManager = DebugPlugin.getDefault.launchManager
		val configName = launchManager?.generateLaunchConfigurationName(image)
		val configType = launchManager?.getLaunchConfigurationType(CONFIG_TYPE)
		if (configType != null) {
			configType.newInstance(null, configName) => [
				setAttribute(ATTR_IMAGE, image)
				setAttribute(ATTR_CMD, command)
// Disable refresh by default		
//				setAttribute(RefreshTab.ATTR_REFRESH_SCOPE, "${workspace}")
//				setAttribute(RefreshTab.ATTR_REFRESH_RECURSIVE, false)
				// all other attributes are optional!
				doSave
			]
		} else error('Invalid Configuration', 'Could not find configuration of type: ' + CONFIG_TYPE)
	}

	def configEquals(ILaunchConfiguration it) {
		type.identifier.equals(CONFIG_TYPE) &&
		getAttribute(ATTR_IMAGE, '').equals(image) &&
		getAttribute(ATTR_CMD, '').equals(command)
	}
	
	def isValid() {
		!image.nullOrEmpty && !command.nullOrEmpty
	}
	
	def static toDockerConfig(ILaunchConfiguration it) {
		val image = getAttribute(ATTR_IMAGE, '')
		val command = getAttribute(ATTR_CMD, '')
		val hasParams = getAttribute(ATTR_PARAMS, false)
		val name = getAttribute(ATTR_NAME, '')
		val portSpecs = getAttribute(ATTR_PORT_SPEC, '').split(' ')
		val tty = hasParams && getAttribute(ATTR_TTY, false)
		val detached = hasParams && getAttribute(ATTR_DETACHED, false)
		val stdin = hasParams && getAttribute(ATTR_STDIN, false)
		val attachStdout = hasParams && getAttribute(ATTR_ATTACH_STDOUT, false)
		val attachStderr = hasParams && getAttribute(ATTR_ATTACH_STDERR, false)
		val publishPorts = hasParams && getAttribute(ATTR_PUPLISH_PORTS, false)
		val remove = hasParams && getAttribute(ATTR_REMOVE, false)
		return new DockerRunConfig(
			image, command, hasParams, name, portSpecs, tty, detached,  
			stdin, attachStdout, attachStderr, publishPorts, remove
		)
	}
}