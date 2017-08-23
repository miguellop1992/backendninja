package com.udemy.backendninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.component.ExampleComponent;
import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {

	public static final String EXAMPLE_VIEW = "example";

	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	
	
	// Primera forma
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("person", new Person("Jon", 23));
		model.addAttribute("people", exampleService.getListPeople());
		return EXAMPLE_VIEW;
	}

	// Segunda forma
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("person", new Person("Mikel",30));
		mav.addObject("people", exampleService.getListPeople());
		return mav;
	}
	
	
}
