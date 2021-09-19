package com.example.sharesdemotask.utls;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SharesValidator.class)
public @interface SharesCustomValidator {

    String message() default "bid should be smaller than ask";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

