package com.galaxy.studentmanagement.controller;

import com.galaxy.studentmanagement.model.Student;
import com.galaxy.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students =  studentService.getStudentlist();
        return ResponseEntity.ok(students);
    }
}
