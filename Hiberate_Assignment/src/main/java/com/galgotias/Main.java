package com.galgotias;

import java.sql.Date;
import java.util.List;

import com.galgotias.model.Item;
import com.galgotias.model.Supplier;
import com.galgotias.model.Supply;

import jakarta.persistence.EntityManager;

public class Main {
	public static void main(String[] args) {
	    EntityManager em = EntityManagerFactoryProvider.getEntityManager();

	    try {
//	        em.getTransaction().begin();


	        Item i1 = new Item("Tomato", "Veg");
	        Item i2 = new Item("Onion", "Veg");
	        Item i3 = new Item("Sugar", "Groc");


	        em.persist(i1);
	        em.persist(i2);
	        em.persist(i3);


	        Supplier s1 = new Supplier("Ranjan Enterprises", "Delhi", 4.5);
	        Supplier s2 = new Supplier("Indian Supply", "Gurugram", 3.4);


	        em.persist(s1);
	        em.persist(s2);


	        Supply sp1 = new Supply();
	        sp1.setSupplier(s1);
	        sp1.setItem(i2);
	        sp1.setDatesupply("2019-03-03");
	        sp1.setPrice(36);
	        sp1.setQuantity(50);
	        
	        Supply sp2 = new Supply();
	        sp1.setSupplier(s1);
	        sp1.setItem(i3);
	        sp1.setDatesupply("2019-05-05");
	        sp1.setPrice(10);
	        sp1.setQuantity(45);
	        
	        Supply sp3 = new Supply();
	        sp1.setSupplier(s2);
	        sp1.setItem(i1);
	        sp1.setDatesupply("2019-08-15");
	        sp1.setPrice(50);
	        sp1.setQuantity(10);


	        em.persist(sp1);

//	        em.getTransaction().commit();

	        // Query 1: find all supplier names
	        List<String> supplierNames = em
	                .createQuery("SELECT s.name FROM Supplier s", String.class)
	                .getResultList();
	        System.out.println("Supplier Names: " + supplierNames);

	        // Query 2: find suppliers from Delhi
	        List<String> suppliersFromDelhi = em
	                .createQuery("SELECT s.name FROM Supplier s WHERE s.city = 'Delhi'", String.class)
	                .getResultList();
	        System.out.println("Suppliers from Delhi: " + suppliersFromDelhi);

	        // Query 3: find items supplied by supplier 1
	        List<String> itemsSuppliedBySupplier1 = em
	                .createQuery("SELECT sp.item.name FROM Supply sp WHERE sp.supplier.sid = :sid", String.class)
	                .setParameter("sid", s1.getSid())
	                .getResultList();
	        System.out.println("Items supplied by supplier with Sid=" + s1.getSid() + ": " + itemsSuppliedBySupplier1);

	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	}
}
