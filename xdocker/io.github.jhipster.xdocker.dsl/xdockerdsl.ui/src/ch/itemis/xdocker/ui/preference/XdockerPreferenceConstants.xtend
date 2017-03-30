package ch.itemis.xdocker.ui.preference

import ch.itemis.xdocker.lib.config.DockerPropertiesConstants

import static ch.itemis.xdocker.util.OsUtil.*
import static java.lang.System.*

/** 
 * Docker constant definitions for plug-in preferences
 */
interface XdockerPreferenceConstants extends DockerPropertiesConstants {
	
	public static String V_Home_Value = getProperty('user.home').replace('\\','/')
	public static String V_Home_Token = '\\$\\{user.home\\}'
	public static String V_User_Value = getProperty('user.name').replace('\\','/')
	public static String V_User_Token =  '\\$\\{user.name\\}'
	public static String V_Docker_URL = if (isUnix)  'unix:///var/run/docker.sock' else if (isWindows) 'tcp://0.0.0.0:2375' else ''
	public static String V_Docker_ServerAddress = 'https://index.docker.io/v1/'
	public static String V_Docker_CertPath = '${user.home}/.docker'
	public static String V_Docker_CfgPath = '${user.home}/.docker'
	public static String V_Docker_UserName = '${user.name}'
	public static boolean V_Docker_EnableLoggingFilter = true

}
