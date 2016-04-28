package com.myschool.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myschool.form.model.LoginForm;

@Controller
public class PdfController {
	@RequestMapping(value = "/generate/pdf.htm", method = RequestMethod.GET)
	ModelAndView generatePdf(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		System.out.println("Calling generatePdf()...");
		LoginForm loginForm=new LoginForm();
		loginForm.setUserId(100001);
		loginForm.setUserName("Rakesh");
		ModelAndView modelAndView = new ModelAndView("pdfView", "command",loginForm);
		return modelAndView;
	}
}
