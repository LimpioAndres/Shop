package com.solvd.shop.models;

import java.sql.Date;

public class Delivery {

    public Delivery(String id_tracker_delivery, Date date_registered) {
        this.id_tracker_delivery = id_tracker_delivery;
        this.date_registered = date_registered;
    }

    private Long idDelivery;
    private String id_tracker_delivery;
    private Date date_registered;

    public Long getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(Long idDelivery) {
        this.idDelivery = idDelivery;
    }

    public String getId_tracker_delivery() {
        return id_tracker_delivery;
    }

    public void setId_tracker_delivery(String id_tracker_delivery) {
        this.id_tracker_delivery = id_tracker_delivery;
    }

    public Date getDate_registered() {
        return date_registered;
    }

    public void setDate_registered(Date date_registered) {
        this.date_registered = date_registered;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "idDelivery=" + idDelivery +
                ", id_tracker_delivery='" + id_tracker_delivery + '\'' +
                ", date_registered=" + date_registered +
                '}';
    }
}
