package com.galaxy.studentmanagement.model;

import java.io.Serializable;

public class Student {
    public int stt;
    public String name;
    public int age;
    public String gender;
    public Double math;
    public Double biology;
    public Double literature;

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


    public Student(int stt, String name, int age, String gender){
        this.stt = stt;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public Student(int stt, String name, int age, String gender, Double math){
        this.stt = stt;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.math = math;
    }
    public Student(int stt, String name, int age, String gender, Double math, Double biology){
        this.stt = stt;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.math = math;
        this.biology = biology;
    }
    public Student(int stt, String name, int age, String gender, Double math, Double biology, Double literature){
        this.stt = stt;
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


    public int getStt(){
        return stt;
    }
    public void setStt(int stt){
        this.stt = stt;
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

