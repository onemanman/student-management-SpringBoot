package com.galaxy.studentmanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galaxy.studentmanagement.dto.StudentDTO;
import com.galaxy.studentmanagement.model.Student;
import com.galaxy.studentmanagement.model.StudentResponse;
import com.galaxy.studentmanagement.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.JSON.json;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    StudentService studentService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testGetAllStudents() throws Exception {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Long","male",8.9,8.1,8.2,15));
        students.add(new Student(2,"Hoang","male",8.6,8.5,8.2,15));

        when(studentService.getStudentList()).thenReturn(students);
        mockMvc.perform(get("/students")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(status().isOk())
                        .andExpect(content().json(new ObjectMapper().writeValueAsString(students)));
    }

    @Test
    public void testGetStudentById() throws Exception {
        int stt = 1;
        Student student = new Student(stt, "Long", "male", 8.9, 8.1, 8.2, 15);

        when(studentService.getStudentById(stt)).thenReturn(student);

        mockMvc.perform(get("/students/{stt}", stt)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(status().isOk())
                        .andExpect(content().json(new ObjectMapper().writeValueAsString(student)));
    }
    @Test
    public void testCreateStudent() throws Exception {
        StudentDTO studentDTO = new StudentDTO("Long", "male", 8.9, 8.1, 8.2, 15);
        Student student = new Student(1, "Long", "male", 8.9, 8.1, 8.2, 15);

        when(studentService.createStudent(studentDTO)).thenReturn(student);
        System.out.println(student);
        System.out.println(json(new ObjectMapper().writeValueAsString(student)));
        mockMvc.perform(post("/students")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .characterEncoding("UTF-8")
                        .content(new ObjectMapper().writeValueAsString(studentDTO)))
                        .andExpect(status().isCreated())
                        .andExpect(content().json(new ObjectMapper().writeValueAsString(student)));

    }
    @Test
    public void testUpdateStudent() throws Exception {
        Student student = new Student(1, "Long", "male", 8.9, 8.1, 8.2, 15);

        when(studentService.updateStudent(student)).thenReturn(student);

        mockMvc.perform(put("/students/{stt}", student.getStt())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .characterEncoding("UTF-8")
                        .content(new ObjectMapper().writeValueAsString(student)))
                        .andExpect(status().isOk())
                        .andExpect(content().json(new ObjectMapper().writeValueAsString(student)));
    }
    @Test
    public void testDeleteStudent() throws Exception {
        int id = 1;
        StudentResponse studentResponse = new StudentResponse("Student with id " + id + " has been deleted.");

        when(studentService.deleteStudent(id)).thenReturn(studentResponse);

        mockMvc.perform(delete("/students/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(status().isOk())
                        .andExpect(content().json(new ObjectMapper().writeValueAsString(studentResponse)));
    }

}