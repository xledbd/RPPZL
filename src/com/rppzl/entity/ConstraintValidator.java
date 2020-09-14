package com.rppzl.entity;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ConstraintValidator {
	private static Validator instance;

	private ConstraintValidator() {

	}

	public static Validator getInstance() {
		if (instance == null) {
			ValidatorFactory factory = Validation.byDefaultProvider()
					.configure().messageInterpolator(new ParameterMessageInterpolator())
					.buildValidatorFactory();
			instance = factory.getValidator();
		}
		return instance;
	}
}
