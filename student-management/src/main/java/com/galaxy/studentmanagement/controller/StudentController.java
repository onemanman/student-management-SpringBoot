package com.galaxy.studentmanagement.controller;

import com.galaxy.studentmanagement.dto.StudentDTO;
import com.galaxy.studentmanagement.model.Student;
import com.galaxy.studentmanagement.model.StudentResponse;
import com.galaxy.studentmanagement.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page<Student> getAllStudents(@RequestParam(value = "page",defaultValue = "0") int page,
                                        @RequestParam(value = "size",defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> students = studentService.getStudentList(pageable);
        log.info("GET /students page={},size={}",page,size);
        return students;
    }

    @GetMapping("/name")
    public List<Student> getStudentByName(@RequestParam("name") String name){
        log.info("GET /students/ name={}", name);
        return studentService.getStudentByName(name);
    }

    @GetMapping("/age")
    public List<Student> getStudentByAge(@RequestParam("age") int age){
        log.info("GET /students/ age={}",age);
        return studentService.getStudentByAge(age);
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
    @PutMapping()
    public Student updateStudent(@Valid @RequestParam("stt") int stt,
                                 @Valid @RequestParam("math") double math,
                                 @Valid @RequestParam("biology") double biology,
                                 @Valid @RequestParam("literature") double literature ){
        Student student = studentService.getStudentById(stt);
        student.setMath(math);
        student.setBiology(biology);
        student.setLiterature(literature);
        log.info("PUT /students?Math={}andBiology={}andLiterature={}",math,biology,literature);
        return studentService.updateStudent(student);
    }
    @DeleteMapping("/{id}")
    public StudentResponse deleteStudent(@PathVariable int id) {
        log.info("Delete /students/{}",id);
        return studentService.deleteStudent(id);
    }

}
