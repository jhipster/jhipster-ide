/**
 * Copyright 2016-2024 the original author or authors from the JHipster project.
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
 */
package io.github.jhipster.jdl.ui.wizard;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "io.github.jhipster.jdl.ui.wizard.messages"; //$NON-NLS-1$
	
	public static String MonolithProject_Label;
	public static String MonolithProject_Description;
	public static String JHipsterProject_Label;
	public static String JHipsterProject_Description;
	public static String JHipsterMonolithProject_Label;
	public static String JHipsterMonolithProject_Description;
	public static String JHipsterProjectFromCli_Label;
	public static String JHipsterProjectFromCli_Description;
	public static String JHipsterMonolithProject2_Label;
	public static String JHipsterMonolithProject2_Description;
	public static String JHipsterMicroserviceProject_Label;
	public static String JHipsterMicroserviceProject_Description;
	public static String JHipsterGatewayProject_Label;
	public static String JHipsterGatewayProject_Description;
	
	static {
	// initialize resource bundle
	NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
	private Messages() {
	}
}
