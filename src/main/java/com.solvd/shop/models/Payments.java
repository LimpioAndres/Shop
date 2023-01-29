package com.solvd.shop.models;

public class Payments {
    private String id_payments;
    private Long idOrders;
    private String amount_payments;
    private String date_payments;

    public String getId_payments() {
        return id_payments;
    }

    public void setId_payments(String id_payments) {
        this.id_payments = id_payments;
    }

    public Long getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(Long idOrders) {
        this.idOrders = idOrders;
    }

    public String getAmount_payments() {
        return amount_payments;
    }

    public void setAmount_payments(String amount_payments) {
        this.amount_payments = amount_payments;
    }

    public String getDate_payments() {
        return date_payments;
    }

    public void setDate_payments(String date_payments) {
        this.date_payments = date_payments;
    }
}
