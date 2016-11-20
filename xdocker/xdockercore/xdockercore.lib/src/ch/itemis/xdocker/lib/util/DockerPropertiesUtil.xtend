/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.lib.util

import ch.itemis.xdocker.lib.DockerProperties
import java.io.File
import java.util.Properties
import org.apache.commons.beanutils.BeanUtils
import org.apache.commons.io.FileUtils

import static java.lang.System.getProperty
import static java.lang.System.setProperty
import static org.apache.commons.beanutils.PropertyUtils.getProperty

/**
 * Docker Utility Class
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class DockerPropertiesUtil {
	
	val static DEFAULT_PROPS_FILE_NAME = '''«getProperty('user.home')»/.xdocker/docker.properties'''
	
	/**
	 * Setup Docker Properties 
	 */
	def static void setupDockerProperties(DockerProperties props) {
		val propNames = props?.class?.declaredFields?.map[name]
		if (!propNames.nullOrEmpty) propNames.forEach[propName|
			val propValue = getProperty(props, propName) ?: ""
			setDockerProperty(propName, propValue.toString)
		]
	}
	
	/**
	 * Setup a Docker Property
	 */
	def static setDockerProperty(String propName, String propValue) {
		if (propValue != null) {
			setProperty('''docker.io.«propName»''', 
				if (propValue.nullOrEmpty) "" else propValue
			)
		}
	}

	/** 
	 * Persists docker properties to default file name
	 */
	def static void saveToDisk(DockerProperties props) {
		props.saveToDisk(DEFAULT_PROPS_FILE_NAME)
	}	
	
	/** 
	 * Persists docker properties
	 */
	def static void saveToDisk(DockerProperties dockerProps, String fileName) {
		val propFile = new File(fileName)
		propFile.parentFile.mkdirs
		val out = FileUtils.openOutputStream(propFile)
		dockerProps.toProperties.store(out, 'Docker Properties')
		out.close
	}

	/** 
	 * Loads docker properties from disk from default file name
	 */
	def static DockerProperties loadFromDisk() {
		loadFromDisk(DEFAULT_PROPS_FILE_NAME)
	}	

	/** 
	 * Loads docker properties from disk
	 */
	def static DockerProperties loadFromDisk(String fileName) {
		val propFile = new File(fileName)
		if (!propFile.exists) return null
		val in = FileUtils.openInputStream(propFile)
		val props = new Properties => [
			load(in)
		]
		in.close
		return toDockerProperties(props)
	}	

	/** 
	 * Converts a Properties object to a DockerProperties
	 */
	def static toDockerProperties(Properties it) {
		return new DockerProperties(
			getProperty('url'),
			Boolean.valueOf(
				getProperty('enableLoggingFilter')
			),
			getProperty('dockerCertPath'),
			getProperty('dockerCfgPath'),
			getProperty('serverAddress'),
			getProperty('username'),
			getProperty('password'),
			getProperty('projectPath')
		)
	}
	
	/** 
	 * Converts a DockerProperties object to a Properties
	 */
	def static Properties toProperties(DockerProperties props) {
		val result = new Properties
		val keys = props?.class?.declaredFields?.map[name]
		if (!keys.nullOrEmpty) keys.forEach[key|
			val value = BeanUtils.getProperty(props, key) ?: ''
			result.put(key, value)
		]
		result		
	}
}
