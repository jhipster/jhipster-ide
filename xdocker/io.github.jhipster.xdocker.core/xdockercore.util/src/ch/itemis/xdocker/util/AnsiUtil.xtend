/** 
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis-schweiz.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ch.itemis.xdocker.util

import java.io.ByteArrayOutputStream
import java.io.IOException
import org.fusesource.jansi.AnsiOutputStream

/** 
 * Utility Class to remove ANSI sequence Chars
 * @author Serano Colameo - Initial contribution and API
 */
class AnsiUtil {

	/**
	 * Removes ANSI character sequences
	 * 
	 * @param byteArray
	 */	
	def static String stripAnsi(byte[] byteArray) {
		return stripAnsi(new String(byteArray))
	}

	/**
	 * Removes ANSI character sequences
	 * 
	 * @param byteArray
	 */	
	def static String stripAnsi(String str) {
		if(str === null) return ''
		try {
			var ByteArrayOutputStream baos = new ByteArrayOutputStream
			var AnsiOutputStream aos = new AnsiOutputStream(baos)
			aos.write(str.getBytes())
			aos.close
			return baos.toString
		} catch (IOException e) {
			return str
		}
	}
}
