package com.example.demoJava.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoJava.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

}
