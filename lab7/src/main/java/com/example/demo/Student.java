package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
int id;
int totalMarks;
String name;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getTotalMarks() {
	return totalMarks;
}
public void setTotalMarks(int totalMarks) {
	this.totalMarks = totalMarks;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Student [id=" + id + ", totalMarks=" + totalMarks + ", name=" + name + "]";
}



}
