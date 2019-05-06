/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sumit
 */
@Entity
@Table(name="student_table")
public class Student implements Serializable  {
    private static final long serialVersionUID=1L;
    @Id // primary key
    @GeneratedValue(strategy= GenerationType.AUTO) //auto generate and auto increment gaarne 
    @Column(name ="student_id")
    private int id;
    @Column(name ="student_name")
    private String name ;
    @Column(name ="Address")
    private String address;
    @Column(name ="phone")
    private long phone;
    @Column(name ="Gender")
    private String gender;
    @Column(name ="Semester")
    private String semester;
    
//    @Transient
//    private int age; // transient fields are not presistped to databse yo vaneko chai yeha matra basxa not in databse

    public Student() {
    }
    public Student(int id, String name, String address, long phone, String gender, String semester) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.semester = semester;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", gender=" + gender + ", semester=" + semester + '}';
    }
    


}
