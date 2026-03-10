package com.galgotias;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryConnectionMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("online_shopping_pu");
		EntityManager em = emf.createEntityManager();
		
		System.out.println(emf);
		em.close();
		emf.close();
	}

}
