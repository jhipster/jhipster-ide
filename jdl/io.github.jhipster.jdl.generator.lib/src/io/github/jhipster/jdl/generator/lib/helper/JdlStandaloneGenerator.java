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
