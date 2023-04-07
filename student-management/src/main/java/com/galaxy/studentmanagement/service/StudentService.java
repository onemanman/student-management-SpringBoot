package com.galaxy.studentmanagement.service;
import com.galaxy.studentmanagement.model.Student;
import java.util.List;
public interface StudentService {
    List<Student> getStudentlist();
    void showStudentById(int stt);

}
