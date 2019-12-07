/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leoberson.cursomc.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leoberson
 */
public class ValidationError extends StandardError{
    
    private static final long serialVersionUID = 1L;
    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Integer status, String msg, long timeStamp) {
        super(status, msg, timeStamp);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message){
        errors.add(new FieldMessage(fieldName, message));
    }
    
}
