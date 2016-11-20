package io.github.jhipster.jdl.ui.view

import org.eclipse.ui.IPageLayout
import org.eclipse.ui.IPerspectiveFactory

import static org.eclipse.debug.ui.IDebugUIConstants.LAUNCH_ACTION_SET
import static org.eclipse.ui.IPageLayout.*
import static org.eclipse.ui.progress.IProgressConstants.*

class JDLPerspective implements IPerspectiveFactory {
	
	static String PLANTUML_ID = 'net.sourceforge.plantuml.eclipse.views.PlantUmlView'
	
	/** 
	 * Creates the initial layout for a page.
	 */
	override void createInitialLayout(IPageLayout it) {
		// create left side of perspective
		createFolder("left", LEFT, 0.25 as float, editorArea) => [ addView(ID_PROJECT_EXPLORER) ]
		// create bottom side of perspective
		createFolder("bottom", BOTTOM, 0.7 as float, editorArea) => [ f |
			#[ ID_PROBLEM_VIEW, PROGRESS_VIEW_ID, PLANTUML_ID].forEach[
				f.addView(it)
			]
		]
		// create top right side of perspective
		createFolder("right", RIGHT, 0.75 as float, editorArea) => [
			addView(ID_OUTLINE)
		]
		// create action sets
		#[LAUNCH_ACTION_SET, ID_NAVIGATE_ACTION_SET].forEach[ s |
		  addActionSet(s)
		]		
		// create show view shortcuts 
//		#[ID_PROJECTS_VIEW, ID_CONSOLE_VIEW, ID_CONTAINER_BROWSER_VIEW, ID_IMAGE_BROWSER_VIEW].forEach[ v |
//			addShowViewShortcut(v)
//		]
	}
}
