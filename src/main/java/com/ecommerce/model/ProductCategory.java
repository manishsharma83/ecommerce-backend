package com.ecommerce.model;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity 
@Table (name = "product_categories")
@Component
public class ProductCategory {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
