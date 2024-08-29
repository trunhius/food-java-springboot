package com.example.demoJava.entity;

import java.sql.Timestamp;

import com.example.demoJava.entity.keys.KeyMenuRestaurant;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "menu_restaurant")
public class MenuRestaurant {

    // @EmbeddedId
    // private KeyMenuRestaurant keys;

    // @ManyToOne
    // @JoinColumn(name = "cate_id")
    // private Category category;

    // @ManyToOne
    // @JoinColumn(name = "res_id")
    // private Restaurant restaurant;

    // @Column(name = "create_date")
    // private Timestamp createDate;
    @EmbeddedId
    private KeyMenuRestaurant keys;

    @ManyToOne
    @JoinColumn(name = "cate_id", insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "res_id", insertable = false, updatable = false)
    private Restaurant restaurant;

    @Column(name = "create_date")
    private Timestamp createDate;

    // Getter cho keys
    public KeyMenuRestaurant getKeys() {
        return keys;
    }

    // Setter cho keys
    public void setKeys(KeyMenuRestaurant keys) {
        this.keys = keys;
    }

    // Getter cho category
    public Category getCategory() {
        return category;
    }

    // Setter cho category
    public void setCategory(Category category) {
        this.category = category;
    }

    // Getter cho restaurant
    public Restaurant getRestaurant() {
        return restaurant;
    }

    // Setter cho restaurant
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    // Getter cho createDate
    public Timestamp getCreateDate() {
        return createDate;
    }

    // Setter cho createDate
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}