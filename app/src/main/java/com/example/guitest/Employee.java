package com.example.guitest;

import com.google.gson.annotations.Expose;

public class Employee {

    public Employee() {
    }

    @Expose
    private String id;
    @Expose
    private String profile_image;
    @Expose
    private String employee_name;
    @Expose
    private String employee_salery;
    @Expose
    private String employee_age;

    public void setId(String id) {
        this.id = id;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public void setEmployee_salery(String employee_salery) {
        this.employee_salery = employee_salery;
    }

    public void setEmployee_age(String employee_age) {
        this.employee_age = employee_age;
    }

    public String getId() {
        return id;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public String getEmployee_salery() {
        return employee_salery;
    }

    public String getEmployee_age() {
        return employee_age;
    }
}
