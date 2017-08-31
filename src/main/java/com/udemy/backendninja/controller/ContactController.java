package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.udemy.backendninja.contant.ViewContant;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	
	private static final Log LOG= LogFactory.getLog(ContactController.class);
	private static final String REDIRECT_CONTACTS= "redirect:/contacts";

	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	@GetMapping
	public ModelAndView view() {
		ModelAndView mav = new ModelAndView(ViewContant.CONTACTS);
		mav.addObject("contacts",contactService.listAllContact());
		return mav;
	}
	
	
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name="contactModel") ContactModel contactModel, Model model,RedirectAttributes redirectAttributes) {
		LOG.info("Method: addContact() --Parame: contactModel="+contactModel);
		
		if(contactService.addContact(contactModel)!=null){
			redirectAttributes.addFlashAttribute("result",(contactModel.getId()==0?1:2));
		}else {
			redirectAttributes.addFlashAttribute("result",0);
		}
		
		return REDIRECT_CONTACTS ;		
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return REDIRECT_CONTACTS;
	}
	
	@GetMapping("/form")
	public String form(@RequestParam(name="id",defaultValue="0",required=false) int id,Model model) {
		
		ContactModel contactModel=(id!=0)?contactService.findContactById(id):new ContactModel();
		
		model.addAttribute("contactModel", contactModel);
		
		return ViewContant.CONTACT_FORM;
	}
	
	@GetMapping("/removecontact")
	public String removeContact(@RequestParam(name="id",required=true) int id) {
		contactService.removeContact(id);
		return REDIRECT_CONTACTS;
	}

}
