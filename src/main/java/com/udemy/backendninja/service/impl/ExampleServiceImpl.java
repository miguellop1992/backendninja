package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{
	
	private static final Log LOG=LogFactory.getLog(ExampleServiceImpl.class);
	
	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Juan",23));
		people.add(new Person("Maria",30));
		people.add(new Person("Eva",43));
		people.add(new Person("Miguel",18));
		LOG.info("INFO HELLO SERVICE");
		return people;
	}

}
