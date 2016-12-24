/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.lib

import ch.itemis.xdocker.lib.config.DockerBuildImageConfig
import ch.itemis.xdocker.lib.config.DockerRunConfig
import com.github.dockerjava.api.DockerClient
import com.github.dockerjava.core.DockerClientBuilder
import com.github.dockerjava.core.DockerClientConfig
import com.github.dockerjava.core.command.BuildImageResultCallback
import com.github.dockerjava.core.command.LogContainerResultCallback
import com.github.dockerjava.core.command.PullImageResultCallback
import java.nio.file.Paths
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1

import static ch.itemis.xdocker.lib.util.DockerPropertiesUtil.*
//import com.github.dockerjava.api.command.CreateContainerResponse
//import com.github.dockerjava.api.model.Ports
//import com.github.dockerjava.api.model.ExposedPort
import com.github.dockerjava.api.exception.NotModifiedException
import com.github.dockerjava.core.DefaultDockerClientConfig

/**
 * Extension Class for Docker Java API
 *
 * @author Serano Colameo - Initial contribution and API
 */
class DockerExtensions {

	@Accessors private var DockerClientConfig config
    @Accessors private var DockerClient dockerClient

	def static newInstance() {
		return new DockerExtensions
	}

	def static newInstance(DockerProperties props) {
		return new DockerExtensions(props)
	}

	private new() {
		this(null)
	}

	private new(DockerProperties props) {
		setupDocker(props)
	}

	def setupDocker(DockerProperties props) {
		setupDockerProperties = props
		val builder = DefaultDockerClientConfig.createDefaultConfigBuilder()
		config = builder.build
		dockerClient = if (config != null) DockerClientBuilder.getInstance(config).build	
	}

	def DockerExtensions docker(Procedure1<? super DockerClient> initializer) {
		if (initializer != null) initializer.apply(dockerClient)
		return this
	}

	def close() {
	    dockerClient.close
	}

	def search(String term) {
		if (term.nullOrEmpty) throw new IllegalArgumentException("Argument 'term' cannot be null or empty!")
		if (dockerClient == null) throw new IllegalStateException("Docker client not initialized properly!")
		search(dockerClient, term)
	}

	def search(extension DockerClient it, String term) {
		if (term.nullOrEmpty) throw new IllegalArgumentException("Argument 'term' cannot be null or empty!")
		searchImagesCmd(term).exec
	}
	
	def images(extension DockerClient it) {
		images(it, null)
	}
	
	def images(extension DockerClient it, String term) {
		val result = listImagesCmd.exec
		if (!term.nullOrEmpty) {
			result.filter[
				val name = if (repoTags.size >=1) repoTags.get(0) else ''
				#[id, name].exists[contains(term)]
 			].toList
		}
		else result
	}

	def ping() {
		dockerClient?.pingCmd?.exec
	}

	def info() {
		dockerClient?.infoCmd?.exec
	}

	def containers(extension DockerClient it) {
		return containers(false)
	}

	def containers(extension DockerClient it, boolean showAll) {
		return listContainersCmd.withShowAll(showAll).exec
	}
	
	def waitContainer(extension DockerClient it, String containerId) {
		if (containerId.nullOrEmpty) throw new IllegalArgumentException("Argument 'containerId' cannot be null!")
		waitContainerCmd(containerId).exec(null)
	}

	def logContainers(extension DockerClient it, List<String> containerIds, LogContainerResultCallback callback) {
		if (containerIds.nullOrEmpty) throw new IllegalArgumentException("Argument 'containerIds' cannot be null or empty!")
		val result = newArrayList
		containerIds.forEach[id | 
			result.add(logContainer(id, callback))
		]
		return result
	}

	def logContainer(extension DockerClient it, String containerId, LogContainerResultCallback callback) {
		if (containerId.nullOrEmpty) throw new IllegalArgumentException("Argument 'containerId' cannot be null!")
        return logContainerCmd(containerId).withStdErr(true).withStdOut(true).exec(callback)
	}
	
	def pull(extension DockerClient it, String image) {
		pull(image, new PullImageResultCallback)
	}

	def pull(extension DockerClient it, String image, PullImageResultCallback callback) {
		if (image.nullOrEmpty) throw new IllegalArgumentException("Argument 'image' cannot be null!")
		val term = if (!image.contains('/') && !image.contains(':')) image + ':latest' else image
		pullImageCmd(term).exec(callback)
	}

	def removeImages(extension DockerClient it, List<String> imageIds) {
		if (imageIds.nullOrEmpty) throw new IllegalArgumentException("Argument 'imageIds' cannot be null or empty!")
		imageIds.forEach[ id |
			removeImage(id)
		]
	}
	
	def removeImage(extension DockerClient it, String imageId) {
		if (imageId.nullOrEmpty) throw new IllegalArgumentException("Argument 'imageId' cannot be null or empty!")
		removeImageCmd(imageId).withForce(true).exec
	}

	def void stopContainers(extension DockerClient it, List<String> containerIds) {
		if (containerIds.nullOrEmpty) throw new IllegalArgumentException("Argument 'containerIds' cannot be null or empty!")
		containerIds.forEach[ id |
			stopContainer(id)
		]
	}
	
	def void stopContainer(extension DockerClient it, String containerId) {
		if (containerId.nullOrEmpty) throw new IllegalArgumentException("Argument 'containerId' cannot be null or empty!")
		try {
			stopContainerCmd(containerId).exec
		} catch (NotModifiedException e) {
			// ignore this exception			
		}
	}

	def removeContainers(extension DockerClient it, List<String> containerIds) {
		removeContainers(containerIds, true)
	}
	
	def removeContainers(extension DockerClient it, List<String> containerIds, boolean force) {
		if (containerIds.nullOrEmpty) throw new IllegalArgumentException("Argument 'containerIds' cannot be null or empty!")
		containerIds.forEach[ id |
			removeContainer(id, force)
		]
	}

	def void removeContainer(extension DockerClient it, String containerId) {
		removeContainer(containerId, true)
	}

	def void removeContainer(extension DockerClient it, String containerId, boolean force) {
		if (containerId.nullOrEmpty) throw new IllegalArgumentException("Argument 'containerId' cannot be null or empty!")
		removeContainerCmd(containerId).withForce(force).exec
	}

	def build(extension DockerClient it, String dockerFileOrFolder) {
		build(dockerFileOrFolder, new BuildImageResultCallback)
	}

	def build(extension DockerClient it, String dockerFileOrFolder, BuildImageResultCallback callback) {
		build(dockerFileOrFolder, null, callback)
	}

	def build(extension DockerClient it, String dockerFileOrFolder, extension DockerBuildImageConfig cfg, BuildImageResultCallback callback) {
		if (dockerFileOrFolder.nullOrEmpty) throw new IllegalArgumentException("Argument 'dockerFileOrFolder' cannot be null or empty!")
		val dockerfile = Paths.get(dockerFileOrFolder).toFile
		if (dockerfile.exists == false) throw new IllegalArgumentException('''«dockerfile.toString» does not exits!''')
		val cmd = buildImageCmd(dockerfile) => [ build |
			if (cfg != null && cfg.hasParams) {
				build.withNoCache(noCache)
			      .withPull(pull)
			      .withQuiet(quiet)
			      .withRemove(rm) => [
				  	if (!cfg.tag.nullOrEmpty) withTag(cfg.tag)
				]
			}
		]
		cmd.exec(callback)
	}

	def void startContainers(extension DockerClient it, List<String> containerIds) {
		if (containerIds.nullOrEmpty) throw new IllegalArgumentException("Argument 'containerIds' cannot be null or empty!")
		containerIds.forEach[ id |
			startContainer(id)
		]
	}

	def void startContainer(extension DockerClient it, String containerId) {
		if (containerId.nullOrEmpty) throw new IllegalArgumentException("Argument 'containerId' cannot be null or empty!")
		else startContainerCmd(containerId).exec
	}

	def execStart(extension DockerClient it, String containerId) {
		execStart(containerId, null)
	}

	def execStart(extension DockerClient it, String containerId, extension DockerRunConfig cfg) {
		if (containerId.nullOrEmpty) throw new IllegalArgumentException("Argument 'containerId' cannot be null or empty!")
		else {
			val cmd = execStartCmd(containerId) => [
				if (cfg != null) withDetach(detached).withTty(tty)
			]
			return cmd.execId
		}
	}

	def run(extension DockerClient it, String image, String cmd) {
		run(image, cmd, null)
	}

	def run(extension DockerClient docker, String image, String cmdstr, extension DockerRunConfig cfg) {
		if (image.nullOrEmpty) throw new IllegalArgumentException("Argument 'image' cannot be null or empty!")

// @TODO:		
//        ExposedPort tcp22 = ExposedPort.tcp(22);
//        ExposedPort tcp23 = ExposedPort.tcp(23);
//
//        Ports portBindings = new Ports();
//        portBindings.bind(tcp22, Ports.Binding(11022));
//        portBindings.bind(tcp23, Ports.Binding(11023));
//        portBindings.bind(tcp23, Ports.Binding(11024));
//
//        CreateContainerResponse container = dockerClient.createContainerCmd("busybox").withCmd("true")
//                .withExposedPorts(tcp22, tcp23).withPortBindings(portBindings).exec();
		
		val cmd = createContainerCmd(image).withCmd(cmdstr.split(' ')) => [ run |
			if (cfg != null && cfg.hasParams) {
				run.withTty(tty)
				.withStdinOpen(keepStdinOpen)
				.withAttachStdout(attachStdout)
				.withAttachStderr(attachStderr)
				.withPublishAllPorts(publishAllPorts)
				.withPortSpecs(portSpecs)
				.withName(name)
			}
		]
		// create and start container command
		val container = try (cmd.exec => [
			if (it != null && id.nullOrEmpty == false) {
				docker.startContainer(id)
			}
		]) catch (Exception e) {
			throw new RuntimeException(e.message)		
		}
		if (container == null) throw new RuntimeException('''Could not create container for image «image» and «cmdstr»''')
		docker.execStart(container.id)
        return container.id
	}
}
