package ch.itemis.xdocker.app.xdockerscout.shared.service;

import java.util.List;

import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;

import ch.itemis.xdocker.app.xdockerscout.shared.prefs.XdockerDockerPreferncesFormData;
import ch.itemis.xdocker.lib.config.DockerRunConfig;

/**
 * <h3>{@link IXdockerDockerService}</h3>
 *
 * @author serano
 */
@TunnelToServer
public interface IXdockerDockerService extends IService {

/**************	
	def close()
	def search(String term)
	def search(String term)
	def images()
	def images(String term)
	def ping()
	def info()
	def containers()
	def containers(boolean showAll)
	def waitContainer(String containerId)
	def logContainers(List<String> containerIds, LogContainerResultCallback callback)
	def logContainer(String containerId, LogContainerResultCallback callback)
	def pull(String image)
	def pull(String image, PullImageResultCallback callback)
	def removeImages(List<String> imageIds)
	def removeImage(String imageId)
	def void stopContainers(List<String> containerIds)
	def void stopContainer(String containerId)
	def removeContainers(List<String> containerIds)
	def removeContainers(List<String> containerIds, boolean force)
	def void removeContainer(String containerId)
	def void removeContainer(String containerId, boolean force)
	def build(String dockerFileOrFolder)
	def build(String dockerFileOrFolder, BuildImageResultCallback callback)
	def build(String dockerFileOrFolder, extension DockerBuildImageConfig cfg, BuildImageResultCallback callback)
	def void startContainers(List<String> containerIds)
	def void startContainer(String containerId)
	def execStart(String containerId)
	def execStart(String containerId, extension DockerRunConfig cfg)
	def run(String image, String cmd)
	def run(String image, String cmd, extension DockerRunConfig cfg)
*****/

	public void ping() throws XdockerDockerServiceException;
	
	public XdockerInfo info() throws XdockerDockerServiceException;
	
	public void doTestConnection(XdockerDockerPreferncesFormData data) throws XdockerDockerServiceException;

	public List<IImageInfo> search(String term, boolean isLocal) throws XdockerDockerServiceException;

	public List<IContainer> containers(boolean showAll) throws XdockerDockerServiceException;
	
	public void build(String dockerfile) throws XdockerDockerServiceException;
	
	public void removeContainers(List<String> containerIds, boolean force) throws XdockerDockerServiceException; 

	public void removeImages(List<String> imageIds) throws XdockerDockerServiceException; 

	public String run(String image, String cmd, DockerRunConfig cfg) throws XdockerDockerServiceException; 

	public StringBuffer logContainer(String containerId) throws XdockerDockerServiceException; 
	
	public void pull(String image) throws XdockerDockerServiceException; 
}
