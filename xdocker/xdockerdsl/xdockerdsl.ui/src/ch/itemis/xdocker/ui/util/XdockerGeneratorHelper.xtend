/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.util

import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import com.google.inject.Inject
import org.eclipse.xtext.generator.IGenerator
import javax.inject.Provider
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.generator.GeneratorContext

/**
 * This is a Helper Class to call the Xdocker Genrator
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerGeneratorHelper {
	
	@Inject IGenerator2 generator
 	@Inject Provider<EclipseResourceFileSystemAccess2> fileAccessProvider
    @Inject IResourceSetProvider resourceSetProvider     	

	/**
	 * Call generator to transform xdocker file to Dockerfile
	 */	
	def IFolder generate(IFile dockerfile) {
        val fsa = fileAccessProvider.get()
		if (fsa != null && dockerfile != null) {
			val project = dockerfile.project
			val srcGenFolder = project.getFolder("src-gen")
			if (!srcGenFolder.exists()) {
				try {
					srcGenFolder.create(true, true, new NullProgressMonitor)
				} catch (CoreException e) {
					return srcGenFolder
				}
			}
			fsa.project = project
			fsa.monitor = new NullProgressMonitor
			fsa.outputPath = srcGenFolder.fullPath.lastSegment
			val out = fsa?.outputConfigurations.get(IFileSystemAccess.DEFAULT_OUTPUT)
			if (out != null) {
				out.createOutputDirectory = true
				out.canClearOutputDirectory = true
			}
			val uri = URI.createPlatformResourceURI(dockerfile.getFullPath().toString(), true)
	        val rs = resourceSetProvider.get(project)
			val res = rs.getResource(uri, true)
			val ctx =  new GeneratorContext // TODO
			generator.doGenerate(res, fsa, ctx)
			return srcGenFolder
		}
	}
}