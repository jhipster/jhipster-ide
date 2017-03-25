/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.job

import ch.itemis.xdocker.ui.util.XdockerGeneratorHelper
import java.util.Stack
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtend.lib.annotations.Accessors

import static ch.itemis.xdocker.util.XdockerContants.*
import static org.eclipse.core.runtime.IStatus.*
import static xdockerdsl.ui.internal.XdockerdslActivator.*

/**
 * Xdocker Generate Job
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerGenerateJob extends AbstractXdockerJob {

	@Accessors var IFile dockerfile

	private static val JOB_NAME = 'Docker Generate Job'
	private static val ERR_GENERATING_DOCKERFILE = 'Error generating dockerfile'
	private static val TASK_GENERATING_DOCKERFILE = 'Generating dockerfile'
	private static val MSG_GENERATING_DOCKERFILE = TASK_GENERATING_DOCKERFILE + ':'

    @Accessors extension XdockerGeneratorHelper generator
    
	new() {
		super(JOB_NAME)
	}

	protected new(String name) {
		super(name)
	}

	override runInternal(IProgressMonitor monitor) {
		monitor.taskName = dockerfile.msg(TASK_GENERATING_DOCKERFILE)
		return callGenerator(dockerfile)
	}

	protected def XdockerJobStatus callGenerator(IFile it) {
		clearConsole
		val result = new Stack<XdockerJobStatus>
		try {
			if (name.equalsIgnoreCase(DOCKERFILE_NAME)) {
				val folder = workspace.root.getFolder(parent.fullPath);
				return XdockerJobStatus.createJobOkStatus(folder)
			}
			log(msg(MSG_GENERATING_DOCKERFILE))
			generate => [
				result.push(XdockerJobStatus.createJobOkStatus(it))	
				log('''Dockerfile genereated in folder «fullPath.toFile»''')
			]
		} catch (Exception ex) {
			log(msg(XdockerGenerateJob.ERR_GENERATING_DOCKERFILE))
			log(ex.message)
			result.push(new XdockerJobStatus(ERROR, CH_ITEMIS_XDOCKER_XDOCKER, ERROR, ERR_GENERATING_DOCKERFILE, ex))
			cancel
		}
		return result.pop
	}
	
	private def msg(IFile it, String msg) {
		return '''«msg» «fullPath.toString»'''
	}
}
