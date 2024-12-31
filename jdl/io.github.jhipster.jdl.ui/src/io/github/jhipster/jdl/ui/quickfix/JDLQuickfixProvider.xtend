/**
 * Copyright 2016-2025 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.ui.quickfix

import io.github.jhipster.jdl.validation.IssueCodes
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue

/**
 * @author Serano Colameo - Initial contribution and API
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
	def void removeRequiredConstraint(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Remove "required" keyword', 'Remove required constraint', 'many-to-many.gif') [
			context |
			val xtextDocument = context.xtextDocument
			xtextDocument.replace(issue.offset, issue.length, '')
		]
	}

	@Fix(IssueCodes.WRONG_PARAM_VALUE_TYPE)
	def changeToStringLiteral(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Change to string literal', 'Change to string literal.', 'change.gif') [
			context |
			context.xtextDocument => [ doc |
				val xtextDocument = context.xtextDocument
				val identifier = xtextDocument.get(issue.offset, issue.length)
				xtextDocument.replace(issue.offset, issue.length, '''"«identifier»"''')
			]
		]
	}
	
	@Fix(IssueCodes.DEPRECATED_PARAMETER)
	def void removeParamter(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Remove parameter definition', 'Remove parameter', 'remove.gif') [
			context |
			val xtextDocument = context.xtextDocument
			xtextDocument.replace(issue.offset, issue.length, '')
		]
	}
	
	@Fix(IssueCodes.INVALID_AUTH_VALUE_TYPE)
	def void setAuthParameterToUaa(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Set authentication type to uaa', 'Set authentication type to uaa', 'change.gif') [
			context |
			val xtextDocument = context.xtextDocument
			xtextDocument.replace(issue.offset, issue.length, 'uaa')
		]
	}
}
