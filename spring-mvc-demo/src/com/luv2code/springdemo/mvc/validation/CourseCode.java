package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=CourseCodeConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	//Value attribute
	public String value() default "LUV";
	
	//Message attribute
	public String message() default "Should start with LUV";
	
	//Default groups
	public Class<?>[] groups() default {};
	
	//Default payload
	public Class<? extends Payload>[] payload() default {};
}
