package com.galaxy.studentmanagement.model;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private int id;
    private String name;
    private int age;
    private String gender;
}
