/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.lib;

import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.fusesource.jansi.AnsiOutputStream;
import org.junit.Before;
import org.junit.Test;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.DockerException;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.SearchItem;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

/**
 * Docker Test Class
 *
 * @author Serano Colameo - Initial contribution and API
 */
public class TestDockerClient {

	protected DockerClient dockerClient;

	@Before
	public void beforeTest() throws Exception {
		DockerClientConfig.DockerClientConfigBuilder builder = DockerClientConfig.createDefaultConfigBuilder()
				.withServerAddress("https://index.docker.io/v1/");
		DockerClientConfig config = builder.build();
		dockerClient = DockerClientBuilder.getInstance(config).build();
	}

	@Test
	public void execStart() throws Exception {
		String containerName = "generated_serano" + new SecureRandom().nextInt();
		CreateContainerResponse container = dockerClient.createContainerCmd("busybox").withCmd("ls")
				.withName(containerName).exec();
		assertNotNull(container);
		assertNotNull(container.getId());

		InputStream response = dockerClient.execStartCmd(container.getId()).exec(null);
		assertNotNull(response);

		List<String> res = IOUtils.readLines(response);
		for (String string : res) {
			System.out.println(string);
		}
	}

	private void removeImage(DockerClient dockerClient, String image) throws DockerException, InterruptedException {
		dockerClient.pullImageCmd(image).exec(null);
		CreateContainerResponse container = dockerClient.createContainerCmd(image).withCmd("sleep", "9999").exec();

		dockerClient.startContainerCmd(container.getId()).exec();
		String imageId = dockerClient.commitCmd(container.getId()).exec();

		dockerClient.stopContainerCmd(container.getId()).exec();
		dockerClient.killContainerCmd(container.getId()).exec();
		dockerClient.removeContainerCmd(container.getId()).exec();
		dockerClient.removeImageCmd(imageId).exec();

		List<Container> containers = dockerClient.listContainersCmd().withShowAll(true).exec();

		for (Container c : containers) {
			System.out.println(c.getId());
		}
	}

	public void run() throws DockerException, InterruptedException {
		String image = "busybox";
		DockerClient dockerClient = getDockerClient();
		List<SearchItem> dockerSearch = dockerClient.searchImagesCmd(image).exec();
		for (SearchItem searchItem : dockerSearch) {
			System.out.println(searchItem.getName());
		}
		removeImage(dockerClient, image);
	}

	private DockerClient getDockerClient() {
		DockerClientConfig.DockerClientConfigBuilder builder = DockerClientConfig.createDefaultConfigBuilder();
		DockerClient dockerClient = DockerClientBuilder.getInstance(builder.build())
				.withDockerCmdExecFactory(DockerClientBuilder.getDefaultDockerCmdExecFactory()).build();
		return dockerClient;
	}

	public static String stripAnsi(String str) {
		if (str == null)
			return "";
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			AnsiOutputStream aos = new AnsiOutputStream(baos);
			aos.write(str.getBytes());
			aos.close();
			return baos.toString();
		} catch (IOException e) {
			return str;
		}
	}

	public static void main(String[] args) throws DockerException, InterruptedException {
		new TestDockerClient().run();
	}
}
