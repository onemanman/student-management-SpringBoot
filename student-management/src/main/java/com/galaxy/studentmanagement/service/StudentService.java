package com.galaxy.studentmanagement.service;
import com.galaxy.studentmanagement.dto.StudentDTO;
import com.galaxy.studentmanagement.model.Student;
import com.galaxy.studentmanagement.model.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.xml.bind.ValidationException;
import java.util.List;
public interface StudentService {
    Page<Student> getStudentList(Pageable pageable);

    Student getStudentById(int stt);
    Student createStudent(StudentDTO student) throws ValidationException;
    Student updateStudent(Student student);
    StudentResponse deleteStudent(int id);
    List<Student> getStudentByName(String name);
    List<Student> getStudentByAge(int age);
}
