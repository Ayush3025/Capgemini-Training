package com.gal.algo;


import org.springframework.stereotype.Component;

// asking Ioc container(Application Context :  AnnotationConfigApplicationContext)
// create object for this ioc

@Component
public class PasswordHasher {
	public String hash(String password) {
		return new StringBuilder(password).reverse().toString();
	}
}
