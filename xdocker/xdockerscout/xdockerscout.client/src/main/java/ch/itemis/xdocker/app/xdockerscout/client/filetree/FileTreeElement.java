package ch.itemis.xdocker.app.xdockerscout.client.filetree;

import java.io.File;
import java.nio.file.Path;

public class FileTreeElement {
  private String m_path;
  private String m_name;

  private boolean m_isDirectory;
  private boolean m_collapsed;

  public FileTreeElement(Path p) {
    File file = p.toFile();
    m_isDirectory = file.isDirectory();
    m_name = file.getName();
    m_path = file.getAbsolutePath();
    m_collapsed = true;
  }

  public String getPath() {
    return m_path;
  }

  public void setPath(String path) {
    m_path = path;
  }

  public String getName() {
    return m_name;
  }

  public void setName(String name) {
    m_name = name;
  }

  public boolean isDirectory() {
    return m_isDirectory;
  }

  public void setDirectory(boolean isDirectory) {
    m_isDirectory = isDirectory;
  }

  public boolean isCollapsed() {
    return m_collapsed;
  }

  public void setCollapsed(boolean collapsed) {
    m_collapsed = collapsed;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("FileTreeElement [m_path=").append(m_path).append(", m_name=").append(m_name)
        .append(", m_isDirectory=").append(m_isDirectory).append(", m_collapsed=").append(m_collapsed)
        .append("]");
    return builder.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (m_collapsed ? 1231 : 1237);
    result = prime * result + (m_isDirectory ? 1231 : 1237);
    result = prime * result + ((m_name == null) ? 0 : m_name.hashCode());
    result = prime * result + ((m_path == null) ? 0 : m_path.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    FileTreeElement other = (FileTreeElement) obj;
    if (m_collapsed != other.m_collapsed) {
      return false;
    }
    if (m_isDirectory != other.m_isDirectory) {
      return false;
    }
    if (m_name == null) {
      if (other.m_name != null) {
        return false;
      }
    }
    else if (!m_name.equals(other.m_name)) {
      return false;
    }
    if (m_path == null) {
      if (other.m_path != null) {
        return false;
      }
    }
    else if (!m_path.equals(other.m_path)) {
      return false;
    }
    return true;
  }
}
