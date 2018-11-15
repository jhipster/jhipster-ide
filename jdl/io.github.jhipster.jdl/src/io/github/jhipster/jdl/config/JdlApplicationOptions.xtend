/**
 * Copyright 2013-2018 the original author or authors from the JHipster project.
 *
 * This file is part of the JHipster project, see http://www.jhipster.tech/
 * for more information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.jhipster.jdl.config

import com.google.inject.Singleton
import org.eclipse.xtend.lib.annotations.Accessors

import static io.github.jhipster.jdl.config.JdlParameterType.*

/**
 * @author Serano Colameo - Initial contribution and API
 */ 
@Singleton
class JdlApplicationOptions extends JdlAbstractOptions {
	
	public static val JH_VERSION = 'jhipsterVersion'
	public static val SERVER_PORT = 'serverPort'
	
	@Accessors(PUBLIC_GETTER) val static INSTANCE = new JdlApplicationOptions => [
		val noSqlDbTypes = #['mongodb', 'cassandra', 'couchbase']
		val prodDbTypes = #['mysql', 'mariadb', 'mssql', 'postgresql', 'oracle', 'no'] + noSqlDbTypes
		addAll(#[
			new JdlOption('applicationType', #['monolith', 'microservice', 'gateway', 'uaa']),
			new JdlOption('authenticationType', #['jwt', 'session', 'uaa', 'oauth2']),
			new JdlOption('baseName', #['yourBaseName'], AnyLiteral),
			new JdlOption('buildTool', #['maven', 'gradle']),
			new JdlOption('cacheProvider', #['ehcache', 'hazelcast', 'infinispan', 'no']),
			new JdlOption('clientFramework', #['angularX', 'react']),
			new JdlOption('clientPackageManager', #['yarn', 'npm']),
			new JdlOption('databaseType', #['sql', 'mongodb', 'cassandra', 'couchbase', 'no']),
			new JdlOption('prodDatabaseType', prodDbTypes),
			new JdlOption('devDatabaseType', #['h2Disk', 'h2Memory', '*'] + prodDbTypes),
			new JdlOption('enableHibernateCache', #['true'], Boolean),
			new JdlOption('enableSwaggerCodegen', #['false'], Boolean),
			new JdlOption('enableTranslation', #['true'], Boolean),
			new JdlOption('jhiPrefix', #['jhi'], JavaIdentifierLiteral),
			new JdlOption('jhipsterVersion', Version),
			new JdlOption('languages', #['en', 'fr'], ListOfLangIsoCodes),
			new JdlOption('messageBroker', #['kafka', 'false']),
			new JdlOption('nativeLanguage', #['en'], LangIsoCode),
			new JdlOption('packageName', Namespace),
			new JdlOption('searchEngine', #['elasticsearch', 'false']),
			new JdlOption('serverPort', #['8080', '8081', '9999'], Number),
			new JdlOption('serviceDiscoveryType', #['eureka', 'consul', 'no', 'false']),
			new JdlOption('skipClient', Boolean),
			new JdlOption('skipServer', Boolean),
			new JdlOption('skipUserManagement', Boolean),
			new JdlOption('testFrameworks', #['protractor', 'cucumber', 'gatling'], ListOfLiterals),
			new JdlOption('uaaBaseName',  #['"uaa"']),
			new JdlOption('useSass', Boolean),
			new JdlOption('websocket', #['spring-websocket', 'false'])
		])
	]
}
