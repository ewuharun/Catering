package com.example.catering.Customer.DataModel;

/**
 * Created By Md.Harun or rashid on 10 th, aug,2021
 * MOBILE : 01531946638
 * UNiVERSITY : EWU (CSE)
 **/
public class Category {
    int category_id;
    String category_name;
    String category_description;
    int total_product;

    public Category(int category_id, String category_name, String category_description, int total_product) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_description = category_description;
        this.total_product = total_product;
    }

    public Category() {
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_description() {
        return category_description;
    }

    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }

    public int getTotal_product() {
        return total_product;
    }

    public void setTotal_product(int total_product) {
        this.total_product = total_product;
    }
}
