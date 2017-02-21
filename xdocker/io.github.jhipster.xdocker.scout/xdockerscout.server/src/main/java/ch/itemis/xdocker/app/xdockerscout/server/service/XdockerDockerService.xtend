package ch.itemis.xdocker.app.xdockerscout.server.service

import ch.itemis.xdocker.app.xdockerscout.server.ServerSession
import ch.itemis.xdocker.app.xdockerscout.shared.notification.DockerNotification
import ch.itemis.xdocker.app.xdockerscout.shared.prefs.XdockerDockerPreferncesFormData
import ch.itemis.xdocker.app.xdockerscout.shared.service.IContainer
import ch.itemis.xdocker.app.xdockerscout.shared.service.IImageInfo
import ch.itemis.xdocker.app.xdockerscout.shared.service.IXdockerDockerService
import ch.itemis.xdocker.app.xdockerscout.shared.service.XdockerContainerInfo
import ch.itemis.xdocker.app.xdockerscout.shared.service.XdockerDockerServiceException
import ch.itemis.xdocker.app.xdockerscout.shared.service.XdockerInfo
import ch.itemis.xdocker.app.xdockerscout.shared.service.XdockerLocalImageInfo
import ch.itemis.xdocker.app.xdockerscout.shared.service.XdockerRemoteImageInfo
import ch.itemis.xdocker.lib.DockerExtensions
import ch.itemis.xdocker.lib.config.DockerRunConfig
import ch.itemis.xdocker.lib.util.DockerPropertiesUtil
import com.github.dockerjava.api.model.BuildResponseItem
import com.github.dockerjava.api.model.Frame
import com.github.dockerjava.core.command.BuildImageResultCallback
import com.github.dockerjava.core.command.LogContainerResultCallback
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import java.util.List
import java.util.Stack
import javax.inject.Inject
import org.eclipse.scout.rt.platform.BEANS
import org.eclipse.scout.rt.platform.exception.PlatformExceptionTranslator
import org.eclipse.scout.rt.platform.job.Jobs
import org.eclipse.scout.rt.platform.util.concurrent.IRunnable
import org.eclipse.scout.rt.server.clientnotification.ClientNotificationRegistry
import org.eclipse.scout.rt.server.context.ServerRunContexts

import static ch.itemis.xdocker.app.xdockerscout.shared.prefs.XdockerDockerPropertiesConverter.*
import static ch.itemis.xdocker.util.AnsiUtil.*
import org.eclipse.scout.rt.shared.ISession

/**
 * XdockerDockerService 
 * 
 */
class XdockerDockerService implements IXdockerDockerService {

//	static val HEADER_COLUMNS = #['Key','Value'].toArray
//	static val (Object[])=>String formatter = [ String.format('%-20s%s\n', it)]
//	static val HEADER = formatter.apply(HEADER_COLUMNS)
//	static val (Map<String, String>)=>String BODY = [ map |
//		map.keySet.map[ key |
//			formatter.apply( #[
//				substring(key, 0, 20), abbreviate(map.get(key), 0, 30)
//			])
//		].join
//	]
	val sessionId = (ServerSession.get as ISession).id
	
	@Inject extension DockerExtensions docker = DockerExtensions.newInstance(
		DockerPropertiesUtil.loadFromDisk
	)

	/**
	 * Ping docker server
	 */
	override ping() {
		docker.ping
	}

	/**
	 * Ping docker server
	 */
	override doTestConnection(XdockerDockerPreferncesFormData data) throws XdockerDockerServiceException {
		try {
			docker [
// FIXME
//				setupDocker = toDockerProperties(data)
			].ping
		} catch (Exception e) {
			throw new XdockerDockerServiceException("testConnection() failed!", e)
		}
	}

	override info() throws XdockerDockerServiceException {
		try {
			return new XdockerInfo(newHashMap =>
				[
					docker.info =>
						[ i |
							put('Containers', String.valueOf(i.containers))
							put('Images', String.valueOf(i.images))
							put('Storage Driver', i.driver)
							put('Execution Driver', i.executionDriver)
							put('Kernel Version', i.kernelVersion)
							put('Operating System', i.operatingSystem)
							put('CPUs', String.valueOf(i.NCPU))
							put(
								'Total Memory', '''«BigDecimal.valueOf(i.memTotal).divide(BigDecimal.valueOf(1073741824)).round(new MathContext(4, RoundingMode.HALF_UP))» GiB''')
							put('Name', i.name)
							put('ID', i.ID)
							put('Debug mode (server)', String.valueOf(i.isDebug))
							put('File Descriptors', String.valueOf(i.NFd))
							put('Goroutines', String.valueOf(i.NGoroutines))
							put('EventsListeners', String.valueOf(i.getnEventListener))
							put('Init SHA1', i.initSha1)
							put('Init Path', i.initPath)
							put('Docker Root Dir', i.dockerRootDir)
							put('Index Server Address', i.indexServerAddress)
						]
				])
//					«FOR it : driverStatuses»
//					 	«IF (it instanceof List<?>)»
//					 		<tr><td>«toString.replaceAll('\\[|\\]', '').replaceAll(',', ':')»</td></tr>
//						«ENDIF»
//					«ENDFOR»
		} catch (Exception e) {
			throw new XdockerDockerServiceException("Call docker info failed!", e)
		}
	}

	override List<IImageInfo> search(String term, boolean isLocal) throws XdockerDockerServiceException {
		val List<IImageInfo> result = newArrayList
		docker [
			try {
				if (isLocal) {
					images(term).forEach [
						result.add(new XdockerLocalImageInfo(repoTags, id, created, virtualSize))
					]
				} else {
					search(term).forEach [
						result.add(new XdockerRemoteImageInfo(name, description, starCount, isOfficial, isTrusted))
					]
				}
			} catch (Exception ex) {
				
				notify(ex.message, sessionId)
			}
		]
		return result
	}

	/** 
	 * Build a dockerfile service operation
	 */
	override build(String dockerfile) {
		try {
			Jobs.schedule(new IRunnable {
				override run() {
					try {
						docker [
							val callback = new BuildImageResultCallback {
								override onNext(BuildResponseItem item) {
									if (!item?.stream.nullOrEmpty)
										notify(item.stream, sessionId)
									else if (!item?.status.nullOrEmpty)
										notify('''«item.status» «item.progress»''', sessionId)
									else if (!item?.errorDetail?.message.nullOrEmpty)
										notify(item.errorDetail.message, sessionId)
									else if (!item?.id.nullOrEmpty)
										notify('''id is «item.id»''', sessionId)
								}

								override onComplete() {
									close
									notify('\nFinished!', sessionId)
								}

								override onError(Throwable ex) {
									notify(
										if(ex.message.nullOrEmpty) ex.cause.toString else ex.message,
										sessionId
									)
								}
							}
							// @TODO: Implement me
							// val cfg = new DockerBuildImageConfig(null, null, true, "Xdocker:MyTag", false, true, true, false)
							val cfg = null
							build(dockerfile, cfg, callback).awaitCompletion
						]
					} catch (Exception e) {
						notify("Docker build() failed! " + e.message, sessionId)
						throw new XdockerDockerServiceException("Docker build() failed!", e)
					}
				}
			}, Jobs.newInput.withRunContext(ServerRunContexts.copyCurrent))
		} catch (Exception e) {
			notify("Docker build() failed! " + e.message, sessionId)
			throw new XdockerDockerServiceException("Docker build() failed!", e)
		}
	}

	override List<IContainer> containers(boolean showAll) {
		val List<IContainer> result = newArrayList
		try {
			docker [
				containers(docker.dockerClient, showAll).forEach [
					val p = ports.map [
						new XdockerContainerInfo.Port(ip, privatePort, publicPort, type)
					]
					val c = new XdockerContainerInfo(command, created, id, image, status, names, p, labels)
					result.add(c)
				]
			]
		} catch (Exception e) {
			throw new XdockerDockerServiceException("Docker containers() failed!", e)
		}
		return result
	}

	override removeContainers(List<String> containerIds, boolean force) throws XdockerDockerServiceException {
		try {
			docker [
				removeContainers(it, containerIds, force)
			]
		} catch (Exception e) {
			throw new XdockerDockerServiceException("Docker removeContainers() failed!", e)
		}
	}

	override removeImages(List<String> imageIds) throws XdockerDockerServiceException {
		try {
			docker [
				removeImages(it, imageIds)
			]
		} catch (Exception e) {
			throw BEANS.get(PlatformExceptionTranslator).translate(
				new XdockerDockerServiceException("Docker removeImages() failed!", e)
			);
		}
	}

	override run(String image, String cmd, DockerRunConfig cfg) throws XdockerDockerServiceException {
		val result = new Stack<String>
		try {
			docker [
				result.push(it.run(image, cmd, cfg))
			]
		} catch (Exception e) {
			throw new XdockerDockerServiceException("Docker run() failed!", e)
		}
		return result.pop
	}

	override logContainer(String containerId) throws XdockerDockerServiceException {
		val logBuffer = new StringBuffer
		try {
			val callback = new LogContainerResultCallback {
				override onNext(Frame item) {
					logBuffer.append(stripAnsi(item.payload))
				}

				override onError(Throwable ex) {
					notify(if(ex.message.nullOrEmpty) ex.cause.toString else ex.message, sessionId)
				}

				override onComplete() {
					close // close stream in completion
				}
			}
			docker [
				it.logContainer(containerId, callback)
			]
			callback.awaitCompletion
		} catch (Exception e) {
			throw new XdockerDockerServiceException("Docker run() failed!", e)
		}
		return logBuffer
	}

	override pull(String image) throws XdockerDockerServiceException {
		try {
			Jobs.schedule(new IRunnable {
				override run() {
					docker [
						it.pull(image).awaitCompletion
					]
				}
			}, Jobs.newInput.withRunContext(ServerRunContexts.copyCurrent))
		} catch (Exception e) {
			throw new XdockerDockerServiceException("Docker pull() failed!", e)
		}
	}

	def protected notify(String msg, String sessionId) {
		new DockerNotification(msg) => [
			BEANS.get(ClientNotificationRegistry).putForSession(sessionId, it)
		]
	}
}
