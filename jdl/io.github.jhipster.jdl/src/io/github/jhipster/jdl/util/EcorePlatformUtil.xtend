/**
 * Copyright 2016-2022 the original author or authors from the JHipster project.
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
import org.eclipse.core.runtime.Assert
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.Platform
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceImpl
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.FeatureMap
import java.io.File

/**
 * @author Serano Colameo - Initial contribution and API
 */
final class EcorePlatformUtil {
	
	private new() { } // Prevent from instantiation

	/** 
	 * Converts given {@link IPath path} into a workspace-relative platform resource {@link URI} if possible or an
	 * absolute file {@link URI} otherwise. Returns given {@link IPath} as indeterminate (scheme-less) {@link URI} if
	 * none of both is possible.
	 * @param pathThe {@link IPath path} for which to create the {@link URI}; must not be <code>null</code>.
	 * @return Workspace-relative platform resource {@link URI} or absolute file {@link URI} for given {@link IPathpath} or given {@link IPath} as indeterminate (scheme-less) {@link URI} otherwise.
	 */
	def static URI createURI(IPath path) {
		Assert.isNotNull(path)
		var URI uri = URI.createURI(path.toString(), true)
		var URI convertedURI = EcoreResourceUtil.convertToPlatformResourceURI(uri)
		if (!convertedURI.isPlatformResource()) {
			convertedURI = EcoreResourceUtil.convertToAbsoluteFileURI(convertedURI)
		}
		return convertedURI
	}

	def static IPath createPath(URI uri) {
		Assert.isNotNull(uri)
		if (uri.isPlatform()) {
			return new Path(uri.toPlatformString(true)).removeTrailingSeparator()
		} else if (uri.isFile()) {
			return new Path(uri.toFileString()).removeTrailingSeparator()
		} else {
			return new Path(uri.toString()).removeTrailingSeparator()
		}
	}

	/** 
	 * Converts the given {@link IPath path} into an absolute file {@linkplain URI}.
	 * @param pathThe {@link Path path} for which an {@linkplain URI} is to be created.
	 * @return The absolute file {@linkplain URI} for the given {@link IPath path} or an {@link URI} corresponding to
	 * given {@link IPath path} as is if no conversion is possible.
	 */
	def static URI createAbsoluteFileURI(IPath path) {
		var URI uri = createURI(path)
		return EcoreResourceUtil.convertToAbsoluteFileURI(uri)
	}

	/** 
	 * Converts the given {@link URI uri} into an absolute file location, <em>i.e.</em> into a {@linkplain IPath path}.
	 * @param uriThe file {@linkplain URI} for which an absolute file {@linkplain IPath location} must be created.
	 * @return The absolute file {@linkplain IPath location} for the given file {@link URI uri}.
	 */
	def static IPath createAbsoluteFileLocation(URI uri_finalParam_) {
		var uri = uri_finalParam_
		uri = EcoreResourceUtil.convertToAbsoluteFileURI(uri)
		var String uriString
		if (uri.isFile()) {
			uriString = uri.toFileString()
		} else {
			uriString = uri.toString()
		}
		return new Path(uriString).removeTrailingSeparator()
	}
	
	def static File toFile(Resource resource, String ext) {
		val uri = resource.getURI.trimFileExtension.appendFileExtension(ext) 
		uri.createAbsoluteFileLocation.toFile
	}

	def static java.nio.file.Path toPath(Resource resource, String ext) {
		resource.toFile(ext).toPath
	}

	/** 
	 * Converts the given {@link IPath path} into an absolute file {@linkplain IPath location}.
	 * @param pathThe file path for which an absolute file {@linkplain IPath location} must be created.
	 * @return The absolute file {@linkplain IPath location} for the given file {@link IPath path}.
	 */
	def static IPath convertToAbsoluteFileLocation(IPath path) {
		var URI uri = createAbsoluteFileURI(path)
		var String uriString
		if (uri.isFile()) {
			uriString = uri.toFileString()
		} else {
			uriString = uri.toString()
		}
		return new Path(uriString).removeTrailingSeparator()
	}

	/** 
	 * Resolves given fragment-based {@link URI} against the specified {@link IPath path}. Returns the given URI as is
	 * if it is not fragment-based.
	 * <p>
	 * A fragment-based URI is a URI that doesn't contain any information about the resource that contains the model
	 * object it refers to (e.g., hb:/#//MyComponent/MyParameterValue). By calling this method, such fragment-based URIs
	 * will be expanded to a URI that starts with the specified path and is followed by the fragment of the given URI
	 * (e.g., platform:/resource/MyProject/MyResource/#//MyComponent/MyParameterValue).
	 * </p>
	 * @param uriThe fragment-based URI to be resolved.
	 * @param pathThe {@link IPath path} against which the fragment-based URI is to be resolved.
	 * @return The resolved {@link URI} if given URI is a fragment-based URI, or the given URI as is otherwise.
	 */
	def static URI resolveURI(URI uri, IPath path) {
		Assert.isNotNull(uri)
		// Is given URI a fragment-based URI not knowing the resource that contains the eObject it refers to?
		if (uri.segmentCount() === 0) {
			// Form resolved URI by using the URI corresponding to specified path as prefix and the fragment of given
			// URI as postfix
			var URI resourceURI = createURI(path)
			var String eObjectURIFragment = uri.fragment()
			return resourceURI.appendFragment(eObjectURIFragment)
		}
		return uri
	}

	/** 
	 * Returns the {@linkplain Resource resource} corresponding to the specified {@linkplain Object object}.
	 * <p>
	 * The supported object types are:
	 * <ul>
	 * <li>{@linkplain org.eclipse.core.resources.IFile}</li>
	 * <li>{@linkplain org.eclipse.emf.common.util.URI}</li>
	 * <li>{@linkplain org.eclipse.emf.ecore.resource.Resource}</li>
	 * <li>{@linkplain org.eclipse.emf.ecore.EObject}</li>
	 * <li>{@linkplain org.eclipse.emf.ecore.util.FeatureMap.Entry}</li>
	 * <li>{@linkplain org.eclipse.emf.edit.provider.IWrapperItemProvider}</li>
	 * </ul>
	 * <p>
	 * If the type of the specified object does not belongs to that list of supported types, <code>null</code> is
	 * returned.
	 * @param objectThe object from which a resource must be returned.
	 * @return The underlying resource from the given object.
	 */
	def static Resource getResource(Object object) {
		if (object instanceof IFile) {
			return getResource((object as IFile))
		} else if (object instanceof URI) {
			return getResource((object as URI))
		} else if (object instanceof Resource) {
			return (object as Resource)
		} else if (object instanceof EObject) {
			return getResource((object as EObject))
		} else if (object instanceof FeatureMap.Entry) {
			return getResource((object as FeatureMap.Entry))
		}
		return null
	}

	/** 
	 * Returns the {@linkplain IFile file} corresponding to the specified {@linkplain Object object}.
	 * <p>
	 * The supported object types are:
	 * <ul>
	 * <li>{@linkplain org.eclipse.core.resources.IFile}</li>
	 * <li>{@linkplain org.eclipse.emf.common.util.URI}</li>
	 * <li>{@linkplain org.eclipse.emf.ecore.resource.Resource}</li>
	 * <li>{@linkplain org.eclipse.emf.ecore.EObject}</li>
	 * <li>{@linkplain org.eclipse.emf.edit.provider.IWrapperItemProvider}</li>
	 * <li>{@linkplain org.eclipse.emf.ecore.util.FeatureMap.Entry}</li>
	 * </ul>
	 * @param objectThe object from which a file must be returned.
	 * @return The underlying file from the given object.
	 */
	def static IFile getFile(Object object) {
		if (object instanceof IFile) {
			return (object as IFile)
		} else if (object instanceof URI) {
			return getFile((object as URI))
		} else if (object instanceof Resource) {
			return getFile((object as Resource))
		} else if (object instanceof EObject) {
			return getFile((object as EObject)) 
		}
		return null
	}

	/** 
	 * Retrieves the {@linkplain IFile file} corresponding to the given {@linkplain org.eclipse.emf.common.util.URI}.
	 * @param uriThe {@linkplain URI} of the file to return.
	 * @return The file corresponding to the specified {@link URI uri}.
	 */
	def static IFile getFile(URI uri) {
		if (uri !== null && Platform.isRunning()) {
			// Create dummy resource transporting given URI
			var Resource resource = new ResourceImpl(uri)
			// Create dummy resource set transporting appropriate URI converter
			var ResourceSet resourceSet = new ResourceSetImpl()
			resourceSet.getResources().add(resource)
			resourceSet.setURIConverter(EcoreResourceUtil.getURIConverter())
			// Delegate to getFile(Resource) method
			return getFile(resource)
		}
		return null
	}

	/** 
	 * Retrieves the {@linkplain IFile file} owning to the given {@linkplain org.eclipse.emf.ecore.EObject}.
	 * @param eObjectThe {@linkplain EObject} whose file must be returned.
	 * @return The file containing the specified {@link EObject eObject}.
	 */
	def static IFile getFile(EObject eObject) {
		if (eObject !== null) {
			return getFile(eObject.eResource())
		}
		return null
	}
}
