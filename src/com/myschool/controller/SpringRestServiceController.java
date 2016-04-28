package com.myschool.controller;
/**
 * Spring 4.0 version code*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myschool.form.model.LoginForm;
import com.myschool.form.service.LoginService;

@RestController
@RequestMapping("/service/greeting")
public class SpringRestServiceController {
	@Autowired
	LoginService loginService;
	@Autowired
	private LoginForm loginForm;
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String getGreeting(@PathVariable String name) {
		  String result="Hello "+name; 
		  return result;
		 }
	@RequestMapping("/loginForm")
	public LoginForm getPersonDetail(@RequestParam(value = "id",required = false,
	                                                    defaultValue = "100001") Integer id) {
		LoginForm dbLoginForm = loginService.findById(id);
		dbLoginForm.setNewPswd(null);
		dbLoginForm.setOldPswd(null);
		return dbLoginForm;
	}

}
