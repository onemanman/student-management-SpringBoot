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

    @Override
    public List<Student> getStudentList() {
        return studentRepository.getAll();
    }

    @Override
    public Student getStudentById(int stt) {
        return studentRepository.getByID(stt);
    }
}




