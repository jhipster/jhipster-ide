/** 
 * Copyright (c) 2015-2021 Arcware GmbH (http://arcware.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ch.itemis.xdocker.ui.view

import ch.itemis.xdocker.ui.job.AbstractXdockerJob
import ch.itemis.xdocker.ui.job.XdockerJobStatus
import org.eclipse.core.runtime.jobs.IJobChangeEvent
import org.eclipse.core.runtime.jobs.IJobChangeListener
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Display
import org.eclipse.ui.part.ViewPart
import org.eclipse.ui.part.WorkbenchPart
import org.eclipse.xtend.lib.annotations.Accessors

/** 
 * Abstract Xdocker Browser View
 * @author Serano Colameo - Initial contribution and API
 */
abstract class AbstractXdockerBrowserView extends ViewPart {
	@Accessors var Composite parent

	/** 
	 * Create contents of the view part.
	 */
	def void createControls(Composite parent) {}
	
	override void dispose() {}

	/*
	 * (non-Javadoc)
	 * 
	 * @see WorkbenchPart#setFocus()
	 */
	override void setFocus() {
		parent.layout(true)
	}

	protected static class JobChangeListener implements IJobChangeListener {
		AbstractXdockerJob job
		AbstractXdockerBrowserView view

		/** 
		 * @param job
		 */
		new(AbstractXdockerBrowserView view, AbstractXdockerJob job) {
			super()
			this.job = job
			this.view = view
		}

		override void sleeping(IJobChangeEvent event) {}
		override void scheduled(IJobChangeEvent event) {}
		override void running(IJobChangeEvent event) {}

		override void done(IJobChangeEvent event) {
			if (job.getResult() instanceof XdockerJobStatus) {
				Display::getDefault().asyncExec((
					[|view.processResult(job.getResult() as XdockerJobStatus)] as Runnable))
			}

		}

		override void awake(IJobChangeEvent event) {}
		override void aboutToRun(IJobChangeEvent event) {}
	}

	def protected abstract void processResult(XdockerJobStatus status)
}
