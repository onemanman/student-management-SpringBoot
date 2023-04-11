package com.galaxy.studentmanagement.service;
import com.galaxy.studentmanagement.exception.NotFoundException;
import com.galaxy.studentmanagement.repository.*;
import com.galaxy.studentmanagement.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    public StudentRepository studentRepository ;

    @Override
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int stt) {
        return studentRepository.findById(stt).orElseThrow(() -> new NotFoundException("Student not found with ID: " + stt));
    }
    @Override
    public void saveOrUpdateStudent(Student student) {
        studentRepository.save(student);
    }
    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}






