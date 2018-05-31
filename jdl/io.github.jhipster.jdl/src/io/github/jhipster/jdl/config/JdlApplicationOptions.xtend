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

import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.Triple
import org.eclipse.xtext.util.Tuples
import com.google.inject.Singleton

import static io.github.jhipster.jdl.config.JdlApplicationParameterType.*

/**
 * @author Serano Colameo - Initial contribution and API
 */ 
@Singleton
class JdlApplicationOptions {
	
	val Map<String, JdlApplicationOption> options = newHashMap
	
	private new() {} // this is a singleton!
	
	@Accessors(PUBLIC_GETTER) val static INSTANCE = new JdlApplicationOptions => [
		addAll(#[
			new JdlApplicationOption('applicationType', #['monolith', 'microservice', 'gateway', 'uaa']),
			new JdlApplicationOption('authenticationType', #['jwt', 'session', 'uaa', 'oauth2']),
			new JdlApplicationOption('baseName', #['jhipster']),
			new JdlApplicationOption('buildTool', #['maven', 'gradle']),
			new JdlApplicationOption('cacheProvider', #['ehcache', 'hazelcast', 'infinispan', 'no']),
			new JdlApplicationOption('clientFramework', #['angularX', 'react']),
			new JdlApplicationOption('clientPackageManager', #['yarn', 'npm']),
			new JdlApplicationOption('databaseType', #['sql', 'mongodb', 'cassandra', 'couchbase', 'no']),
			new JdlApplicationOption('devDatabaseType', #['h2Disk', 'h2Memory', '*']),
			new JdlApplicationOption('enableHibernateCache', #['true']),
			new JdlApplicationOption('enableSwaggerCodegen', #['false']),
			new JdlApplicationOption('enableTranslation', #['true']),
			new JdlApplicationOption('jhiPrefix', #['jhi']),
			new JdlApplicationOption('jhipsterVersion', Version),
			new JdlApplicationOption('languages', #['en', 'fr'], ListOfLangIsoCodes),
			new JdlApplicationOption('messageBroker', #['kafka', 'false']),
			new JdlApplicationOption('nativeLanguage', #['en'], LangIsoCode),
			new JdlApplicationOption('packageName', Namespace),
			new JdlApplicationOption('prodDatabaseType', #['mysql', 'mariadb', 'mssql', 'postgresql', 'oracle', 'no']),
			new JdlApplicationOption('searchEngine', #['elasticsearch', 'false']),
			new JdlApplicationOption('serverPort', #['8080', '8081', '9999'], Number),
			new JdlApplicationOption('serviceDiscoveryType', #['eureka', 'consul', 'no']),
			new JdlApplicationOption('skipClient', Boolean),
			new JdlApplicationOption('skipServer', Boolean),
			new JdlApplicationOption('skipUserManagement', Boolean),
			new JdlApplicationOption('testFrameworks', #['protactor', 'cucumber', 'gatling'], ListOfLiterals),
			new JdlApplicationOption('uaaBaseName',  #['uaa']),
			new JdlApplicationOption('useSass', Boolean),
			new JdlApplicationOption('websocket', #['spring-websocket', 'false'])
		])
		
	]

	def void add(JdlApplicationOption option) {
		options.put(option.name, option)
	}

	def void addAll(JdlApplicationOption[] options) {
		options.forEach[add(it)]
	}
	
	def List<String> getNames() {
		return if (options.isEmpty) #[] else options.keySet.toList
	}

	def List<String> getParameters(String name) {
		return if (!options.containsKey(name)) #[] else options.get(name).parameters
	}

	def JdlApplicationParameterType getParameterType(String name) {
		return if (!options.containsKey(name)) Undefined else options.get(name).parameterType
	}
}

enum JdlApplicationParameterType {
	Undefined,
	Literal,
	ListOfLiterals,
	ListOfLangIsoCodes,
	LangIsoCode,
	Namespace,
	Boolean,
	Version,
	Number
}

class JdlApplicationOption {
	@Accessors(PUBLIC_GETTER) Triple<String, String[], JdlApplicationParameterType> config

	def String getName() {
		return config.first
	}

	def JdlApplicationParameterType getParameterType() {
		return config.third
	}

	def List<String> getParameters() {
		return config.second
	}

	new(String name) {
		this(name, #[], Literal)
	}

	new(String name, String[] properties) {
		this(name, properties, Literal)
	}
	
	new(String name, JdlApplicationParameterType type) {
		this(name,  #[], type)
	}
	
	new(String name, String[] properties, JdlApplicationParameterType type) {
		this.config = Tuples.create(name, properties, type)
	}
}
