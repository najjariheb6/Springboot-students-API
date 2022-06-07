package com.najjar.students.models;

import lombok.ToString;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity

@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING,
        name = "Instructor_Type")
public class Instructor extends Admin {
    private String credentials;


    public Instructor(Long id, String name, String email, LocalDate dob, String credentials) {
        super(id, name, email, dob);
        this.credentials = credentials;
    }

    public Instructor() {

    }
    @Override
    public String toString(){
        return super.toString()+ credentials;
    }
}