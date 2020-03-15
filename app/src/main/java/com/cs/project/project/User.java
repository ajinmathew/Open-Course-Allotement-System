package com.cs.project.project;

public class User {
    String name,dob,department,emailid,password,registerno;

    public User() {
    }

    public User(String name, String dob, String department, String emailid, String password, String registerno) {
        this.name = name;
        this.dob = dob;
        this.department = department;
        this.emailid = emailid;
        this.password = password;
        this.registerno = registerno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisterno() {
        return registerno;
    }

    public void setRegisterno(String registerno) {
        this.registerno = registerno;
    }
}
