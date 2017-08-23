package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.service.EjercicioService;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {
	
	private static final Log LOG=LogFactory.getLog(EjercicioController.class);
	private static final String EJECICIO_VIEW="ejercicio";
	
	@Autowired
	@Qualifier("ejercicioService")
	private EjercicioService ejercicioService;
	
	@GetMapping("/method1")
	public String method1() {
		return "redirect:/ejercicio/method2";
	}
	
	@GetMapping("/method2")
	public ModelAndView method2() {
		ModelAndView mav = new ModelAndView(EJECICIO_VIEW);
		mav.addObject("message", "Ejercicio");
		ejercicioService.execute();
		LOG.info("--REQUEST AFTER EXECUTE LOG --TIME : "+System.currentTimeMillis()+"ms");
		return mav;
	}
}
