package com.cnfad.lab1;

public class Customer {
	
	private String name, address;
	private Ticket tick;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Ticket getTick() {
		return tick;
	}
	public void setTick(Ticket tick) {
		this.tick = tick;
	}


}
