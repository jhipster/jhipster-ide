/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis-schweiz.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.lib

import com.google.inject.Inject
import org.eclipse.xtend.lib.annotations.Accessors
import org.junit.BeforeClass
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

/**
 * Docker JHipster Dev Box Test Class
 *
 * @author Serano Colameo - Initial contribution and API
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestJHipsterDevBox {
	
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
/*
 * 
     	convert(params.get("enableLoggingFilter"), Boolean.class),
    	convert(params.get("projectPath"), String.class),
    	convert(params.get("dockerHost"), String.class),
    	convert(params.get("dockerCertPath"), String.class),
    	convert(params.get("dockerConfig"), String.class),
    	convert(params.get("dockerTlsVerify"), String.class),
    	convert(params.get("registryUrl"), String.class),
    	convert(params.get("registryUsername"), String.class),
    	convert(params.get("registryPassword"), String.class),
    	convert(params.get("registryEmail"), String.class),
    	convert(params.get("apiVersion"), String.class)
 
 * 
 * 
 */		
		
		// log parameters
		println('--<Docker config parameters>---')
		props.parameters.forEach[p1, p2|
			println('''«p1» = «p2»''')
		]
		println('------------------------')
	}

	@Test
	def void test0Images() {
		println("========> test0Images")
		docker [
			//docker run --name $1 -v $PWD/$1:/home/jhipster/app -v ~/.m2:/home/jhipster/.m2 -d -t jhipster/jhipster
			run('jhipster/jhipster', '')
		]
	}
}
