package com.example.demoJava.payload.request;

public class OrderRequest {
    private int userId;
    private int resId;
    private int[] foodIds;

    public int[] getFoodIds() {
        return foodIds;
    }

    public void setFoodIds(int[] foodIds) {
        this.foodIds = foodIds;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
