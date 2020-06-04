/**
 * 
 */
package com.learning.spring.validator;

import com.learning.spring.bean.Address;
import com.learning.spring.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Xiong.Liu
 *
 */
public class CustomerValidator implements Validator{

	private final Validator addressValidator;
	
	@Autowired
	public CustomerValidator(Validator addressValidator) {
		if (addressValidator == null) {
			throw new IllegalArgumentException("The supplied [Validator] is " +
	                "required and must not be null.");
		}
		
		if (!addressValidator.supports(Address.class)) {
			throw new IllegalArgumentException("The supplied [Validator] must " +
	                "support the validation of [Address] instances.");
		}
		this.addressValidator = addressValidator;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Customer.class.isAssignableFrom(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "firstName", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "secondName", "field.required");
		Customer customer = (Customer) target;
		try {
			errors.pushNestedPath("address");
			ValidationUtils.invokeValidator(this.addressValidator, customer.getAddress(), errors);
		} finally {
			errors.popNestedPath();
		}
	}

}
