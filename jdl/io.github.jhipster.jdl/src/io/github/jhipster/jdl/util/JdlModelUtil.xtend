package io.github.jhipster.jdl.util

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider

class JdlModelUtil {
	
	@Inject IEObjectDocumentationProvider documentationProvider;

	def String getDocumentation(EObject source) {
		if (source === null) return '' // prevent NPE
		val documentation = documentationProvider.getDocumentation(source)
		return documentation;
	}
}
