package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.model.ContactModel;

public interface ContactService {
	
	public ContactModel addContact(ContactModel contactModel);
	
	public List<ContactModel> listAllContact();
	
	public ContactModel findContactById(int id);
	
	public void removeContact(int id);
}
