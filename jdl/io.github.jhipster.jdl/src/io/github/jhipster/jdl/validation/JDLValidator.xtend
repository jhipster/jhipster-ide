package io.github.jhipster.jdl.validation

import org.eclipse.xtext.validation.ComposedChecks

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@ComposedChecks(validators = #[
	CaseSensitivityValidator,
	CardinalityValidator,
	OptionSelectionValidator
])
class JDLValidator extends AbstractJDLValidator {
	
}
