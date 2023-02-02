package com.solvd.shop.models;

import java.sql.Date;

public class Inventory {

    private Long idInvetory;
    private Double stock_inventory;
    private Date date_adquisition_inventory;

    public Inventory(Double stock_inventory, Date date_adquisition_inventory) {
        this.stock_inventory = stock_inventory;
        this.date_adquisition_inventory = date_adquisition_inventory;
    }

    public Long getIdInvetory() {
        return idInvetory;
    }

    public void setIdInvetory(Long idInvetory) {
        this.idInvetory = idInvetory;
    }

    public Double getStock_inventory() {
        return stock_inventory;
    }

    public void setStock_inventory(Double stock_inventory) {
        this.stock_inventory = stock_inventory;
    }

    public Date getDate_adquisition_inventory() {
        return date_adquisition_inventory;
    }

    public void setDate_adquisition_inventory(Date date_adquisition_inventory) {
        this.date_adquisition_inventory = date_adquisition_inventory;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "idInvetory=" + idInvetory +
                ", stock_inventory=" + stock_inventory +
                ", date_adquisition_inventory=" + date_adquisition_inventory +
                '}';
    }
}
