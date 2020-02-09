package io.github.jhipster.jdl.renderer

import com.google.inject.Inject
import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEntityField
import java.nio.file.Paths
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider

import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.*
import io.github.jhipster.jdl.jdl.JdlEntityFieldDefinition

class JdlToAsciiDocRenderer implements IJdlModelViewerRenderer {
	
	@Inject extension MultiLineCommentDocumentationProvider

	val linebreak = "'''"
	val open = "«"
	val close = "»"
	
	override render(JdlDomainModel model) {
		model.toAscidoc
	}
	
	def private toAscidoc(JdlDomainModel model) {
		if (model === null || model.name.isNullOrEmpty || model.fullFileName.isNullOrEmpty) return ''
		val entities = model.features.filter(JdlEntity)
		val jdlFile = Paths.get(model.fullFileName).toFile
		return '''
			.Please note
			[NOTE]
			====
			This spec was generated out of _«jdlFile.name»_ with *jdlbridge*
			====
			<<<
			
			= Specification of «model.name.toFirstUpper»
			«model.documentation ?: ''»
			--
			«linebreak»
			[plantuml,align="center",alt="«model.name».plantuml"]
			----
			include::«model.name».plantuml[]
			----
			---
			--
			
			«entities.filter[it.name != 'User'].compile»
			
			«linebreak»
		'''
	}
	
	def dispatch compile(Iterable<JdlEntity> entities) {
		entities.map[compile].join
	}

	def dispatch compile(JdlEntity e) '''	
		=== Entity «open»«e.name»«close»
		«e.documentation»
		
		.«e.name»
		«IF e.fieldDefinition != null»
			«e.fieldDefinition.compile»
		«ENDIF»
		
	'''

	def dispatch compile(JdlEntityFieldDefinition it) '''
		[options="header"]
		|=======================
		|Field Name|Type | Constraint | Comment
		«FOR it:fields»«compile»«ENDFOR»
		|=======================
	'''

	def dispatch compile(JdlEntityField it) '''
		«val typeNode = type.node»
		«val typeText = typeNode?.text?.trim ?: ''»
		«val constraints = if (typeText.contains(' ')) typeText.substring(typeText.indexOf(' ')).trim else ''»
		|«name.toFirstUpper»|«typeText?.split(' ')?.head»|«constraints» | «documentation»
	'''
}