package com.example.demoJava.entity;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    @Column(name = "time_ship", length = 10)
    private String timeShip;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "is_freeship")
    private boolean isFreeShip;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;

    @OneToMany(mappedBy = "food")
    private Set<RatingFood> listRatingFood;

    @OneToMany(mappedBy = "food")
    private Set<OrdersItem> listOrdersItem;

    // Getter cho id
    public int getId() {
        return id;
    }

    // Setter cho id
    public void setId(int id) {
        this.id = id;
    }

    // Getter cho title
    public String getTitle() {
        return title;
    }

    // Setter cho title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter cho image
    public String getImage() {
        return image;
    }

    // Setter cho image
    public void setImage(String image) {
        this.image = image;
    }

    // Getter cho timeShip
    public String getTimeShip() {
        return timeShip;
    }

    // Setter cho timeShip
    public void setTimeShip(String timeShip) {
        this.timeShip = timeShip;
    }

    // Getter cho price
    public BigDecimal getPrice() {
        return price;
    }

    // Setter cho price
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // description
    public String isDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter cho category
    public Category getCategory() {
        return category;
    }

    // Setter cho category
    public void setCategory(Category category) {
        this.category = category;
    }

    // Getter cho listRatingFood
    public Set<RatingFood> getListRatingFood() {
        return listRatingFood;
    }

    // Setter cho listRatingFood
    public void setListRatingFood(Set<RatingFood> listRatingFood) {
        this.listRatingFood = listRatingFood;
    }

    // Getter cho listOrdersItem
    public Set<OrdersItem> getListOrdersItem() {
        return listOrdersItem;
    }

    // Setter cho listOrdersItem
    public void setListOrdersItem(Set<OrdersItem> listOrdersItem) {
        this.listOrdersItem = listOrdersItem;
    }

    // Getter for isFreeShip
    public boolean isFreeShip() {
        return isFreeShip;
    }

    // Setter for isFreeShip
    public void setFreeShip(boolean freeShip) {
        this.isFreeShip = freeShip;
    }
}
