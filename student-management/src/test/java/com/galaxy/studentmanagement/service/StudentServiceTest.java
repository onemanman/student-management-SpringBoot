package com.galaxy.studentmanagement.service;


import com.galaxy.studentmanagement.dto.StudentDTO;
import com.galaxy.studentmanagement.model.Student;
import com.galaxy.studentmanagement.model.StudentResponse;
import com.galaxy.studentmanagement.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
public class StudentServiceTest {
    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Test
    public void testGetAllStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Long","male",8.8,9.9,8.9,16));
        students.add(new Student(2,"Hoang","male",8.8,9.9,8.9,16));
        when(studentRepository.getAll()).thenReturn(students);

        List<Student> studentResult = studentService.getStudentList();

        assertEquals(studentResult,students);
    }@Test
    public void testGetStudentById() {
        int stt = 1;
        Student student = new Student(stt,"Long","male",8.8,9.9,8.9,16);
        when(studentRepository.findById(stt)).thenReturn(student);

        Student result = studentService.getStudentById(stt);

        assertEquals(result,student);
    }

    @Test
    public void testCreateStudent() {
        StudentDTO studentDTO = new StudentDTO("Long","male",8.2,8.9,9.9,16);
        Student student = new Student(1,"Long","male",8.2,8.9,9.9,16);
        when(studentRepository.create(studentDTO)).thenReturn(student);

        Student studentCreateResult = studentRepository.create(studentDTO);

        assertEquals(studentCreateResult,student);
    }
    @Test
    public void testUpdateStudent(){
        Student student = new Student(1,"Long","male",8.2,8.9,9.9,16);
        when(studentRepository.update(student)).thenReturn(student);

        Student studentUpdateResult = studentRepository.update(student);

        assertEquals(studentUpdateResult,student);
    }

    @Test
    public void testDeleteStudent(){
        int stt = 1;
        Student student = new Student(1,"Long","male",8.2,8.9,9.9,16);
        when(studentRepository.findById(stt)).thenReturn(student);

        StudentResponse studentResponse = studentService.deleteStudent(stt);

        verify(studentRepository,times(1)).deleteById(stt);
        assertEquals("Delete student successfully!",studentResponse.getDeleteMessage());
    }
}
