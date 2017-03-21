/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.job

import ch.itemis.xdocker.lib.DockerExtensions
import ch.itemis.xdocker.ui.console.XdockerConsoleLogger
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
 * Xdocker Remove Image Job
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerRemoveImageJob extends AbstractXdockerJob {

	static val JOB_NAME = 'Docker Remove Image Job'
	static val ERR_RM_IMAGE = 'Error removing image from docker'
	static val TASK_RM_IMAGE = 'Removing image from docker...\n'
	
	@Accessors var List<String> imageIds = newArrayList

	@Inject extension DockerExtensions docker
	@Inject extension XdockerConsoleLogger console = XdockerConsoleLogger.INSTANCE

	new(String imageId) {
		this(Arrays.asList(imageId))
	}

	new(List<String> imageIds) {
		super(JOB_NAME)
		this.imageIds.addAll(imageIds)
		this.docker = DockerExtensions.newInstance(dockerProperties)
	}

	override runInternal(IProgressMonitor monitor) {
		monitor.taskName = XdockerRemoveImageJob.TASK_RM_IMAGE
		return execute
	}

	private def XdockerJobStatus execute() {
		val result = new Stack<XdockerJobStatus>
		docker [
			try {
				removeImages(imageIds)
				result.push = XdockerJobStatus.createJobOkStatus
			} catch (Exception ex) {
				result.push = new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, XdockerRemoveImageJob.ERR_RM_IMAGE, ex)
				log('''«XdockerRemoveImageJob.ERR_RM_IMAGE»''')
				log(ex.message)
				cancel
			}
		]
		return result.last
	}
}
