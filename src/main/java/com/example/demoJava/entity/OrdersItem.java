package com.example.demoJava.entity;

import java.sql.Timestamp;

import com.example.demoJava.entity.keys.KeyOrderItem;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "order_item")
public class OrdersItem {

    @EmbeddedId
    private KeyOrderItem keyOrderItem;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "food_id", insertable = false, updatable = false)
    private Food food;

    @Column(name = "create_date")
    private Timestamp createDate;

    // Constructors, getters, and setters

    public OrdersItem() {
    }

    public KeyOrderItem getKeyOrderItem() {
        return keyOrderItem;
    }

    public void setKeyOrderItem(KeyOrderItem keyOrderItem) {
        this.keyOrderItem = keyOrderItem;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}