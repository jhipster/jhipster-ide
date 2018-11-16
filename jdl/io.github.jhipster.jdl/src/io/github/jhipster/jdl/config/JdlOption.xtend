package io.github.jhipster.jdl.config

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.Triple
import org.eclipse.xtext.util.Tuples

import static io.github.jhipster.jdl.config.JdlParameterType.*

class JdlOption {
	@Accessors(PUBLIC_GETTER) Triple<String, String[], JdlParameterType> config

	new(String name) {
		this(name, #[], Literal)
	}

	new(String name, String[] properties) {
		this(name, properties, Literal)
	}

	new(String name, JdlParameterType type) {
		this(name, #[], type)
	}

	new(String name, String[] properties, JdlParameterType type) {
		this.config = Tuples.create(name, properties, type)
	}

	def String getName() {
		return config.first
	}

	def JdlParameterType getParameterType() {
		return config.third
	}

	def List<String> getParameters() {
		return config.second
	}
}
