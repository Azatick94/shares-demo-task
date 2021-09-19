package com.example.sharesdemotask.utls;

import com.example.sharesdemotask.models.Quote;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SharesValidator implements ConstraintValidator<SharesCustomValidator, Quote> {

    @Override
    public void initialize(SharesCustomValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Quote quote, ConstraintValidatorContext context) {
        return quote.getBid() < quote.getAsk();
    }
}
