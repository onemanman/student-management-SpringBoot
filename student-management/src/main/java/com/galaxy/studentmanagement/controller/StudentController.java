package com.galaxy.studentmanagement.controller;

import com.galaxy.studentmanagement.dto.StudentDTO;
import com.galaxy.studentmanagement.model.Student;
import com.galaxy.studentmanagement.model.StudentResponse;
import com.galaxy.studentmanagement.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping()
    public List<Student> getAllStudents(){
        List<Student> students = studentService.getStudentList();
        log.info("GET /students");
        return students;
    }

    @GetMapping(value = "/{stt}")
    public Student getStudentById(@PathVariable int stt){
        log.info("GET /student/{}",stt);
         return studentService.getStudentById(stt);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Student createStudent(@Valid @RequestBody StudentDTO studentDTO) throws ValidationException {
        log.info("POST /students {}",studentDTO);
        return studentService.createStudent(studentDTO);
    }

    @PutMapping("/{stt}")
    public Student updateStudent(@RequestBody Student student){

        log.info("PUT /students {}",student);
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public StudentResponse deleteStudent(@PathVariable int id) {
        log.info("Delete /students/{}",id);
        return studentService.deleteStudent(id);
    }

}
