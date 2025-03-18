package com.cnfad.lab4;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Product {
	
	@NotNull(message="id is required")
	@Min(1)
	@Max(100)
	private Long id;
	
	@NotNull(message="name is required")
	private String name;
	
	@Min(1)
	@NotNull(message="price is required")
	private Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	

}
