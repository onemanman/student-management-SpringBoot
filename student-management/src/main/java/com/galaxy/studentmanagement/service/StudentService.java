package com.galaxy.studentmanagement.service;
import com.galaxy.studentmanagement.model.Student;
import java.util.List;
public interface StudentService {
    List<Student> getStudentList();
    Student getStudentById(int stt);
    void saveOrUpdateStudent(Student student);
    void deleteStudent(int id) ;
}
