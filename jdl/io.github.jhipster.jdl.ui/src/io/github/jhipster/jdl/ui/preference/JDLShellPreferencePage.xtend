package io.github.jhipster.jdl.ui.preference

import io.github.jhipster.jdl.ui.JdlActivator
import org.eclipse.core.runtime.Assert
import org.eclipse.jface.preference.StringFieldEditor
import org.eclipse.jface.text.Document
import org.eclipse.jface.text.source.SourceViewerConfiguration
import org.eclipse.jface.text.source.projection.ProjectionViewer
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.eclipse.xtext.ui.editor.preferences.AbstractPreferencePage

import static io.github.jhipster.jdl.ui.preference.JDLPreferenceProperties.*

class JDLShellPreferencePage extends AbstractPreferencePage {
	
	var ProjectionViewer shellEditor

	new() {
		preferenceStore = JdlActivator.instance.preferenceStore
		description = 'Set preferences for calling JHipster generator'
	}

	override protected createFieldEditors() {
		val script = preferenceStore.getString(SCRIPT)
		fieldEditorParent => [
			addField(new StringFieldEditor(P_Shell, COMMAND, it))
			shellEditor = createEditor(it, script, SCRIPT)
		]
	}

	override protected performApply() {
		store
		super.performApply()
	}
	
	override performOk() {
		store
		super.performOk()
	}
	
	def private store() {
		preferenceStore.setValue(SCRIPT, shellEditor.textWidget.text)
	}

	def private createEditor(Composite parent, String content, String labelText) {
		Assert.isNotNull(labelText)
        new Label(parent, SWT.TOP) => [
        	font = parent.font
			text = labelText
        ]
		val viewer = createViewer(parent) => [
			editable = true
			addTextListener[] // TODO: implement me!
			addSelectionChangedListener[] // TODO: implement me!
		]
		val doc = viewer.document => [
			if (it !== null) set(content) else viewer.document = new Document(content)
		]
		val (int)=>int nlines = [l | if (l < 5) 5 else if (l > 12) 12 else l]
		new GridData(GridData.FILL_BOTH) => [
			widthHint = convertWidthInCharsToPixels(80)
			heightHint = convertHeightInCharsToPixels(nlines.apply(doc.numberOfLines))
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
