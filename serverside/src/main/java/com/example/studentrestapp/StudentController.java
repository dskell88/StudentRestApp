package com.example.studentrestapp;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
@RestController
public class StudentController {
    private StudentRepository repository;
    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/students")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Student> goodStudents() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

}