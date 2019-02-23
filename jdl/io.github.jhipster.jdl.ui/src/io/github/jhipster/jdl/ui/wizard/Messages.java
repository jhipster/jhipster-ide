package io.github.jhipster.jdl.ui.wizard;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "io.github.jhipster.jdl.ui.wizard.messages"; //$NON-NLS-1$
	
	public static String HelloWorldProject_Label;
	public static String HelloWorldProject_Description;
	public static String HelloWorldProject2_Label;
	public static String HelloWorldProject2_Description;
	public static String MonolithProject_Label;
	public static String MonolithProject_Description;
	public static String JHipsterProject_Label;
	public static String JHipsterProject_Description;
	public static String JHipsterMonolithProject_Label;
	public static String JHipsterMonolithProject_Description;
	public static String JHipsterProjectFromCli_Label;
	public static String JHipsterProjectFromCli_Description;
	
	static {
	// initialize resource bundle
	NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
