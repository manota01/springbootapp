package com.example.springbootapp.model;

public class Property {
    private String title;
    private String address;
    private String price;

    public Property(String title, String address, String price) {
        this.title = title;
        this.address = address;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
