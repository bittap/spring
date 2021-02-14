package com.javalec.vaildate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StduentVaildator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		Student student = (Student)target;
		
		String id = student.getId();
		
		if(id == null || id.trim().isEmpty())
		{
			System.out.println("id : null or isEmpty");
			errors.reject("id","error");
		}
		
		int age = student.getAge();
		
		if(age == 0)
		{
			System.out.println("age : null");
			errors.reject("age","error");
		}
	}
}
