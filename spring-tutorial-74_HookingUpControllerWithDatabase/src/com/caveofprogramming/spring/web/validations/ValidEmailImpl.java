package com.caveofprogramming.spring.web.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.EmailValidator;

//When implementing a ConstraintValidator, the first argument is a class that implements Annotation.
//The second parameter is the kind of data that we are going to validate
@SuppressWarnings("deprecation")
public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String>{

	private int min;
	
	@Override
	public void initialize(ValidEmail constraintAnnotation) {
		min = constraintAnnotation.min() ;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.length() < min){
			return false;
		}
		
		return EmailValidator.getInstance().isValid(value);
		
		
	}

}
