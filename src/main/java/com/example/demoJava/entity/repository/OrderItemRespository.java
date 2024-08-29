package com.example.demoJava.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoJava.entity.OrdersItem;
import com.example.demoJava.entity.keys.KeyOrderItem;

@Repository
public interface OrderItemRespository extends JpaRepository<OrdersItem, KeyOrderItem> {

}
