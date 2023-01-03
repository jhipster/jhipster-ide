/**
 * Copyright 2016-2023 the original author or authors from the JHipster project.
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

import * as vscode from 'vscode';
import { LanguageClient } from 'vscode-languageclient';

var process = require('process');

export class PlantUMLRenderer {
  private editor: vscode.TextEditor = null;
  private langClient: LanguageClient;
  private webview: vscode.Webview
  private status: string;

  public constructor(private ctx: vscode.ExtensionContext) {}

  public async init(langClient: LanguageClient) {
    this.langClient = langClient;
    this.status = 'Initializing JHipster IDE extension, please wait or retry later...'
    this.prepareAndRegisterCmd();
    await langClient.onReady().then(() => {
      this.status = null; 
      console.log('PlantUML for JDL is ready!');
    });
  }

  private prepareAndRegisterCmd() {
    this.ctx.subscriptions.push(
      vscode.commands.registerCommand('plantuml.preview', () => {
        const panel = vscode.window.createWebviewPanel(
          'plantuml',
          'PlantUML',
          vscode.ViewColumn.Two,
          {
            enableScripts: true
          }
        );
        this.webview = panel.webview;
        const updateWebview = () => {
          let img = this.getImageFile();
          panel.webview.html = null;
          panel.title = "PlantUML " + (img !== null ? `of ${img}` : '');
          this.getWebviewContent().then(content => {
            panel.webview.html = content;
          });
        };
  
        // Set initial content
        updateWebview();
  
        // And schedule updates to the content every second
        setInterval(updateWebview, 1000);
      })
    );
  }

  private toPngFile(file: string): string {
    var pos = file.lastIndexOf('.jdl');
    return file.substring(0, pos) + '.png';
  }

  private getImageFile(): string {
    this.editor = vscode.window.activeTextEditor;
    if (this.editor === null || this.editor.document.languageId !== "jdl") {
        return null;
    }
    return this.toPngFile(this.editor.document.uri.fsPath)
  }

  private getWebviewContent(): Thenable<string> {
    let imageFile = this.getImageFile();
    if (imageFile === null) {
      return null;
    }
    return new Promise<string>((resolve) => {
      if (this.status === null) {
        let img = this.webview.asWebviewUri(vscode.Uri.file(imageFile))
        let html = `<html><body style="background-color:white;"><img src="${img}"/></body></html>`;
        resolve(html);
      } else {
        resolve(`<html><body></b>${this.status}</b></body></html>`);
      }
    });
  }
}
