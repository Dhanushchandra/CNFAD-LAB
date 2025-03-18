package com.cnfad.lab1;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Lab1Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);
		Scanner sc =new Scanner(System.in);
		ApplicationContext ac = new ClassPathXmlApplicationContext("coldept.xml");
	    Department dt = (Department) ac.getBean("department");
		
		
		while(true) {
			System.out.println("1.insert the Department details \n" + "2.Dispaly dept with college details \n" +"3.exit");
			System.out.println("Enter choice");
			int a=sc.nextInt();
			switch(a) {
			case 1:
				System.out.println("Enter Department Name: ");
				dt.setName(sc.next());
				System.out.println("Enter Department Number: ");
				dt.setId(sc.nextInt());
				System.out.println("Enter Department Description: ");
				dt.setDescription(sc.next());
				System.out.println("Thanks");
				break;
			case 2:
				System.out.println("dept details");
				System.out.println("Name:"+dt.getName()+" "+"ID:"+dt.getId()+"Dept desc"+dt.getDescription());
				System.out.println("clg details");
				College c=dt.getCollege();
				System.out.println("clg name:"+c.getName());
				System.out.println("Clg address"+c.getAddress());
				break;
			case 3:
				System.exit(0);
			}
	}
	}
}


