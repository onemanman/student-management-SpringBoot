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
import java.util.HashMap;
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
        log.info("GET /students page={},size={}");
        System.out.println(students);
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
        System.out.println(studentDTO.toString());
        return studentService.createStudent(studentDTO);
    }
//
//    @PutMapping("/{stt}")
//    public Student updateStudent(@PathVariable int stt,
//                                                 @RequestParam(value = "math",required = false) Double math,
//                                                 @RequestParam(value = "biology",required = false) Double biology,
//                                                 @RequestParam(value = "literature",required = false) Double literature){
//        Student student = studentService.getStudentById(stt);
//        HashMap<String, Double> updateMap = new HashMap<>();
//        updateMap.put("math",math);
//        updateMap.put("biology",biology);
//        updateMap.put("literature",literature);
////        log.info("PUT /students?math={}&biology={}&literature={}",updateMap.get("math"),updateMap.get("biology"),updateMap.get("literature"));
//        return studentService.updateStudent(stt,updateMap);
//    }
//
    @DeleteMapping("/{id}")
    public StudentResponse deleteStudent(@PathVariable int id) {
        log.info("Delete /students/{}",id);
        return studentService.deleteStudent(id);
    }

}
