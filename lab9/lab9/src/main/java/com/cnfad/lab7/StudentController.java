package com.cnfad.lab7;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        studentService.insertMessage(student.getName(), student.getTotalmarks());
        return "Student added successfully";
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.displayMessage();
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student) {
        studentService.updateMessage(id, student.getTotalmarks());
        return "Student updated successfully";
    }
}
