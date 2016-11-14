package com.rajatgoyal.hw4_studentlist.model;

import java.util.ArrayList;

/**
 * Created by rajat goyal on 9/2/2016.
 */

//public class Student {
//
//    int age;
//    int rollNo;
//    String name;
//    String address;
//
//    public Student(int age, int rollNo, String name, String address) {
//        this.age = age;
//        this.rollNo = rollNo;
//        this.name = name;
//        this.address = address;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public int getRollNo() {
//        return rollNo;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setRollNo(int rollNo) {
//        this.rollNo = rollNo;
//    }
//
//    @Override
//    public String toString() {
//        return "Name: " + name + "\n" + "Age: " + age + "\n";
//    }
//
//    public static ArrayList<Student> getStudents(){
//        ArrayList<Student> students = new ArrayList<>();
//
//        String[] randomNames= {"Ram","Shyam","Madhav"};
//        String[] randomAddr = {"Pitampura","Rohini","Faridabad"};
//        String[] randomFatherNames = {"Mohan","Sohan","Rohan"};
//
//        for(int i=1;i<=200;i++){
//            students.add(new Student(10+i%5,i,randomNames[i%3],randomAddr[i%3]));
//        }
//
//        return students;
//    }
//}



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

    public static ArrayList<Student> getStudents() {
        ArrayList students = new ArrayList<Student>();
        for(int i=1;i<=5;i++) {
            students.add(new Student(i,stuAddress[i%4],stuName[i%4],stuFatherName[i%4],stuEmail[i%4],stuCourse[i%4],stuContact[i%4]));
        }
        return students;
    }
}
