/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.lib

import com.github.dockerjava.core.command.BuildImageResultCallback
import com.github.dockerjava.core.command.PullImageResultCallback
import com.google.inject.Inject
import org.eclipse.xtend.lib.annotations.Accessors
import org.junit.BeforeClass
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

import static org.junit.Assert.*

/**
 * Docker Extensions Test Class
 *
 * @author Serano Colameo - Initial contribution and API
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestDockerExtensions {
	
	@Accessors static var String image
	@Accessors static var DockerProperties props
	
	@Inject extension DockerExtensions = DockerExtensions.newInstance(props)

	@BeforeClass
	def static void setUpClass() {
		props = new DockerProperties(newHashMap(
				'enableLoggingFilter' -> true,
				'dockerHost' -> 'unix:///var/run/docker.sock',
				'registryUrl' -> 'https://index.docker.io/v1/'
			)
		)
		
		// log parameters
		println('--<Docker config parameters>---')
		props.parameters.forEach[key, value|
			println('''«key» = «value»''')
		]
		println('------------------------')
	}

	@Test
	def void test0Images() {
		println("========> test0Images")
		docker [
			images.forEach [
				print(it.id + ' ')
				println(it.repoTags.head)
			]
		]
	}
	
	@Test
	def void test1Build() {
		println("========> test1Build")
		docker [
			val BuildImageResultCallback callback = build('./resources/ex1')
			val response = callback.awaitCompletion
			println(response)
		]
	}
	
	@Test
	def void test2Search() {
		println("========> test2Search")
		docker [
			val images = search('busybox')
			assertFalse("No images 'busybox' could be found", images.isNullOrEmpty)
			images.forEach [
				if (isOfficial) image = name
				println(name)
			]
			assertNotNull(image)
		]
	}

	@Test
	def void test3Pull() {
		assertNotNull(image)
		println("========> test3Pull: " + image)
		docker [
			val PullImageResultCallback callback = pull(image)
			assertNotNull(callback)
			val result = callback.awaitCompletion
			assertNotNull(result)
			println("response ===> " + result)
		]
	}
	
	@Test
	def void test4Run() {
		assertNotNull(image)
		println("========> test4Run")
		docker [
			val id = run(image, 'ps')
			println('''Cotainer id = «id»''')
		]
	}
	
	@Test
	def void test5CleanUp() {
		println("========> test5Remove")
		docker [
			for (container : containers) {
				val id = container.id
				println("stop container ==> " + id)
				stopContainer = id
			}
			for (container : containers(true)) {
				val id = container.id
				println("remove container ==> " + id)
				removeContainer = id
			}
		]
	}
}
