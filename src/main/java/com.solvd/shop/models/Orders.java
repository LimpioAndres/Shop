package com.solvd.shop.models;

import java.sql.Date;

public class Orders {

    private Long idOrders;
    private Double amount_orders;
    private Date date_orders;
    private Long idClients;
    private Long idEmployees;
    private Long idDelivery;

    public Orders(Double amount_orders, Date date_orders, Long idClients, Long idEmployees, Long idDelivery) {
        this.amount_orders = amount_orders;
        this.date_orders = date_orders;
        this.idClients = idClients;
        this.idEmployees = idEmployees;
        this.idDelivery = idDelivery;
    }

    public Long getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(Long idOrders) {
        this.idOrders = idOrders;
    }

    public Double getAmount_orders() {
        return amount_orders;
    }

    public void setAmount_orders(Double amount_orders) {
        this.amount_orders = amount_orders;
    }

    public Date getDate_orders() {
        return date_orders;
    }

    public void setDate_orders(Date date_orders) {
        this.date_orders = date_orders;
    }

    public Long getIdClients() {
        return idClients;
    }

    public void setIdClients(Long idClients) {
        this.idClients = idClients;
    }

    public Long getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(Long idEmployees) {
        this.idEmployees = idEmployees;
    }

    public Long getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(Long idDelivery) {
        this.idDelivery = idDelivery;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "idOrders=" + idOrders +
                ", amount_orders=" + amount_orders +
                ", date_orders=" + date_orders +
                ", idClients=" + idClients +
                ", idEmployees=" + idEmployees +
                ", idDelivery=" + idDelivery +
                '}';
    }
}
