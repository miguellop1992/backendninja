package com.udemy.backendninja.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.service.EjercicioService;

@Service("ejercicioService")
public class EjercicioServiceImpl implements EjercicioService {

	private static final Log LOG = LogFactory.getLog(EjercicioServiceImpl.class);
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		LOG.info("--REQUEST EJERCICIO");
	}

}
