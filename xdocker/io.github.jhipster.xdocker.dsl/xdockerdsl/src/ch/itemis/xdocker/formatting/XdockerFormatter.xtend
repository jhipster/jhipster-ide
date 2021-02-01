/*******************************************************************************
 * Copyright (c) 2015-2021 Arcware GmbH (http://arcware.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.formatting

import org.eclipse.xtext.Keyword
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter
import org.eclipse.xtext.formatting.impl.FormattingConfig

import static org.eclipse.xtext.EcoreUtil2.eAllContentsAsList
import static org.eclipse.xtext.EcoreUtil2.typeSelect
import static org.eclipse.xtext.GrammarUtil.*

/**
 * This class contains custom formatting declarations.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#formatting
 * on how and when to use it.
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerFormatter extends AbstractDeclarativeFormatter {

//	@Inject extension XdockerGrammarAccess
	
	override protected void configureFormatting(FormattingConfig c) {
		allParserRules(grammar.getGrammar()).forEach[parseRule|
			typeSelect(
				eAllContentsAsList(parseRule), typeof(Keyword)
			).forEach[keyword|
				c.setLinewrap(0, 1, 2).before(keyword)
			]
		]
	}
}
