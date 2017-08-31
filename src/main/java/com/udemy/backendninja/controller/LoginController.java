package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.contant.ViewContant;
import com.udemy.backendninja.model.UserCredential;

@Controller
public class LoginController {

	private static final Log LOG= LogFactory.getLog(LoginController.class);
	
	@GetMapping("/")
	public String redirectToLogin() {
		LOG.info("METHOD: redirectToLogin()");
		return "redirect:/login";
	}
	
	
	@GetMapping("/login")
	public ModelAndView showLoginForm(
			@RequestParam(name="error",required=false) String error,
			@RequestParam(name="logout",required=false) String logout) {
		
		LOG.info("METHOD: showLoginForm() --PARAMS: error="+error+" , logiuot="+logout);

		ModelAndView mav=new ModelAndView(ViewContant.LOGIN);
		mav.addObject("userCredential",new UserCredential());
		mav.addObject("logout",logout);
		mav.addObject("error",error);
		
		LOG.info("Returning to login view");

		return mav;
	}
	
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute("userCredential") UserCredential userCredential) {
		LOG.info("METHOD: showLoginForm() --PARAMS: userCredential="+userCredential);

		String value="user";
		if(userCredential.getUsername().equals(value) && userCredential.getPassword().equals(value)) {
			LOG.info("Returning to contacts view");
			return "redirect:/contacts";
		}else {
			LOG.info("Returning to login?erro");
			
			return "redirect:/login?error=Invalid username or password".replace(" ","%20");
		}
		
	}
	
	
	
	
}
