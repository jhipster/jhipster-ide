package ch.itemis.xdocker.util

/**
 * Operating System Utility Class
 */
class OsUtil {

	public static String osName = System.getProperty('os.name')?.toLowerCase
	public static boolean isWindows = osName !== null && osName.contains('windows')
	public static boolean isMacOsX = osName !== null && osName.contains('mac')
	public static boolean isLinux = osName !== null && osName.contains('linux')
	public static boolean isUnix = isMacOsX || isLinux
	
}
