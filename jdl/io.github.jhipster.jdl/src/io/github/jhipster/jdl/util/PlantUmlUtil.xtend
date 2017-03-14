package io.github.jhipster.jdl.util

import java.io.File
import net.sourceforge.plantuml.SourceStringReader
import java.io.FileOutputStream
import static java.nio.file.Files.*

class PlantUmlUtil {

	def static createPlantUml(String src, File dst) {
		write(dst.toPath, #[src]);			
	}

	def static createImage(String src, File dst) {
		val reader = new SourceStringReader(src)
		return reader.generateImage(new FileOutputStream(dst))
	}
}
