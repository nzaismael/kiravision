/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.validator.partner;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


/**
 *
 * @author AOS
 */
@FacesValidator("com.kira.validator.reductionValidator")
public class ContractReductionValidator implements Validator {
 /* private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." +
			"[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
			"(\\.[A-Za-z]{2,})$";

	private Pattern pattern;
	private Matcher matcher;

	public ContractSignedOnValidator(){
		  pattern = Pattern.compile(EMAIL_PATTERN);
	}  
    */
 @Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

	/*	matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){

			FacesMessage msg =
				new FacesMessage("E-mail validation failed.",
						"Invalid E-mail format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}*/
   try
   {
if((Double)value==0.0)
{
    FacesMessage msg =
				new FacesMessage("Reduction validation failed.",
						"The reduction A=percentage mount should be greater than zero <br></br>");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
}

 else if((Double)value<0.0)
  {
     FacesMessage msg =
				new FacesMessage("Reduction validation failed.",
						".The reduction should not be negative <br></br>");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
      
  }

   }
  
   
   
   catch( Exception e)
   {
    FacesMessage msg =
				new FacesMessage("Reduction validation failed.",
						".The reduction Should be a number <br></br>");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);   
   }



        
	}
    
}
