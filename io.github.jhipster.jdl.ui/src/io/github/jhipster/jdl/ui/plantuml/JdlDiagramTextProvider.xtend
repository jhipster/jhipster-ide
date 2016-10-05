package io.github.jhipster.jdl.ui.plantuml

import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlEntityField
import io.github.jhipster.jdl.jdl.JdlEnum
import io.github.jhipster.jdl.jdl.JdlEnumFieldType
import io.github.jhipster.jdl.jdl.JdlExceptEntityExclusion
import io.github.jhipster.jdl.jdl.JdlFeature
import io.github.jhipster.jdl.jdl.JdlFieldType
import io.github.jhipster.jdl.jdl.JdlForEntityInclusion
import io.github.jhipster.jdl.jdl.JdlOption
import io.github.jhipster.jdl.jdl.JdlOptionSetting
import io.github.jhipster.jdl.jdl.JdlRelationship
import io.github.jhipster.jdl.jdl.JdlRelationshipName
import io.github.jhipster.jdl.jdl.JdlRelationships
import io.github.jhipster.jdl.jdl.JdlWithEntityInclusion
import java.util.List
import net.sourceforge.plantuml.eclipse.utils.AbstractDiagramTextProvider
import org.eclipse.emf.ecore.EObject
import org.eclipse.ui.IEditorInput
import org.eclipse.ui.IEditorPart
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.model.XtextDocument
import io.github.jhipster.jdl.jdl.JdlWildcardPredicate

class JdlDiagramTextProvider extends AbstractDiagramTextProvider {

	override protected getDiagramText(IEditorPart editorPart, IEditorInput editorInput) {
		val document = (editorPart as XtextEditor).documentProvider.getDocument(editorInput) as XtextDocument
		document?.readOnly [
			val element = contents.head
			if (element instanceof JdlDomainModel) element else null
		]?.render.toString
	}

	def dispatch private render(JdlDomainModel model) '''
		@startuml
			«model.features.map[render].join»
		@enduml
	'''

	/**
	 * Manually dispatch features 
	 */
	def dispatch private render(JdlFeature feature) {
		switch (feature) {
			JdlEntity : render(feature as JdlEntity)
			JdlEnum : render(feature as JdlEnum)
			JdlRelationships : render(feature as JdlRelationships)
			JdlOption : render(feature as JdlOption)
			default : throw new IllegalArgumentException('''Unknown feature «feature.class»''')
		}
	}

	def dispatch private render(JdlOption opt) {
		opt.setting.render
	}

	def dispatch private render(extension JdlOptionSetting setting) '''
		abstract class «val option = switch (setting) {
				case isAngularSuffixOption : 'AngularSuffix'
				case isDtoOption : 'DTO'
				case isMicroserviceOption : 'Microservice'
				case isNoFluentMethodOption : 'NoFluentMethod'
				case isPaginateOption : 'Paginate'
				case isSearchOption : 'Search'
				case isServiceOption : 'Service'
				case isSkipServerOption : 'SkipServer'
				case isSkipClientOption : 'SkipClient'
				default : 'Unknown'
			}» «option» <<Option>>
		«option.render(setting.includes)»
	'''

	def private render(String option, EObject eObj) '''
		«switch (eObj) {
			JdlWithEntityInclusion : option.render(eObj)
			JdlForEntityInclusion : option.render(eObj)
			JdlExceptEntityExclusion : option.render(eObj)
			default: 'Unknown'
		}»
	'''

	def private render(String option, JdlWithEntityInclusion withInclusion) '''
		«IF (withInclusion.selection != null)»
			«render(option, withInclusion.selection.entities)»
		«ELSEIF (withInclusion.predicate != null)»
			«render(option, withInclusion.predicate)»
		«ENDIF»
	'''

	def private render(String option, JdlForEntityInclusion forInclusion) '''
		«IF (forInclusion.selection != null)»
			«render(option, forInclusion.selection.entities)»
		«ELSEIF (forInclusion.predicate != null)»
			«render(option, forInclusion.predicate)»
		«ENDIF»
	'''

	def private render(String option, JdlExceptEntityExclusion exclusion) '''
		«IF (exclusion.selection != null)»
			«render(option, exclusion.selection.entities)»
		«ENDIF»
	'''
	
	def private render(String option, JdlWildcardPredicate predicate) '''
		note top of «option» : «option» applies to «IF predicate.isAll || predicate.isWildcard»all«ENDIF»
	'''

	def private render(String option, List<JdlEntity> entities) '''
		«FOR e : entities»
			«option» --> «e.name»
		«ENDFOR»
	'''

	def dispatch private render(JdlEnum _enum) '''
		enum «_enum.name» {
			«FOR value : _enum.values SEPARATOR ","»
				«value» 
			«ENDFOR»
		}
	'''
	
	def dispatch private render(JdlRelationships rel) '''
		«rel.relationships.map[render].join»
	'''
	
	def dispatch private render(JdlRelationship rel) '''
		«rel.fromEntity.name» «relationName(rel.fromName)» -- «relationName(rel.toName)» «rel.toEntity.name»
	'''
	
	def private relationName(JdlRelationshipName relName) {
		if (relName != null) '''"«relName?.name»«IF !relName.role.nullOrEmpty»(«relName.role»)«ENDIF»"''' else ''
	}
	
	// *** Note ***
	// Warning message: "Cannot infer type from recursive usage. Type 'Object' is used." is a bug
	// @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=404817
	// The Xtend Compiler works fine and generates the expected java code correctly
 	def dispatch private render(JdlEntity entity) '''
		class «entity.name» {
			«entity.fields.map[render].join»
		}
		«FOR e: entity.fields.map[type].filter(JdlEnumFieldType)»
			«entity.name» --> «e.element.name»
		«ENDFOR»
	'''
	
	def dispatch private render(JdlEntityField field) '''
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
