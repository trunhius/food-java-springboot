package com.example.demoJava.entity;

import java.sql.Timestamp;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_cate", length = 100)
    private String name;

    @Column(name = "create_date")
    private Timestamp createDate;

    @OneToMany(mappedBy = "category")
    private Set<Food> listFood;

    @OneToMany(mappedBy = "category")
    private Set<MenuRestaurant> listMenuRestaurants;

    // Getter cho id
    public int getId() {
        return id;
    }

    // Setter cho id
    public void setId(int id) {
        this.id = id;
    }

    // Getter cho name
    public String getName() {
        return name;
    }

    // Setter cho name
    public void setName(String name) {
        this.name = name;
    }

    // Getter cho createDate
    public Timestamp getCreateDate() {
        return createDate;
    }

    // Setter cho createDate
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    // Getter cho listFood
    public Set<Food> getListFood() {
        return listFood;
    }

    // Setter cho listFood
    public void setListFood(Set<Food> listFood) {
        this.listFood = listFood;
    }

    // Getter cho listMenuRestaurants
    public Set<MenuRestaurant> getListMenuRestaurants() {
        return listMenuRestaurants;
    }

    // Setter cho listMenuRestaurants
    public void setListMenuRestaurants(Set<MenuRestaurant> listMenuRestaurants) {
        this.listMenuRestaurants = listMenuRestaurants;
    }
}
