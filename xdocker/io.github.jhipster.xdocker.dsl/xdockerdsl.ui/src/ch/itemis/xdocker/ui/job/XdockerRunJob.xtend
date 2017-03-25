/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.job

import ch.itemis.xdocker.lib.DockerExtensions
import ch.itemis.xdocker.lib.config.DockerRunConfig
import com.github.dockerjava.api.model.Frame
import com.github.dockerjava.core.command.LogContainerResultCallback
import com.google.inject.Inject
import java.util.Stack
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtend.lib.annotations.Accessors

import static ch.itemis.xdocker.ui.preference.XdockerDockerPreferences.*
import static ch.itemis.xdocker.util.AnsiUtil.*
import static org.eclipse.core.runtime.IStatus.*
import static xdockerdsl.ui.internal.XdockerdslActivator.*

/**
 * Xdocker Run Job
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerRunJob extends AbstractXdockerJob {

	private static val JOB_NAME = 'Docker Run Job'
	private static val ERR_RUN_CMD = 'Error in executing docker run command'
	private static val MSG_RUN_CMD = 'Please wait while connecting to docker...\n'
	private static val TASK_RUN_CMD = 'Running command in docker...\n'
	
	@Inject extension DockerExtensions docker

	@Accessors var String image
	@Accessors var String command
	@Accessors var DockerRunConfig dockerCfg

	new() {
		super(JOB_NAME)
		this.docker = DockerExtensions.newInstance(dockerProperties)
	}

	override runInternal(IProgressMonitor monitor) {
		monitor.taskName = TASK_RUN_CMD
		return execute
	}

	private def XdockerJobStatus execute() {
		val result = new Stack<XdockerJobStatus>
		val logstr = new StringBuffer
		clearConsole
		docker [
			try {
				log(MSG_RUN_CMD)
				val callback = new LogContainerResultCallback {
					override onNext(Frame item) {
						logstr.append(stripAnsi(item.payload))
					}
					override onError(Throwable ex) {
						log(if (ex.message.nullOrEmpty) ex.cause.toString else ex.message)
						result.push = new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, ERR_RUN_CMD, ex)
					}
					override onComplete() {
						close // close stream in completion
						log(logstr.toString)
					}
				}
				run(image, command, dockerCfg) => [ containerId |
					if (!containerId.nullOrEmpty) {
						log('Started and executed successfully:')
						log('''CONTAINER ID:		IMAGE:			COMMAND:''')
						log('''«containerId.substring(0,12)»		«image»		«command»''')
						logContainer(containerId, callback)
						if (dockerCfg !== null && dockerCfg.remove) removeContainer(containerId, false)
						result.push = XdockerJobStatus.createJobOkStatus(it)
					} else log(ERR_RUN_CMD)
				]
			} catch (Exception ex) {
				result.push = new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, ERR_RUN_CMD, ex)
				log('''«ERR_RUN_CMD»''')
				log(ex.message)
				cancel
			}
		]
		return result.last
	}
}
