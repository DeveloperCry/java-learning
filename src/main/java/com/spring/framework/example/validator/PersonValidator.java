/**
 * 
 */
package com.spring.framework.example.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.framework.example.bean.Person;

/**
 * @author Xiong.Liu
 *
 */
public class PersonValidator implements Validator{

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Person.class.equals(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
		Person person = (Person) target;
		if (person.getAge() < 0) {
			errors.rejectValue("age", "negativevalue");
		} else if (person.getAge() > 110) {
			errors.rejectValue("age", "too.darn.old");
		}
	}

}
