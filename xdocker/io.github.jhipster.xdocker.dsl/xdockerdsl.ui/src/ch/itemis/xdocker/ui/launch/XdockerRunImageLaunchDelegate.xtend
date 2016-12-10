/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.launch

import ch.itemis.xdocker.ui.console.XdockerConsoleLogger
import ch.itemis.xdocker.ui.util.XdockerGeneratorHelper
import ch.itemis.xdocker.ui.job.XdockerRunJob
import ch.itemis.xdocker.ui.launch.shortcut.XdockerRunLaunchConfigData
import com.google.inject.Inject
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.debug.core.ILaunch
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.model.LaunchConfigurationDelegate
import org.eclipse.debug.ui.RefreshTab
import org.eclipse.swt.widgets.Display

import static ch.itemis.xdocker.ui.util.MessageUtil.*

import static extension ch.itemis.xdocker.ui.job.AbstractXdockerJob.*
import static ch.itemis.xdocker.ui.launch.shortcut.XdockerRunLaunchConfigData.*
import xdockerdsl.ui.internal.XdockerdslActivator

/**
 * Xdocker run container delegating class
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerRunImageLaunchDelegate extends LaunchConfigurationDelegate {
	val static console = XdockerConsoleLogger.INSTANCE
	val static ERR_TITLE = 'Error launching Docker Build Image Job'
	val static ERR_MSG = 'Wrong launcher definition - project and Xdocker file must be defined and accessible!'	
	
    @Inject protected XdockerGeneratorHelper generator

    new() {
		val injector = XdockerdslActivator.getInstance().getInjector(XdockerdslActivator.CH_ITEMIS_XDOCKER_XDOCKER)
		if (injector != null) injector.injectMembers(this)
    }	
	
	override launch(ILaunchConfiguration cfg, String mode,
		            ILaunch launch, IProgressMonitor monitor) {
		val image = cfg.getAttribute(ATTR_IMAGE, '')
		var command = cfg.getAttribute(ATTR_CMD, '') 
		if (command.nullOrEmpty) command = ' '
		val dockerCfg = XdockerRunLaunchConfigData.toDockerConfig(cfg)
		if (!image.nullOrEmpty) {
			XdockerRunJob.create(#{
				'image' -> image,	
				'command' -> command, // note: command is optional
				'dockerCfg' -> dockerCfg
			}) => [
				execute [it, result |
					// refresh after job has finished
					if (result != null && result.isOK && 
						RefreshTab.getRefreshScope(cfg) != null) {
						try {
							RefreshTab.refreshResources(cfg, monitor)
						} catch (CoreException e) {
							console.log(e.message)
						}
					}
				]
			]
		} else Display.^default.asyncExec [
			error(ERR_TITLE, ERR_MSG)
	    ]
	}
}

