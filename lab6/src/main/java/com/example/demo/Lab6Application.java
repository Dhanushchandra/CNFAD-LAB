package com.example.demo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.persistence.Query;

@SpringBootApplication
public class Lab6Application {
	
	private static SessionFactory sessionFactory;
	
	public Session getSession() {
		 if (sessionFactory == null) {
		        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		    }
		    return sessionFactory.openSession();
	}
	
	public void insert(int id, String name, String address,String usn, int totalMarks) {
		Student student = new Student();
		student.setAddress(address);
		student.setName(name);
		student.setTotalMarks(totalMarks);
		student.setUsn(usn);
		student.setId(id);
		Session s = getSession();
		Transaction t = s.beginTransaction();
		s.save(student);
		t.commit();
		s.close();
	}
	
	public List<Student> display(){
		Session s = getSession();
		Query query = s.createQuery("from Student",Student.class);
		List<Student> students = query.getResultList();
		 s.close();
		return students;
	}
	
	public void search(String name) {
		Session s = getSession();
		Transaction transaction = s.beginTransaction();
		Query query = s.createQuery("select s from Student s where s.name = :name", Student.class);
		query.setParameter("name", name);
		System.out.println(query.getResultList());
		transaction.commit();
		s.close();
	}
	public void delete(String name) {
		Session s = getSession();
		Transaction transaction = s.beginTransaction();
		Query query = s.createQuery("delete from Student s where s.name = :name");
		query.setParameter("name", name);
		int status = query.executeUpdate();
		System.out.println("Rows Deleted: " + status);
		transaction.commit();
		s.close();
	}
	
	
	

	public static void main(String[] args) {
		Lab6Application hb = new Lab6Application();
		SpringApplication.run(Lab6Application.class, args);
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("----------------MENU-----------------");
			System.out.println("1. Insert");
			System.out.println("2. Search");
			System.out.println("3. Display");
			System.out.println("4. Delete");
			System.out.println("5. Exit");
			System.out.println("Enter your Choice :  ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the Student Details:-");
				System.out.println("Enter name = ");
				String name = scanner.next();
				System.out.println("Enter id = ");
				int id = scanner.nextInt();
				System.out.println("Enter address = ");
				String address = scanner.next();
				System.out.println("Enter usn = ");
				String usn = scanner.next();
				System.out.println("Enter TotalMarks = ");
				int totalMarks = scanner.nextInt();
				hb.insert(id, name, address,usn, totalMarks);
				break;
			case 2:
				System.out.println("Enter name = ");
				String name1 = scanner.next();
				hb.search(name1);
				break;
			case 3:
				System.out.println(hb.display());
				break;
			case 4:
				System.out.println("Enter name = ");
				String name2 = scanner.next();
				hb.delete(name2);
				break;
			case 5:
				System.exit(0);
			default:
				break;
			}
		}
	
	}

}
