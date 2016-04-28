package com.myschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myschool.constant.GlobalConstant;
import com.myschool.form.model.LoginForm;
import com.myschool.form.service.LoginService;
import com.myschool.form.validator.LoginFormValidator;

@Controller
public class LoginController {
	@Autowired
	LoginFormValidator loginFormValidator;
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		String viewName = GlobalConstant.ERROR_PAGE;
		try {
			LoginForm loginForm = new LoginForm();
			loginForm.setUserActionUrl(GlobalConstant.LOGIN_PAGE_ACTION);
			model.addAttribute("loginForm", loginForm);
			viewName = GlobalConstant.LOGIN_PAGE;
			System.out.println("inside login()...");
		} catch (Exception e) {
			// log exception
			// redirect to error page/Exception page
		}
		return viewName;
	}

	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public ModelAndView doLogin(
			@Validated @ModelAttribute("loginForm") LoginForm loginForm,
			BindingResult result, ModelMap model) {
		String viewName = GlobalConstant.ERROR_PAGE;
		boolean loginStatus = false;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);
		try {
			// Validation code
			loginFormValidator.validate(loginForm, result);
			if (result.hasErrors()) {
				System.out
						.println("inside doLogin()...Data type mismatch occured");
				loginForm.setUserActionUrl(GlobalConstant.LOGIN_PAGE_ACTION);
				model.addAttribute("loginForm", loginForm);
				// redirect to login page with errors
				viewName = GlobalConstant.LOGIN_PAGE;
				modelAndView.setViewName(viewName);
			} else {
				// No Data type mismatch occured
				System.out.println("inside doLogin()...Normal Flow");
				LoginForm dbLoginForm = loginService.findById(loginForm
						.getUserId());
				// business logic for login validation
				if (null != dbLoginForm) {
					// user exists
					if (!StringUtils.isEmpty(dbLoginForm.getNewPswd())) {
						// check if password matches
						if (!StringUtils.isEmpty(loginForm.getNewPswd())
								&& loginForm.getNewPswd().equals(dbLoginForm.getNewPswd())) {
							// redirect to welcome page
							String message = "";
							if(!StringUtils.isEmpty(dbLoginForm.getUserName())){
								message=message+dbLoginForm.getUserName()+" , ";	
							}
							message=message+"Welcome to School application!!!";
							model.addAttribute("message", message);
							viewName = GlobalConstant.WELCOME_PAGE;
						} else {
							// redirect with password doesn't match message
						}
					}
				} else {
					// user does not exist
					// redirect with password doesn't does not exist message
				}
				modelAndView.setViewName(viewName);
			}
		} catch (Exception e) {
			// log error
			// redirect to error page
			System.out.println("inside doLogin()...Exception");
			e.printStackTrace();
		}
		return modelAndView;
	}
}
