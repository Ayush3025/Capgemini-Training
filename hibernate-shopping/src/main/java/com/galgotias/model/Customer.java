package com.galgotias.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Customer {
	
	@SequenceGenerator(name = "customerSeq", initialValue = 1001, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerSeq")
	long custId;
	String name, address, phone, email;
	
	@OnetoMany
	List<AnOrder> orders;

}
