package com.galaxy.studentmanagement.repository;
import com.galaxy.studentmanagement.model.Student;
import java.util.List;

public interface StudentRepository {
    List<Student> getAll();
    Student getByID(int stt);

}
