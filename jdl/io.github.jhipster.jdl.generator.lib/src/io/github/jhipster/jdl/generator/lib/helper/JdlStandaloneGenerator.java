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
package io.github.jhipster.jdl.generator.lib.helper;

import java.nio.file.Path;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import io.github.jhipster.jdl.JDLStandaloneSetup;
import io.github.jhipster.jdl.jdl.JdlDomainModel;

/**
 * @author Serano Colameo - Initial contribution and API
 */
abstract public class JdlStandaloneGenerator {

	static {
		new JDLStandaloneSetup().createInjectorAndDoEMFRegistration();
	}

	public static JdlDomainModel load(final Path jdlFilePath) {
		URI uri = URI.createURI(jdlFilePath.toFile().toURI().toString());
		Resource resource = new ResourceSetImpl().getResource(uri, true);
		EList<EObject> contents = resource != null ? resource.getContents() : null;
		EObject element = IterableExtensions.<EObject>head(contents);
		return (element instanceof JdlDomainModel) ? ((JdlDomainModel) element) : null;
	}
}
