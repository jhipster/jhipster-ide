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
package io.github.jhipster.jdl.util

import java.io.File
import java.io.FileOutputStream
import net.sourceforge.plantuml.SourceStringReader
import net.sourceforge.plantuml.cucadiagram.dot.GraphvizUtils

import static java.nio.file.Files.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class PlantUmlUtil {

	public static val USER = 'class User'
	public static final String START_UML = "@startuml"
	public static final String END_UML = "@enduml"

	def static createPlantUml(String src, File dst) {
		write(dst.toPath, #[src]);
	}

	def static String createImage(String src, File dst) {
		val reader = new SourceStringReader(src)
		return reader.generateImage(new FileOutputStream(dst))
	} 

	def static boolean useDotExe() {
		try {
			val dotExists = GraphvizUtils.dotExe.exists
			val dotVersion = GraphvizUtils.getDotVersion
			return dotExists && dotVersion > 0
		} catch (Exception e) {
			return false
		}
	}
	
	def static boolean useJDot() {
		return useDotExe === false
	}
}
