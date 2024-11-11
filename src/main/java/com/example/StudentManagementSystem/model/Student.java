package com.example.StudentManagementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table (name = "students")

public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "firstName", nullable = false)
    private String firstName;

    @Column (name = "lastName", nullable = false)
    private String lastName;

    @Column (name = "email", nullable = false, unique = true)
    private String email;

    @Column (name = "department", nullable = false)
    private String department;

    @Column (name = "yearOfEnrollment", nullable = false)
    private int yearOfEnrollment;
}
