/** 
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis-schweiz.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ch.itemis.xdocker.ui.dialogs

import org.eclipse.jface.dialogs.IMessageProvider
import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.widgets.Text

import static org.eclipse.swt.SWT.*

/** 
 * Creates a scrollable dialog message box
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerScrollableDialog extends TitleAreaDialog {
	var String title
	var String subtitle
	var String message
	var int messageType

	def static showInfoBox(Shell shell, String title, String subtitle, String message) {
		return new XdockerScrollableDialog(
			shell, title, subtitle, message, IMessageProvider.INFORMATION
		) => [
			create
			open
		]
	}

	private new(Shell shell, String title, String subtitle, String message, int messageType) {
		super(shell)
		this.title = title
		this.subtitle = subtitle
		this.message = message
		this.messageType = messageType
	}

	override protected Control createDialogArea(Composite parent) {
		// Let the ialog create the parent composite
		var composite = super.createDialogArea(parent) as Composite
		var gridData = new GridData
		gridData.grabExcessHorizontalSpace = true
		gridData.horizontalAlignment = GridData.FILL
		gridData.grabExcessVerticalSpace = true // Layout vertically, too!
		gridData.verticalAlignment = GridData.FILL
		var Text scrollable = new Text(
			composite, BORDER.bitwiseOr(V_SCROLL).
							  bitwiseOr(H_SCROLL).
							  bitwiseOr(READ_ONLY)
		)
		scrollable.layoutData = gridData
		scrollable.text = message
		return composite
	}

	override void create() {
		super.create
		/*
		 * This is not necessary; the dialog will become bigger as the text
		 * grows but at the same time, the user will be able to see all (or at
		 * least more) of the error message at once
		 */
		// getShell().setSize(300, 300);
		setTitle(title)
		setMessage(subtitle, messageType)
	}

	override protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, OK, "OK", true) => [
			addSelectionListener(new SelectionAdapter() {
				override void widgetSelected(SelectionEvent e) {
					close
				}
			})
		]
	}

	/**
	 * allow the user to change the dialog size
	 */ 
	override protected boolean isResizable() {
		return true 
	}
}
