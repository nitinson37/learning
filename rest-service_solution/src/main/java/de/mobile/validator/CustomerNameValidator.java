package de.mobile.validator;

import de.mobile.annotations.CustomerNameConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class CustomerNameValidator implements ConstraintValidator<CustomerNameConstraint, String> {
    @Override
    public void initialize(CustomerNameConstraint customerName) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return name != null && name.matches("[a-zA-Z0-9]+");
    }
}
