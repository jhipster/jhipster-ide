package ch.itemis.xdocker.app.xdockerscout.ui.html.res.loader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.eclipse.scout.rt.platform.config.CONFIG;
import org.eclipse.scout.rt.ui.html.res.loader.HtmlDocumentParser;
import org.eclipse.scout.rt.ui.html.res.loader.HtmlDocumentParserParameters;

import ch.itemis.xdocker.app.xdockerscout.client.config.XdockerServerUrlProperty;

public class XdockerHtmlDocumentParser extends HtmlDocumentParser {

	private static final String PATTERN_XTEXT_SERVER_URL = "#xtextServerUrl";

	public XdockerHtmlDocumentParser(HtmlDocumentParserParameters params) {
		super(params);
	}

	@Override
	public byte[] parseDocument(byte[] document) throws IOException {
		String content = toUtf8String(document);
		return super.parseDocument(toBytes(replaceXtextBaseTags(content)));
	}

	public String getServerUrl() {
		return CONFIG.getPropertyValue(XdockerServerUrlProperty.class);
	}

	protected String replaceXtextBaseTags(String content) {
		String xtextServerUrl = getServerUrl();
		return content.replaceAll(PATTERN_XTEXT_SERVER_URL, xtextServerUrl);
	}

	private String toUtf8String(byte[] document) throws IOException {
		return new String(document, StandardCharsets.UTF_8.name());
	}

	private byte[] toBytes(String content) throws UnsupportedEncodingException {
		return content.getBytes(StandardCharsets.UTF_8.name());
	}
}
