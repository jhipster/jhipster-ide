/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis-schweiz.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.preference

import ch.itemis.xdocker.lib.DockerProperties
import org.eclipse.jface.preference.IPreferenceStore
import xdockerdsl.ui.internal.XdockerdslActivator

import static ch.itemis.xdocker.lib.config.DockerPropertiesConstants.*

/**
 * XdockerDockerPreferences Class - returns stored preference properties
 * 
 * @author Serano Colameo - Initial contribution and API
 */
final class XdockerDockerPreferences {

	var IPreferenceStore store
	public static var XdockerDockerPreferences INSTANCE = new XdockerDockerPreferences

	def static void defaults(String dockerUrl, Boolean enableLoggingFilter, String dockerCertPath, String dockerCfgPath,
		String dockerServerAddress, String dockerUserName, String dockerPassword) {
		INSTANCE = new XdockerDockerPreferences(
			dockerUrl,
			enableLoggingFilter,
			dockerCertPath,
			dockerCfgPath,
			dockerServerAddress,
			dockerUserName,
			dockerPassword
		)
	}

	def static DockerProperties getDockerProperties() {
		if (INSTANCE === null) throw new IllegalStateException('Unable to load Xdocker properties!')
		return INSTANCE.toDockerProperties
	}

	private new() {
		store = XdockerdslActivator.instance.preferenceStore
	}

	private new(String dockerUrl, Boolean enableLoggingFilter, String dockerCertPath, String dockerCfgPath,
		String dockerServerAddress, String dockerUserName, String dockerPassword) {
		this()
		store.setDefault(P_Docker_URL, dockerUrl)
		store.setDefault(P_Docker_EnableLoggingFilter, enableLoggingFilter)
		store.setDefault(P_Docker_CertPath, dockerCertPath)
		store.setDefault(P_Docker_CfgPath, dockerCfgPath)
		store.setDefault(P_Docker_UserName, dockerUserName)
		store.setDefault(P_Docker_UserName, dockerUserName)
		store.setDefault(P_Docker_ServerAddress, dockerServerAddress)
	}

	def DockerProperties toDockerProperties() {
		return new DockerProperties(newHashMap(
				'enableLoggingFilter' -> enableLoggingFilter,
				'dockerHost' -> dockerUrl,
				'dockerCertPath' -> dockerCertPath,
				'dockerConfig' -> dockerCfgPath,
				'registryUrl' -> dockerServerAddress,
				'registryUsername' -> dockerUserName,
				'registryPassword' -> dockerPassword
			)
		)
	}

	def dockerUrl() {
		store.getString(P_Docker_URL)
	}

	def dockerUrl(String value) {
		store.setValue(P_Docker_URL, value)
	}

	def enableLoggingFilter() {
		store.getBoolean(P_Docker_EnableLoggingFilter)
	}

	def enableLoggingFilter(boolean value) {
		store.setValue(P_Docker_EnableLoggingFilter, value)
	}

	def dockerCertPath() {
		store.getString(P_Docker_CertPath)
	}

	def dockerCertPath(String value) {
		store.setValue(P_Docker_CertPath, value)
	}

	def dockerCfgPath() {
		store.getString(P_Docker_CfgPath)
	}

	def dockerCfgPath(String value) {
		store.setValue(P_Docker_CfgPath, value)
	}

	def dockerServerAddress() {
		store.getString(P_Docker_ServerAddress)
	}

	def dockerServerAddress(String value) {
		store.setValue(P_Docker_ServerAddress, value)
	}

	def dockerUserName() {
		store.getString(P_Docker_UserName)
	}

	def dockerUserName(String value) {
		store.setValue(P_Docker_UserName, value)
	}

	def dockerPassword() {
		store.getString(P_Docker_Password)
	}

	def dockerPassword(String value) {
		store.setValue(P_Docker_Password, value)
	}
}
