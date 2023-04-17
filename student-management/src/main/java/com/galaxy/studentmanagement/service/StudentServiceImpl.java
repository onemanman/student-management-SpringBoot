package com.galaxy.studentmanagement.service;
import com.galaxy.studentmanagement.dto.StudentDTO;
import com.galaxy.studentmanagement.exception.NotFoundException;
import com.galaxy.studentmanagement.model.StudentResponse;
import com.galaxy.studentmanagement.repository.*;
import com.galaxy.studentmanagement.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.HashMap;
import java.util.List;



@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    public StudentRepository studentRepository ;

    @Override
    public Page<Student> getStudentList(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }


    @Override
    public Student getStudentById(int stt) {
        return studentRepository.findById(stt).orElseThrow(() -> new NotFoundException("Student not found with ID: " + stt));
    }

    @Override
    public Student createStudent(StudentDTO studentDTO) throws ValidationException {
        return studentRepository.save(Student.map(studentDTO));
    }

    @Override
    public Student updateStudent(int stt, HashMap<String, Double> updateMap) {
        Student student = studentRepository.findById(stt).orElseThrow(() -> new NotFoundException("Student not found with ID: " + stt));
        if (updateMap.containsKey("math")) {
            student.setMath(updateMap.get("math"));
        }
        if (updateMap.containsKey("biology")) {
            student.setBiology(updateMap.get("biology"));
        }
        if (updateMap.containsKey("literature")) {
            student.setLiterature(updateMap.get("literature"));
        }
        return studentRepository.save(student);
    }

    @Override
    public StudentResponse deleteStudent(int id) {
        if (studentRepository.findById(id).isEmpty()){
            throw new NotFoundException("Student not found with ID: " + id);
        }
        studentRepository.deleteById(id);
        return new StudentResponse("Delete student sucessfully!");
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public List<Student> getStudentByAge(int age) {
        return studentRepository.findByAge(age);
    }
}






