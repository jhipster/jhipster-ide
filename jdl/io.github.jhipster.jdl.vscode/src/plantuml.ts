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
    private provider: PreviewProvider;

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
        let cmdPreview = vscode.commands.registerTextEditorCommand('plantuml.preview', () => {
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
        this.onDidChangeVar.fire(uri);
    }

    public provideTextDocumentContent(uri: vscode.Uri, token: vscode.CancellationToken): string | Thenable<string> {
        this.renderer.preview = true;
        return this.renderer.render();
    }
}

class Renderer {
    public preview: boolean = true;
    private editor: vscode.TextEditor = null;

    public constructor(private langClient: LanguageClient) {
    }

    public sendChangeNotification(uri: string, version: number) {
        this.langClient.sendNotification(DidChangeTextDocumentNotification.type, {
            textDocument: {
                uri: uri,
                version: version
            },
            contentChanges: [{ text: this.editor.document.getText() }]
        });
    }

    public render(): Thenable<string> {
        let ret: Thenable<string> = null;
        this.editor = vscode.window.activeTextEditor;

        if (this.editor == null || this.editor.document.languageId !== "jdl") {
            return ret;
        }

        ret = this.toHtml(this.editor.document.uri);
        this.editor = null;
        return ret
    }

    private toPngFile(file: string): string {
        var pos = file.lastIndexOf('.jdl');
        var str = file.substring(0, pos) + '.png';
        return str;
    }

    private toUriString(uri: vscode.Uri): string {
        return uri.toString(false);
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

    private toHtml(uri: vscode.Uri): Thenable<string> {
        let ret: Thenable<string> = null;
        let imageUri = this.toPngFile(this.toUriString(uri));
        let imageFile = this.toPngFile(uri.fsPath);
        if (this.preview) {
            if (fs.existsSync(imageFile)) {
                ret = new Promise<string>((res) => {
                    let html = `<html><body style="background-color:white;"><img src="${imageUri}"></body></html>`;
                    res(html);
                });
            } else {
                ret = new Promise<string>((res) => {
                    let html = `<html><body>Image file ${imageFile} not found!</body></html>`;
                    res(html);
                });
            }
        } 
        return ret;
    }
}