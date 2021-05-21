package com.website.prostudy.models;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class People {




private int id;

@NotEmpty(message = "Not be empty")
@Size(min = 2, max = 30, message =  "Out of range")
private String name;

@NotEmpty(message = "Not be empty")
@Email
private String email;


    public People()
    {

    }

    public People(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
