package com.solvd.shop.models;

public class Products {

    private Long idProducts;
    private String name_products;
    private Integer stock_inventory;
    private Double price_sell_products;
    private Double price_buy_products;
    private Long idSuppliers;
    private Long idCategories;
    private Long idInventory;

    public Products(String name_products, Integer stock_inventory, Double price_sell_products, Double price_buy_products,
                    Long idSuppliers, Long idCategories, Long idInventory) {
        this.name_products = name_products;
        this.stock_inventory = stock_inventory;
        this.price_sell_products = price_sell_products;
        this.price_buy_products = price_buy_products;
        this.idSuppliers = idSuppliers;
        this.idCategories = idCategories;
        this.idInventory = idInventory;
    }

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

    public Integer getStock_inventory() {
        return stock_inventory;
    }

    public void setStock_inventory(Integer stock_inventory) {
        this.stock_inventory = stock_inventory;
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

    @Override
    public String toString() {
        return "Products{" +
                "idProducts=" + idProducts +
                ", name_products='" + name_products + '\'' +
                ", quantity_products=" + stock_inventory +
                ", price_sell_products=" + price_sell_products +
                ", price_buy_products=" + price_buy_products +
                ", idSuppliers=" + idSuppliers +
                ", idCategories=" + idCategories +
                ", idInventory=" + idInventory +
                '}';
    }
}
