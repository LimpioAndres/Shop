package com.solvd.shop.models;

public class Categories {

    private Long idCategories;
    private String name_categories;
    private String description_categories;

    public Categories(String name_categories, String description_categories) {
        this.name_categories = name_categories;
        this.description_categories = description_categories;
    }

    public Long getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(Long idCategories) {
        this.idCategories = idCategories;
    }

    public String getName_categories() {
        return name_categories;
    }

    public void setName_categories(String name_categories) {
        this.name_categories = name_categories;
    }

    public String getDescription_categories() {
        return description_categories;
    }

    public void setDescription_categories(String description_categories) {
        this.description_categories = description_categories;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "idCategories=" + idCategories +
                ", name_categories='" + name_categories + '\'' +
                ", description_categories='" + description_categories + '\'' +
                '}';
    }
}
