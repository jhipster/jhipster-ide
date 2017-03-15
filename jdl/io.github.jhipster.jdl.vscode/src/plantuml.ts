'use strict';

import * as net from 'net';
import * as path from 'path';
import * as child_process from 'child_process';
import * as fs from 'fs';
import * as vscode from 'vscode';
import { LanguageClient } from 'vscode-languageclient';
import  { DidChangeTextDocumentNotification } from 'vscode-languageclient/lib/protocol';

var process = require('process');

export class PlantUMLRenderer {
    private static PREVIEW_URI = vscode.Uri.parse('plantuml-preview://authority/plantuml-preview');
    private provider;

    public constructor(private ctx: vscode.ExtensionContext) {
    }

    public init(langClient: LanguageClient) {
        let renderer = new Renderer(langClient);
        this.provider = new PreviewProvider(renderer)
        this.prepareAndRegisterContentProvider();
        this.prepareAndRegisterCommands();
    }

    private prepareAndRegisterContentProvider() {
        let registration = vscode.workspace.registerTextDocumentContentProvider('plantuml-preview', this.provider);
        this.ctx.subscriptions.push(this.provider);
    }

    private prepareAndRegisterCommands() {
        this.preparePreviewCmd();
    }

    private preparePreviewCmd() {
        let cmdPreview = vscode.commands.registerCommand('plantuml.preview', () => {
            let ret = vscode.commands.executeCommand('vscode.previewHtml', PlantUMLRenderer.PREVIEW_URI, vscode.ViewColumn.Two, 'PlantUML');
            ret.then((ok) => {
                this.provider.update(PlantUMLRenderer.PREVIEW_URI);
            }, (err) => {
                vscode.window.showErrorMessage(err);
            });
        });
        this.ctx.subscriptions.push(cmdPreview);
    }
}

class PreviewProvider implements vscode.TextDocumentContentProvider {
    private onDidChangeVar = new vscode.EventEmitter<vscode.Uri>();

    public constructor(private renderer: Renderer) {
    }

    public dispose() {
        this.onDidChangeVar.dispose();
    }

    public get onDidChange() {
        return this.onDidChangeVar.event;
    }

    public update(uri: vscode.Uri) {
//        this.renderer.sendChangeNotification();
        this.onDidChangeVar.fire(uri);
    }

    public provideTextDocumentContent(uri: vscode.Uri, token: vscode.CancellationToken): string | Thenable<string> {
        this.renderer.preview = true;
        let ret = this.renderer.render();
        return new Promise((resolve, reject) => {
            ret.then(
                r => {
                    resolve(r);
                }
            );
        });
    }
}

class Renderer {
    public preview: boolean = true;
    private editor: vscode.TextEditor = null;

    public constructor(private langClient: LanguageClient) {
    }

    public sendChangeNotification() {
        let docuri = this.editor.document.uri.toString(false);
        this.langClient.sendNotification(DidChangeTextDocumentNotification.type, {
            textDocument: {
                uri: docuri,
                version: this.editor.document.version
            },
            contentChanges: [{ text: this.editor.document.getText() }]
        });
    }

    public render(): Thenable<string> {
        let ret: Thenable<string> = null;
        this.editor = vscode.window.activeTextEditor;
        let [dirName, fsPath] = this.getWorkingPath();
//        this.sendChangeNotification();
        let docUri = this.editor.document.uri;
        return this.toHtml(docUri);
    }

    private getWorkingPath(): string[] {
        let fsPath = this.editor.document.uri.fsPath;
        let dirName = path.dirname(fsPath);
        if (dirName === ".") {
            dirName = vscode.workspace.rootPath;
            if (dirName === undefined) {
                dirName = process.env['HOME'];
                if (dirName === undefined) {
                    dirName = process.env['USERPROFILE'];
                }
            }
            fsPath = dirName + "/" + fsPath;
        }
        return [dirName, fsPath];
    }

    private toHtml(jdl: vscode.Uri): Thenable<string> {
        let ret: Thenable<string> = null;
        let imageFile = jdl.toString(false).replace('.jdl', '.png');
        if (this.preview) {
            ret = new Promise<string>((res) => {
                let html = `<html><body style="background-color:white;"><img src="${imageFile}"></body></html>`;
                res(html);
            });
        } 
        return ret;
    }
}