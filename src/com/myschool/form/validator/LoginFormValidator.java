package com.myschool.form.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myschool.form.model.LoginForm;
//@Component
public class LoginFormValidator implements Validator {
	@Autowired
	@Qualifier("passwordValidator")
	PasswordValidator passwordValidator;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return LoginForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginForm loginForm=(LoginForm)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "NotEmpty.loginForm.userId");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.loginForm.userName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPswd", "NotEmpty.loginForm.newPswd");
		if(!passwordValidator.validate(loginForm.getNewPswd())){
			errors.rejectValue("newPswd", "NotMatches.password.policy");
		}
	}

}
