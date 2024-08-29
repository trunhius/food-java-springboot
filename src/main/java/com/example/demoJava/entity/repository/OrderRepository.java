package com.example.demoJava.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoJava.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
}