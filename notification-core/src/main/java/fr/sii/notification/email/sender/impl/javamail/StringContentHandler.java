package fr.sii.notification.email.sender.impl.javamail;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimePart;

import fr.sii.notification.core.exception.mimetype.MimeTypeDetectionException;
import fr.sii.notification.core.message.content.Content;
import fr.sii.notification.core.message.content.StringContent;
import fr.sii.notification.core.mimetype.MimeTypeProvider;
import fr.sii.notification.email.exception.javamail.ContentHandlerException;

/**
 * Content handler that adds string contents (HTML, text, ...). It needs to
 * detect Mime Type for indicating the type of the added content.
 * 
 * @author Aurélien Baudet
 *
 */
public class StringContentHandler implements JavaMailContentHandler {
	/**
	 * The Mime Type detector
	 */
	private MimeTypeProvider mimetypeProvider;

	public StringContentHandler(MimeTypeProvider mimetypeProvider) {
		super();
		this.mimetypeProvider = mimetypeProvider;
	}

	@Override
	public void setContent(MimePart message, Multipart multipart, Content content) throws ContentHandlerException {
		try {
			MimeBodyPart part = new MimeBodyPart();
			String strContent = ((StringContent) content).getContent();
			part.setContent(strContent, mimetypeProvider.detect(strContent).toString());
			multipart.addBodyPart(part);
		} catch (MessagingException e) {
			throw new ContentHandlerException("failed to set content on mime message", content, e);
		} catch (MimeTypeDetectionException e) {
			throw new ContentHandlerException("failed to determine mimetype for the content", content, e);
		}
	}

}
