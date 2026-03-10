package com.galgotias.model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.TableGenerator;

@Entity
public class AnOrder {
	
	@TableGenerator(name="allseqgenerator", allocationSize = 1, initialValue = 101, pkColumnName = "seqname", pkColumnValue = "nextorderid")
	@Id
	@GeneratedValue
	long orderId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="custId")
	Customer customer;
	int numberItems;
	Double cost;
	String deliveryAddress;
	
	@OneToOne
	@JoinColumn(name="payemntId")
	Payment  payment;

}
