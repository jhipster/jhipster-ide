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
package io.github.jhipster.jdl.ui.wizard

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.m2e.core.MavenPlugin
import org.eclipse.m2e.core.project.ResolverConfiguration

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JDLExtendedProjectCreator extends JDLProjectCreator {

	override protected enhanceProject(IProject project, IProgressMonitor monitor) throws CoreException {
		super.enhanceProject(project, monitor)
		project.description => [
			natureIds = #[JavaCore.NATURE_ID, XtextProjectHelper.NATURE_ID]
			project.setDescription(it, new NullProgressMonitor)
			val srcPath = project.getFolder('src').fullPath
			val srcEntries = #[JavaCore.newSourceEntry(srcPath, null)]
			val resolverConfiguration = new ResolverConfiguration
//			MavenPlugin.projectConfigurationManager.enableMavenNature(project, resolverConfiguration, new NullProgressMonitor)
//            val srcMainJavaPath = project.getFolder('src/main/java').fullPath
//			JavaCore.newSourceEntry(srcMainJavaPath)
//			JavaCore.create(project).setRawClasspath(srcEntries, new NullProgressMonitor)
            MavenPlugin.projectConfigurationManager.enableMavenNature(project, resolverConfiguration, new NullProgressMonitor)
            JavaCore.create(project).setRawClasspath(srcEntries, new NullProgressMonitor)

		]
	}
}
