/*******************************************************************************
 * Copyright (c) 2015-2021 Arcware GmbH (http://arcware.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.job

import ch.itemis.xdocker.lib.DockerExtensions
import com.google.inject.Inject
import java.util.Arrays
import java.util.List
import java.util.Stack
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtend.lib.annotations.Accessors

import static ch.itemis.xdocker.ui.preference.XdockerDockerPreferences.*
import static org.eclipse.core.runtime.IStatus.*
import static xdockerdsl.ui.internal.XdockerdslActivator.*

/**
 * Xdocker Stop Container Job
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerStopCntnrJob extends AbstractXdockerJob {

	static val JOB_NAME = 'Docker Stop Container Job'
	static val ERR_STOP_CONTAINER = 'Error stopping container from docker'
	static val TASK_STOP_CONTAINER = 'Stopping container from docker...\n'
	
	@Accessors var List<String> containerIds = newArrayList

	@Inject extension DockerExtensions docker

	new(String containerId) {
		this(Arrays.asList(containerId))
	}

	new(List<String> containerIds) {
		super(JOB_NAME)
		this.containerIds.addAll(containerIds)
		this.docker = DockerExtensions.newInstance(dockerProperties)
	}

	override runInternal(IProgressMonitor monitor) {
		monitor.taskName = TASK_STOP_CONTAINER
		return execute
	}

	private def XdockerJobStatus execute() {
		val result = new Stack<XdockerJobStatus>
		docker [
			try {
				stopContainers(containerIds)
				result.push = XdockerJobStatus.createJobOkStatus
			} catch (Exception ex) {
				result.push = new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, ERR_STOP_CONTAINER, ex)
				log('''«ERR_STOP_CONTAINER»''')
				log(ex.message)
				cancel
			}
		]
		return result.last
	}
}
