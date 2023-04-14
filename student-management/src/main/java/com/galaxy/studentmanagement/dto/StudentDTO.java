package com.galaxy.studentmanagement.dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDTO {
    @Column(name = "name")
    @NotEmpty(message = "Name field can't be empty")
    public String name;
    @Column(name = "gender")
    @Pattern(regexp = "^(male|female|other)$", message = "Gender must be 'male','female' or 'other'")
    @NotEmpty(message = "Gender field can't be empty")
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
    @Min(value = 7, message = "Age must be greater than or equal to 7")
    public int age;
    public static String dress = "Blue pants and white shirt";
    public static final byte maxAge = 30;

    public static void studyTime(){
        System.out.println("Study time start at 7:00AM in the morning and 13:00PM afternoon");
    }

}

