package com.solvd.shop.models;

public class Detail_orders {

    private Long idDetail_orders;
    private Long idOrders;
    private Long idProducts;

    public Detail_orders(Long idOrders, Long idProducts) {
        this.idOrders = idOrders;
        this.idProducts = idProducts;
    }

    public Long getIdDetail_orders() {
        return idDetail_orders;
    }

    public void setIdDetail_orders(Long idDetail_orders) {
        this.idDetail_orders = idDetail_orders;
    }

    public Long getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(Long idOrders) {
        this.idOrders = idOrders;
    }

    public Long getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(Long idProducts) {
        this.idProducts = idProducts;
    }

    @Override
    public String toString() {
        return "Detail_orders{" +
                "idDetail_orders=" + idDetail_orders +
                ", idOrders=" + idOrders +
                ", idProducts=" + idProducts +
                '}';
    }
}
