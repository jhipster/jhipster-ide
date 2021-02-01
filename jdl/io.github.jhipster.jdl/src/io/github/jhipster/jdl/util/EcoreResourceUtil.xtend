/**
 * Copyright 2016-2021 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.util

import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Assert
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.Platform
import org.eclipse.emf.common.CommonPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl

/**
 * @author Serano Colameo - Initial contribution and API
 */
final class EcoreResourceUtil {
	
	private new() { } // Prevent from instantiation

	/** 
	 * Returns an instance of {@link ExtensibleURIConverterImpl} where the URI mappings are initialized in such a way
	 * that normalization of non-platform:/resource {@link URI}s which reference resources inside the workspace yields
	 * the corresponding platform:/resource {@link URI}s.
	 * @return An instance of {@link ExtensibleURIConverterImpl} containing URI mappings for normalizing
	 * non-platform:/resource {@link URI}s referencing workspace resources to corresponding platform:/resource{@link URI}s.
	 */
	def static URIConverter getURIConverter() {
		return getURIConverter(null)
	}

	/** 
	 * Returns the {@link URIConverter URI converter} of given {@link ResourceSet resource set}. If no{@link ResourceSet resource set} is provided an instance of {@link ExtensibleURIConverterImpl} is returned
	 * instead. In both cases, the {@link URIConverter URI converter}'s URI mappings are initialized in such a way that
	 * normalization of non-platform:/resource {@link URI}s which reference resources inside the workspace yields the
	 * corresponding platform:/resource {@link URI}s.
	 * @param resourceSetThe {@link ResourceSet resource set} whose {@link URIConverter URI converter} is to be retrieved.
	 * @return The {@link URIConverter URI converter} of given {@link ResourceSet resource set}, or an instance of{@link ExtensibleURIConverterImpl} if no such is provided, containing URI mappings for normalizing
	 * non-platform:/resource {@link URI}s referencing workspace resources to corresponding platform:/resource{@link URI}s.
	 */
	def static URIConverter getURIConverter(ResourceSet resourceSet) {
		// Retrieve or create URI converter
		var URIConverter uriConverter
		if (resourceSet !== null) {
			uriConverter = resourceSet.getURIConverter
		} else {
			uriConverter = new ExtensibleURIConverterImpl
		}
		if (Platform.isRunning) {
			// Initialize URI mappings
			var IPath workspaceRootPath = ResourcesPlugin.workspace.root.fullPath.addTrailingSeparator
			var URI workspaceRootURI = URI.createPlatformResourceURI(workspaceRootPath.toString, true)
			var IPath workspaceRootLocation = ResourcesPlugin.workspace.root.location.addTrailingSeparator
			var URI workspaceRootLocationURI = URI.createURI(workspaceRootLocation.toString, true)
			var URI workspaceRootLocationFileURI = URI.createFileURI(workspaceRootLocation.toString)
			uriConverter.getURIMap.put(workspaceRootLocationURI, workspaceRootURI)
			uriConverter.getURIMap.put(workspaceRootLocationFileURI, workspaceRootURI)
		}
		return uriConverter
	}

	/** 
	 * Converts given {@link URI} into an absolute file {@link URI}.
	 * @param uriThe {@link URI} to be converted.
	 * @return Absolute file {@link URI} for the given {@link URI} or given {@link URI} if no conversion is possible.
	 */
	def static URI convertToAbsoluteFileURI(URI uri_finalParam_) {
		var uri = uri_finalParam_
		Assert.isNotNull(uri)
		// Workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=423286: manually convert URIs that start with a
		// Windows drive letter
		if (!uri.isRelative() && uri.scheme().matches("[A-Za-z]")) {
			// $NON-NLS-1$
			uri = URI.createFileURI(uri.toString())
		}
		// Try to convert given URI to absolute file URI right away
		var URI convertedURI = CommonPlugin.asLocalURI(uri)
		// Resulting URI still relative?
		if (convertedURI.isRelative()) {
			// Normalize given URI and try to convert it again
			uri = getURIConverter().normalize(uri)
			convertedURI = CommonPlugin.asLocalURI(uri)
		}
		return convertedURI
	}

	/** 
	 * Converts given URI into a platform resource URI.
	 * @param uriThe {@link URI} to be converted.
	 * @return platform resource URI for the given URI or given URI if it references a location outside the workspace or
	 * platform is not available.
	 */
	def static URI convertToPlatformResourceURI(URI uri) {
		Assert.isNotNull(uri)
		// Already a platform resource URI?
		if (uri.isPlatformResource()) {
			return uri
		}
		// Try to convert absolute file URIs to platform resource URIs
		if (uri.isFile() && !uri.isRelative() && Platform.isRunning()) {
			/*
			 * !! Important Note !! Use IWorkspaceRoot#getFileForLocation(IPath) rather than trying to match the given
			 * URI against the workspace root location. This enables cases to be covered where the given URI references
			 * a resource that is part of the workspace but physically (i.e., at file system level) not located under
			 * the workspace root.
			 */
			var IFile file = ResourcesPlugin.workspace.root.getFileForLocation(new Path(uri.toFileString))
			if (file !== null) {
				return URI.createPlatformResourceURI(file.fullPath.toString, true)
			}
		}
		return getURIConverter.normalize(uri)
	}

	/** 
	 * Proves if resource specified by an URI exists.
	 * @param uriThe URI to prove Returns <b>true</b> only if the URI represents a file and if this file exists.
	 */
	def static boolean exists(URI uri) {
		return if (uri !== null) getURIConverter.exists(uri, null) else false
	}
}
