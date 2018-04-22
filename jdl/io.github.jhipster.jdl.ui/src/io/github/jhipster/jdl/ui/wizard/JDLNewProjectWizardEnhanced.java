/**
 * Copyright 2013-2018 the original author or authors from the JHipster project.
 *
 * This file is part of the JHipster project, see http://www.jhipster.tech/
 * for more information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.jhipster.jdl.ui.wizard;

import org.eclipse.xtext.ui.wizard.IExtendedProjectInfo;
import org.eclipse.xtext.ui.wizard.IProjectCreator;

import com.google.inject.Inject;

/**
 * @author Serano Colameo - Initial contribution and API
 */
public class JDLNewProjectWizardEnhanced extends JDLNewProjectWizard {

	private JDLWizardNewProjectCreationPage mainPage;

	@Inject
	public JDLNewProjectWizardEnhanced(IProjectCreator projectCreator) {
		super(projectCreator);
		setWindowTitle("New JHipster Project");
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
		mainPage.setTitle("JHipster Project");
		mainPage.setDescription("Create a new JHipster project.");
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
