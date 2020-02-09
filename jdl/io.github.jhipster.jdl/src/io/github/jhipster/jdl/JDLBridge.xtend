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
package io.github.jhipster.jdl

import com.google.inject.Inject
import com.google.inject.Provider
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.renderer.JdlToAsciiDocRenderer
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.util.Comparator
import java.util.Set
import org.apache.commons.cli.BasicParser
import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.HelpFormatter
import org.apache.commons.cli.Option
import org.apache.commons.cli.Options
import org.apache.commons.cli.ParseException
import org.apache.commons.io.filefilter.WildcardFileFilter
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.generator.GeneratorContext
import org.eclipse.xtext.generator.GeneratorDelegate
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.validation.IResourceValidator

import static java.lang.System.*
import static org.apache.commons.cli.Option.*
import static org.apache.commons.io.FileUtils.*
import static org.eclipse.emf.common.util.URI.*
import static org.eclipse.xtext.util.CancelIndicator.*
import static org.eclipse.xtext.validation.CheckMode.*
import java.time.LocalDate

/**
 * @author Serano Colameo - Initial contribution and API
 */
class JDLBridge {

	@Inject Provider<ResourceSet> rsp
	@Inject JavaIoFileSystemAccess fileAccess
	@Inject extension IResourceValidator
	@Inject extension GeneratorDelegate
	@Inject extension JdlToAsciiDocRenderer

	val resources = <Resource>newArrayList

	static val VERSION = '1.1.3'
	static val FACILITY = 'jdlbridge'
	static val PUML_OPT = new Option('puml', 'Generate PlantUML for each JDL file')
	static val PNG_OPT = new Option('png', 'Generate UML diagrams in PNG for each JDL file')
	static val ADOC_OPT = new Option('adoc','Generate an AsciiDoc with PlantUML diagrams for each JDL')
	static val SINGLE_OPTS = #[PUML_OPT, PNG_OPT, ADOC_OPT]
	static val JDL_OPT = new Option('f', 'jdlfiles', true, 'JDL files or folders separated by a space with wildcards') => [
		args = UNLIMITED_VALUES
		valueSeparator = ' '
		argName = 'file(s)'
	]
	static val ALL_OPTIONS = newArrayList(SINGLE_OPTS + #[JDL_OPT]).flatten.toList
	static val OPTIONS = new Options => [ options |
		ALL_OPTIONS.forEach[options.addOption(it)]
	]

	static var CommandLine CLI

	def static private void info(String message) {
		println('''[«FACILITY»] INFO - «message»''')
	}

	def static private void warn(String message) {
		println('''[«FACILITY»] WARN - «message»''')
	}

	def static private void error(String message) {
		err.println('''[«FACILITY»] ERROR - «message»''')
	}

	def static private boolean isPresent(Option opt) {
		return CLI.hasOption(opt.opt)
	}

	def static private String[] getOptionValues(Option opt) {
		return CLI.getOptionValues(opt.opt)
	}
	
	def private Set<String> getPaths() {
		val fileOptions = JDL_OPT.optionValues
		val paths = newHashSet
		fileOptions.forEach[
			val f = new File(it)
			if (!f.exists) {
				error('''File '«f?.name»' does not exists or is not accessabile!''')
				exit(1)
			}
			if (f.isDirectory) {
				val files = listFiles(f, new WildcardFileFilter('*.j*'), null)
				if (!files.isEmpty) paths.addAll(files.filter[ fn |
					#['.jdl', '.jh'].exists[fn.name.endsWith(it)]
				] .map[absolutePath])
			} else {
				val files = listFiles(f.parentFile, new WildcardFileFilter(f.name), null)
				if (!files.isEmpty) paths.addAll(files.map[absolutePath])
			}
		]
		return paths
	}

	def private void runWith(Set<String> jdlFiles) {
		if (jdlFiles.isNullOrEmpty) {
			warn('''No files found to process!''')
			exit(1)
		}
		jdlFiles.forEach[run]
		if (ADOC_OPT.isPresent) createAscidocFile
	}

	def private void run(String jdl) {
		info('''Processing: «jdl»''')
		if (!Files.exists(Paths.get(jdl))) {
			error('''JDL file «jdl» does not exist or is not accessible!''')
			exit(1)
		}
		rsp.get.getResource(createFileURI(jdl), true) => [ res |
			res.validate(ALL, NullImpl).forEach[warn('''Validation issue: «it»''')]
			resources += res
			generate(res, fileAccess, new GeneratorContext => [
				cancelIndicator = NullImpl
			])
		]
	}

	def private void createAscidocFile() {
		val ext = '.adoc'
		resources.forEach [
			allContents.filter(JdlDomainModel).forEach [
				val adoc = fullFileName.replace('.jh', ext).replace('.jdl', ext)
				Files.write(Paths.get(adoc), render.bytes)
				info('''Created: «adoc»''')
			]
		]
	}

	def static private printUsageAndExit() {
		prinVersion
		new HelpFormatter => [
			setOptionComparator(new Comparator<Option>() {
				override compare(Option o1, Option o2) {
					ALL_OPTIONS.indexOf(o1) - ALL_OPTIONS.indexOf(o2)
				}
			})
			printHelp('\njdlbridge', '\noptions:\n', OPTIONS, '\n' + '''
				examples:
				$ jdlbridge -f myApp/MyApp.jdl
				$ jdlbridge -f myApp/My*.jdl
				$ jdlbridge -f myApp/*.jdl
				$ jdlbridge -f myApp/				
				$ jdlbridge -f myApp/ myApp2/A*.jdl myApp3/*.jh
			''', true)
		]
		exit(1)
	}

	def static private prinVersion() {
		println('''
			   ___ ______  _      _            _      _
			  |_  ||  _  \| |    | |          (_)    | |
			    | || | | || |    | |__   _ __  _   __| |  __ _   ___
			    | || | | || |    | '_ \ | '__|| | / _` | / _` | / _ \
			/\__/ /| |/ / | |____| |_) || |   | || (_| || (_| ||  __/
			\____/ |___/  \_____/|_.__/ |_|   |_| \__,_| \__, | \___|
			                                              __/ |
			                                             |___/
			(c) Copyright 2013-«LocalDate.now.year» the JHipster project
			Author: Serano Colameo
			Version: «VERSION» 
		''')
	}

	def static void main(String[] args) throws ParseException {
		try {
			CLI = new BasicParser().parse(OPTIONS, args)
		} catch (Exception ex) {
			error(ex.message)
			printUsageAndExit
		}
		if (!SINGLE_OPTS.exists[it.isPresent] || !JDL_OPT.isPresent) printUsageAndExit
		if (ADOC_OPT.isPresent || JDLBridge.PUML_OPT.isPresent) setProperty('plantuml.gen', 'true')
		if (PNG_OPT.isPresent) setProperty('pnguml.gen', 'true')
		prinVersion
		new JDLStandaloneSetup().createInjectorAndDoEMFRegistration => [ injector |
			injector.getInstance(JDLBridge) => [
				runWith(getPaths)
			]
		]
		info('Execution finished!')
	}
}
