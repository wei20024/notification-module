package fr.sii.notification.core.template.parser;

import fr.sii.notification.core.exception.template.ParseException;
import fr.sii.notification.core.message.content.Content;
import fr.sii.notification.core.template.context.Context;
import fr.sii.notification.core.template.resolver.TemplateResolver;

/**
 * Interface that defines the general contract for template parsing. Template
 * parsing consists to load a template from its name (or path) and then replace
 * all variables that are defined in the template by the values provided by the
 * context.
 * 
 * The parser may rely on a {@link TemplateResolver} for finding and loading
 * template.
 * 
 * @author Aurélien Baudet
 * @see TemplateResolver More information about template resolution
 */
public interface TemplateParser {
	/**
	 * Load the template from its name (or path). Read it and replace variables
	 * by the values defined in the context.
	 * 
	 * @param templateName
	 *            the name of the template to load (or the path)
	 * @param ctx
	 *            the context that contains the variable values
	 * @return the content generated from the template
	 * @throws ParseException
	 *             when the template couldn't be parsed either if the template
	 *             couldn't be read or if the template could't be processed
	 */
	public Content parse(String templateName, Context ctx) throws ParseException;
}
