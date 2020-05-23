/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis-schweiz.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.converter;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.conversion.impl.INTValueConverter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Xdocker Terminal Converters Class
 * 
 * @author Serano Colameo
 */
@Singleton
public class XdockerTerminalConverters extends
	AbstractDeclarativeValueConverterService {

    @Inject
    private INTValueConverter intValueConverter;

    @Inject
    private ANYValueConverter anyValueConverter;

    @ValueConverter(rule = "INT")
    public IValueConverter<Integer> INT() {
	return intValueConverter;
    }

    @ValueConverter(rule = "ANY")
    public IValueConverter<String> ANY() {
	return anyValueConverter;
    }
}
