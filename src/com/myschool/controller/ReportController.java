package com.myschool.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.myschool.form.model.LoginForm;
import com.myschool.form.service.LoginService;

@Controller
public class ReportController extends AbstractController{
	@Autowired
	LoginService loginService;
	@Autowired
	private LoginForm loginForm;
	
	@RequestMapping(value = "/generate/excel.htm", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		LoginForm dbLoginForm = loginService.findById(100001);
		return new ModelAndView("excelView","loginForm",dbLoginForm);
	}

}
