package com.solvd.shop.models;



public class Clients{

    private Long idClients;
    private String name_clients;
    private String last_name_clients;
    private Integer age_clients;
    private String phone_clients;
    private String email_clients;

    public Long getIdClients() {
        return idClients;
    }

    public void setIdClients(Long idClients) {
        this.idClients = idClients;
    }

    public String getName_clients() {
        return name_clients;
    }

    public void setName_clients(String name_clients) {
        this.name_clients = name_clients;
    }

    public String getLast_name_clients() {
        return last_name_clients;
    }

    public void setLast_name_clients(String last_name_clients) {
        this.last_name_clients = last_name_clients;
    }

    public Integer getAge_clients() {
        return age_clients;
    }

    public void setAge_clients(Integer age_clients) {
        this.age_clients = age_clients;
    }

    public String getPhone_clients() {
        return phone_clients;
    }

    public void setPhone_clients(String phone_clients) {
        this.phone_clients = phone_clients;
    }

    public String getEmail_clients() {
        return email_clients;
    }

    public void setEmail_clients(String email_clients) {
        this.email_clients = email_clients;
    }
}
