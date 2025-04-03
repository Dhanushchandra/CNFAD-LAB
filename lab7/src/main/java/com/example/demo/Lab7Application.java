package com.example.demo;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lab7Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Lab7Application.class, args);
		 Scanner scanner = new Scanner(System.in);
	        
	        int ch;
	        String name;
	        int marks;
	        
			StudentService studentService= context.getBean(StudentService.class);
		while(true) { 
			System.out.println("MENU\n1.Enter name\n2.Display table\n3.Delete\n4.Exit");
			
			switch (scanner.nextInt()) {
			
				case 1: {
					System.out.println("Enter Student name:");
					name=scanner.next();
					System.out.println("Enter Marks");
					marks=scanner.nextInt();
					studentService.insertMessage(name,marks);
					break;
				}
					
				case 2: {
			
						System.out.println(studentService.displayMessage());
					
					break;
				}
				
				case 3: {
					System.out.println("Enter Student id:");
					int id=scanner.nextInt();
					studentService.deleteMessage(id);
					System.out.print("Record deleted");
				break;
				}
	
				case 4: {
					System.exit(0);
				}	
			}

}
	}

}
