/** 
 * Copyright 2016-2023 the original author or authors from the JHipster project.
 * This file is part of the JHipster project, see http://www.jhipster.tech/
 * for more information.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.jhipster.jdl.ide.contentassist

import org.eclipse.lsp4j.CompletionItem
import org.eclipse.lsp4j.MarkupContent
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService

/** 
 * @author Serano Colameo - Initial contribution and API
 */
class JdlContentAssistService extends ContentAssistService {
	
	override protected CompletionItem toCompletionItem(ContentAssistEntry entry, int caretOffset,
		Position caretPosition, Document document) {
		val completionItem = super.toCompletionItem(entry, caretOffset, caretPosition, document)
		
		if (completionItem === null) return null
		
		val documentation = completionItem.getDocumentation()
		
		if (documentation !== null && documentation.getLeft() === null && documentation.getRight() === null) {
			completionItem.setDocumentation((null as Either<String, MarkupContent>))
		}
		return completionItem
	}
}
