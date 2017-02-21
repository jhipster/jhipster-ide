package ch.itemis.xdocker.app.xdockerscout.ui.html.res.loader;

import org.eclipse.scout.rt.ui.html.res.loader.HtmlDocumentParser;
import org.eclipse.scout.rt.ui.html.res.loader.HtmlDocumentParserParameters;
import org.eclipse.scout.rt.ui.html.res.loader.HtmlFileLoader;

public class XdockerHtmlFileLoader extends HtmlFileLoader {

	public XdockerHtmlFileLoader(String theme, boolean minify, boolean cacheEnabled) {
		super(theme, minify, cacheEnabled);
	}

	@Override
	protected HtmlDocumentParser createHtmlDocumentParser(HtmlDocumentParserParameters params) {
		return new XdockerHtmlDocumentParser(params);
	}
}
