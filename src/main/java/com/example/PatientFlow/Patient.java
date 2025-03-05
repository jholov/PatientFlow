package com.example.PatientFlow;

import java.time.LocalDate;
import java.time.Period;

public class Patient {

    private String name;
    private int age;
    private int id;
    private LocalDate dateOfBirth;

    public Patient(String name, int age, int id){
        this.name = name;
        this.age = age;
        this.id = id;
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
