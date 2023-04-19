package com.galaxy.studentmanagement.service;

import com.galaxy.studentmanagement.dto.StudentDTO;
import com.galaxy.studentmanagement.exception.NotFoundException;
import com.galaxy.studentmanagement.model.Student;
import com.galaxy.studentmanagement.model.StudentResponse;
import com.galaxy.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudentList() {
        return studentRepository.getAll();
    }

    @Override
    public Student getStudentById(int stt) {
        if (studentRepository.findById(stt) == null)
            throw new NotFoundException("Student not found with ID: " + stt);
        return studentRepository.findById(stt);
    }

    @Override
    public Student createStudent(StudentDTO studentDTO) {
        return studentRepository.create(studentDTO);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.update(student);
    }

    @Override
    public StudentResponse deleteStudent(int id) {
        if (studentRepository.findById(id) == null){
            throw new NotFoundException("Student not found with ID: " + id);
        }
        studentRepository.deleteById(id);
        return new StudentResponse("Delete student sucessfully!");
    }

}






