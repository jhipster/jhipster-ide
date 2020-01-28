/**
 * Copyright 2013-2020 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.lib.pp;

import static org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_doubleArrow;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor;

import com.google.common.collect.Iterables;

/**
 * @author Serano Colameo - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JdlMetaModelPostProcessor implements IXtext2EcorePostProcessor {
	@Extension
	private EcoreFactory factory = EcoreFactory.eINSTANCE;

	@Extension
	private EcorePackage ecorePackage = EcorePackage.eINSTANCE;

	/**
	 * Process metamodel
	 *
	 * @param pkg
	 */
	@Override
	public void process(final GeneratedMetamodel metamodel) {
		process(metamodel.getEPackage());
	}

	/**
	 * Process metamodel package
	 * 
	 * @param pkg
	 */
	private void process(final EPackage pkg) {
		for (final EClass eClass : Iterables.<EClass>filter(pkg.getEClassifiers(), EClass.class)) {
			String elemenName = eClass.getName();
			if (elemenName != null) {
				switch (elemenName) {
					case "JdlDomainModel":
						this.handleMetaModel(eClass);
					break;
				}
			}
		}
	}

	/**
	 * Handle 
	 * @param eClass
	 */
	private void handleMetaModel(final EClass eClass) {
		operator_doubleArrow(factory.createEAttribute(), (EAttribute it) -> {
			it.setName("name");
			it.setEType(this.ecorePackage.getEString());
			eClass.getEStructuralFeatures().add(it);
		});
		operator_doubleArrow(factory.createEAttribute(), (EAttribute it) -> {
			it.setName("fullFileName");
			it.setEType(this.ecorePackage.getEString());
			eClass.getEStructuralFeatures().add(it);
		});
	}
}
