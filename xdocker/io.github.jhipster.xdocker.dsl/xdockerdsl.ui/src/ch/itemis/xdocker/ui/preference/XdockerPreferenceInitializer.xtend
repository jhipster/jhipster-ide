package ch.itemis.xdocker.ui.preference

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer

import static ch.itemis.xdocker.ui.preference.XdockerPreferenceConstants.*

/** 
 * Class used to initialize default preference values.
 */
class XdockerPreferenceInitializer extends AbstractPreferenceInitializer {	
	/*
	 * (non-Javadoc)
	 * 
	 * @see AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	override void initializeDefaultPreferences() {
		XdockerDockerPreferences.defaults(
			V_Docker_URL,
			V_Docker_EnableLoggingFilter,
			V_Docker_CertPath.replaceAll(V_Home_Token, V_Home_Value),
			V_Docker_CfgPath.replaceAll(V_Home_Token, V_Home_Value),
			V_Docker_ServerAddress,
			V_Docker_UserName.replaceAll(V_User_Token, V_User_Value),
			'' // no default password!
		)
	}
}
