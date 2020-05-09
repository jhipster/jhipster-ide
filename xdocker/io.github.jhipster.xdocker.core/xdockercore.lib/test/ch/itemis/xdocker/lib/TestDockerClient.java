/*******************************************************************************
 * Copyright (c) 2015 itemis Schweiz GmbH (http://www.itemis-schweiz.ch) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.lib;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.fusesource.jansi.AnsiOutputStream;
import org.junit.Before;
import org.junit.Test;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.ExecCreateCmdResponse;
import com.github.dockerjava.api.exception.DockerException;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.SearchItem;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.ExecStartResultCallback;

/**
 * Docker Test Class
 *
 * @author Serano Colameo - Initial contribution and API
 */
public class TestDockerClient {

	protected DockerClient dockerClient;

	@Before
	public void beforeTest() throws Exception {
		dockerClient = DockerClientBuilder.getInstance(config()).build();
	}

	@Test
	public void execStart() throws Exception {
        String containerName = "generated_" + new SecureRandom().nextInt();
        CreateContainerResponse container = dockerClient.createContainerCmd("alpine").withCmd("sleep", "9999")
                .withName(containerName).exec();
        dockerClient.startContainerCmd(container.getId()).exec();
        InputStream stdin = new ByteArrayInputStream("STDIN\n".getBytes("UTF-8"));
        ByteArrayOutputStream stdout = new ByteArrayOutputStream();

        ExecCreateCmdResponse execCreateCmdResponse = dockerClient.execCreateCmd(container.getId())
                .withAttachStdout(true)
                .withAttachStdin(true)
                .withCmd("ls")
                .exec();

        boolean completed = dockerClient.execStartCmd(execCreateCmdResponse.getId())
                .withDetach(false)
                .withTty(true)
                .withStdIn(stdin)
                .exec(new ExecStartResultCallback(stdout, System.err))
                .awaitCompletion(5, TimeUnit.SECONDS);

        assertTrue("The process was not finished.", completed);
        System.out.println(stdout.toString("UTF-8"));
	}

	@SuppressWarnings("unused")
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
//			removeImage(dockerClient, searchItem.getName());
		}
	}

	private DockerClient getDockerClient() {
		DockerClient dockerClient = DockerClientBuilder.getInstance(config())
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
	
	private static DefaultDockerClientConfig config() {
		DefaultDockerClientConfig.Builder builder = DefaultDockerClientConfig.createDefaultConfigBuilder()
                .withRegistryUrl("https://index.docker.io/v1/");
        return builder.build();		
	}

	public static void main(String[] args) throws DockerException, InterruptedException {
		new TestDockerClient().run();
	}
}
