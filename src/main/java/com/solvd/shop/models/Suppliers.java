package com.solvd.shop.models;

public class Suppliers {

    private Long idSuppliers;
    private String company_name_suppliers;
    private String email_suppliers;
    private String phone_suppliers;
    private String contact_suppliers;

    public Suppliers(String company_name_suppliers, String email_suppliers, String phone_suppliers, String contact_suppliers) {
        this.company_name_suppliers = company_name_suppliers;
        this.email_suppliers = email_suppliers;
        this.phone_suppliers = phone_suppliers;
        this.contact_suppliers = contact_suppliers;
    }

    public Long getIdSuppliers() {
        return idSuppliers;
    }

    public void setIdSuppliers(Long idSuppliers) {
        this.idSuppliers = idSuppliers;
    }

    public String getCompany_name_suppliers() {
        return company_name_suppliers;
    }

    public void setCompany_name_suppliers(String company_name_suppliers) {
        this.company_name_suppliers = company_name_suppliers;
    }

    public String getEmail_suppliers() {
        return email_suppliers;
    }

    public void setEmail_suppliers(String email_suppliers) {
        this.email_suppliers = email_suppliers;
    }

    public String getPhone_suppliers() {
        return phone_suppliers;
    }

    public void setPhone_suppliers(String phone_suppliers) {
        this.phone_suppliers = phone_suppliers;
    }

    public String getContact_suppliers() {
        return contact_suppliers;
    }

    public void setContact_suppliers(String contact_suppliers) {
        this.contact_suppliers = contact_suppliers;
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "idSuppliers=" + idSuppliers +
                ", company_name_suppliers='" + company_name_suppliers + '\'' +
                ", email_suppliers='" + email_suppliers + '\'' +
                ", phone_suppliers='" + phone_suppliers + '\'' +
                ", contact_suppliers='" + contact_suppliers + '\'' +
                '}';
    }
}
