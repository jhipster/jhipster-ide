/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis-schweiz.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.job

import ch.itemis.xdocker.lib.DockerExtensions
import com.google.inject.Inject
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import java.text.DateFormat
import java.util.Calendar
import java.util.List
import java.util.Stack
import org.eclipse.core.runtime.IProgressMonitor

import static ch.itemis.xdocker.ui.preference.XdockerDockerPreferences.*
import static org.eclipse.core.runtime.IStatus.*
import static xdockerdsl.ui.internal.XdockerdslActivator.*

/**
 * Xdocker Info Job
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerInfoJob extends AbstractXdockerJob {

	static val JOB_NAME = 'Docker Info Job'
	static val ERR_GETTING_INFO = 'Error getting info from docker!\n\nPlease verify if docker daemon is running properly!\n'
	static val MSG_GETTING_INFO = 'Please wait while connecting to docker...\n'
	static val TASK_GETTING_INFO = 'Getting info from docker...\n'
	
	@Inject extension DockerExtensions docker

	new() {
		super(JOB_NAME)
		this.docker = DockerExtensions.newInstance(dockerProperties)
	}

	override runInternal(IProgressMonitor monitor) {
		monitor.taskName = TASK_GETTING_INFO
		return execute
	}

	private def XdockerJobStatus execute() {
		val result = new Stack<XdockerJobStatus>
		clearConsole
		docker [
			try {
				log(MSG_GETTING_INFO)
				info => [
					if (it === null) throw new IllegalStateException('Result object is null!')					
					val status = XdockerJobStatus.createJobOkStatus(
						'''
							Containers: «containers»
							Images: «images»
							Storage Driver: «driver»
							 «FOR it : driverStatuses»
							 	«IF (it instanceof List<?>)»
							 	  «toString.replaceAll('\\[|\\]', '').replaceAll(',', ':')»
								«ENDIF»
							 «ENDFOR»
							Execution Driver: «executionDriver»
							Logging Driver: 
							Kernel Version: «kernelVersion»
							Operating System: «operatingSystem»
							CPUs: «NCPU»
							Total Memory: «BigDecimal.valueOf(memTotal).divide(BigDecimal.valueOf(
								1073741824
							)).round(new MathContext(4, RoundingMode.HALF_UP))» GiB
							Name: «name»
							ID: «id»
							Debug mode (server): «debug»
							File Descriptors: «NFd»
							Goroutines: «NGoroutines»
							System Time: «systime»
							Init SHA1: «initSha1»
							Init Path: «initPath»
							Docker Root Dir: «dockerRootDir»
							Index Server Address: «indexServerAddress»
						'''
					)
					log('Docker Info:\n============')
					log(status.getArgument.toString)
					result.push = status
				]
			} catch (Exception ex) {
				result.push = new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, ERR_GETTING_INFO, ex)
				log('''«ERR_GETTING_INFO»''')
				log(ex.message)
				cancel
			}
		]
		return result.last
	}
	
	private def String systime() {
		val Calendar cal = Calendar.getInstance()
	   	val DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM)		
	  	return df.format(cal.time)
	}
}
