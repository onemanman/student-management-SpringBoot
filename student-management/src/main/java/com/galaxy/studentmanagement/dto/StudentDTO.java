package com.galaxy.studentmanagement.dto;

public class StudentDTO {

    public String name;
    public String gender;
    public Double math;
    public Double biology;
    public Double literature;
    public int age;
    public static String dress = "Blue pants and white shirt";
    public static final byte maxAge = 30;

    public StudentDTO() {
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", math=" + math +
                ", biology=" + biology +
                ", literature=" + literature +
                ", age=" + age +
                '}';
    }

    public StudentDTO(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public StudentDTO(String name, int age, String gender, Double math){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.math = math;
    }
    public StudentDTO(String name, int age, String gender, Double math, Double biology){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.math = math;
        this.biology = biology;
    }
    public StudentDTO(String name, int age, String gender, Double math, Double biology, Double literature){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.math = math;
        this.biology = biology;
        this.literature = literature;
    }


    public static void studyTime(){
        System.out.println("Study time start at 7:00AM in the morning and 13:00PM afternoon");
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public Double getMath(){
        return math;
    }
    public void setMath(Double math){
        this.math = math;
    }
    public Double getBiology(){
        return biology;
    }
    public void setBiology(Double biology){
        this.biology = biology;
    }
    public Double getLiterature(){
        return literature;
    }
    public void setLiterature(Double literature){
        this.literature = literature;
    }
}

