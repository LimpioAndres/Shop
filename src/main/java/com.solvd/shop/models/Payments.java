package com.solvd.shop.models;

import java.sql.Date;

public class Payments {
    private Long id_payments;
    private Long idOrders;
    private Double amount_payments;
    private Date date_payments;

    public Payments(Long idOrders, Double amount_payments, Date date_payments) {
        this.idOrders = idOrders;
        this.amount_payments = amount_payments;
        this.date_payments = date_payments;
    }

    public Long getId_payments() {
        return id_payments;
    }

    public void setId_payments(Long id_payments) {
        this.id_payments = id_payments;
    }

    public Long getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(Long idOrders) {
        this.idOrders = idOrders;
    }

    public Double getAmount_payments() {
        return amount_payments;
    }

    public void setAmount_payments(Double amount_payments) {
        this.amount_payments = amount_payments;
    }

    public Date getDate_payments() {
        return date_payments;
    }

    public void setDate_payments(Date date_payments) {
        this.date_payments = date_payments;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "id_payments=" + id_payments +
                ", idOrders=" + idOrders +
                ", amount_payments='" + amount_payments + '\'' +
                ", date_payments='" + date_payments + '\'' +
                '}';
    }
}
