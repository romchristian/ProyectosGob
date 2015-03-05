/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.dao;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author cromero
 */
@FacesValidator("validadorNroExpediente")
public class ValidadorNroExpediente implements Validator {

    @EJB
    private ValidadoresDAO ejb;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String valor = (String) value;
        if (valor != null && ejb.hayNroExpediente(valor.toUpperCase().trim())) {

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El nro de expediente  " + valor + " ya existe!",
                    "El nro de expediente  " + valor + " ya existe!");

            throw new ValidatorException(message);
        }
    }

}
