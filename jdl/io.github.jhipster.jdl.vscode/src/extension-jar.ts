/**
 * Copyright 2013-2020 the original author or authors from the JHipster project.
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
 *
 * @author Serano Colameo - Initial contribution and API
 */
'use strict';

import * as path from 'path';
import * as vscode from 'vscode';
import { Trace } from 'vscode-jsonrpc';
import { PlantUMLRenderer } from './plantuml';
import { workspace, commands, ExtensionContext, window, StatusBarAlignment, TextEditor  } from 'vscode';
import { LanguageClient, LanguageClientOptions, Executable } from 'vscode-languageclient';

let plantuml: PlantUMLRenderer;

const LANGUAGE_CLIENT_ID = 'LANGUAGE_ID_JDL';

export function activate(context: ExtensionContext) {
	const libFolder = context.asAbsolutePath(path.join('./jdl-ls/lib/*'))
	let vmargs = '-Dpnguml.gen=true';

	let serverOptions: Executable = {
		command: 'java',
		args: [ vmargs, '-cp', libFolder, 'org.eclipse.xtext.ide.server.ServerLauncher' ],
		options: {stdio: 'pipe'}
	};

	let clientOptions: LanguageClientOptions = {
		documentSelector: ['jdl', 'jh'],
		synchronize: {
			configurationSection: 'languageServerExample',
			fileEvents: [
				workspace.createFileSystemWatcher('**/*.jdl'),
				workspace.createFileSystemWatcher('**/*.jh')
			]
		}
	};	

	let item = window.createStatusBarItem(StatusBarAlignment.Right, Number.MIN_VALUE);
	item.text = 'Starting JDL Language Server...';
	toggleItem(window.activeTextEditor, item);
	let languageClient = new LanguageClient(LANGUAGE_CLIENT_ID, 'Language Support for JDL', serverOptions, clientOptions);
	languageClient.onReady().then(() => {
		item.text = 'JDL Language Server started!';
		toggleItem(window.activeTextEditor, item);
	});
	
	languageClient.trace = Trace.Off;
	let disposable = languageClient.start();
	let activeEditor = vscode.window.activeTextEditor;
	window.onDidChangeActiveTextEditor((activeEditor) => {
		toggleItem(activeEditor, item);
	});
	/*
	let result = commands.executeCommand("init", activeEditor.document.uri.toString())
	console.log("Init succeeded: "+result);
	*/

	// Push the disposable to the context's subscriptions so that the 
	// client can be deactivated on extension deactivation
	context.subscriptions.push(disposable);
    plantuml = new PlantUMLRenderer(context);
    plantuml.init(languageClient);
}

export function deactivate() {
    plantuml = null;
}

function toggleItem(editor: TextEditor, item) {
	if (editor && editor.document &&
		(editor.document.languageId === 'jdl' || editor.document.languageId === 'jh')){
		item.show();
	} else{
		item.hide();
	}
}
