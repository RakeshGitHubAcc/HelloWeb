package com.myschool.form.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.myschool.form.model.FileBucket;

public class FileValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		 return FileBucket.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object obj, Errors errors) {
		FileBucket file = (FileBucket) obj;
		 if(file.getFile()!=null){
	            if (file.getFile().getSize() == 0) {
	                errors.rejectValue("file", "missing.file");
	            }
	        }
	}

}
