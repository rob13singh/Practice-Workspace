package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String prefix;
	
	public void initialize (CourseCode courseCode)
	{
		prefix=courseCode.value();
	}
	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
		
		boolean result;
		System.out.println(code);
		if(code != null)
		{
			result	= code.startsWith(prefix);
		}
		else
		{
			result=true;
		}
		return result;
	}
	
	

}
