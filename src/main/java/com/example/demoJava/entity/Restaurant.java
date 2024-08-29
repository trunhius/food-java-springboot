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
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "subtitle", length = 255)
    private String subtitle;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    @Column(name = "is_freeship")
    private Boolean isFreeShip;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "open_date")
    private Timestamp openDate;

    @OneToMany(mappedBy = "restaurant")
    private Set<RatingRestaurant> listRatingRestaurants;

    @OneToMany(mappedBy = "restaurant")
    private Set<Orders> listOrders;

    @OneToMany(mappedBy = "restaurant")
    private Set<MenuRestaurant> listMenuRestaurants;

    @OneToMany(mappedBy = "restaurant")
    private Set<Promo> listPromo;

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

    // Getter cho subtitle
    public String getSubtitle() {
        return subtitle;
    }

    // Setter cho subtitle
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    // Getter cho description
    public String getDescription() {
        return description;
    }

    // Setter cho description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter cho image
    public String getImage() {
        return image;
    }

    // Setter cho image
    public void setImage(String image) {
        this.image = image;
    }

    // Getter cho isFreeShip
    public Boolean getIsFreeShip() {
        return isFreeShip;
    }

    // Setter cho isFreeShip
    public void setIsFreeShip(Boolean isFreeShip) {
        this.isFreeShip = isFreeShip;
    }

    // Getter cho address
    public String getAddress() {
        return address;
    }

    // Setter cho address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter cho openDate
    public Timestamp getOpenDate() {
        return openDate;
    }

    // Setter cho openDate
    public void setOpenDate(Timestamp openDate) {
        this.openDate = openDate;
    }

    // Getter cho listRatingRestaurants
    public Set<RatingRestaurant> getListRatingRestaurants() {
        return listRatingRestaurants;
    }

    // Setter cho listRatingRestaurants
    public void setListRatingRestaurants(Set<RatingRestaurant> listRatingRestaurants) {
        this.listRatingRestaurants = listRatingRestaurants;
    }

    // Getter cho listOrders
    public Set<Orders> getListOrders() {
        return listOrders;
    }

    // Setter cho listOrders
    public void setListOrders(Set<Orders> listOrders) {
        this.listOrders = listOrders;
    }

    // Getter cho listMenuRestaurants
    public Set<MenuRestaurant> getListMenuRestaurants() {
        return listMenuRestaurants;
    }

    // Setter cho listMenuRestaurants
    public void setListMenuRestaurants(Set<MenuRestaurant> listMenuRestaurants) {
        this.listMenuRestaurants = listMenuRestaurants;
    }

    // Getter cho listPromo
    public Set<Promo> getListPromo() {
        return listPromo;
    }

    // Setter cho listPromo
    public void setListPromo(Set<Promo> listPromo) {
        this.listPromo = listPromo;
    }
}