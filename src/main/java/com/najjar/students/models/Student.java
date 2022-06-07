package com.najjar.students.models;


import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@ToString
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING,
        name = "Student_Type")
public class Student extends Admin{
    private String atmNumber;

    public Student(long id, String name, String email, LocalDate dod, String atm) {
        super(id, name, email, dod);
        this.atmNumber = atm;
    }

    public Student() {

    }

}