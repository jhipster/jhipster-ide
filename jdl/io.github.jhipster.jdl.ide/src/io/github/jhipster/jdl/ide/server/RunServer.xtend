/** 
 * Copyright 2013-2020 the original author or authors from the JHipster project.
 * This file is part of the JHipster project, see http://www.jhipster.tech/
 * for more information.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.jhipster.jdl.ide.server

import java.io.IOException
import java.net.InetSocketAddress
import java.net.SocketAddress
import java.nio.channels.AsynchronousServerSocketChannel
import java.nio.channels.AsynchronousSocketChannel
import java.nio.channels.Channels
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.function.Function
import org.eclipse.lsp4j.jsonrpc.Launcher
import org.eclipse.lsp4j.jsonrpc.MessageConsumer
import org.eclipse.lsp4j.services.LanguageClient
import org.eclipse.xtext.ide.server.LanguageServerImpl
import org.eclipse.xtext.ide.server.ServerModule
import com.google.inject.Guice

/** 
 * @author Serano Colameo - Initial contribution and API
 */
class RunServer {
	
	val static PORT = 5007
	
	def static void main(String[] args) throws InterruptedException, IOException {
		println('''Server is listening on port: «PORT»''')
		val injector = Guice.createInjector(new ServerModule)
		val languageServer = injector.getInstance(LanguageServerImpl) 
		val Function<MessageConsumer, MessageConsumer> wrapper = [ consumer | {
			var MessageConsumer result = consumer 
			return result 
		}] 
		val launcher = createSocketLauncher(languageServer, LanguageClient, 
			new InetSocketAddress('localhost', PORT), Executors.newCachedThreadPool, wrapper
		) 
		languageServer.connect(launcher.remoteProxy)
		val Future<?> future = launcher.startListening
		while (!future.isDone) {
			Thread.sleep(10_000l) 
		}
	}
	
	def static package <T>Launcher<T> createSocketLauncher(Object localService, Class<T> remoteInterface, SocketAddress socketAddress, ExecutorService executorService, Function<MessageConsumer, MessageConsumer> wrapper) throws IOException {
		val serverSocket = AsynchronousServerSocketChannel.open.bind(socketAddress) 
		var AsynchronousSocketChannel socketChannel 
		try {
			socketChannel = serverSocket.accept.get
			return Launcher.createIoLauncher(
				localService, remoteInterface, Channels.newInputStream(socketChannel), 
				Channels.newOutputStream(socketChannel), executorService, wrapper
			) 
		} catch (Exception e) {
			e.printStackTrace() 
		}
		return null 
	}
}