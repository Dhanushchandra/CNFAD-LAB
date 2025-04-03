package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public void insertMessage(String name,int marks) {
		Student s = new Student();
		s.setName(name);
		s.setTotalMarks(marks);
		studentRepository.save(s);
	}
	
	public List<Student> displayMessage(){
		return studentRepository.findAll();
	}
	
	public void deleteMessage(int id) {
		studentRepository.deleteById(id);
	}

}
