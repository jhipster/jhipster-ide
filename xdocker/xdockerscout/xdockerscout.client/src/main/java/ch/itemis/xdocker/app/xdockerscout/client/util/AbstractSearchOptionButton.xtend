package ch.itemis.xdocker.app.xdockerscout.client.util

import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractButton

abstract class AbstractSearchOptionButton extends AbstractButton {
	
	String option1 // default if not selected
	String option2 // otherwise if selected	
		
	new(String option1, String option2) {
		this.option1 = option1 
		this.option2 = option2 
	}
	
	override protected int getConfiguredDisplayStyle() {
		return DISPLAY_STYLE_TOGGLE
	}

	override protected String getConfiguredLabel() {
		return option1 // TEXTS.get("FormReset");
	}

	override protected boolean getConfiguredProcessButton() {
		return false
	}

	override protected execInitField() {
		execSelectionChanged(false)
	}

	override protected void execSelectionChanged(boolean selected) {
		label = if (!selected) option1 else option2
	}
	
	def boolean isOption1() {
		!selected
	}
	
	def boolean isOption2() {
		selected
	}
}
