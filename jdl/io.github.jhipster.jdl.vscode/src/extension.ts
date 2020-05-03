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
import { PlantUMLRenderer } from './plantuml';
import { workspace, commands, Disposable, ExtensionContext, Uri, window, StatusBarAlignment, TextEditor } from 'vscode';
import { LanguageClient, LanguageClientOptions, ServerOptions } from 'vscode-languageclient';

let plantuml: PlantUMLRenderer;
var process = require('process');

export function activate(context: ExtensionContext) {
    let executable = process.platform == 'win32' ? 'launch.bat' : 'launch';
    let serverLauncher = context.asAbsolutePath(path.join('lib', 'bin', executable));
    
    let serverOptions: ServerOptions = {
        run:   { command: serverLauncher }, 
        debug: { command: serverLauncher }
    }

    let clientOptions: LanguageClientOptions = {
        documentSelector: ['jdl', 'jh'],
        synchronize: {
            configurationSection: 'jdlLanguageServer',
            fileEvents: workspace.createFileSystemWatcher('**/*.*')
        }
    }
	
    process.env['JDL_LS_OPTS'] = "-Dpnguml.gen=true -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=9999,suspend=n,quiet=y";

	let item = window.createStatusBarItem(StatusBarAlignment.Right, Number.MIN_VALUE);
	item.text = 'Starting JDL Language Server...';
	toggleItem(window.activeTextEditor, item);

    let langClient = new LanguageClient('JDL Xtext Server', serverOptions, clientOptions)
	langClient.onReady().then(() => {
		item.text = 'JDL Language Server started!';
		toggleItem(window.activeTextEditor, item);
	});

    let disposable = langClient.start();
    let activeEditor = vscode.window.activeTextEditor;
    //let result = commands.executeCommand("init", activeEditor.document.uri.toString())
	// Push the disposable to the context's subscriptions so that the 
    // client can be deactivated on extension deactivation
	window.onDidChangeActiveTextEditor((activeEditor) => {
		toggleItem(activeEditor, item);
	});
	context.subscriptions.push(disposable);
    plantuml = new PlantUMLRenderer(context);
    plantuml.init(langClient);
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
