package io.github.jhipster.jdl.ui.preference

import io.github.jhipster.jdl.ui.JdlActivator
import org.eclipse.jface.preference.StringFieldEditor
import org.eclipse.jface.text.Document
import org.eclipse.jface.text.source.SourceViewerConfiguration
import org.eclipse.jface.text.source.projection.ProjectionViewer
import org.eclipse.swt.SWT
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.events.SelectionListener
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.FileDialog
import org.eclipse.swt.widgets.Label
import org.eclipse.xtext.ui.editor.preferences.AbstractPreferencePage

import static io.github.jhipster.jdl.ui.preference.JDLPreferenceProperties.*
import static org.eclipse.core.runtime.Assert.*
import static org.eclipse.debug.internal.ui.SWTFactory.*

class JDLShellPreferencePage extends AbstractPreferencePage {
	
	var ProjectionViewer shellEditor
	var Button browseProgramButton

	new() {
		preferenceStore = JdlActivator.instance.preferenceStore
		description = 'Set preferences for calling JHipster generator'
	}

	override protected createFieldEditors() {
		fieldEditorParent => [
			val maingrp = createGroup(it, SHELL, 1, 1, GridData.FILL_HORIZONTAL) => [
				enabled = true
			]
			val execField = new StringFieldEditor(P_Exec, EXEC, maingrp) => [
				addField
			]
			addField(new StringFieldEditor(P_Args, ARGS, maingrp))
			browseProgramButton = createPushButton(it, 'Browse', null) => [
				addSelectionListener = new SelectionListener {
					override widgetDefaultSelected(SelectionEvent e) { /* nothing todo */ }
					override widgetSelected(SelectionEvent e) {
						new FileDialog(shell, SWT.OPEN) => [
					        execField.stringValue = open
						]
					}
				}
			]
			createGroup(it, SCRIPT, 2, 2, GridData.FILL_HORIZONTAL) => [group|
				group.enabled = true
				shellEditor = createEditor(group, store.getString(P_Script), null) 
			]
		]
	}

	override protected performApply() {
		save
		super.performApply()
	}
	
	override performOk() {
		save
		super.performOk()
	}
	
	def private save() {
		store.setValue(P_Script, shellEditor.textWidget.text)
	}
	
	def private store() {
		preferenceStore
	}

	def private createEditor(Composite parent, String content, String labelText) {
		isNotNull(parent)
		if (!labelText.isNullOrEmpty) {
	        new Label(parent, SWT.TOP) => [
	        	font = parent.font
				text = labelText
	        ]
		}
		val viewer = createViewer(parent) => [
			editable = true
			document.set(content)
		]
		new GridData(GridData.FILL_BOTH) => [
			widthHint = convertWidthInCharsToPixels(80)
			heightHint = convertHeightInCharsToPixels(20)
			viewer.control.layoutData = it
		]
		return viewer
	}

	def private createViewer(Composite parent) {
		return new ProjectionViewer(
			parent, null, null, false,
			SWT.BORDER.bitwiseOr(SWT.V_SCROLL).bitwiseOr(SWT.H_SCROLL)
		) => [
			configure = new SourceViewerConfiguration
			document = new Document
		]
	}
}
