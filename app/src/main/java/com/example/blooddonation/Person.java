package com.example.blooddonation;

public class Person
{
    private String dName;
    private String dBloodGroup;
    private String dLocation;
    private String phone;

    public Person(String dName, String dBloodGroup, String dLocation, String phone) {
        this.dName = dName;
        this.dBloodGroup = dBloodGroup;
        this.dLocation = dLocation;
        this.phone = phone;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdBloodGroup() {
        return dBloodGroup;
    }

    public void setdBloodGroup(String dBloodGroup) {
        this.dBloodGroup = dBloodGroup;
    }

    public String getdLocation() {
        return dLocation;
    }

    public void setdLocation(String dLocation) {
        this.dLocation = dLocation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
