package com.example.demoJava.dto;

import java.math.BigDecimal;

public class MenuDTO {
    private int id;
    private String title;
    private String image;
    private boolean isFreeship;
    private String desc;
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    // Getter for isFreeship
    public boolean isFreeship() {
        return isFreeship;
    }

    public void setFreeship(boolean isFreeship) {
        this.isFreeship = isFreeship;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
