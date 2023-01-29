package com.solvd.shop.models;

public class Employees {

    private Long idEmployees;
    private String name_employees;
    private String last_name_employees;
    private Integer age_employees;
    private String phone_employees;
    private String email_employees;
    private Double salary_employees;
    private Long idOffices;

    public Long getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(Long idEmployees) {
        this.idEmployees = idEmployees;
    }

    public String getName_employees() {
        return name_employees;
    }

    public void setName_employees(String name_employees) {
        this.name_employees = name_employees;
    }

    public String getLast_name_employees() {
        return last_name_employees;
    }

    public void setLast_name_employees(String last_name_employees) {
        this.last_name_employees = last_name_employees;
    }

    public Integer getAge_employees() {
        return age_employees;
    }

    public void setAge_employees(Integer age_employees) {
        this.age_employees = age_employees;
    }

    public String getPhone_employees() {
        return phone_employees;
    }

    public void setPhone_employees(String phone_employees) {
        this.phone_employees = phone_employees;
    }

    public String getEmail_employees() {
        return email_employees;
    }

    public void setEmail_employees(String email_employees) {
        this.email_employees = email_employees;
    }

    public Double getSalary_employees() {
        return salary_employees;
    }

    public void setSalary_employees(Double salary_employees) {
        this.salary_employees = salary_employees;
    }

    public Long getIdOffices() {
        return idOffices;
    }

    public void setIdOffices(Long idOffices) {
        this.idOffices = idOffices;
    }
}
