package ch.itemis.xdocker.app.xdockerscout.ui.html.res.loader;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.scout.rt.ui.html.res.loader.HtmlDocumentParser;
import org.eclipse.scout.rt.ui.html.res.loader.HtmlDocumentParserParameters;
import org.eclipse.scout.rt.ui.html.res.loader.HtmlFileLoader;
import org.eclipse.scout.rt.ui.html.scriptprocessor.ScriptProcessor;

public class XdockerHtmlFileLoader extends HtmlFileLoader {

	public XdockerHtmlFileLoader(HttpServletRequest req, ScriptProcessor scriptProcessor) {
		super(req, scriptProcessor);
	}

	@Override
	protected HtmlDocumentParser createHtmlDocumentParser(HtmlDocumentParserParameters params) {
		return new XdockerHtmlDocumentParser(params);
	}
}
