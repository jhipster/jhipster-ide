/** 
 * Copyright (c) 2015-2021 Arcware GmbH (http://arcware.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ch.itemis.xdocker.ui.dialogs

import ch.itemis.xdocker.lib.DockerExtensions
import java.lang.reflect.InvocationTargetException
import java.util.Collections
import java.util.Comparator
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.jface.dialogs.IDialogSettings
import org.eclipse.jface.dialogs.ProgressMonitorDialog
import org.eclipse.jface.operation.IRunnableWithProgress
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.Shell
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter
import org.eclipse.xtend.lib.annotations.Accessors
import xdockerdsl.ui.internal.XdockerdslActivator

import static ch.itemis.xdocker.ui.preference.XdockerDockerPreferences.*

/** 
 * Abstract Xdocker Selection Dialog
 * 
 * @author Serano Colameo - Initial contribution and API
 */
abstract class AbstractXdockerSelectionDialog extends FilteredItemsSelectionDialog {
	static final String MSG_SUFFIX = ' (? = any character, * = any string):'

	@Accessors protected val content = <String>newHashSet
	@Accessors protected extension DockerExtensions docker = DockerExtensions.newInstance(dockerProperties)
	
	new(Shell shell, String title, String message) {
		super(shell, false)
		setTitle(title)
		setMessage(message + MSG_SUFFIX)
		result = Collections.EMPTY_LIST
	}

	def abstract protected IRunnableWithProgress runnable(ExecutorService executorService)

	def private void execute() {
		val executor = Executors.newSingleThreadExecutor()
		val operation = executor.runnable
		try {
			var progess = new ProgressMonitorDialog(shell) {
				override protected void cancelPressed() {
					super.cancelPressed
					executor.shutdownNow
					docker.close
					close
				}
				override protected void configureShell(Shell shell) {
					super.configureShell(shell)
					shell.setText("Please wait while contacting Docker...")
				}
			}
			progess.run(true, true, operation)
		} catch (InvocationTargetException e) {
			e.printStackTrace()
		} catch (InterruptedException e) {
			e.printStackTrace()
		}
	}

	override protected Control createExtendedContentArea(Composite parent) {
		return null
	}

	override protected IDialogSettings getDialogSettings() {
		var IDialogSettings settings = XdockerdslActivator.getInstance().getDialogSettings().getSection(class.simpleName)
		if (settings === null) {
			settings = XdockerdslActivator.getInstance().getDialogSettings().addNewSection(class.simpleName)
		}
		return settings
	}

	override protected IStatus validateItem(Object item) {
		return Status.OK_STATUS
	}

	override protected ItemsFilter createFilter() {
		return new ItemsFilter() {
			override boolean matchItem(Object item) {
				return matches(item.toString)
			}
			override boolean isConsistentItem(Object item) {
				return true
			}
		}
	}

	override protected Comparator<Object> getItemsComparator() {
		return [Object arg0, Object arg1 | 
			arg0.toString.compareTo(arg1.toString)
		]
	}

	override protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter,
		IProgressMonitor progressMonitor) throws CoreException {
		progressMonitor.beginTask("Searching", content.size)
		for (String image : content) {
			contentProvider.add(image, itemsFilter)
			progressMonitor.worked = 1
		}
		progressMonitor.done
	}

	override String getElementName(Object item) {
		return item.toString
	}

	override open() {
		execute
		super.open
	}
}