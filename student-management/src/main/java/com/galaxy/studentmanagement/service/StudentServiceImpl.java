package com.galaxy.studentmanagement.service;
import com.galaxy.studentmanagement.dto.StudentDTO;
import com.galaxy.studentmanagement.exception.NotFoundException;
import com.galaxy.studentmanagement.model.StudentResponse;
import com.galaxy.studentmanagement.repository.*;
import com.galaxy.studentmanagement.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
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
    public Student createStudent(StudentDTO studentDTO) throws ValidationException {
        if (studentDTO.getName().isEmpty()){
            throw new ValidationException("Name field can't be empty");
        }
        if (studentDTO.getAge() < 7) {
            throw new ValidationException("Age must be greater than or equal to 7.");
        }
        if (!(studentDTO.getGender().equals("male") || studentDTO.getGender().equals("female") || studentDTO.getGender().equals("other"))){
            throw new ValidationException("Gender must be 'male', 'female' or 'other' ");
        }
        if (studentDTO.getMath() > 10 || studentDTO.getBiology() > 10 || studentDTO.getLiterature() > 10 ||
            studentDTO.getMath() < 0 || studentDTO.getBiology() < 0 || studentDTO.getLiterature() < 0){
            throw new ValidationException("Score value must be between 0 and 10.");
        }
        return studentRepository.save(Student.map(studentDTO));
    }

    @Override
    public Student updateStudent(Student student) {
        if (studentRepository.findById(student.stt).isEmpty()){
            throw new NotFoundException("Student not found with ID: " + student.stt);
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






