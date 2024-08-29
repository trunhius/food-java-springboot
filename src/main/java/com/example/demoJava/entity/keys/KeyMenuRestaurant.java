package com.example.demoJava.entity.keys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class KeyMenuRestaurant implements Serializable {

    @Column(name = "cate_id")
    private int cateId;

    @Column(name = "res_id")
    private int resId;

    // Constructor mặc định không tham số
    public KeyMenuRestaurant() {
    }

    // Constructor có tham số
    public KeyMenuRestaurant(int cateId, int resId) {
        this.cateId = cateId;
        this.resId = resId;
    }

    // Getter cho cateId
    public int getCateId() {
        return cateId;
    }

    // Setter cho cateId
    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    // Getter cho resId
    public int getResId() {
        return resId;
    }

    // Setter cho resId
    public void setResId(int resId) {
        this.resId = resId;
    }
}