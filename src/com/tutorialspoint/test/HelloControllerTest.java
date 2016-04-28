package com.tutorialspoint.test;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.tutorialspoint.HelloController;

public class HelloControllerTest extends TestCase {
	protected final Log logger = LogFactory.getLog(getClass());
	public void  testHandleRequestView() throws Exception {
		HelloController controller = new HelloController();
		ModelAndView modelAndView = controller.handleRequest(null,null);
		logger.info("Returning hello view");
		assertEquals("helloTest", modelAndView.getViewName());
	}
}
