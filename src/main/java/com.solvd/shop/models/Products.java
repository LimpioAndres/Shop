package com.solvd.shop.models;

public class Products {

    private Long idProducts;
    private String name_products;
    private Integer quantity_products;
    private Double price_sell_products;
    private Double price_buy_products;
    private Long idSuppliers;
    private Long idCategories;
    private Long idInventory;

    public Long getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(Long idProducts) {
        this.idProducts = idProducts;
    }

    public String getName_products() {
        return name_products;
    }

    public void setName_products(String name_products) {
        this.name_products = name_products;
    }

    public Integer getQuantity_products() {
        return quantity_products;
    }

    public void setQuantity_products(Integer quantity_products) {
        this.quantity_products = quantity_products;
    }

    public Double getPrice_sell_products() {
        return price_sell_products;
    }

    public void setPrice_sell_products(Double price_sell_products) {
        this.price_sell_products = price_sell_products;
    }

    public Double getPrice_buy_products() {
        return price_buy_products;
    }

    public void setPrice_buy_products(Double price_buy_products) {
        this.price_buy_products = price_buy_products;
    }

    public Long getIdSuppliers() {
        return idSuppliers;
    }

    public void setIdSuppliers(Long idSuppliers) {
        this.idSuppliers = idSuppliers;
    }

    public Long getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(Long idCategories) {
        this.idCategories = idCategories;
    }

    public Long getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(Long idInventory) {
        this.idInventory = idInventory;
    }
}
