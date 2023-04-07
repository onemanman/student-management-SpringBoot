package com.galaxy.studentmanagement.service;
import com.galaxy.studentmanagement.repository.*;
import com.galaxy.studentmanagement.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    public StudentRepository studentRepository ;

    //Showing list of all student
    @Override
    public List<Student> getStudentlist() {
        return studentRepository.getAll();
    }

    //Showing information of a student by id
    @Override
    public void showStudentById(int stt) {
        System.out.println(studentRepository.getByID(stt).toString());
    }

}




