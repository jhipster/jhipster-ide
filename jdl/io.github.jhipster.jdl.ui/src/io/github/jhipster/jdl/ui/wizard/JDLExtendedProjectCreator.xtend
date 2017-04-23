package io.github.jhipster.jdl.ui.wizard

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtext.ui.XtextProjectHelper

class JDLExtendedProjectCreator extends JDLProjectCreator {

	override protected enhanceProject(IProject project, IProgressMonitor monitor) throws CoreException {
		super.enhanceProject(project, monitor)
		project.description => [
			natureIds = #[JavaCore.NATURE_ID, XtextProjectHelper.NATURE_ID]
			project.setDescription(it, new NullProgressMonitor)
			val srcPath = project.getFolder('src').fullPath
			val srcEntries = #[JavaCore.newSourceEntry(srcPath, null)]
			JavaCore.create(project).setRawClasspath(srcEntries, new NullProgressMonitor)		
		]
	}
}
