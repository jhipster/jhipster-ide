/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.launch

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup
import org.eclipse.debug.ui.CommonTab
import org.eclipse.debug.ui.ILaunchConfigurationDialog
import org.eclipse.debug.ui.RefreshTab

/**
 * Xdocker Build Launch Tab Group Class
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerBuildLaunchTabGroup extends AbstractLaunchConfigurationTabGroup {

	override createTabs(ILaunchConfigurationDialog dialog, String mode) {
		tabs = newArrayList(
			new XdockerBuildImageLaunchConfigurationTab,
			new RefreshTab,
			new CommonTab
		)
	}
}