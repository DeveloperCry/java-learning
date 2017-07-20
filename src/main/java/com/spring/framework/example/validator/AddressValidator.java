/**
 * 
 */
package com.spring.framework.example.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.framework.example.bean.Address;

/**
 * @author Xiong.Liu
 *
 */
public class AddressValidator implements Validator{

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Address.class.equals(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "city", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "street", "field.required");
	}

}
