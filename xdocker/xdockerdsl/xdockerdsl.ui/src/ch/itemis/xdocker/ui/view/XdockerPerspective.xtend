/** 
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ch.itemis.xdocker.ui.view

import org.eclipse.ui.IPageLayout
import org.eclipse.ui.IPerspectiveFactory

import static ch.itemis.xdocker.ui.view.XdockerContainerBrowserView.*
import static ch.itemis.xdocker.ui.view.XdockerImageBrowserView.*
import static org.eclipse.jdt.ui.JavaUI.*
import static org.eclipse.ui.IPageLayout.*
import static org.eclipse.ui.console.IConsoleConstants.*
import static org.eclipse.ui.progress.IProgressConstants.*
import static org.eclipse.debug.ui.IDebugUIConstants.LAUNCH_ACTION_SET

/** 
 * Xdocker Perspective Class
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerPerspective implements IPerspectiveFactory {
	/** 
	 * Creates the initial layout for a page.
	 */
	override void createInitialLayout(IPageLayout it) {
		// create left side of perspective
		createFolder("left", LEFT, 0.25 as float, editorArea) => [ addView(ID_PROJECT_EXPLORER) ]
		// create bottom side of perspective
		createFolder("bottom", BOTTOM, 0.7 as float, editorArea) => [ f |
			#[ ID_PROBLEM_VIEW, ID_CONSOLE_VIEW, PROGRESS_VIEW_ID, ID_CONTAINER_BROWSER_VIEW, ID_IMAGE_BROWSER_VIEW ].forEach[
				f.addView(it)
			]
		]
		// create top right side of perspective
		createFolder("right", RIGHT, 0.75 as float, editorArea) => [
			addView(ID_OUTLINE)
		]
		// create action sets
		#[LAUNCH_ACTION_SET, ID_ACTION_SET, ID_ELEMENT_CREATION_ACTION_SET, ID_NAVIGATE_ACTION_SET].forEach[ s |
		  addActionSet(s)
		]		
		// create show view shortcuts 
		#[ID_PROJECTS_VIEW, ID_CONSOLE_VIEW, ID_CONTAINER_BROWSER_VIEW, ID_IMAGE_BROWSER_VIEW].forEach[ v |
			addShowViewShortcut(v)
		]
	}
}
