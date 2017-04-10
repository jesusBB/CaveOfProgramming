package com.caveofprogramming.spring.web.validations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {com.caveofprogramming.spring.web.validations.ValidEmailImpl.class })
public @interface ValidEmail {

	String message() default "This does not apper to be a valid email address";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	int min() default 5;
}
