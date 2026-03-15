
package com.example.studentapi.controller;

import com.example.studentapi.exception.InvalidInputException;
import com.example.studentapi.exception.StudentNotFoundException;
import com.example.studentapi.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static Map<Integer, Student> students = new HashMap<>();

    static {
        students.put(1, new Student(1, "Rahul", "Computer Science"));
        students.put(2, new Student(2, "Anita", "Electronics"));
        students.put(3, new Student(3, "Kiran", "Mechanical"));
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {

        if (id <= 0) {
            throw new InvalidInputException("Student ID must be a positive number");
        }

        Student student = students.get(id);

        if (student == null) {
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }

        return student;
    }
}
