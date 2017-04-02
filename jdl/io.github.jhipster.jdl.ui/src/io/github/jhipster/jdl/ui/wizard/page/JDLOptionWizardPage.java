package io.github.jhipster.jdl.ui.wizard.page;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.ide.IIDEHelpContextIds;

@SuppressWarnings("restriction")
public class JDLOptionWizardPage extends WizardPage {

	private Button btnCallJhipsterGenerator;

	public JDLOptionWizardPage(String pageName) {
		super(pageName);
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		initializeDialogUnits(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(composite, IIDEHelpContextIds.NEW_PROJECT_WIZARD_PAGE);

		GridLayout layout = new GridLayout();
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		// Show description on opening
		setErrorMessage(null);
		setMessage(null);
		setControl(composite);
		Dialog.applyDialogFont(composite);

		btnCallJhipsterGenerator = new Button(composite, SWT.CHECK);
		btnCallJhipsterGenerator.setText("Call JHipster Generator");
	}

	public boolean isCallJhipsterGenerator() {
		return btnCallJhipsterGenerator.getSelection();
	}
}
