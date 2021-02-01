/*******************************************************************************
 * Copyright (c) 2015-2021 Arcware GmbH (http://arcware.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.job

import ch.itemis.xdocker.lib.DockerExtensions
import ch.itemis.xdocker.lib.config.DockerBuildImageConfig
import com.github.dockerjava.api.model.BuildResponseItem
import com.github.dockerjava.core.command.BuildImageResultCallback
import java.util.Stack
import org.eclipse.core.resources.IFolder
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtend.lib.annotations.Accessors

import static ch.itemis.xdocker.ui.preference.XdockerDockerPreferences.*
import static ch.itemis.xdocker.util.XdockerContants.*
import static org.apache.commons.io.FileUtils.*
import static org.apache.commons.io.filefilter.DirectoryFileFilter.*
import static org.apache.commons.io.filefilter.FileFileFilter.*
import static org.apache.commons.io.filefilter.FileFilterUtils.*
import static org.eclipse.core.runtime.IStatus.*
import static xdockerdsl.ui.internal.XdockerdslActivator.*

/**
 * Xdocker Build Job
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerBuildJob extends XdockerGenerateJob {

	static val JOB_NAME = 'Docker Build Job'
	static val ERR_BUILDING_IMAGE = 'Error building Dockerfile'
	static val TASK_BUILDING_IMAGE = 'Building docker image, please wait this may take a while...'
	static val MSG_BUILDING_IMAGE = TASK_BUILDING_IMAGE+'\n'

	extension DockerExtensions docker

	@Accessors var DockerBuildImageConfig dockerCfg

	new() {
		super(JOB_NAME)
		this.docker = DockerExtensions.newInstance(dockerProperties)
	}
	
	override runInternal(IProgressMonitor monitor) {
		monitor.taskName = TASK_BUILDING_IMAGE
		return execute
	}

	private def XdockerJobStatus execute() {
		if (dockerfile?.location?.toString.nullOrEmpty || !dockerfile.exists) {
			log('Unknown build folder!')
			return new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, ERR_BUILDING_IMAGE, null)
		}
		var status = callGenerator(dockerfile) // call generator first...
		return if (status !== null && status.OK && status.argument instanceof IFolder) {
			val buildFolder = status.argument as IFolder
			copyResourcesTo(buildFolder)
			callBuilder(buildFolder) 
		} else status
	}
	
	override protected canceling() {
		super.canceling() // TODO: Implement me!
	}
	
	private def XdockerJobStatus callBuilder(IFolder buildFolder) {
		val result = new Stack<XdockerJobStatus>
		docker [
			try {
				val callback = new BuildImageResultCallback {
					override onNext(BuildResponseItem item) {
						if (!item?.stream.nullOrEmpty) log(item.stream)
						else if (!item?.status.nullOrEmpty) log('''«item.status» «item.progress»''')
						else if (!item?.error.nullOrEmpty) {
							log(item.error)
							result.push = new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, item.error, null)
						}
						else if (!item?.id.nullOrEmpty) log('''id is «item.id»''')
					}

					override onComplete() {
						close
						log('\nFinished!')
					}
					
					override onError(Throwable ex) {
						log(if(ex.message.nullOrEmpty) ex.cause.toString else ex.message)
						result.push = new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, ERR_BUILDING_IMAGE, ex)
					}
				}
				val dockerFileOrFolder = buildFolder.location.toFile.toString
				log('''Build folder: «dockerFileOrFolder»''')
				log(MSG_BUILDING_IMAGE)
				build(dockerFileOrFolder, dockerCfg, callback).awaitCompletion => [
					if (result.isEmpty) result.push = XdockerJobStatus.createJobOkStatus(it)
				]
			} catch (Exception ex) {
				log('''«ERR_BUILDING_IMAGE» in «buildFolder»''')
				log(ex.message)
				result.push = new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, ERR_BUILDING_IMAGE, ex)
				cancel
			}
		]
		return result.pop
	}
	
	private def void copyResourcesTo(IFolder buildFolder) {
		val dstdir = buildFolder.location.toFile
		val srcdir = dockerfile.location.toFile.parentFile
		if (srcdir.equals(dstdir)) return // src and dst are the same... so nothing to copy!
		val fileFilter = notFileFilter(and(FILE, suffixFileFilter('.' + XDOCKER_EXTENSION)))
		val dirFilter = notFileFilter(and(DIRECTORY, suffixFileFilter(srcdir.name)))
		copyDirectory(srcdir, dstdir, and(fileFilter, dirFilter))				
	}
}
