package com.galaxy.studentmanagement.repository;

import com.galaxy.studentmanagement.dto.StudentDTO;
import com.galaxy.studentmanagement.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAll();
    Student findById(int stt);
    Student create(StudentDTO studentDTO);
    Student update(Student student);
    void deleteById(int stt);

}