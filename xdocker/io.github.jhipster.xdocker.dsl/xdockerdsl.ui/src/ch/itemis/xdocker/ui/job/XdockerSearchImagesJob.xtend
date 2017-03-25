/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.job

import ch.itemis.xdocker.lib.DockerExtensions
import com.google.inject.Inject
import java.util.Stack
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtend.lib.annotations.Accessors

import static ch.itemis.xdocker.ui.preference.XdockerDockerPreferences.*
import static org.eclipse.core.runtime.IStatus.*
import static xdockerdsl.ui.internal.XdockerdslActivator.*

/**
 * Xdocker Search Images Job
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerSearchImagesJob extends AbstractXdockerJob {

	static val JOB_NAME = 'Search Docker Images Job'
	static val ERR_SEARCHING = 'Error searching images from docker'
	static val TASK_SEARCHING = 'Searching images from docker...\n'

	@Accessors var String term
	@Accessors var boolean local = false

	@Inject extension DockerExtensions docker

	new() {
		this(null) // term must be initialized afterwards...
	}

	new(String term) {
		this(false, term)
	}

	new(boolean local, String term) {
		super(JOB_NAME)
		this.local = local
		this.term = term
		this.docker = DockerExtensions.newInstance(dockerProperties)
	}

	override runInternal(IProgressMonitor monitor) {
		monitor.taskName = TASK_SEARCHING
		return execute
	}

	private def XdockerJobStatus execute() {
		val result = new Stack<XdockerJobStatus>
		docker [
			try {
				(if (isLocal) images(term) else search(term)) => [
					result.push = XdockerJobStatus.createJobOkStatus(it)
				]
			} catch (Exception ex) {
				result.push = new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, ERR_SEARCHING, ex)
				log('''«ERR_SEARCHING»''')
				log(ex.message)
				cancel
			}
		]
		return result.last
	}
}
