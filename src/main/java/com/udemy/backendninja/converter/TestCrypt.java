package com.udemy.backendninja.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {

	public static void main(String[] args) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		//$2a$10$PV3gtKfSB/vNkDMWNEwRIeSxvhJD1vbBb4SDH79ji6kS/pLfYXC22
		System.out.println(pe.encode("user"));

	}

}
