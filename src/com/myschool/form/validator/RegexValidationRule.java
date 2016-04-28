package com.myschool.form.validator;

import java.util.regex.Pattern;

public class RegexValidationRule implements ValidationRule{
private String regex;
private String message;
public RegexValidationRule() { }
public RegexValidationRule(String inRegex, String inMessage) {
	this.regex = inRegex;
	this.message = inMessage;
}
/* (non-Javadoc)
 * @see dm.passwordvalidator.ValidationRule#validate(java.lang.String)
 */
public boolean validate(String inPassword) {
	if (Pattern.matches(regex, inPassword)) {
		return true;
	}
	return false;
}
/* (non-Javadoc)
 * @see dm.passwordvalidator.ValidationRule#getMessage()
 */
public String getMessage() {
	return message;
}

/**
 * @param message
 */
public void setMessage(String message) {
	this.message = message;
}

/**
 * @param inRegex
 */
public void setRegex(String inRegex) {
	this.regex = inRegex;
}
}
