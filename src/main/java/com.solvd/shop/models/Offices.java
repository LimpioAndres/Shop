package com.solvd.shop.models;

public class Offices {

    private Long idOffices;
    private String name_offices;
    private String department;

    private String manager;

    public Offices(String name_offices, String department, String manager) {
        this.name_offices = name_offices;
        this.department = department;
        this.manager = manager;
    }

    public Long getIdOffices() {
        return idOffices;
    }

    public void setIdOffices(Long idOffices) {
        this.idOffices = idOffices;
    }

    public String getName_offices() {
        return name_offices;
    }

    public void setName_offices(String name_offices) {
        this.name_offices = name_offices;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Offices{" +
                "idOffices=" + idOffices +
                ", name_offices='" + name_offices + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
