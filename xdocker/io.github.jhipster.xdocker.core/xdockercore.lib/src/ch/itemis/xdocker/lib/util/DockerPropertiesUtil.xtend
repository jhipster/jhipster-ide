/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.lib.util

import ch.itemis.xdocker.lib.DockerProperties
import com.github.dockerjava.core.DefaultDockerClientConfig
import java.io.File
import java.util.Properties
import org.apache.commons.io.FileUtils

import static java.lang.System.getProperty

/**
 * Docker Utility Class
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class DockerPropertiesUtil {
	
	val static DEFAULT_PROPS_FILE_NAME = '''«getProperty('user.home')»/.xdocker/docker.properties'''
	
	/**
	 * Create docker config 
	 */
	def static createDockerConfig(DockerProperties dockerProps) {
		createDockerBuilder(dockerProps).build
	}
	
	/**
	 * Create docker config builder 
	 */
	def static createDockerBuilder(DockerProperties dockerProps) {
		return new DefaultDockerClientConfig.Builder => [
			withProperties(dockerProps.toProperties)
		]
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
	def static toDockerProperties(Properties props) {
		if (props === null || props.isEmpty) return null
		val params = <String, Object>newHashMap
		props.keySet.forEach[ k | params.put(k.toString, props.get(k))]
		return new DockerProperties(params) 
	}
	
	/** 
	 * Converts a DockerProperties object to a Properties
	 */
	def static Properties toProperties(DockerProperties it) {
		return new Properties => [ props |
			parameters.forEach[k, v|
				if (k != null && v != null) props.put(k, v)
			]
		]
	}
}
