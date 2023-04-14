package com.galaxy.studentmanagement.dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentScoreDTO {
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

    public static String dress = "Blue pants and white shirt";
    public static final byte maxAge = 30;

    public static void studyTime(){
        System.out.println("Study time start at 7:00AM in the morning and 13:00PM afternoon");
    }

}

