package com.galaxy.studentmanagement.controller;
import com.galaxy.studentmanagement.model.Student;
import com.galaxy.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getStudentList();
        return ResponseEntity.ok(students);
    }
    @GetMapping("/{stt}")
    public ResponseEntity<Student> getStudentById(@PathVariable int stt){
        Student student = studentService.getStudentById(stt);
        return ResponseEntity.ok(student);
    }
}

