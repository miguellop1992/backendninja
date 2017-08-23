package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/example2")
public class Example2Controller {
	
	private static final String EXAMPLE2_VIEW="example2";
	
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name="nm", required=false,defaultValue="NULL") String name) {
		ModelAndView mav=new ModelAndView(EXAMPLE2_VIEW);
		mav.addObject("name", name);
		return mav;
	}
	
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(@PathVariable("nm") String name) {
		ModelAndView mav=new ModelAndView(EXAMPLE2_VIEW);
		mav.addObject("name", name);
		return mav;
	}
}
