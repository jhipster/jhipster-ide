package io.github.jhipster.jdl.ide.renderer.plantuml

import io.github.jhipster.jdl.ide.renderer.IJdlModelViewerRenderer
import com.google.inject.ImplementedBy

@ImplementedBy(JdlToPlantUmlRenderer)
interface IJdlToPlantUmlRenderer extends IJdlModelViewerRenderer {
	
	static (Object)=>String toPlantUml = [ it | '''
		«IF it != null»
			@startuml
				«toString»
			@enduml
		«ENDIF»
	''' ]
}
