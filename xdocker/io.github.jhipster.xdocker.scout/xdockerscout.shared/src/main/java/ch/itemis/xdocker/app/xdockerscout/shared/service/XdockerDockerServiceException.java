package ch.itemis.xdocker.app.xdockerscout.shared.service;

/**
 * XdockerDockerServiceException
 * 
 * @author serano
 */
public class XdockerDockerServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	public XdockerDockerServiceException(String message) {
		super(message);
	}

	public XdockerDockerServiceException(Throwable cause) {
		super(cause);
	}

	public XdockerDockerServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public XdockerDockerServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
