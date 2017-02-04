package ch.itemis.xdocker.ui.preference

import ch.itemis.xdocker.lib.DockerExtensions
import org.eclipse.jface.preference.BooleanFieldEditor
import org.eclipse.jface.preference.DirectoryFieldEditor
import org.eclipse.jface.preference.StringFieldEditor
import org.eclipse.swt.SWT
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Composite
import org.eclipse.xtext.ui.editor.preferences.AbstractPreferencePage
import xdockerdsl.ui.internal.XdockerdslActivator

import static ch.itemis.xdocker.ui.util.MessageUtil.*
import static org.eclipse.swt.widgets.Display.*

/** 
 * Xdocker Docker Preference Page Class
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerDockerPreferencePage extends AbstractPreferencePage implements XdockerPreferenceConstants {
	
	new() {
		preferenceStore = XdockerdslActivator.instance.preferenceStore
		description = 'Docker Preference Page'
	}
	
	/** 
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	override void createFieldEditors() {
		addField(new StringFieldEditor(P_Docker_URL, 'Docker URL:', fieldEditorParent)) 
		addField(new BooleanFieldEditor(P_Docker_EnableLoggingFilter, 'Enable Logging Filter', fieldEditorParent))
		addField(new DirectoryFieldEditor(P_Docker_CertPath, 'Docker Cert Path:', fieldEditorParent)) 
		addField(new DirectoryFieldEditor(P_Docker_CfgPath, 'Docker Config Path:', fieldEditorParent)) 
		addField(new StringFieldEditor(P_Docker_ServerAddress, 'Docker Server Address:', fieldEditorParent)) 
		addField(new StringFieldEditor(P_Docker_UserName, 'Docker User Name:', fieldEditorParent)) 
		addField(new StringFieldEditor(P_Docker_Password, 'Docker Psssword:', fieldEditorParent) {
			override protected doFillIntoGrid(Composite parent, int numColumns) {
				super.doFillIntoGrid(parent, numColumns)
	    	    textControl.echoChar = '*'
   		 	}
		})
	}
	
    override void contributeButtons(Composite parent) {
    	val title = 'Test Connection'
    	(parent.getLayout() as GridLayout).numColumns++
		new Button(parent, SWT.NONE) => [
	    	setText(title)
	    	addSelectionListener(new SelectionAdapter() {
		    	override void widgetSelected(SelectionEvent e) {
		      		DockerExtensions.newInstance(XdockerDockerPreferences.dockerProperties) => [
		      			try {
			      			ping // ping docker instance... 
			    	  		^default.asyncExec [info(title, 'Connection established successful!')]
		      			} catch (Exception ex) {
			      			^default.asyncExec [error(title, 'Error connecting to docker!')]
		      			}
		      		]
		      	}
		    })
		]
    }
}
