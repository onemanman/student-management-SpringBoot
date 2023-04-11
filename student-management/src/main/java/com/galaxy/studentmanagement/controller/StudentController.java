package com.galaxy.studentmanagement.controller;

import com.galaxy.studentmanagement.model.Student;
import com.galaxy.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getAllStudents(){
        return studentService.getStudentList();

    }
    @GetMapping("/{stt}")
    public Student getStudentById(@PathVariable int stt){
        System.out.println();
         return studentService.getStudentById(stt);
    }
    @PostMapping
    public void saveOrUpdateStudent(@RequestBody Student student) {
        studentService.saveOrUpdateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
}
