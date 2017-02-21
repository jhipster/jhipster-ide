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

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.server.commons.servlet.cache.HttpCacheKey;
import org.eclipse.scout.rt.server.commons.servlet.cache.HttpCacheObject;
import org.eclipse.scout.rt.ui.html.res.loader.AbstractResourceLoader;
import org.eclipse.scout.rt.ui.html.res.loader.IResourceLoader;

@ApplicationScoped
public class XdockerResourceLoaders extends AbstractResourceLoader {

//	@Override
//	public IResourceLoader createResourceLoader(HttpServletRequest req, String resourcePath) {
//		if (resourcePath.endsWith(".html")) {
//			return new XdockerHtmlFileLoader(req, getScriptProcessor());
//		}
//		return super.createResourceLoader(req, resourcePath);
//	}

	// FIXME - DO NOT KNOW HOW TO DO THIS....
	@Override
	public HttpCacheObject loadResource(HttpCacheKey cacheKey) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
