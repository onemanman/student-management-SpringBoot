package com.galaxy.studentmanagement.model;

import com.galaxy.studentmanagement.dto.StudentDTO;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Student3")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stt")
    public int stt;
    @Column(name = "name")
    @NotEmpty
    public String name;
    @Column(name = "gender")
    @Pattern(regexp = "^(male|female|other)$")
    public String gender;

    @Column(name = "math")
    @Min(0)
    @Max(value = 10)
    public Double math;
    @Column(name = "biology")
    @Max(value = 10)
    @Min(0)
    public Double biology;
    @Column(name = "literature")
    @Max(value = 10)
    @Min(0)
    public Double literature;
    @Column(name = "age")
    @Min(value = 7)
    public int age;

    public static String dress = "Blue pants and white shirt";
    public static final byte maxAge = 30;


    @Override
    public String toString() {
        return  " stt : " + stt +
                ", name :'" + name + '\'' +
                ", age : " + age +
                ", gender : '" + gender + '\'' +
                ", math : " + math +
                ", biology : " + biology +
                ", literature : " + literature
                ;
    }

    public Student() {
    }

    public Student(String name, String gender, Double math, Double biology, Double literature, int age) {
        this.name = name;
        this.gender = gender;
        this.math = math;
        this.biology = biology;
        this.literature = literature;
        this.age = age;
    }

    public static void studyTime(){
        System.out.println("Study time start at 7:00AM in the morning and 13:00PM afternoon");
    }

    public static Student map(StudentDTO studentDTO){
        return new Student(studentDTO.name,studentDTO.gender,studentDTO.math,studentDTO.biology,studentDTO.literature,studentDTO.age);
    }
}

