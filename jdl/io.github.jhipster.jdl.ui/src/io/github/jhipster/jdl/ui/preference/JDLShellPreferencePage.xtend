package io.github.jhipster.jdl.ui.preference

import io.github.jhipster.jdl.ui.JdlActivator
import java.nio.file.Files
import java.nio.file.Paths
import org.eclipse.jface.preference.BooleanFieldEditor
import org.eclipse.jface.preference.StringFieldEditor
import org.eclipse.jface.text.Document
import org.eclipse.jface.text.source.SourceViewerConfiguration
import org.eclipse.jface.text.source.projection.ProjectionViewer
import org.eclipse.jface.util.PropertyChangeEvent
import org.eclipse.swt.SWT
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.events.SelectionListener
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.FileDialog
import org.eclipse.swt.widgets.Group
import org.eclipse.swt.widgets.Label
import org.eclipse.xtext.ui.editor.preferences.AbstractPreferencePage

import static io.github.jhipster.jdl.ui.preference.JDLPreferenceProperties.*
import static org.eclipse.core.runtime.Assert.*
import static org.eclipse.debug.internal.ui.SWTFactory.*
import static org.eclipse.jface.dialogs.MessageDialog.*

class JDLShellPreferencePage extends AbstractPreferencePage {
	
	Group shellgrp
	Button browseProgramButton
	BooleanFieldEditor shellEnabledField
	StringFieldEditor execField
	StringFieldEditor argsField
	ProjectionViewer shellScriptEditor

	new() {
		preferenceStore = JdlActivator.instance.preferenceStore
		description = 'JHipster shell integration'
	}

	override propertyChange(PropertyChangeEvent event) {
		switch (event.source) {
			case execField: {
				val exec = event.newValue?.toString
				exec.checkExecutable
			}
			case shellEnabledField: {
				enableWidgets(shellEnabledField.booleanValue)
			}
		}
	}

	def private enableWidgets(boolean value) {
		#[browseProgramButton, shellgrp, shellScriptEditor.textWidget].forEach[
			enabled = value
		]
	}

	def private boolean checkExecutable() {
		checkExecutable(execField?.stringValue)
	}

	def private boolean checkExecutable(String exec) {
		if (!exec.isNullOrEmpty) {
			if (!Files.isExecutable(Paths.get(exec))) {
				Display.^default.asyncExec([
			 		openError(shell, 'Error setting executable', '''File '«exec»' is not an executable!''')   	
				])
				return false
	 		}
		}
		return true
	}

	override protected createFieldEditors() {
		fieldEditorParent => [
			shellEnabledField = new BooleanFieldEditor(P_ShellEnabled, SCRIPT_CHECKBOX, SWT.NONE, it) => [
				addField
			]
			shellgrp = createGroup(it, SHELL, 1, 1, GridData.FILL_HORIZONTAL) => [
				enabled = true
			]
			execField = new StringFieldEditor(P_Exec, EXEC, shellgrp) => [
				addField
			]
			browseProgramButton = createPushButton(it, 'Browse...', null) => [
				addSelectionListener = new SelectionListener {
					override widgetDefaultSelected(SelectionEvent e) { /* nothing todo */ }
					override widgetSelected(SelectionEvent e) {
						new FileDialog(shell, SWT.OPEN) => [
							filterPath = executable
							val result = open
							if (!result.isNullOrEmpty) execField.stringValue = result
						]
					}
				}
			]
			argsField = new StringFieldEditor(P_Args, ARGS, shellgrp) => [
				addField
			]
			createGroup(it, SCRIPT, 2, 2, GridData.FILL_HORIZONTAL) => [group|
				group.enabled = true
				shellScriptEditor = createEditor(group, store.getString(P_Script), null) => [
					editable = true
				]
			]
			enableWidgets(preferenceStore.getBoolean(P_ShellEnabled))
		]
	}

	def private String getExecutable() {
		execField?.stringValue		
	}

	def private String getShellScript() {
		shellScriptEditor?.textWidget?.text		
	}

	override protected performApply() {
		save
	}
	
	override performOk() {
		return if (save) super.performOk() else false
	}
	
	def private validate() {
		checkExecutable		
	}
	
	def private save() {
		return validate => [ succeeded |
			if (succeeded) {
				store.setValue(P_Script, shellScript)
			}
		]
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
