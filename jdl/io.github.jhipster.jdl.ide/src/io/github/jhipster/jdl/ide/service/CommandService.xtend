package io.github.jhipster.jdl.ide.service

import java.util.List
import org.eclipse.lsp4j.ExecuteCommandParams
import org.eclipse.xtext.ide.server.ILanguageServerAccess
import org.eclipse.xtext.ide.server.commands.IExecutableCommandService
import org.eclipse.xtext.util.CancelIndicator

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
