package com.solvd.shop.models;

import java.sql.Date;

public class Delivery_shippers {

    private Long idDelivery;
    private Long idShippers;
    private Date date_creation;

    public Delivery_shippers(Long idShippers, Date date_creation) {
        this.idShippers = idShippers;
        this.date_creation = date_creation;
    }

    public Long getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(Long idDelivery) {
        this.idDelivery = idDelivery;
    }

    public Long getIdShippers() {
        return idShippers;
    }

    public void setIdShippers(Long idShippers) {
        this.idShippers = idShippers;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    @Override
    public String toString() {
        return "Delivery_shippers{" +
                "idDelivery=" + idDelivery +
                ", idShippers=" + idShippers +
                ", date_creation=" + date_creation +
                '}';
    }
}
