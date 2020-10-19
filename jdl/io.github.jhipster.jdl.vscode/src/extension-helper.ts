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
import * as cp from 'child_process';
import { workspace, window, TextEditor  } from 'vscode';

export const isWindows = process.platform.indexOf('win') === 0;
export const JAVA_BIN = 'java' + (isWindows ? '.exe' : '');

export function toggleItem(editor: TextEditor, item) {
	if (editor && editor.document &&
		(editor.document.languageId === 'jdl' || editor.document.languageId === 'jh')){
		item.show();
	} else{
		item.hide();
	}
}

export function getJavaExec() : string {
    let result = JAVA_BIN;
    const javaHome = workspace.getConfiguration('java').home;
	if (javaHome) {
		const absPath = (javaHome + path.sep + 'bin' + path.sep + 'java')
        result = absPath.replace(path.sep + path.sep, path.sep);
    } else {
        window.showWarningMessage("No Java home defined in preference settings - use system defaults...");
    }
    return result;    
}

export async function checkJavaVersion(javaCli: string): Promise<number> {
    let javaVersion = await getJavaVersion(javaCli);
    return new Promise<number>((resolve, reject) => {
        if (javaVersion < 11) {
			let errmsg = 'Java 11 or more recent is required to run JHipster IDE extension!';
			window.showErrorMessage(errmsg);
			throw new Error(errmsg);
        }
        return resolve(javaVersion);
    });
}

async function getJavaVersion(javaCli: string): Promise<number> {
    return new Promise((resolve, reject) => {
        cp.execFile(javaCli, ['-version'], {}, (error, stdout, stderr) => {
            const match = (/version "(.*)"/g).exec(stderr);
            if (!match) {
                return resolve(0);
            }
            resolve(getJavaMajorVersion(match[1]));
        });
    });
}

function getJavaMajorVersion(version: string): number {
	let input = version.startsWith('1.') ? version.substring(2) : version;
    const match = (/\d+/g).exec(input);
    return match ? parseInt(match[0]) : 0;
}
