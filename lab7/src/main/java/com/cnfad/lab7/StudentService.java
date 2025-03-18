package com.cnfad.lab7;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	void insertMessage(String name,int marks) {
		Student s = new Student();
		s.setName(name);
		s.setTotalmarks(marks);
		studentRepository.save(s);
	}
	
	
	List<Student> displayMessage(){
		return studentRepository.findAll();
	}
	
	void updateMessage(int id,int marks) {
		Optional<Student> s = studentRepository.findById(id);
		if(s.isPresent()) {
			Student student = s.get();
			student.setTotalmarks(marks);
			studentRepository.save(student);	
		}else {
			System.out.println("No such record");
		}
	}
}
