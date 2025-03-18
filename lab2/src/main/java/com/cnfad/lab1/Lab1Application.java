package com.cnfad.lab1;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Lab1Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Customer c = ac.getBean(Customer.class);
		Ticket t = ac.getBean(Ticket.class);
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Customer Details");
		System.out.println("Name:");
		c.setName(sc.nextLine());
		
		System.out.println("Address:");
		c.setAddress(sc.nextLine());
		
		
		System.out.println("Enter Ticket Details");
		System.out.println("Ticket Number");
		t.setTicno(sc.nextInt());
		
		System.out.println("Price");
		t.setPrice(sc.nextInt());
		
		System.out.println("Seat Number");
		t.setSeatno(sc.nextInt());
		
		System.out.println("Ticket Type");
		t.setTictype(sc.next());
		
		System.out.println("Customer Details");
		System.out.println(c.getName());
		System.out.println(c.getAddress());
		
		System.out.println("Ticket Details");
		System.out.println(t.getPrice());
		System.out.println(t.getSeatno());
		System.out.println(t.getTicno());
		System.out.println(t.getTictype());
		
		
		sc.close();
		
	}

}
