package ch.itemis.xdocker.ui.preference

import ch.itemis.xdocker.lib.config.DockerPropertiesConstants

/** 
 * Docker constant definitions for plug-in preferences
 */
interface XdockerPreferenceConstants extends DockerPropertiesConstants {
	public static val String V_Home_Value = System.getProperty('user.home')
	public static val String V_Home_Token = '\\$\\{user.home\\}'
	public static val String V_User_Value = System.getProperty('user.name')
	public static val String V_User_Token = '\\$\\{user.name\\}'
	public static val String V_Docker_URL = 'https://localhost:2376'
	public static val String V_Docker_ServerAddress = 'https://index.docker.io/v1/'
	public static val String V_Docker_CertPath = '${user.home}/.docker'
	public static val String V_Docker_CfgPath = '${user.home}/.dockercfg'
	public static val String V_Docker_UserName = '${user.name}'
	public static val boolean V_Docker_EnableLoggingFilter = true
}
