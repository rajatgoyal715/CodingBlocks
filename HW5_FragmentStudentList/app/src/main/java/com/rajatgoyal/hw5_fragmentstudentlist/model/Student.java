package com.rajatgoyal.hw5_fragmentstudentlist.model;

import java.util.ArrayList;

/**
 * Created by rajat goyal on 9/4/2016.
 */

public class Student {
    int id;
    String name;
    String fatherName;
    String contact;
    String email;
    String address;
    String course;

    static String[] stuAddress = {"Pitampura","Rithala","Faridabad","Kohat"};
    static String[] stuName = {"Rohan","Sohan","Mohan","Rahul"};
    static String[] stuFatherName = {"Rakesh","Sarvesh","Mahesh","Ramesh"};
    static String[] stuContact = {"9810733729","9899086497","9898473883","8860625624"};
    static String[] stuEmail = {"rohan@gmail.com","sohan@gmail.com","mohan@gmail.com","rahul@gmail.com"};
    static String[] stuCourse = {"Android","Web Development","Java","C++"};

    public Student(int id,String address, String name, String fatherName, String email, String course, String contact) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.fatherName = fatherName;
        this.email = email;
        this.course = course;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static ArrayList<Student> getListItems(int count){
        ArrayList students = new ArrayList<Student>();
        for(int i=1;i<=count;i++){
            students.add(new Student(i,stuAddress[i%4],stuName[i%4],stuFatherName[i%4],stuEmail[i%4],stuCourse[i%4],stuContact[i%4]));
        }
        return students;
    }
}
