package com.cnfad.lab1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	@Bean
	@Scope("prototype")
	public Customer getCustomer() {
		Customer c = new Customer();
		c.setTick(getTicket());
		return c;
	}
	
	@Bean
	@Scope("singleton")
	public Ticket getTicket() {
		return new Ticket();
	}
	
}
