package br.com.caelum.fj26.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "comecaComMaiuscula")
public class ComecaComMaiuscula implements Validator {

	@Override
	public void validate(FacesContext fc, UIComponent uiComponent, Object value) throws ValidatorException {
		String nome = value.toString();
		if (!nome.matches("[A-Z].*")) {
			throw new ValidatorException(new FacesMessage("Deve comecar com maiuscula"));
		}
	}
	
}
