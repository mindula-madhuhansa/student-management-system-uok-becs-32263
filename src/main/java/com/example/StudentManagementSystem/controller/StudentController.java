package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")

public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

//    Get All
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

//    Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentID) {
        return new ResponseEntity<Student>(studentService.getStudentById(studentID), HttpStatus.OK);
    }

//    Update
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

//    Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student deleted successfully", HttpStatus.OK);
    }
}
