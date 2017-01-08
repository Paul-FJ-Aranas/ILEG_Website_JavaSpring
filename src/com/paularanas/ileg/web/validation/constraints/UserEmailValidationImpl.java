package com.paularanas.ileg.web.validation.constraints;

import java.lang.annotation.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;

public class UserEmailValidationImpl implements ConstraintValidator<UserEmailValidation, String> {
	int min;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.length() <= min){
		return false;
		}
		if(!EmailValidator.getInstance(false).isValid(value)){
			return false;
		}
		return true;
	}

	@Override
	public void initialize(UserEmailValidation constraintAnnotation) {
		min = constraintAnnotation.min();
		
	}



}
