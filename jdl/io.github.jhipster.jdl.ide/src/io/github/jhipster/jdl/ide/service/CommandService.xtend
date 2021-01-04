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
package io.github.jhipster.jdl.ide.service

import java.util.List
import org.eclipse.lsp4j.ExecuteCommandParams
import org.eclipse.xtext.ide.server.ILanguageServerAccess
import org.eclipse.xtext.ide.server.commands.IExecutableCommandService
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author Serano Colameo - Initial contribution and API
 */
class CommandService implements IExecutableCommandService {

	override List<String> initialize() {
		return #['command']
	}

	override Object execute(ExecuteCommandParams params, ILanguageServerAccess access,
		CancelIndicator cancelIndicator) {
		if (!params.command.isNullOrEmpty) {
			val uri = params.arguments.head as String
			if (uri !== null) {
				return access.doRead(uri) [
					return params.command +" accepted"
				].get
			} else {
				return params.command + "uri Missing"
			}
		}
		return 'unknown'
	}
}
