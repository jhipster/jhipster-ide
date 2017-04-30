package io.github.jhipster.jdl.ui.quickfix

import io.github.jhipster.jdl.validation.IssueCodes
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue

/**
 * Custom quickfixes.
 *
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
class JDLQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(IssueCodes.INVALID_TYPE_NAME)
	def fixTypeName(Issue issue, IssueResolutionAcceptor acceptor) {
		capitalizeName(issue, acceptor, false)
	}

	@Fix(IssueCodes.NOT_UPPER_CASE)
	def fixEnumValueName(Issue issue, IssueResolutionAcceptor acceptor) {
		capitalizeName(issue, acceptor, true)
	}

	def private capitalizeName(Issue issue, IssueResolutionAcceptor acceptor, boolean all) {
		acceptor.accept(issue, 'Capitalize name', 'Capitalize the name.', 'upcase.png') [
			context |
			context.xtextDocument => [ doc |
				doc.get(issue.offset, if (all) issue.length else 1) => [
					doc.replace(issue.offset, if (all) length else 1, toUpperCase)
	 			]
			]
		]
	}

	@Fix(IssueCodes.INVALID_FEATURE_NAME)
	def void fixFeatureName(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Uncapitalize name', 'Uncapitalize the name.', 'upcase.png') [
			context |
			val xtextDocument = context.xtextDocument
			val firstLetter = xtextDocument.get(issue.offset, 1)
			xtextDocument.replace(issue.offset, 1, firstLetter.toLowerCase)
		]
	}

	@Fix(IssueCodes.INVALID_REQUIRED_OPTION)
	def void fixFeatureName2(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Remove required', 'Remove required constraint', 'many-to-many.gif') [
			context |
			val xtextDocument = context.xtextDocument
			xtextDocument.replace(issue.offset, issue.length, '')
		]
	}
}
