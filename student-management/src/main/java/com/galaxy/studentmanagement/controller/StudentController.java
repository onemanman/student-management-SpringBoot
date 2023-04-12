package com.galaxy.studentmanagement.controller;

import com.galaxy.studentmanagement.dto.StudentDTO;
import com.galaxy.studentmanagement.model.Student;
import com.galaxy.studentmanagement.model.StudentResponse;
import com.galaxy.studentmanagement.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping()
    public List<Student> getAllStudents(){
        return studentService.getStudentList();

    }

    @GetMapping("/name")
    public List<Student> getStudentByName(@RequestParam("name") String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping("/age")
    public List<Student> getStudentByAge(@RequestParam("age") int age){
        return studentService.getStudentByAge(age);
    }

    @GetMapping(value = "/{stt}")
    public Student getStudentById(@PathVariable int stt){
         return studentService.getStudentById(stt);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Student createStudent(@Valid @RequestBody StudentDTO studentDTO) throws ValidationException {
        return studentService.createStudent(studentDTO);
    }
    @PutMapping()
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }
    @DeleteMapping("/{id}")
    public StudentResponse deleteStudent(@PathVariable int id) {
       return studentService.deleteStudent(id);
    }

}
