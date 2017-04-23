package io.github.jhipster.jdl.ui.wizard;

import org.eclipse.xtext.ui.wizard.IExtendedProjectInfo;
import org.eclipse.xtext.ui.wizard.IProjectCreator;

import com.google.inject.Inject;

public class JDLNewProjectWizardEnhanced extends JDLNewProjectWizard {

	private JDLWizardNewProjectCreationPage mainPage;

	@Inject
	public JDLNewProjectWizardEnhanced(IProjectCreator projectCreator) {
		super(projectCreator);
		setWindowTitle("New JDL Project");
	}

	protected JDLWizardNewProjectCreationPage getMainPage() {
		return mainPage;
	}

	/**
	 * Use this method to add pages to the wizard.
	 * The one-time generated version of this class will add a default new project page to the wizard.
	 */
	@Override
	public void addPages() {
		mainPage = createMainPage("basicNewProjectPage");
		mainPage.setTitle("JDL Project");
		mainPage.setDescription("Create a new JDL project.");
		addPage(mainPage);
	}

	protected JDLWizardNewProjectCreationPage createMainPage(String pageName) {
		return new JDLWizardNewProjectCreationPage(pageName);
	}

	/**
	 * Use this method to read the project settings from the wizard pages and feed them into the project info class.
	 */
	@Override
	protected IExtendedProjectInfo getProjectInfo() {
		JDLProjectInfo projectInfo = new JDLProjectInfo();
		projectInfo.setProjectName(mainPage.getProjectName());
		if (!mainPage.useDefaults()) {
			projectInfo.setLocationPath(mainPage.getLocationPath());
		}
		return projectInfo;
	}

}
