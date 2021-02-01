/**
 * Copyright (c) 2015-2021 Arcware GmbH (http://arcware.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ch.itemis.xdocker.lib;

import ch.itemis.xdocker.base.processor.ConfigProperty;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import java.util.HashMap;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Docker Properties Class
 * 
 * @author Serano Colameo - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public final class DockerProperties {
  @ConfigProperty
  private final Boolean enableLoggingFilter;
  
  @ConfigProperty
  private final String projectPath;
  
  @ConfigProperty(DefaultDockerClientConfig.DOCKER_HOST)
  private final String dockerHost;
  
  @ConfigProperty(DefaultDockerClientConfig.DOCKER_CERT_PATH)
  private final String dockerCertPath;
  
  @ConfigProperty(DefaultDockerClientConfig.DOCKER_CONFIG)
  private final String dockerConfig;
  
  @ConfigProperty(DefaultDockerClientConfig.DOCKER_TLS_VERIFY)
  private final String dockerTlsVerify;
  
  @ConfigProperty(DefaultDockerClientConfig.REGISTRY_URL)
  private final String registryUrl;
  
  @ConfigProperty(DefaultDockerClientConfig.REGISTRY_USERNAME)
  private final String registryUsername;
  
  @ConfigProperty(DefaultDockerClientConfig.REGISTRY_PASSWORD)
  private final String registryPassword;
  
  @ConfigProperty(DefaultDockerClientConfig.REGISTRY_EMAIL)
  private final String registryEmail;
  
  @ConfigProperty(DefaultDockerClientConfig.API_VERSION)
  private final String apiVersion;
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.enableLoggingFilter== null) ? 0 : this.enableLoggingFilter.hashCode());
    result = prime * result + ((this.projectPath== null) ? 0 : this.projectPath.hashCode());
    result = prime * result + ((this.dockerHost== null) ? 0 : this.dockerHost.hashCode());
    result = prime * result + ((this.dockerCertPath== null) ? 0 : this.dockerCertPath.hashCode());
    result = prime * result + ((this.dockerConfig== null) ? 0 : this.dockerConfig.hashCode());
    result = prime * result + ((this.dockerTlsVerify== null) ? 0 : this.dockerTlsVerify.hashCode());
    result = prime * result + ((this.registryUrl== null) ? 0 : this.registryUrl.hashCode());
    result = prime * result + ((this.registryUsername== null) ? 0 : this.registryUsername.hashCode());
    result = prime * result + ((this.registryPassword== null) ? 0 : this.registryPassword.hashCode());
    result = prime * result + ((this.registryEmail== null) ? 0 : this.registryEmail.hashCode());
    result = prime * result + ((this.apiVersion== null) ? 0 : this.apiVersion.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DockerProperties other = (DockerProperties) obj;
    if (this.enableLoggingFilter == null) {
      if (other.enableLoggingFilter != null)
        return false;
    } else if (!this.enableLoggingFilter.equals(other.enableLoggingFilter))
      return false;
    if (this.projectPath == null) {
      if (other.projectPath != null)
        return false;
    } else if (!this.projectPath.equals(other.projectPath))
      return false;
    if (this.dockerHost == null) {
      if (other.dockerHost != null)
        return false;
    } else if (!this.dockerHost.equals(other.dockerHost))
      return false;
    if (this.dockerCertPath == null) {
      if (other.dockerCertPath != null)
        return false;
    } else if (!this.dockerCertPath.equals(other.dockerCertPath))
      return false;
    if (this.dockerConfig == null) {
      if (other.dockerConfig != null)
        return false;
    } else if (!this.dockerConfig.equals(other.dockerConfig))
      return false;
    if (this.dockerTlsVerify == null) {
      if (other.dockerTlsVerify != null)
        return false;
    } else if (!this.dockerTlsVerify.equals(other.dockerTlsVerify))
      return false;
    if (this.registryUrl == null) {
      if (other.registryUrl != null)
        return false;
    } else if (!this.registryUrl.equals(other.registryUrl))
      return false;
    if (this.registryUsername == null) {
      if (other.registryUsername != null)
        return false;
    } else if (!this.registryUsername.equals(other.registryUsername))
      return false;
    if (this.registryPassword == null) {
      if (other.registryPassword != null)
        return false;
    } else if (!this.registryPassword.equals(other.registryPassword))
      return false;
    if (this.registryEmail == null) {
      if (other.registryEmail != null)
        return false;
    } else if (!this.registryEmail.equals(other.registryEmail))
      return false;
    if (this.apiVersion == null) {
      if (other.apiVersion != null)
        return false;
    } else if (!this.apiVersion.equals(other.apiVersion))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("enableLoggingFilter", this.enableLoggingFilter);
    b.add("projectPath", this.projectPath);
    b.add("dockerHost", this.dockerHost);
    b.add("dockerCertPath", this.dockerCertPath);
    b.add("dockerConfig", this.dockerConfig);
    b.add("dockerTlsVerify", this.dockerTlsVerify);
    b.add("registryUrl", this.registryUrl);
    b.add("registryUsername", this.registryUsername);
    b.add("registryPassword", this.registryPassword);
    b.add("registryEmail", this.registryEmail);
    b.add("apiVersion", this.apiVersion);
    return b.toString();
  }
  
  @Pure
  public Boolean getEnableLoggingFilter() {
    return this.enableLoggingFilter;
  }
  
  @Pure
  public String getProjectPath() {
    return this.projectPath;
  }
  
  @Pure
  public String getDockerHost() {
    return this.dockerHost;
  }
  
  @Pure
  public String getDockerCertPath() {
    return this.dockerCertPath;
  }
  
  @Pure
  public String getDockerConfig() {
    return this.dockerConfig;
  }
  
  @Pure
  public String getDockerTlsVerify() {
    return this.dockerTlsVerify;
  }
  
  @Pure
  public String getRegistryUrl() {
    return this.registryUrl;
  }
  
  @Pure
  public String getRegistryUsername() {
    return this.registryUsername;
  }
  
  @Pure
  public String getRegistryPassword() {
    return this.registryPassword;
  }
  
  @Pure
  public String getRegistryEmail() {
    return this.registryEmail;
  }
  
  @Pure
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  private static <T> T convert(final Object obj, final Class type) {
    if (obj == null) return null;
    return (T)org.apache.commons.beanutils.ConvertUtils.convert(obj, type);
  }
  
  public DockerProperties(final Boolean enableLoggingFilter, final String projectPath, final String dockerHost, final String dockerCertPath, final String dockerConfig, final String dockerTlsVerify, final String registryUrl, final String registryUsername, final String registryPassword, final String registryEmail, final String apiVersion) {
	    super();
	    this.enableLoggingFilter = enableLoggingFilter;
	    this.projectPath = projectPath;
	    this.dockerHost = dockerHost;
	    this.dockerCertPath = dockerCertPath;
	    this.dockerConfig = dockerConfig;
	    this.dockerTlsVerify = dockerTlsVerify;
	    this.registryUrl = registryUrl;
	    this.registryUsername = registryUsername;
	    this.registryPassword = registryPassword;
	    this.registryEmail = registryEmail;
	    this.apiVersion = apiVersion;
	  }
	  
  public DockerProperties(final HashMap<String, Object> params) {
    this(
    	(Boolean)convert(params.get("enableLoggingFilter"), Boolean.class),
    	(String)convert(params.get("projectPath"), String.class),
    	(String)convert(params.get("dockerHost"), String.class),
    	(String)convert(params.get("dockerCertPath"), String.class),
    	(String)convert(params.get("dockerConfig"), String.class),
    	(String)convert(params.get("dockerTlsVerify"), String.class),
    	(String)convert(params.get("registryUrl"), String.class),
    	(String)convert(params.get("registryUsername"), String.class),
    	(String)convert(params.get("registryPassword"), String.class),
    	(String)convert(params.get("registryEmail"), String.class),
    	(String)convert(params.get("apiVersion"), String.class)
    );
  }
  
  /**
   * Returns all parameters annotated with @ConfigProperty
   */
  public HashMap<String, Object> getParameters() {
    HashMap<String, Object> params = new java.util.HashMap<java.lang.String, java.lang.Object>();
    params.put("enableLoggingFilter", getEnableLoggingFilter());
    params.put("projectPath", getProjectPath());
    params.put("DOCKER_HOST", getDockerHost());
    params.put("DOCKER_CERT_PATH", getDockerCertPath());
    params.put("DOCKER_CONFIG", getDockerConfig());
    params.put("DOCKER_TLS_VERIFY", getDockerTlsVerify());
    params.put("registry.url", getRegistryUrl());
    params.put("registry.username", getRegistryUsername());
    params.put("registry.password", getRegistryPassword());
    params.put("registry.email", getRegistryEmail());
    params.put("api.version", getApiVersion());
    return params;
  }
}
