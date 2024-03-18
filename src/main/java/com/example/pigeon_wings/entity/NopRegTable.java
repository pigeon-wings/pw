package com.example.pigeon_wings.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class NopRegTable {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getDynamicEmail() {
        return dynamicEmail;
    }

    public void setDynamicEmail(String dynamicEmail) {
        this.dynamicEmail = dynamicEmail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    Date dob;
    @Column(name="dynamicEmail")
    String dynamicEmail;
    @Column(name="companyName")
    String companyName;
    String status;
    String password;
    String message;

}
