/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis-schweiz.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.converter;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.conversion.impl.AbstractIDValueConverter;

import com.google.common.collect.ImmutableSet;

/**
 * Value Converter for ANY Terminal
 * 
 * @author Serano Colameo
 */
public class ANYValueConverter extends AbstractIDValueConverter {

    public ANYValueConverter() {
    	super();
    }

    @Override
    protected Set<String> computeValuesToEscape(final Grammar grammar) {
    	return ImmutableSet.copyOf(GrammarUtil.getAllKeywords(grammar));
    }

    @Override
    protected boolean mustEscape(final String value) {
    	return getValuesToEscape().contains(value);
    }
}
