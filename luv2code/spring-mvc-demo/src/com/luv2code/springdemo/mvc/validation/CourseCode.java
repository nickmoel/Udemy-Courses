package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // class that creates the logic
@Target({ ElementType.METHOD, ElementType.FIELD }) // annotation to a method or field
@Retention(RetentionPolicy.RUNTIME) // use this annotation at runtime
public @interface CourseCode {

	 // define default course code
    public String[] value() default {"LUV"};

	// define default error message
	public String message() default "must start with LUV";

	// define default groups
	public Class<?>[] groups() default {};

	// define default payloads
	public Class<? extends Payload>[] payload() default {};
}
