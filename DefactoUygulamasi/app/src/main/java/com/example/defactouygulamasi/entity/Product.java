package com.example.defactouygulamasi.entity;

public class Product{
    private int id;
    private String name;
    private String pictureName;
    private double price;
    private int colorAmount;

    public Product() {
    }

    public Product(int id, String name, String pictureName, double price, int colorAmount) {
        this.id = id;
        this.name = name;
        this.pictureName = pictureName;
        this.price = price;
        this.colorAmount = colorAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getColorAmount() {
        return colorAmount;
    }

    public void setColorAmount(int colorAmount) {
        this.colorAmount = colorAmount;
    }
}
