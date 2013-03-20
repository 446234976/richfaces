package it.richfaces.validate;

import it.richfaces.view.backing.HomeBB;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

@FacesValidator("validate")
public class Validate implements Validator {
	
	private final static Logger log = Logger.getLogger(Validate.class);

	public void validate(FacesContext context, UIComponent uiComponent, Object object)
			throws ValidatorException {
log.info("Start=====================>validate"+uiComponent);
		
		if(uiComponent.getId().equals("itValidate")){
			log.info("Start=====================>validateItRows");
			String v = (String) object;
			log.info("\nValue: "+v);
			if(!v.contains("0")){
				FacesMessage message = new FacesMessage();
	            message.setSeverity(FacesMessage.SEVERITY_ERROR);
	            message.setSummary("Value is not valid.");
	            message.setDetail("Value is not valid.");
	            context.addMessage("form:itValidate", message);
	            //HtmlInputText it = (HtmlInputText) uiComponent;
	            //it.setOnfocus("setRequired('itValidate','E\' necessario immettere un Valore.');");
//	            HomeBB home = (HomeBB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("home");
//	            log.info("HomeBB from Session: "+home);
//	            home.getItvalidate().setValue("Test");
	            	
	            throw new ValidatorException(message);
			}
			log.info("End=====================>validateItRows");
		}
		
		log.info("End=====================>validate");

	}

}
