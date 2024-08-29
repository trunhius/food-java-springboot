package com.example.demoJava.dto;

import java.sql.Timestamp;
import java.util.List;

public class RestaurantDTO {
    private int id;
    private String img;
    private String title;
    private double rating;
    private String subtitle;
    private boolean isFreeShip;
    private Object isTest;
    private Timestamp openDate;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    List<CategoryDTO> categorys;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Timestamp openDate) {
        this.openDate = openDate;
    }

    public List<CategoryDTO> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<CategoryDTO> categorys) {
        this.categorys = categorys;
    }

    // Getter for img
    public String getImg() {
        return img;
    }

    // Setter for img
    public void setImg(String img) {
        this.img = img;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for rating
    public double getRating() {
        return rating;
    }

    // Setter for rating
    public void setRating(double rating) {
        this.rating = rating;
    }

    // Getter for subtitle
    public String getSubtitle() {
        return subtitle;
    }

    // Setter for subtitle
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    // Getter for isFreeShip
    public boolean isFreeShip() {
        return isFreeShip;
    }

    // Setter for isFreeShip
    public void setFreeShip(boolean freeShip) {
        isFreeShip = freeShip;
    }

    // Getter for isTest
    public Object getIsTest() {
        return isTest;
    }

    // Setter for isTest
    public void setIsTest(Object isTest) {
        this.isTest = isTest;
    }
}
