package io.github.jhipster.jdl.ui.wizard

import java.net.URI
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IWorkspace
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Path
import org.eclipse.jface.dialogs.Dialog
import org.eclipse.jface.util.BidiUtils
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.wizard.WizardPage
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Event
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Listener
import org.eclipse.swt.widgets.Text
import org.eclipse.ui.IWorkingSet
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.dialogs.WorkingSetGroup
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin
import org.eclipse.ui.internal.ide.IIDEHelpContextIds
import org.eclipse.ui.internal.ide.dialogs.ProjectContentsLocationArea
import io.github.jhipster.jdl.ui.internal.JdlActivator

import static io.github.jhipster.jdl.ui.util.ResourceManager.getPluginImage
import static org.eclipse.jface.resource.ImageDescriptor.createFromImage
import static io.github.jhipster.jdl.ui.preference.JDLPreferenceProperties.*

@SuppressWarnings("restriction") 
class AbstractJDLWizardNewProjectCreationPage extends WizardPage {
	String ICON = "icons/JHipster.gif"
	String SYMBOLIC_NAME = "io.github.jhipster.jdl.ui"
	// initial value stores
	String initialProjectFieldValue
	Button btnCallJhipsterGenerator
	// widgets
	package Text projectNameField
	ProjectContentsLocationArea locationArea
	WorkingSetGroup workingSetGroup

	protected String projectName
	protected String location
	
	Listener nameModifyListener = [ Event e |
		setLocationForSelection()
		var boolean valid = validatePage()
		setPageComplete(valid)
	]

	static final int SIZING_TEXT_FIELD_WIDTH = 250

	new(String pageName) {
		super(pageName)
		setPageComplete(false)
		setImageDescriptor(createFromImage(getPluginImage(SYMBOLIC_NAME, ICON)))
	}

	override void createControl(Composite parent) {
		var Composite composite = new Composite(parent, SWT.NULL)
		initializeDialogUnits(parent)
		PlatformUI.workbench.helpSystem.setHelp(composite, IIDEHelpContextIds.NEW_PROJECT_WIZARD_PAGE)
		composite.setLayout(new GridLayout())
		composite.setLayoutData(new GridData(GridData.FILL_BOTH))
		createProjectNameGroup(composite)
		locationArea = new ProjectContentsLocationArea(getErrorReporter(), composite)
		if (initialProjectFieldValue !== null) {
			locationArea.updateProjectName(initialProjectFieldValue)
		}
		// Scale the button based on the rest of the dialog
		setButtonLayoutData(locationArea.getBrowseButton())
		setPageComplete(validatePage())
		// Show description on opening
		setErrorMessage(null)
		setMessage(null)
		setControl(composite)
		Dialog.applyDialogFont(composite)
	}

	def WorkingSetGroup createWorkingSetGroup(Composite composite, IStructuredSelection selection,
		String[] supportedWorkingSetTypes) {
		if (workingSetGroup !== null) return workingSetGroup
		workingSetGroup = new WorkingSetGroup(composite, selection, supportedWorkingSetTypes)
		return workingSetGroup
	}

	def private getErrorReporter() {
		return [ String errorMessage, boolean infoOnly |
			if (infoOnly) {
				setMessage(errorMessage, IStatus.INFO)
				setErrorMessage(null)
			} else
				setErrorMessage(errorMessage)
			var boolean valid = errorMessage === null
			if (valid) {
				valid = validatePage()
			}
			setPageComplete(valid)
		]
	}

	def private final void createProjectNameGroup(Composite parent) {
		val isShellEnabled = JdlActivator.instance.preferenceStore.getBoolean(P_ShellEnabled)
		// project specification group
		var Composite projectGroup = new Composite(parent, SWT.NONE)
		var GridLayout layout = new GridLayout()
		layout.numColumns = 2
		projectGroup.setLayout(layout)
		projectGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL))
		// new project label
		var Label projectLabel = new Label(projectGroup, SWT.NONE)
		projectLabel.setText(IDEWorkbenchMessages.WizardNewProjectCreationPage_nameLabel)
		projectLabel.setFont(parent.getFont())
		// new project name entry field
		projectNameField = new Text(projectGroup, SWT.BORDER)
		var GridData data = new GridData(GridData.FILL_HORIZONTAL)
		data.widthHint = SIZING_TEXT_FIELD_WIDTH
		projectNameField.setLayoutData(data)
		projectNameField.setFont(parent.getFont())
		if (isShellEnabled) {
			btnCallJhipsterGenerator = new Button(projectGroup, SWT.CHECK)
			btnCallJhipsterGenerator.setText("Bootstrap project")
			btnCallJhipsterGenerator.setSelection(true)
		}
		
		// Set the initial value first before listener
		// to avoid handling an event during the creation.
		if (initialProjectFieldValue !== null) {
			projectNameField.setText(initialProjectFieldValue)
		}
		projectNameField.addListener(SWT.Modify, nameModifyListener)
		BidiUtils.applyBidiProcessing(projectNameField, BidiUtils.BTD_DEFAULT)
	}

	def IPath getLocationPath() {
		return new Path(locationArea.getProjectLocation())
	}

	def URI getLocationURI() {
		return locationArea.getProjectLocationURI()
	}

	def IProject getProjectHandle() {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectName())
	}

	def String getProjectName() {
		if (projectNameField === null) {
			return initialProjectFieldValue
		}
		return getProjectNameFieldValue()
	}

	def private String getProjectNameFieldValue() {
		if (projectNameField === null) {
			return "" // $NON-NLS-1$
		}
		return projectNameField.getText().trim()
	}

	def void setInitialProjectName(String name) {
		if (name === null) {
			initialProjectFieldValue = null
		} else {
			initialProjectFieldValue = name.trim()
			if (locationArea !== null) {
				locationArea.updateProjectName(name.trim())
			}
		}
	}

	def package void setLocationForSelection() {
		projectName = getProjectNameFieldValue()
		locationArea.updateProjectName(projectName)
		location = locationArea.projectLocation
	}

	def protected boolean validatePage() {
		var IWorkspace workspace = IDEWorkbenchPlugin.getPluginWorkspace()
		var String projectFieldContents = getProjectNameFieldValue()
		if (projectFieldContents.equals('')) {
			setErrorMessage(null)
			setMessage(IDEWorkbenchMessages.WizardNewProjectCreationPage_projectNameEmpty)
			return false
		}
		var IStatus nameStatus = workspace.validateName(projectFieldContents, IResource.PROJECT)
		if (!nameStatus.isOK()) {
			setErrorMessage(nameStatus.getMessage())
			return false
		}
		var IProject handle = getProjectHandle()
		if (handle.exists()) {
			setErrorMessage(IDEWorkbenchMessages.WizardNewProjectCreationPage_projectExistsMessage)
			return false
		}
		var IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectNameFieldValue())
		locationArea.setExistingProject(project)
		var String validLocationMessage = locationArea.checkValidLocation()
		if (validLocationMessage !== null) {
			// there is no destination location given
			setErrorMessage(validLocationMessage)
			return false
		}
		errorMessage = null
		message = null 
		return true
	}

	override void setVisible(boolean visible) {
		super.setVisible(visible)
		if (visible) projectNameField.setFocus
	}

	def boolean useDefaults() {
		return locationArea.isDefault
	}
	
	def IWorkingSet[] getSelectedWorkingSets() {
		return if (workingSetGroup === null) newArrayOfSize(0) else workingSetGroup.selectedWorkingSets
	}

	def boolean isCallJhipsterGenerator() {
		return btnCallJhipsterGenerator !== null && btnCallJhipsterGenerator.selection
	}
}
