package fr.sii.notification.email.exception.javamail;

import fr.sii.notification.core.message.content.Content;

public class NoContentHandlerException extends ContentHandlerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7169028390651116070L;

	public NoContentHandlerException(String message, Content content) {
		super(message, content);
	}

}
