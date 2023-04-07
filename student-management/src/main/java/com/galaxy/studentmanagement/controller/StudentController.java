package com.galaxy.studentmanagement.controller;

import com.galaxy.studentmanagement.model.Student;
import com.galaxy.studentmanagement.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getStudentList();

    }
    @GetMapping("/{stt}")
    public Student getStudentById(@PathVariable int stt){
         return studentService.getStudentById(stt);
    }

}
