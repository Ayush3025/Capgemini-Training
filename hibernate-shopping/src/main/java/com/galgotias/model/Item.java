package com.galgotias.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Item {
	
	@Id
	long itemId;
	
	String name;
	Double cost;

}
