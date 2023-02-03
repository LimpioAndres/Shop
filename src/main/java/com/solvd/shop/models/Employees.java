package com.solvd.shop.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

@XmlRootElement (name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {

    @JsonProperty("idEmployees")
    @XmlAttribute (name = "idEmployees")
    private Long idEmployees;

    @JsonProperty ("name_employees")
    @XmlElement (name = "name_employees")
    private String name_employees;

    @JsonProperty ("last_name_employees")
    @XmlElement (name = "last_name_employees")
    private String last_name_employees;

    @JsonProperty ("age_employees")
    @XmlElement (name = "age_employees")
    private Integer age_employees;

    @JsonProperty ("phone_employees")
    @XmlElement (name = "phone_employees")
    private String phone_employees;

    @JsonProperty ("email_employees")
    @XmlElement (name = "email_employees")
    private String email_employees;

    @JsonProperty ("salary_employees")
    @XmlElement (name = "salary_employees")
    private Double salary_employees;

    @JsonProperty ("idOffices")
    @XmlElement (name = "idOffices")
    private Long idOffices;


    public Employees( String name_employees, String last_name_employees, Integer age_employees, String phone_employees, String email_employees, Double salary_employees, Long idOffices) {
        this.name_employees = name_employees;
        this.last_name_employees = last_name_employees;
        this.age_employees = age_employees;
        this.phone_employees = phone_employees;
        this.email_employees = email_employees;
        this.salary_employees = salary_employees;
        this.idOffices = idOffices;
    }

    public Employees(Long idEmployees, String name_employees, String last_name_employees, Integer age_employees, String phone_employees, String email_employees, Double salary_employees, Long idOffices) {
        this.idEmployees = idEmployees;
        this.name_employees = name_employees;
        this.last_name_employees = last_name_employees;
        this.age_employees = age_employees;
        this.phone_employees = phone_employees;
        this.email_employees = email_employees;
        this.salary_employees = salary_employees;
        this.idOffices = idOffices;
    }

    public Employees() {
    }

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

    @Override
    public String toString() {
        return "Employees{" +
                "idEmployees=" + idEmployees +
                ", name_employees='" + name_employees + '\'' +
                ", last_name_employees='" + last_name_employees + '\'' +
                ", age_employees=" + age_employees +
                ", phone_employees='" + phone_employees + '\'' +
                ", email_employees='" + email_employees + '\'' +
                ", salary_employees=" + salary_employees +
                ", idOffices=" + idOffices +
                '}';
    }
}
