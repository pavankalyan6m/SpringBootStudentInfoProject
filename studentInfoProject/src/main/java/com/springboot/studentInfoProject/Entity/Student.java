package com.springboot.studentInfoProject.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Entity
@Data
@Table(name = "student_details")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long student_id;
    @Column(nullable = false)
    private String student_name;
    private int student_age;

    public int getStudent_age() {
        return student_age;
    }

    public long getStudent_id() {
        return student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setStudent_age(int student_age) {
        this.student_age = student_age;
    }

}
