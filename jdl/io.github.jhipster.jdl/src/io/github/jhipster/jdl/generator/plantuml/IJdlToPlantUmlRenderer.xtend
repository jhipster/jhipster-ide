package io.github.jhipster.jdl.generator.plantuml

import com.google.inject.ImplementedBy
import io.github.jhipster.jdl.renderer.IJdlModelViewerRenderer

@ImplementedBy(JdlToPlantUmlRenderer)
interface IJdlToPlantUmlRenderer extends IJdlModelViewerRenderer {
	
	static (Object)=>String toPlantUml = [ it | '''
			«IF it !== null»
				@startuml
					«toString»
				@enduml
			«ENDIF»
		''' ]
}
