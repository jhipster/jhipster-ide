/**
 * Copyright 2013-2018 the original author or authors from the JHipster project.
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
package io.github.jhipster.jdl.postprocessor;

import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor;

/**
 * @author Serano Colameo - Initial contribution and API
 */
public class JdlMetaModelPostProcessor implements IXtext2EcorePostProcessor {
	@Extension
	private EcoreFactory factory = EcoreFactory.eINSTANCE;

	@Extension
	private EcorePackage ecorePackage = EcorePackage.eINSTANCE;

	@Override
	public void process(final GeneratedMetamodel metamodel) {
		this.process(metamodel.getEPackage());
	}

	public void process(final EPackage p) {
		for (final EClass eClass : Iterables.<EClass>filter(p.getEClassifiers(), EClass.class)) {
			String elemenName = eClass.getName();
			if (elemenName != null) {
				switch (elemenName) {
				case "JdlDomainModel":
					this.handleModel(eClass);
					break;
				}
			}
		}
	}

	public EAttribute handleModel(final EClass eClass) {
		EAttribute attribute = this.factory.createEAttribute();
		final Procedure1<EAttribute> function = (EAttribute it) -> {
			it.setName("name");
			it.setEType(this.ecorePackage.getEString());
			EList<EStructuralFeature> eStructuralFeatures = eClass.getEStructuralFeatures();
			eStructuralFeatures.add(it);
		};
		return ObjectExtensions.<EAttribute>operator_doubleArrow(attribute, function);
	}
}
