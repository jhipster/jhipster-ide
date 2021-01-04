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
 *
 * @author Serano Colameo - Initial contribution and API
 */
'use strict';

import * as path from 'path';
import * as vscode from 'vscode';
import { Trace } from 'vscode-jsonrpc';
import { PlantUMLRenderer } from './plantuml';
import { workspace, commands, ExtensionContext, window, StatusBarAlignment } from 'vscode';
import { LanguageClient, LanguageClientOptions, Executable } from 'vscode-languageclient';
import { checkJavaVersion, toggleItem, getJavaExec } from './extension-helper';

let plantuml: PlantUMLRenderer;

const LANGUAGE_CLIENT_ID = 'LANGUAGE_ID_JDL';

export function activate(context: ExtensionContext) {
	const vmargs = '-Dpnguml.gen=true';
//  const lib = context.asAbsolutePath(path.join('lib', 'bin', executable));
	let javaCli = getJavaExec();

	checkJavaVersion(javaCli).catch(error => {
		window.showErrorMessage(error.message, error.label).then((selection) => {
			if (error.label && error.label === selection && error.command) {
				commands.executeCommand(error.command, error.commandParam);
			}
		});
		throw error;
	}).then(async (requirements) => {
		let serverOptions: Executable = {
			command: javaCli,
	//		args: [ vmargs, '-cp', lib, 'io.github.jhipster.jdl.ide.server.JdlServerLauncher' ],
	//		args: [ vmargs, '-cp', lib, 'org.eclipse.xtext.ide.server.ServerLauncher' ],
	//		args: [ vmargs, '-jar', lib, 'io.github.jhipster.jdl.ide.server.JdlServerLauncher' ],
			options: {stdio: 'pipe'}
		};
	
		let clientOptions: LanguageClientOptions = {
			documentSelector: ['jdl', 'jh'],
			synchronize: {
				configurationSection: 'jdlLanguageServer',
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
		const activeEditor = vscode.window.activeTextEditor;
		window.onDidChangeActiveTextEditor((editor) => {
			toggleItem(activeEditor, item);
		});
	
		context.subscriptions.push(disposable);
		plantuml = new PlantUMLRenderer(context);
		plantuml.init(languageClient);
	});
}

export function deactivate() {
    plantuml = null;
}
