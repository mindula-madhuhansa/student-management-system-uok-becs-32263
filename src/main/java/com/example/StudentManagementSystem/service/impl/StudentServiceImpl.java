package com.example.StudentManagementSystem.service.impl;

import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.repository.StudentRepository;
import com.example.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

//    save
    @Override
    public Student saveStudent (Student student) {
        return studentRepository.save(student);
    }

//    get all
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

//    get student by id
    @Override
    public Student getStudentById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()){
            return student.get();
        } else {
            throw new RuntimeException("Student not found");
        }
    }

//    update student
    @Override
    public Student updateStudent(Student student, long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found")
        );
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYearOfEnrollment(student.getYearOfEnrollment());

        studentRepository.save(existingStudent);
        return existingStudent;
    }

//    delete student
    public void deleteStudent(long id) {
        studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found")
        );
        studentRepository.deleteById(id);
    }
}
