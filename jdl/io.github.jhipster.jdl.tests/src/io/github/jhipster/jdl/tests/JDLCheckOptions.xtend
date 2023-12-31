/**
 * Copyright 2016-2024 the original author or authors from the JHipster project.
 * 
 * This file is part of the JHipster project, see http://www.jhipster.tech/
 * for more information.
 * 
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.jhipster.jdl.tests

import com.google.inject.Inject
import io.github.jhipster.jdl.jdl.JdlDomainModel
import java.util.Iterator
import java.util.Map
import jbase.config.JDLApplicationOptions
import jbase.config.JDLLanguages
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

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
	
	extension JDLLanguages = JDLLanguages.INSTANCE

	val opts = #['applicationType', 'serviceDiscoveryType', 'devDatabaseType', 'testFrameworks', 'messageBroker',
		'cacheProvider', 'websocket', 'buildTool', 'prodDatabaseType', 'searchEngine', 'clientPackageManager',
		'clientFramework', 'authenticationType']

	val bool = Sequence.of(#['true', 'false'])
	val lang = Sequence.of(langCodes)
	val dtos = Sequence.of(#['DTO', 'DTA', 'DTB', 'DTC'])
	val ports = Sequence.of(#['8080', '8081', '8090', '9090'])
	val names = Sequence.of(
		#['Barbee', 'Barbette', 'Barbey', 'Barbi', 'Barbie', 'Barbra', 'Barby', 'Bari', 'Barrie', 'Barry', 'Basia',
			'Bathsheba', 'Batsheva', 'Bea', 'Beatrice', 'Beatrisa', 'Beatrix', 'Beatriz', 'Bebe', 'Becca'])

	@Test
	def void generateAndParseConfig() {
		JDLApplicationOptions.INSTANCE => [ opt |
			val params = newHashMap
			opts.forEach [
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
				nativeLanguage «lang.next»
				serverPort «ports.next»
				entitySuffix «names.next.substring(0,3)»
				dtoSuffix «dtos.next»
				jwtSecretKey "«names.next.toLowerCase.substring(0,3)»"
				skipClient «bool.next»
				packageName «names.next.toLowerCase»
				baseName «names.next»
				skipUserManagement «bool.next»
				enableTranslation «bool.next»
				languages [«lang.next», «lang.next»]
				jhiPrefix jhi
				reactive «bool.next»
				enableSwaggerCodegen «bool.next»
				skipServer «bool.next»
				enableHibernateCache «bool.next»
				useSass «bool.next»
				clientTheme none
				clientThemeVariant primary
			}
		}
	'''
}
