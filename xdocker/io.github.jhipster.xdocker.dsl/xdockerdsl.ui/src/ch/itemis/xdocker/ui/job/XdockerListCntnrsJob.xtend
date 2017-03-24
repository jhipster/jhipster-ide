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

//KEEP THIS
//import com.github.dockerjava.api.model.Container
//import static org.apache.commons.lang.StringUtils.*

/**
 * Xdocker List Containers Job
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerListCntnrsJob extends AbstractXdockerJob {

	static val JOB_NAME = 'Docker Info Job'
	static val ERR_CNT_LIST = 'Error getting container list from docker'
	static val TASK_CNT_LIST = 'Getting list of containers from docker...\n'
/**	
 * Keep this for the moment!
 * 
	static val MSG_CNT_LIST = 'Please wait while connecting to docker...\n'
	static val HEADER_COLUMNS = #['CONTAINER ID','IMAGE','COMMAND','STATUS', 'PORTS'].toArray
	static val (Object[])=>String formatter = [ String.format('%-14s%-20s%-20s%-30s%s', it)]
	static val HEADER = formatter.apply(HEADER_COLUMNS)
	static val (Container)=>String BODY = [
		formatter.apply( #[
			substring(id, 0, 12), abbreviate(image, 0, 19), abbreviate(command, 0, 19),  
			abbreviate(status, 0, 29), ports.toString.replaceAll('\\[|\\]','')
		])
	]
*/
	@Accessors var boolean listAll

	@Inject extension DockerExtensions docker

	new() {
		this(false)
	}

	new(boolean listAll) {
		super(JOB_NAME)
		this.listAll = listAll
		this.docker = DockerExtensions.newInstance(dockerProperties)
	}

	override runInternal(IProgressMonitor monitor) {
		monitor.taskName = TASK_CNT_LIST
		return execute
	}

	private def XdockerJobStatus execute() {
		val result = new Stack<XdockerJobStatus>
		docker [
			try {
				containers(listAll) => [
					result.push = XdockerJobStatus.createJobOkStatus(it)
				]
			} catch (Exception ex) {
				result.push = new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, ERR_CNT_LIST, ex)
				log('''«ERR_CNT_LIST»''')
				log(ex.message)
				cancel
			}
		]
		return result.last
	}
}
