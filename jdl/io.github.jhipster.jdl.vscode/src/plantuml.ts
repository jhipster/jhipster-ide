'use strict';

import * as net from 'net';
import * as path from 'path';
import * as child_process from 'child_process';
import * as fs from 'fs';
import * as vscode from 'vscode';

export class PlantUMLRenderer {
    private static PREVIEW_URI = vscode.Uri.parse('plantuml-preview://authority/plantuml-preview');
    private renderer = new Renderer();
    private provider = new PreviewProvider(this.renderer);

    public constructor(private _ctx: vscode.ExtensionContext) {
    }

    public init() {
        if (this.checkSetup()) {
            this.prepareAndRegisterContentProvider();
            this.prepareAndRegisterCommands();
            this.prepareEditorListerners();
        }
    }

    private checkSetup(): boolean {
        let ret: boolean = true;
        let javaexe = child_process.exec('java -version', (error, stdout, stderr) => {
            if (error !== null) {
                let msg = `Error executing java: ${error}`;
                vscode.window.showErrorMessage(msg);
                ret = false;
            } else {
                ret = true;
            }
        });
        return ret;
    }

    private prepareAndRegisterContentProvider() {
        let registration = vscode.workspace.registerTextDocumentContentProvider('plantuml-preview', this.provider);
        this._ctx.subscriptions.push(this.provider);
    }

    private prepareAndRegisterCommands() {
        this.preparePreviewCmd();
    }

    private prepareEditorListerners() {
        vscode.workspace.onDidSaveTextDocument((e: vscode.TextDocument) => {
            if (e === vscode.window.activeTextEditor.document)
                this.provider.update(PlantUMLRenderer.PREVIEW_URI);
        });
    }

    private preparePreviewCmd() {
        let cmdPreview = vscode.commands.registerCommand('plantuml.preview', () => {
            let ret = vscode.commands.executeCommand('vscode.previewHtml', PlantUMLRenderer.PREVIEW_URI, vscode.ViewColumn.Two, 'PlantUML Preview');
            ret.then((ok) => {
                this.provider.update(PlantUMLRenderer.PREVIEW_URI);
            }, (err) => {
                vscode.window.showErrorMessage(err);
            });
        });
        this._ctx.subscriptions.push(cmdPreview);
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
    private static JAR_FILE: string = "./lib/plantuml.jar";
//    private static JAVA_EXE: string = path.join(process.env['JAVA_HOME'], 'bin', 'java');
    private static JAVA_EXE: string = "java";
    private static BASE_OPTS: string[] = ["-Djava.awt.headless=true", "-jar", Renderer.JAR_FILE];
    private static DELIM: string[] = ["@startuml", "@enduml"];

    private editor: vscode.TextEditor = null;
    private buff: string = null;

    public render(): Thenable<string> {
        let ret: Thenable<string> = null;
        this.editor = vscode.window.activeTextEditor;
        if (this.editor.document.languageId === "plaintext" || this.editor.document.languageId === "plantuml") {
            this.buff = this.editor.document.getText().trim();
            try {
                if (this._checkBasicSyntax(this.buff)) {
                    let args = this._prepareCmdArgs();
                    ret = this._prepareAndExecCmd(args);
                } 
            } finally {
                this.buff = null;
            }
        }
        this.editor = null;
        return ret;
    }

    private _checkBasicSyntax(buff: string): boolean {
        let ret = false;
        let firstDelim = buff.substr(0, 9).toLowerCase();
        let lastDelim = buff.slice(-7).toLowerCase();
        if (Renderer.DELIM[0] === firstDelim && Renderer.DELIM[1] == lastDelim) ret = true;
        return ret;
    }

    private _getWorkingPath(): string[] {
        let fsPath = this.editor.document.uri.fsPath;
        let dirName = path.dirname(fsPath);
        if (dirName === ".") {
            dirName = vscode.workspace.rootPath;
            if (dirName === undefined) {
                dirName = process.env['HOME'];
                if (dirName === undefined)
                    dirName = process.env['USERPROFILE'];
            }
            fsPath = dirName + "/" + fsPath;
        }
        return [dirName, fsPath];
    }

    private _prepareCmdArgs(): PreparedArgs {
        let ret = {
            opts: null,
            outputFile: null,
            fileExt: null
        };
        let [dirName, fsPath] = this._getWorkingPath();
        let plantumlOpts = ["-Dplantuml.include.path=\"" + dirName + "\""];
        if (this.preview) {
            ret.outputFile = this.editor.document.uri.toString(false).replace('.plantuml', '.png');
            ret.opts = plantumlOpts.concat(Renderer.BASE_OPTS).concat("-tpng").concat(fsPath).concat(" -o " + ret.outputFile);
        }
        return ret;
    }

    private _prepareAndExecCmd(args: PreparedArgs): Thenable<string> {
        if (this.buff.trim().length === 0) return null;
        let plantJar = child_process.spawn(Renderer.JAVA_EXE, args.opts);
        console.log(args.opts);
        plantJar.stdin.write(this.buff);
        plantJar.stdin.end();
        let ret: Thenable<string> = null;
        if (this.preview) {
            ret = new Promise<string>((res) => {
                let b64: string = "";
                plantJar.stdout.on('close', (close) => {
                    let html = `<html><body style="background-color:white;"><img src="${args.outputFile}"></body></html>`;
                    res(html);
                });
            });
        } 
        return ret;
    }
}

interface PreparedArgs {
    opts: string[];
    outputFile?: string;
    fileExt?: string;
}