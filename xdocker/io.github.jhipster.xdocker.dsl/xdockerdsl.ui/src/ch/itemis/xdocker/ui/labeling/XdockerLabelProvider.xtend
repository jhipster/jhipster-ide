/*******************************************************************************
 * Copyright (c) 2015-2021 Arcware GmbH (http://arcware.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.ui.labeling

import ch.itemis.xdocker.xdocker.AddStatement
import ch.itemis.xdocker.xdocker.ArgumentArray
import ch.itemis.xdocker.xdocker.ArgumentList
import ch.itemis.xdocker.xdocker.CmdStatement
import ch.itemis.xdocker.xdocker.CopyStatement
import ch.itemis.xdocker.xdocker.DigestQualifier
import ch.itemis.xdocker.xdocker.EntrypointStatement
import ch.itemis.xdocker.xdocker.EnvStatement
import ch.itemis.xdocker.xdocker.ExposeStatement
import ch.itemis.xdocker.xdocker.FromStatement
import ch.itemis.xdocker.xdocker.KeyValue
import ch.itemis.xdocker.xdocker.KeyValueArguments
import ch.itemis.xdocker.xdocker.LabelStatement
import ch.itemis.xdocker.xdocker.MaintainerStatement
import ch.itemis.xdocker.xdocker.OnbuildStatement
import ch.itemis.xdocker.xdocker.PortNumberList
import ch.itemis.xdocker.xdocker.RunStatement
import ch.itemis.xdocker.xdocker.SourcesDestValue
import ch.itemis.xdocker.xdocker.Statement
import ch.itemis.xdocker.xdocker.TagQualifier
import ch.itemis.xdocker.xdocker.UserStatement
import ch.itemis.xdocker.xdocker.VolumeStatement
import ch.itemis.xdocker.xdocker.WorkdirStatement
import ch.itemis.xdocker.xdocker.Xdocker
import com.github.dockerjava.core.dockerfile.Dockerfile
import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 * 
 * @author Serano Colameo - Initial contribution and API
 */
class XdockerLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	def text(Xdocker it) {
		'Dockerfile' 
	}


	def text(FromStatement it) {
		'FROM'
	}

	def text(TagQualifier it) {
		'Tag'
	}

	def text(DigestQualifier it) {
		'Digest'
	}

	def text(MaintainerStatement it) {
		'MAINTAINER'
	}
	
	def text(RunStatement it) {
		'RUN'
	}

	def text(CmdStatement it) {
		'CMD'
	}

	def text(LabelStatement it) {
		'LABEL'
	}

	def text(ExposeStatement it) {
		'EXPOSE'
	}
	
	def text(PortNumberList it) {
		'Ports: ' + ports.toString.replaceAll("\\[|\\]", "")
	}

	def text(EnvStatement it) {
		'ENV'
	}

	def text(KeyValue it) {
		'Name/Value'
	}
	
	def text(KeyValueArguments it) {
		switch (eContainer) {
			LabelStatement: 'Labels'
			EnvStatement: 'Variables'
			default: 'Key/Value Arguments'
		}
	}

	def text(AddStatement it) {
		'ADD'
	}

	def text(ArgumentArray it) {
		textArguments
	}

	def text(ArgumentList it) {
		textArguments
	}

	def text(SourcesDestValue it) {
		textParameters
	}

	def text(CopyStatement it) {
		'COPY'
	}

	def text(EntrypointStatement it) {
		'ENTRYPOINT'
	}
	
	def text(VolumeStatement it) {
		'VOLUME'
	}
	
	def text(UserStatement it) {
		'USER'
	}
	
	def text(WorkdirStatement it) {
		'WORKDIR'
	}
	
	def text(OnbuildStatement it) {
		'ONBUILD'
	}
	
	def private textArguments(EObject it) {
		switch (eContainer) {
			AddStatement, CopyStatement: 'Parameters'
			EnvStatement: 'Variables'
			LabelStatement: 'Labels'
			EntrypointStatement, RunStatement, CmdStatement: 'Arguments'
		}
	}

	def private textParameters(EObject it) {
		switch (eContainer) {
			AddStatement, CopyStatement: 'Parameters'
			EnvStatement: 'Variables'
		}
	}

	def image(Statement it) {
		switch(it) {
			FromStatement, MaintainerStatement, LabelStatement, ExposeStatement, EnvStatement, VolumeStatement, UserStatement, WorkdirStatement: 'Property.gif' 
			default: 'Operation.gif'
			
		}
	}	
	
	def image(Dockerfile it) {
		'dockerfiles.gif'
	}
}
