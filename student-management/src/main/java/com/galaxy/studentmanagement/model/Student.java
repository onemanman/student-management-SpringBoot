package com.galaxy.studentmanagement.model;

import com.galaxy.studentmanagement.dto.StudentDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "Student3")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stt")
    public int stt;
    @Column(name = "name")
    public String name;
    @Column(name = "gender")
    public String gender;
    @Column(name = "math")
    @Min(value = 0,message = "Math score is between 0 to 10")
    @Max(value = 10,message = "Math score is between 0 to 10")
    public Double math;
    @Column(name = "biology")
    @Min(value = 0,message = "Biology score is between 0 to 10")
    @Max(value = 10,message = "Biology score is between 0 to 10")
    public Double biology;
    @Column(name = "literature")
    @Max(value = 10,message = "Literature score is between 0 to 10")
    @Min(value = 0,message = "Literature score is between 0 to 10")
    public Double literature;
    @Column(name = "age")
    public int age;

    public static String dress = "Blue pants and white shirt";
    public static final byte maxAge = 30;

    public Student(String name, String gender, Double math, Double biology, Double literature, int age) {
        this.name = name;
        this.gender = gender;
        this.math = math;
        this.biology = biology;
        this.literature = literature;
        this.age = age;
    }

    public Student(Double math,Double biology,Double literature){
        this.math = math;
        this.biology = biology;
        this.literature = literature;
    }

    public static void studyTime(){
        System.out.println("Study time start at 7:00AM in the morning and 13:00PM afternoon");
    }

    public static Student map(StudentDTO studentDTO){
        return new Student(studentDTO.name,studentDTO.gender,studentDTO.math,studentDTO.biology,studentDTO.literature,studentDTO.age);
    }


}

