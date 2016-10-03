package io.github.jhipster.jdl.ui.plantuml

import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEntityField
import io.github.jhipster.jdl.jdl.JdlEnumFieldType
import io.github.jhipster.jdl.jdl.JdlFieldType
import io.github.jhipster.jdl.jdl.JdlRelationships
import net.sourceforge.plantuml.eclipse.utils.AbstractDiagramTextProvider
import org.eclipse.ui.IEditorInput
import org.eclipse.ui.IEditorPart
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.model.XtextDocument
import io.github.jhipster.jdl.jdl.JdlRelationship
import io.github.jhipster.jdl.jdl.JdlRelationshipName

class JdlDiagramTextProvider extends AbstractDiagramTextProvider {

	override protected getDiagramText(IEditorPart editorPart, IEditorInput editorInput) {
		val document = (editorPart as XtextEditor).getDocumentProvider().getDocument(editorInput) as XtextDocument;
		val JdlDomainModel model = document.readOnly [
			return contents.head as JdlDomainModel
		]
		'''
			@startuml
				«model.features.filter(JdlEntity).map[render].join»
				«model.features.filter(JdlRelationships).map[render].join»
			@enduml
		'''
	}
	
	def private render(JdlRelationships rel) '''
		«rel.relationships.map[render].join»
	'''
	
	def private render(JdlRelationship rel) '''
		«rel.fromEntity.name» «relationName(rel.fromName)» -- «relationName(rel.toName)» «rel.toEntity.name»
	'''
	
	def private relationName(JdlRelationshipName relName) {
		if (relName != null) '''"«relName?.name»«IF !relName.role.nullOrEmpty»(«relName.role»)«ENDIF»"''' else ''
	}
	
	def private render(JdlEntity entity) '''
		class «entity.name» {
			«FOR field : entity.fields» 
				«field.render»
			«ENDFOR»
		}
	'''
	
	def private render(JdlEntityField field) '''
		«field.type.element» «field.name»
	'''

	def dispatch private getElement(JdlFieldType type) {
		try {
			type.^class.getMethod('getElement', null).invoke(type, null)
		} catch (Exception exception) {
			"'unknown type'"		
		}
	}

	def dispatch private getElement(JdlEnumFieldType type) {
		try {
			type.element.name
		} catch (Exception exception) {
			"'unknown type'"		
		}
	}
}
