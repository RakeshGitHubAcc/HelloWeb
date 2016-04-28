package com.myschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/serviceOld/greeting")
public class SpringOldRestServiceController {
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	 public @ResponseBody String getGreeting(@PathVariable String name) {
	  String result="Hello "+name; 
	  return result;
	 }

}
