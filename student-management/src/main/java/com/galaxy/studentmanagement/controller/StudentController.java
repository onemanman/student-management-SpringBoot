package com.galaxy.studentmanagement.controller;

import com.galaxy.studentmanagement.model.Student;
import com.galaxy.studentmanagement.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
@Api(value="demo", description="Api description")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @ApiOperation(value = "Get all demo items", response = List.class)
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getStudentList();

    }
    @ApiOperation(value = "Get student by ID", response = Student.class)
    @GetMapping("/{stt}")
    public Student getStudentById(@PathVariable int stt){
         return studentService.getStudentById(stt);
    }

}
