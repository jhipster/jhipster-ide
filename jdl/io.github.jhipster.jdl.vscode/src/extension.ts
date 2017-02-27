'use strict';

import * as net from 'net';
import * as path from 'path';

import * as child_process from 'child_process';
import * as fs from 'fs';
import * as vscode from 'vscode';

import { workspace, Disposable, ExtensionContext } from 'vscode';
import { LanguageClient, LanguageClientOptions, ServerOptions } from 'vscode-languageclient';

export function activate(context: ExtensionContext) {
    // The server is a locally installed Java application
    let executable = process.platform == 'win32' ? 'xtext-server-jdl.bat' : 'xtext-server-jdl';
    let serverLauncher = context.asAbsolutePath(path.join('xtext-server-jdl', 'bin', executable));
    let serverOptions: ServerOptions = {
        run : { command: serverLauncher }, debug: { command: serverLauncher }
    }
    
    // Options to control the language client
    let clientOptions: LanguageClientOptions = {
        // Register the server for plain text documents
        documentSelector: ['jdl'],
        synchronize: {
            // Synchronize the setting section 'languageServerExample' to the server
            configurationSection: 'languageServerExample',
            // Notify the server about file changes to '.clientrc files contain in the workspace
            fileEvents: workspace.createFileSystemWatcher('**/*.*')
        }
    }
	
	// Create the language client and start the client.
	let disposable = new LanguageClient('Xtext Server', serverOptions, clientOptions).start();
	
	// Push the disposable to the context's subscriptions so that the 
	// client can be deactivated on extension deactivation
	context.subscriptions.push(disposable);
    let ext = new plantuml.Extension(context);
    ext.init();
}

export function deactivate() {
}

module plantuml {
    export class Extension {
        private static _PREVIEW_URI = vscode.Uri.parse('plantuml-preview://authority/plantuml-preview');
        private _renderer = new Renderer();
        private _provider = new PreviewProvider(this._renderer);

        public constructor(private _ctx: vscode.ExtensionContext) {
        }

        public init() {
            if (this._checkSetup()) {
                this._prepareAndRegisterContentProvider();
                this._prepareAndRegisterCommands();
                this._prepareEditorListerners();
            }
        }

        private _checkSetup(): boolean {
            let ret: boolean = true;
            if (!process.env['PLANTUML_JAR'] || !process.env['JAVA_HOME'] || !process.env['GRAPHVIZ_DOT']) {
                let msg = 'Setup enviroment variable. PLANTUML_JAR, JAVA_HOME, GRAPHVIZ_DOT and then restart vscode';
                vscode.window.showErrorMessage(msg);
                ret = false;
            }
            return ret;
        }

        private _prepareAndRegisterContentProvider() {
            let registration = vscode.workspace.registerTextDocumentContentProvider('plantuml-preview', this._provider);
            this._ctx.subscriptions.push(this._provider);
        }

        private _prepareAndRegisterCommands() {
            this._preparePreviewCmd();
            for (let i = 0; i < 12; i++) {
                this._prepareExportCmds(i);
            }
        }

        private _prepareEditorListerners() {
            vscode.workspace.onDidSaveTextDocument((e: vscode.TextDocument) => {
                if( e === vscode.window.activeTextEditor.document)
                    this._provider.update(Extension._PREVIEW_URI);
            });
        }

        private _preparePreviewCmd() {
            let cmdPreview = vscode.commands.registerCommand('plantuml.preview', () => {
                let ret = vscode.commands.executeCommand('vscode.previewHtml', Extension._PREVIEW_URI, vscode.ViewColumn.Two, 'PlantUML Preview');
                ret.then((ok) => {
                    this._provider.update(Extension._PREVIEW_URI);
                }, (err) => {
                    vscode.window.showErrorMessage(err);
                });
            });
            this._ctx.subscriptions.push(cmdPreview);
        }

        private _prepareExportCmds(fmt: OutputFmt) {
            let sCmd: string = `plantuml.export${OutputFmt[fmt]}`;
            let cmdExport = vscode.commands.registerCommand(sCmd, () => {
                this._renderer.export(fmt);
            });
            this._ctx.subscriptions.push(cmdExport);
        }
    }

    class PreviewProvider implements vscode.TextDocumentContentProvider {
        private _onDidChange = new vscode.EventEmitter<vscode.Uri>();

        public constructor(private _renderer: Renderer) {
        }

        public dispose() {
            this._onDidChange.dispose();
        }

        public get onDidChange() {
            return this._onDidChange.event;
        }

        public update(uri: vscode.Uri) {
            this._onDidChange.fire(uri);
        }

        public provideTextDocumentContent(uri: vscode.Uri, token: vscode.CancellationToken): string | Thenable<string> {
            this._renderer.preview = true;
            return this._renderer.render();
        }
    }

    class Renderer {
        public preview: boolean = true;
        public exportFmt: OutputFmt = OutputFmt.SVG;

        private static _JAR_FILE: string = process.env['PLANTUML_JAR'];
        private static _JAVA_EXE: string = path.join(process.env['JAVA_HOME'], 'bin', 'java');
//        private static _BASE_OPTS: string[] = ["-Djava.awt.headless=true", "-jar", Renderer._JAR_FILE, "-charset", "utf-8", "-p"];
        private static _BASE_OPTS: string[] = ["-Djava.awt.headless=true", "-jar", Renderer._JAR_FILE];
        private static _DELIM: string[] = ["@startuml", "@enduml"];

        private _editor: vscode.TextEditor = null;
        private _buff: string = null;

        public render(): Thenable<string> {
            let ret: Thenable<string> = null;
            this._editor = vscode.window.activeTextEditor;
            if (this._editor.document.languageId === "plaintext" || this._editor.document.languageId === "plantuml") {
                this._buff = this._editor.document.getText().trim();
                try {
                    if (this._checkBasicSyntax(this._buff)) {
                        let args = this._prepareCmdArgs();
                        ret = this._prepareAndExecCmd(args);
                    } else {
                        if (!this.preview)
                            vscode.window.showErrorMessage(`Invalid content for Plant UML export`);
                    }
                } finally {
                    this._buff = null;
                }
            }
            this._editor = null;
            return ret;
        }

        public export(fmt: OutputFmt) {
            this.exportFmt = fmt;
            this.preview = false;
            this.render();
        }

        private _checkBasicSyntax(buff: string): boolean {
            let ret = false;
            let firstDelim = buff.substr(0, 9).toLowerCase();
            let lastDelim = buff.slice(-7).toLowerCase();
            if (Renderer._DELIM[0] === firstDelim && Renderer._DELIM[1] == lastDelim)
                ret = true;
            return ret;
        }

        private _getWorkingPath(): string[] {
            let fsPath = this._editor.document.uri.fsPath;
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
            return [dirName,fsPath];
        }

        private _prepareCmdArgs(): PreparedArgs {
            let ret = {
                opts: null,
                outputFile: null,
                fileExt: null
            };
            let [dirName,fsPath] = this._getWorkingPath();
            let plantumlOpts = ["-Dplantuml.include.path=\""+dirName+"\""];
            if (this.preview) {
//                ret.opts = plantumlOpts.concat(Renderer._BASE_OPTS).concat("-tsvg");
                ret.outputFile = this._editor.document.uri.toString(false).replace('.plantuml', '.png');
                ret.opts = plantumlOpts.concat(Renderer._BASE_OPTS).concat("-tpng").concat(fsPath).concat(" -o " + ret.outputFile);
            } else {
                let format = OutputFmt[this.exportFmt].toLowerCase();
                ret.opts = plantumlOpts.concat(Renderer._BASE_OPTS).concat("-t" + format);
                ret.fileExt = format;
                ret.outputFile = fsPath + '.' + ret.fileExt;
                if (this.exportFmt === OutputFmt.LATEX_NOPREAMBLE)
                    ret.fileExt = ret.fileExt.replace('_', ':');
                vscode.window.showInformationMessage(`Refer to ${ret.outputFile} for exported ${format.toUpperCase()} document`);
            }
            return ret;
        }

        private _prepareAndExecCmd(args: PreparedArgs): Thenable<string> {
            if (this._buff.trim().length === 0)
                return null;
            let plantJar = child_process.spawn(Renderer._JAVA_EXE, args.opts);
//            let plantJar = child_process.execFile(Renderer._JAVA_EXE, args.opts);
            console.log(args.opts);
            plantJar.stdin.write(this._buff);
            plantJar.stdin.end();
            let ret: Thenable<string> = null;
            if (this.preview) {
                ret = new Promise<string>((res) => {
                    let b64: string = "";
//                    plantJar.stdout.on('data', (data) => {
//                        b64 += data.toString('base64');
//                    });
                    plantJar.stdout.on('close', (close) => {
//                        let html = `<html><body style="background-color:white;">${svgTxt}</body></html>`;
//                        let html = `<html><body style="background-color:white;"><img src="data:image/png;base64,${b64}" alt="puml"></body></html>`; 
                        let html = `<html><body style="background-color:white;"><img src="${args.outputFile}"></body></html>`; 
                        res(html);
                    });
                });
            } else {
                let fos: fs.WriteStream = fs.createWriteStream(args.outputFile, { flags: 'a' });
                plantJar.stdout.on('data', (data) => {
                    fos.write(data);
                });
                plantJar.stdout.on('close', (close) => {
                    fos.end();
                    fos.close();
                    vscode.window.showInformationMessage("PlantUML Export completed!");
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

    enum OutputFmt {
        PNG,
        SVG,
        EPS,
        PDF,
        VDX,
        XMI,
        SCXML,
        HTML,
        TXT,
        UTXT,
        LATEX,
        LATEX_NOPREAMBLE
    }
}
