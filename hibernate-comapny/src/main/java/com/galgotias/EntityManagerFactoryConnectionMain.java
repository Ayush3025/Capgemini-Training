package com.galgotias;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryConnectionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("college_pu");
		EntityManager em = emf.createEntityManager();
		
		System.out.println(emf);
		
		em.getTransaction().begin();
		
		Trainer t1 = new Trainer();
		t1.setName("Ayush");
		t1.setTrainerId(501);
		
		Trainer t2 = new Trainer();
		t2.setName("Ayush");
		t2.setTrainerId(500);
		
//		em.persist(t2);
		em.getTransaction().commit();
		
		Trainer trainer = em.find(Trainer.class, 500);
		System.out.println(trainer);
		
		em.close();
		
		emf.close();
	}

}
