package io.github.jhipster.jdl.util

import java.io.File
import java.io.FileOutputStream
import net.sourceforge.plantuml.SourceStringReader
import net.sourceforge.plantuml.cucadiagram.dot.GraphvizUtils

import static java.nio.file.Files.*

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
