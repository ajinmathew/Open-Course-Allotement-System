package com.cs.project.project;

public class Apply {
    String Name,DOB,Department,eMailid,Registerno,Gender,Stream,Total_Mark,Obtained_Mark,Disaster,Accounting,Mathematics,Web,Physics,Physical,Index_Mark,Allotement,Verify;

    public Apply() {
    }

    public Apply(String name, String DOB, String department, String eMailid, String registerno, String gender, String stream, String total_Mark, String obtained_Mark, String disaster, String accounting, String mathematics, String web, String physics, String physical, String index_Mark, String allotement, String verify) {
        Name = name;
        this.DOB = DOB;
        Department = department;
        this.eMailid = eMailid;
        Registerno = registerno;
        Gender = gender;
        Stream = stream;
        Total_Mark = total_Mark;
        Obtained_Mark = obtained_Mark;
        Disaster = disaster;
        Accounting = accounting;
        Mathematics = mathematics;
        Web = web;
        Physics = physics;
        Physical = physical;
        Index_Mark = index_Mark;
        Allotement = allotement;
        Verify = verify;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String geteMailid() {
        return eMailid;
    }

    public void seteMailid(String eMailid) {
        this.eMailid = eMailid;
    }

    public String getRegisterno() {
        return Registerno;
    }

    public void setRegisterno(String registerno) {
        Registerno = registerno;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getStream() {
        return Stream;
    }

    public void setStream(String stream) {
        Stream = stream;
    }

    public String getTotal_Mark() {
        return Total_Mark;
    }

    public void setTotal_Mark(String total_Mark) {
        Total_Mark = total_Mark;
    }

    public String getObtained_Mark() {
        return Obtained_Mark;
    }

    public void setObtained_Mark(String obtained_Mark) {
        Obtained_Mark = obtained_Mark;
    }

    public String getDisaster() {
        return Disaster;
    }

    public void setDisaster(String disaster) {
        Disaster = disaster;
    }

    public String getAccounting() {
        return Accounting;
    }

    public void setAccounting(String accounting) {
        Accounting = accounting;
    }

    public String getMathematics() {
        return Mathematics;
    }

    public void setMathematics(String mathematics) {
        Mathematics = mathematics;
    }

    public String getWeb() {
        return Web;
    }

    public void setWeb(String web) {
        Web = web;
    }

    public String getPhysics() {
        return Physics;
    }

    public void setPhysics(String physics) {
        Physics = physics;
    }

    public String getPhysical() {
        return Physical;
    }

    public void setPhysical(String physical) {
        Physical = physical;
    }

    public String getIndex_Mark() {
        return Index_Mark;
    }

    public void setIndex_Mark(String index_Mark) {
        Index_Mark = index_Mark;
    }

    public String getAllotement() {
        return Allotement;
    }

    public void setAllotement(String allotement) {
        Allotement = allotement;
    }

    public String getVerify() {
        return Verify;
    }

    public void setVerify(String verify) {
        Verify = verify;
    }
}
