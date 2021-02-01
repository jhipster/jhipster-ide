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

import * as net from 'net';
import { Trace } from 'vscode-jsonrpc';
import { window, workspace, commands, ExtensionContext, Uri } from 'vscode';
import { LanguageClient, LanguageClientOptions, StreamInfo, Position as LSPosition, Location as LSLocation } from 'vscode-languageclient';
import { checkJavaVersion, getJavaExec } from './extension-helper';

export function activate(context: ExtensionContext) {
	checkJavaVersion(getJavaExec()).catch(error => {
		window.showErrorMessage(error.message, error.label).then((selection) => {
			if (error.label && error.label === selection && error.command) {
				commands.executeCommand(error.command, error.commandParam);
			}
		});
		throw error;
	}).then(async (requirements) => {
        let connectionInfo = {
            port: 5007
        };

        let serverOptions = () => {
            let socket = net.connect(connectionInfo);
            let result: StreamInfo = {
                writer: socket,
                reader: socket
            };
            return Promise.resolve(result);
        };
        
        let clientOptions: LanguageClientOptions = {
            documentSelector: ['jdl', 'jh'],
            synchronize: {
                fileEvents: workspace.createFileSystemWatcher('**/*.*')
            }
        };
        
        let lc = new LanguageClient('JDL Xtext Server', serverOptions, clientOptions);
        var disposable2 = commands.registerCommand("jdl.a.proxy", async () => {
            let activeEditor = window.activeTextEditor;
            if (!activeEditor || !activeEditor.document || activeEditor.document.languageId !== 'jdl') {
                return;
            }
    
            if (activeEditor.document.uri instanceof Uri) {
                commands.executeCommand("jdl.a", activeEditor.document.uri.toString());
            }
        })
    
        context.subscriptions.push(disposable2);
        // enable tracing (.Off, .Messages, Verbose)
        lc.trace = Trace.Verbose;
        let disposable = lc.start();
        
        // Push the disposable to the context's subscriptions so that the 
        // client can be deactivated on extension deactivation
        context.subscriptions.push(disposable);
    });
}
