package com.example.demoJava.entity;

import java.sql.Timestamp;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "res_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "order")
    private Set<OrdersItem> listOrdersItems;

    @Column(name = "create_date")
    private Timestamp createDate;

    // Getter cho id
    public int getId() {
        return id;
    }

    // Setter cho id
    public void setId(int id) {
        this.id = id;
    }

    // Getter cho user
    public Users getUser() {
        return user;
    }

    // Setter cho user
    public void setUser(Users user) {
        this.user = user;
    }

    // Getter cho restaurant
    public Restaurant getRestaurant() {
        return restaurant;
    }

    // Setter cho restaurant
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    // Getter cho listOrdersItems
    public Set<OrdersItem> getListOrdersItems() {
        return listOrdersItems;
    }

    // Setter cho listOrdersItems
    public void setListOrdersItems(Set<OrdersItem> listOrdersItems) {
        this.listOrdersItems = listOrdersItems;
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
