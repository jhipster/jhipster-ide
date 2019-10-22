package io.github.jhipster.jdl.ide.editor.syntaxcoloring

import io.github.jhipster.jdl.jdl.JdlEntityField
import io.github.jhipster.jdl.jdl.JdlEnumValue
import io.github.jhipster.jdl.jdl.JdlPackage
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.util.CancelIndicator

class KeywordsSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {

	override protected boolean highlightElement(EObject object, IHighlightedPositionAcceptor acceptor,
		CancelIndicator cancelIndicator) {
		switch (object) {
			JdlEntityField: {
				highlightFeature(acceptor, object, JdlPackage.eINSTANCE.jdlEntityField_Type,
					HighlightingStyles.KEYWORD_ID)
				return true
			}
			JdlEnumValue: {
				highlightFeature(acceptor, object, JdlPackage.eINSTANCE.jdlEnumValue_Value, HighlightingStyles.STRING_ID)
				return true
			}
			default: false
		}
	}
}
