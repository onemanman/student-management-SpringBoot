package com.galaxy.studentmanagement.service;
import com.galaxy.studentmanagement.dto.StudentDTO;
import com.galaxy.studentmanagement.model.Student;
import com.galaxy.studentmanagement.model.StudentResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface StudentService {
    List<Student> getStudentList();
    Student getStudentById(int stt);
    Student createStudent(StudentDTO studentDTO) throws ValidationException;
    Student updateStudent(Student student);
    StudentResponse deleteStudent(int id);

}
