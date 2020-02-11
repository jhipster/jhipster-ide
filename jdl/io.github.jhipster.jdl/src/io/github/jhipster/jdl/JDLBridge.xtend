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

import com.google.gson.Gson
import com.google.inject.Inject
import com.google.inject.Provider
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.renderer.JdlToAsciiDocRenderer
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate
import java.util.Comparator
import java.util.HashMap
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
import org.eclipse.xtext.validation.Issue

import static java.lang.System.*
import static org.apache.commons.cli.Option.*
import static org.apache.commons.io.FileUtils.*
import static org.eclipse.emf.common.util.URI.*
import static org.eclipse.xtext.util.CancelIndicator.*
import static org.eclipse.xtext.validation.CheckMode.*

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

	static var VERSION = getVersion
	static val PKG = 'package.json'
	static val FACILITY = 'jdlbridge'
	static val HELP_OPT = new Option('h', 'help', false, 'Print this help message')
	static val PUML_OPT = new Option('u', 'uml', false, 'Generate PlantUML for each JDL file')
	static val PNG_OPT = new Option('p', 'png', false, 'Generate UML diagrams in PNG for each JDL file')
	static val ADOC_OPT = new Option('a', 'adoc', false, 'Generate an AsciiDoc and PlantUML files for each JDL')
	static val SKIP_VALIDATION_OPT = new Option('s', 'skip-validation', false, 'Skip validations')
	static val SINGLE_OPTS = #[HELP_OPT, SKIP_VALIDATION_OPT, PUML_OPT, PNG_OPT, ADOC_OPT]
	static val JDL_OPT = new Option('f', 'jdlfiles', true, 'JDL file search pattern (wildcards allowed) or folders separated by a space') => [
		args = UNLIMITED_VALUES
		valueSeparator = ' '
		argName = 'file(s)'
	]
	static val ALL_OPTIONS = newArrayList(SINGLE_OPTS + #[JDL_OPT]).flatten.toList
	static val OPTIONS = new Options => [ options |
		ALL_OPTIONS.forEach[options.addOption(it)]
	]

	static var CommandLine CLI
	
	def static private getVersion() {
		val in = Thread.currentThread.contextClassLoader.getResourceAsStream(PKG)
		if (in === null) {
			error('Cannot access ' + PKG)
			exit(1)
		}
		val reader = new BufferedReader(new InputStreamReader(in));		
		return new Gson().fromJson(reader, HashMap)?.get('version')
	}

	def static private void info(String message) {
		println('''[«FACILITY»] INFO - «message»''')
	}

	def static private void warn(String message) {
		println('''[«FACILITY»] WARNING - «message»''')
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
		info('''Processing «jdl»''')
		if (!Files.exists(Paths.get(jdl))) {
			error('''JDL file «jdl» does not exist or is not accessible!''')
			exit(1)
		}
		rsp.get.getResource(createFileURI(jdl), true) => [ res |
			if (!SKIP_VALIDATION_OPT.isPresent) {
				val msgs = newArrayList
				res.validate(ALL, NullImpl).forEach[
					val msg = '''[«FACILITY»] «toMessage»'''.toString
					if (!msgs.contains(msg)) {
						msgs.add(msg)
						println(msg)
					}
				]
			}
			resources += res
			generate(res, fileAccess, new GeneratorContext => [
				cancelIndicator = NullImpl
			])
		]
	}
	
	def private toMessage(Issue it) {
		val msg = it.toString.split(':')
		return '''«msg.head» - «msg.subList(1, msg.length).join(' ')» '''
	}

	def private void createAscidocFile() {
		val ext = '.adoc'
		resources.forEach [
			allContents.filter(JdlDomainModel).forEach [
				val adoc = fullFileName.replace('.jh', ext).replace('.jdl', ext)
				Files.write(Paths.get(adoc), render.bytes)
				info('''Created «adoc»''')
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
				$ «FACILITY» -«PUML_OPT.opt» -«JDL_OPT.opt» myApp/MyApp.jdl
				$ «FACILITY» -«PNG_OPT.opt» -«JDL_OPT.opt» myApp/My*.jdl
				$ «FACILITY» -«ADOC_OPT.opt» -«JDL_OPT.opt» myApp/*.jdl
				$ «FACILITY» -«ADOC_OPT.opt» -«JDL_OPT.opt» myApp/				
				$ «FACILITY» --«ADOC_OPT.longOpt» --«JDL_OPT.longOpt» myApp/ myApp2/A*.jdl myApp3/*.jh
			''', true)
		]
		exit(1)
	}

	def static private prinVersion() {
		println('''
		                               _
		       _ _____  _            .'x|.        _      _                _            
		      | |  __ \| |         .'|xx| `.    '|x|    | |         x    | |           
		      | | |  | | |       .'  |xx|   `..' |x|`.  | |__  _ __ _  __| | __ _  ___ 
		  _   | | |  | | |     .'    |xx|        |x|  `.| '_ \| '__| |/ _` |/ _` |/ _ \
		 | |__| | |__| | |____.=========|==========|====| |_) | |  | | (_| | (_| |  __/
		  \____/|_____/|______/~~~~~~|**|~~~~~~~~|*|~~~~|_.__/|_|  |_|\__,_|\__, |\___|
		                                                                     __/ |     
		                                                                    |___/      
		 JDLBridge v«VERSION» (c) Copyright 2019-«LocalDate.now.year» - JHipster Project - Serano Colameo
		''')
	}

	def static void main(String[] args) throws ParseException {
		try {
			CLI = new BasicParser().parse(OPTIONS, args)
		} catch (Exception ex) {
			error(ex.message)
			printUsageAndExit
		}
		if (SKIP_VALIDATION_OPT.isPresent) warn('Validations disabled!')
		if (HELP_OPT.isPresent || !SINGLE_OPTS.exists[it.isPresent] || !JDL_OPT.isPresent) printUsageAndExit
		if (ADOC_OPT.isPresent || JDLBridge.PUML_OPT.isPresent) setProperty('plantuml.gen', 'true')
		if (PNG_OPT.isPresent) setProperty('pnguml.gen', 'true')
		// start execution...
		prinVersion
		new JDLStandaloneSetup().createInjectorAndDoEMFRegistration => [ 
			getInstance(JDLBridge) => [
				runWith(getPaths)
			]
		]
		info('Execution finished!')
	}
}
