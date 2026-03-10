package com.galgotias.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payment {

	@Id
	long paymentId;
}
