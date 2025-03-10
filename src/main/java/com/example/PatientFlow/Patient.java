package com.example.PatientFlow;

import java.time.LocalDate;
import java.time.Period;
import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.relational.core.mapping.Table;


import javax.annotation.processing.Generated;
@Table("patients")
public class Patient {

    @Id
    @JsonIgnore
    private int id;
    private String name;
    private int age;
    private LocalDate dateOfBirth;

    public Patient(){

    }

    public Patient(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId(){
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }


}
