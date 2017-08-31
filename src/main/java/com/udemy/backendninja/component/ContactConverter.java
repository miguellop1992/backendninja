package com.udemy.backendninja.component;

import org.springframework.stereotype.Component;

import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {

	public Contact convert2Entity(ContactModel contactModel) {
		return new Contact(contactModel.getId(), contactModel.getFirstname(), contactModel.getLastname(),
				contactModel.getTelephone(), contactModel.getCity());
	}
	
	
	public ContactModel convert2ContactModel(Contact contact) {
		return new ContactModel(contact.getId(), contact.getFirstname(), contact.getLastname(),
				contact.getTelephone(), contact.getCity());
	}

}
