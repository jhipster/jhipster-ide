/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis-schweiz.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.job

import ch.itemis.xdocker.lib.DockerExtensions
import com.github.dockerjava.api.model.PullResponseItem
import com.github.dockerjava.core.command.PullImageResultCallback
import com.google.inject.Inject
import java.util.List
import java.util.Stack
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtend.lib.annotations.Accessors

import static ch.itemis.xdocker.ui.preference.XdockerDockerPreferences.*
import static org.eclipse.core.runtime.IStatus.*
import static xdockerdsl.ui.internal.XdockerdslActivator.*

/**
 * Xdocker Pull Image Job
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerPullImageJob extends AbstractXdockerJob {

	static val JOB_NAME = 'Docker Pull Images Job'
	static val ERR_PULL = 'Error pulling images from docker'
	static val TASK_PULL = 'Pulling images from docker...\n'
	
	@Accessors var List<String> images

	@Inject extension DockerExtensions docker

	new(List<String> images) {
		super(JOB_NAME)
		this.images = images
		this.docker = DockerExtensions.newInstance(dockerProperties)
	}

	override runInternal(IProgressMonitor monitor) {
		monitor.taskName = TASK_PULL
		return execute
	}

	private def XdockerJobStatus execute() {
		val result = new Stack<XdockerJobStatus>
		clearConsole
		// progressBar(true)
		docker [
			try {
				val callback = new PullImageResultCallback {
					override onNext(PullResponseItem item) {
						if (!item?.status.nullOrEmpty) log('''«item.status» «item.progress»''')
						else if (!item?.errorDetail.message.nullOrEmpty) {
							log(item?.errorDetail.message, false)
							result.push = new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, item.error, null)
						}
						else if (!item?.id.nullOrEmpty) log('''id is «item.id»''')
					}
					
					override onComplete() {
						close
						log('\nFinished!')
					}
					
					override onError(Throwable ex) {
						log(if (ex.message.nullOrEmpty) ex.cause.toString else ex.message)
						result.push = new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, ERR_PULL, ex)
					}
				}
				images.forEach[ image |
					pull(image, callback).awaitCompletion => [
						if (result.isEmpty) result.push = XdockerJobStatus.createJobOkStatus(it)
					]					
				] 
			} catch (Exception ex) {
				result.push = new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, ERR_PULL, ex)
				log('''«ERR_PULL»''')
				log(ex.message)
				cancel
			}
		]
		// progressBar.stopProgress
		return result.last
	}
}
