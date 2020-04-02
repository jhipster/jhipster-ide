/**
 * Copyright 2013-2020 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.tests

import java.util.Iterator
import java.util.Map
import io.github.jhipster.jdl.config.JdlApplicationOptions
import org.eclipse.xtext.testing.util.ParseHelper
import io.github.jhipster.jdl.jdl.JdlDomainModel
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import com.google.inject.Inject
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author Serano Colameo - Initial contribution and API
 */
 
class Sequence {

	Iterable<String> iterable
	Iterator<String> iterator
	@Accessors(PACKAGE_GETTER) boolean done

	new(Iterable<String> iterable) {
		this.iterable = iterable
		this.iterator = iterable.iterator
	}
	
	def static of(Iterable<String> iterable) {
		return new Sequence(iterable)
	}
	
	def reset() {
		iterator = iterable.iterator
	}

	def String next() {
		return try {
			iterator.next 
		} catch (Exception exception) {
			done = true
			reset.next
		}
	}
}

@RunWith(XtextRunner)
@InjectWith(JDLInjectorProvider)
class JDLCheckOptions {

	@Inject extension ParseHelper<JdlDomainModel> parseHelper
	@Inject extension ValidationTestHelper

	val opts = #['applicationType',
				'serviceDiscoveryType',
				'devDatabaseType',
				'testFrameworks',
				'messageBroker',
				'cacheProvider',
				'websocket',
				'buildTool',
				'prodDatabaseType',
				'searchEngine',
				'clientPackageManager',
				'clientFramework',
				'authenticationType']

	@Test
	def void generateAndParseConfig() {
		JdlApplicationOptions.INSTANCE => [ opt |
			val params = newHashMap
			opts.forEach[
				params.put(it, Sequence.of(opt.getParameters(it)))
			]
			while (!params.done) {
				params.toConfig => [
					println = it
					parse => [
						validate
						assertNoErrors
					]
				]
			} 
		]
	}

	def private boolean done(Map<String, Sequence> config) {
		return config.values.forall[done]
	}

	def private toConfig(Map<String, Sequence> it) '''
		application {
			config {
				applicationType «get('applicationType').next»
				serviceDiscoveryType «get('serviceDiscoveryType').next»
				devDatabaseType  «get('devDatabaseType').next»
				testFrameworks [«get('testFrameworks').next»]
				messageBroker «get('messageBroker').next»
				cacheProvider «get('cacheProvider').next»
				websocket «get('websocket').next»
				buildTool «get('buildTool').next»
				prodDatabaseType «get('prodDatabaseType').next»
				searchEngine «get('searchEngine').next»
				clientPackageManager «get('clientPackageManager').next»
				clientFramework «get('clientFramework').next»
				authenticationType «get('authenticationType').next»
				nativeLanguage en
				serverPort 8080
				entitySuffix Entity
				dtoSuffix DTO
				jwtSecretKey "aaa.bbb.ccc"
				skipClient false
				packageName com.foo.bar
				baseName jhipster
				skipUserManagement true
				enableTranslation true
				languages [en, fr]
				jhiPrefix jhi
				uaaBaseName "uaa"
				reactive false
				enableSwaggerCodegen false
				skipServer false
				enableHibernateCache true
				useSass false
				clientTheme none
				clientThemeVariant primary
			}
		}
	'''
}
