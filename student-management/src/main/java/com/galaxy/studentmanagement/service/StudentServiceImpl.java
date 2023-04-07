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

//    @PostConstruct
//    public void init() {
//        // code to initialize the bean
//        System.out.println("Bean initialization completed.");
//    }
//
//    @PreDestroy
//    public void destroy() {
//        // code to clean up the bean
//        System.out.println("Bean destruction completed.");
//    }


    @Override
    public List<Student> getStudentList() {
        return studentRepository.getAll();
    }

    @Override
    public Student getStudentById(int stt) {
        return studentRepository.getByID(stt);
    }
}




