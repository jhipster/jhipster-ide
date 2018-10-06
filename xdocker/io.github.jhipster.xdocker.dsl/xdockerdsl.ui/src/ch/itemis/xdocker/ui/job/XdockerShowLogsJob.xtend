/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.job

import ch.itemis.xdocker.lib.DockerExtensions
import com.github.dockerjava.api.model.Frame
import com.github.dockerjava.core.command.LogContainerResultCallback
import com.google.inject.Inject
import java.util.List
import java.util.Stack
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtend.lib.annotations.Accessors

import static ch.itemis.xdocker.ui.preference.XdockerDockerPreferences.*
import static ch.itemis.xdocker.util.AnsiUtil.*
import static org.eclipse.core.runtime.IStatus.*
import static xdockerdsl.ui.internal.XdockerdslActivator.*

/**
 * Xdocker Show Logs of a Container Job
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerShowLogsJob extends AbstractXdockerJob {

	static val JOB_NAME = 'Docker Show Logs Job'
	static val ERR_GETTING_LOGS = 'Error getting logs from docker'
	static val MSG_GETTING_LOGS = 'Please wait while getting logs from docker...\n'
	static val TASK_GETTING_LOGS = 'Getting logs from docker...\n'
	
	@Accessors var List<String> containerIds = newArrayList

	@Inject extension DockerExtensions docker

	new(List<String> containerIds) {
		super(JOB_NAME)
		this.containerIds.addAll(containerIds)
		this.docker = DockerExtensions.newInstance(dockerProperties)
	}

	override runInternal(IProgressMonitor monitor) {
		monitor.taskName = TASK_GETTING_LOGS
		return execute
	}

	private def XdockerJobStatus execute() {
		val result = new Stack<XdockerJobStatus>
		clearConsole
		docker [
			try {
				log(MSG_GETTING_LOGS)
				val callback = new LogContainerResultCallback {
					val logstr = new StringBuffer
					override onNext(Frame item) {
						logstr.append(stripAnsi(item.payload))
					}
					override onError(Throwable ex) {
						log(if (ex.message.nullOrEmpty) ex.cause.toString else ex.message)
						result.push = new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, ERR_GETTING_LOGS, ex)
					}
					override onComplete() {
						close // close stream in completion
						val message = logstr.toString
						if (message.nullOrEmpty) log('Container returned an empty log!') 
						else {
							log(message)
							log('End of log')
						}
					}
				}
				logContainers(containerIds, callback)
				result.push = XdockerJobStatus.createJobOkStatus
			} catch (Exception ex) {
				result.push = new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, XdockerShowLogsJob.ERR_GETTING_LOGS, ex)
				log('''«XdockerShowLogsJob.ERR_GETTING_LOGS»''')
				log(ex.message)
				cancel
			}
		]
		return result.last
	}
}
