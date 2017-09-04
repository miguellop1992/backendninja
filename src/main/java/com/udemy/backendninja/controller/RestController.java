package com.udemy.backendninja.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.backendninja.model.ContactModel;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("rest")
public class RestController {

	
	
	@GetMapping("/checkrest")
	public ResponseEntity<ContactModel> checkRest(){
		ContactModel contactModel = new ContactModel(2, "Mikel", "Perez", "1456161", "Madrid");
		return new ResponseEntity<ContactModel>(contactModel, HttpStatus.OK);
	}
	
}
