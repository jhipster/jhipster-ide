/*******************************************************************************
 * Copyright (c) 2015-2021 Arcware GmbH (http://arcware.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ch.itemis.xdocker.lib;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.fusesource.jansi.AnsiOutputStream;
import org.junit.Test;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.ExecCreateCmdResponse;
import com.github.dockerjava.api.model.Volume;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.ExecStartResultCallback;

import junit.framework.TestCase;

/**
 * Docker Test Class
 *
 * @author Serano Colameo - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class TestJHipsterDockerRun extends TestCase {

	private static DockerClient dockerClient = getDockerClient();

	@Test
	public void runJHipster() throws Exception {
        String containerName = "JHipsterMyApp" + new SecureRandom().nextInt();
        List<Volume> volumes = new ArrayList<Volume>();
        volumes.add(new Volume("~/MyApp1:/home/jhipster/app"));
        volumes.add(new Volume("~/.m2:/home/jhipster/.m2"));
        CreateContainerResponse container = dockerClient.createContainerCmd("jhipster/jhipster")
        		.withVolumes(volumes)
                .withName(containerName)
                .withTty(true)
                .exec();
        dockerClient.startContainerCmd(container.getId()).exec();
        
        InputStream stdin = new ByteArrayInputStream("STDIN\n".getBytes("UTF-8"));
        ByteArrayOutputStream stdout = new ByteArrayOutputStream();

        ExecCreateCmdResponse execCreateCmdResponse = dockerClient.execCreateCmd(container.getId())
                .withAttachStdout(true)
                .withAttachStdin(true)
                .withAttachStderr(true)
                .withTty(true)
                .withCmd("sh")
                .exec();

        boolean completed = dockerClient.execStartCmd(execCreateCmdResponse.getId())
                .withDetach(true)
                .withTty(true)
                .withStdIn(stdin)
                .exec(new ExecStartResultCallback(stdout, System.err))
                .awaitCompletion(15, TimeUnit.SECONDS);


        execCreateCmdResponse = dockerClient.execCreateCmd(container.getId())
                .withAttachStdout(true)
                .withAttachStdin(true)
                .withAttachStderr(true)
                .withTty(true)
                .withCmd("yo")
                .exec();

//        Scanner scanner = new Scanner(System.in);
//        String username = scanner.nextLine();
        
         completed = dockerClient.execStartCmd(execCreateCmdResponse.getId())
                .withDetach(false)
                .withTty(true)
                .withStdIn(System.in)
                .exec(new ExecStartResultCallback(stdout, System.err))
                .awaitCompletion(15, TimeUnit.SECONDS);
        
        assertTrue("The process was not finished.", completed);
        System.out.println(stdout.toString("UTF-8"));
	}

	private static DockerClient getDockerClient() {
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

	public static void main(String[] args) throws Exception {
		new TestJHipsterDockerRun().runJHipster();
	}
}
