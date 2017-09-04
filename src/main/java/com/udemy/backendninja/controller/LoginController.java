package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.contant.ViewContant;

@Controller
public class LoginController {

	private static final Log LOG= LogFactory.getLog(LoginController.class);
	
	
	@GetMapping("/login")
	public ModelAndView showLoginForm(
			@RequestParam(name="error",required=false) String error,
			@RequestParam(name="logout",required=false) String logout) {
		
		LOG.info("METHOD: showLoginForm() --PARAMS: error="+error+" , logiuot="+logout);

		ModelAndView mav=new ModelAndView(ViewContant.LOGIN);
		mav.addObject("logout",logout);
		mav.addObject("error",error);
		
		LOG.info("Returning to login view");

		return mav;
	}
	
	@GetMapping({"/","/loginsuccess"})
	public String loginCheck() {
		LOG.info("METHOD: loginCheck()");
		LOG.info("Returning to contacts view");
		return "redirect:/contacts";
		
	}
	
	
	
	
	
}
