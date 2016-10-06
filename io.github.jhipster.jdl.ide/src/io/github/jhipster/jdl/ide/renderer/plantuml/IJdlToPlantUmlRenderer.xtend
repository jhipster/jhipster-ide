package io.github.jhipster.jdl.ide.renderer.plantuml

import io.github.jhipster.jdl.ide.renderer.IJdlModelViewerRenderer

interface IJdlToPlantUmlRenderer extends IJdlModelViewerRenderer {
	
	static (Object)=>String toPlantUml = [ it | '''
		«IF it != null»
			@startuml
				«toString»
			@enduml
		«ENDIF»
	''' ]
}
