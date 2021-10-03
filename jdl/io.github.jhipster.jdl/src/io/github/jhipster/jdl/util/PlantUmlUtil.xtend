/**
 * Copyright 2016-2021 the original author or authors from the JHipster project.
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

import static java.nio.file.Files.*
import static net.sourceforge.plantuml.cucadiagram.dot.GraphvizUtils.*

/**
 * @author Serano Colameo - Initial contribution and API
 */
class PlantUmlUtil {

	public static val USER = 'class User'
	public static val START_UML = "@startuml"
	public static val END_UML = "@enduml"
	public static val GRAPHVIZ_DOT = 'graphviz_dot jdot'
	public static val SMETANA = 'layout smetana'
	
	def static createPlantUml(String src, File dst) {
		write(dst.toPath, #[src]);
	}

	def static String createImage(String src, File dst) {
		return new SourceStringReader(src).generateImage(new FileOutputStream(dst))
	} 

	def static boolean useDotExe() {
		try {
			return getDotVersion > 0 && dotExe.exists
		} catch (Exception e) {
			return false
		}
	}
	
	def static boolean useJDot() {
		return useDotExe === false
	}
}
