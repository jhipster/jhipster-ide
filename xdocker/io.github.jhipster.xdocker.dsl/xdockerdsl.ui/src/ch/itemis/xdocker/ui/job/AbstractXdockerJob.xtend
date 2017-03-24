/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.job

import ch.itemis.xdocker.ui.console.XdockerConsoleLogger
import com.google.inject.Inject
import java.util.Map
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2

import static ch.itemis.xdocker.util.AssertUtil.*

import static extension org.apache.commons.beanutils.BeanUtils.*

/**
 * Xdocker Abstract Class
 * 
 * @author Serano Colameo - Initial contribution and API
 */
abstract class AbstractXdockerJob extends Job {

	@Accessors private var Procedure2<? super AbstractXdockerJob, ? super XdockerJobStatus> block

	@Inject protected extension XdockerConsoleLogger console = XdockerConsoleLogger.INSTANCE
	
	new(String name) {
		super(name)
	}
	
	def public static AbstractXdockerJob create(Class<? extends AbstractXdockerJob> job) {
		return job.newInstance
	}

	def public static AbstractXdockerJob create(Class<? extends AbstractXdockerJob> job, Map<String, Object> args) {
		return job.create => [
			assertArguments(args)
			populate(args)
		]
	}

	def public AbstractXdockerJob execute(Procedure2<? super AbstractXdockerJob, ? super XdockerJobStatus> block) {
		setBlock(block)
		schedule
		return this
	}	
	
	override IStatus run(IProgressMonitor monitor) {
		return monitor.runInternal => [
			block?.apply(this, it)
		]	
	}

	abstract protected def XdockerJobStatus runInternal(IProgressMonitor monitor)	
}
