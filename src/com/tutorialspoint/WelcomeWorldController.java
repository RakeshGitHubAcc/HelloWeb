package com.tutorialspoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class WelcomeWorldController {
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {  
        String message = "Welcome to Spring MVC !!!";  
        return new ModelAndView("welcomepage", "message", message);  
    }  
}
