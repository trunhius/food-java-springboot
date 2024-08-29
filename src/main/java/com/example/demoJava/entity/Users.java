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
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name", length = 100)
    private String userName;

    @Column(name = "password", length = 300)
    private String password;

    @Column(name = "fullname", length = 50)
    private String fullname;

    @Column(name = "create_date")
    private Timestamp createDate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<RatingFood> ratings;

    @OneToMany(mappedBy = "user")
    private Set<RatingRestaurant> restaurantRatings;

    @OneToMany(mappedBy = "user")
    private Set<Orders> orders;

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<RatingFood> getRatings() {
        return ratings;
    }

    public void setRatings(Set<RatingFood> ratings) {
        this.ratings = ratings;
    }

    public Set<RatingRestaurant> getRestaurantRatings() {
        return restaurantRatings;
    }

    public void setRestaurantRatings(Set<RatingRestaurant> restaurantRatings) {
        this.restaurantRatings = restaurantRatings;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
