package com.example.demoJava.entity.keys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class KeyOrderItem implements Serializable {
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "food_id")
    private int foodId;

    // Constructors, getters, and setters

    public KeyOrderItem() {
    }

    public KeyOrderItem(int orderId, int foodId) {
        this.orderId = orderId;
        this.foodId = foodId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    // Override equals and hashCode for composite key

    // @Override
    // public boolean equals(Object o) {
    // if (this == o)
    // return true;
    // if (o == null || getClass() != o.getClass())
    // return false;
    // KeyOrderItem that = (KeyOrderItem) o;
    // return orderId == that.orderId && foodId == that.foodId;
    // }

    // @Override
    // public int hashCode() {
    // return Objects.hash(orderId, foodId);
    // }
}
