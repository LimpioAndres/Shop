package com.solvd.shop.models;

import java.util.Date;

public class Delivery {

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
}
