/**
 * Copyright 2016-2025 the original author or authors from the JHipster project.
 * 
 * This file is part of the JHipster project, see http://www.jhipster.tech/
 * for more information.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.jhipster.jdl.validation;

import io.github.jhipster.jdl.validation.AbstractJDLValidator;
import io.github.jhipster.jdl.validation.CaseSensitivityValidator;
import io.github.jhipster.jdl.validation.JDLLint;
import io.github.jhipster.jdl.validation.OptionConfigValidator;
import io.github.jhipster.jdl.validation.OptionSelectionValidator;
import io.github.jhipster.jdl.validation.RelationshipValidator;
import org.eclipse.xtext.validation.ComposedChecks;

/**
 * @author Serano Colameo - Initial contribution and API
 */
@ComposedChecks(
	validators = #[
		CaseSensitivityValidator, 
		OptionSelectionValidator,
		OptionConfigValidator, 
		RelationshipValidator, 
		JDLLint 
	]
)
class JDLValidator extends AbstractJDLValidator {
}
