/**
 * Copyright 2016-2023 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.renderer

import io.github.jhipster.jdl.jdl.JdlDomainModel
import io.github.jhipster.jdl.jdl.JdlEntity
import io.github.jhipster.jdl.jdl.JdlOption
import io.github.jhipster.jdl.util.JdlModelUtil
import java.util.Map
import java.util.Set

/**
 * @author Serano Colameo - Initial contribution and API
 */
abstract class AbstractJdlRenderer {
	
	protected extension JdlModelUtil util
	protected var Map<JdlEntity, Set<JdlOption>> entiyOptionMap
	
	def protected JdlDomainModel init(JdlDomainModel jdl) {
		util = JdlModelUtil.getInstance(jdl)
		entiyOptionMap = toEntiyOptionMap(jdl)
		return jdl
	}
}
