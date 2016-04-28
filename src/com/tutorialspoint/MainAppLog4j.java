package com.tutorialspoint;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppLog4j {
	static Logger log = Logger.getLogger(MainAppLog4j.class.getName());

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Beans.xml");
		log.info("MainAppLog4j:Going to create HelloWord Obj");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		log.info("MainAppLog4j:Exiting the program");
	}

}
