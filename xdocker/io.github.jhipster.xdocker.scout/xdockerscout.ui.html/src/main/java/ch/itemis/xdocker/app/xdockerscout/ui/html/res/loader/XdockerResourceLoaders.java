/*******************************************************************************
 * Copyright (c) 2014-2015 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package ch.itemis.xdocker.app.xdockerscout.ui.html.res.loader;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.ui.html.res.loader.DefaultResourceLoaderFactory;
import org.eclipse.scout.rt.ui.html.res.loader.IResourceLoader;
import org.eclipse.scout.rt.ui.html.res.loader.IResourceLoaderFactory;

@ApplicationScoped
public class XdockerResourceLoaders extends DefaultResourceLoaderFactory implements IResourceLoaderFactory {

	@Override
	public IResourceLoader createResourceLoader(HttpServletRequest req, String resourcePath) {
		if (resourcePath.endsWith(".html")) {
			return new XdockerHtmlFileLoader(req, getScriptProcessor());
		}
		return super.createResourceLoader(req, resourcePath);
	}
}
