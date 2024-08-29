package com.example.demoJava.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava.entity.Orders;
import com.example.demoJava.entity.OrdersItem;
import com.example.demoJava.entity.Restaurant;
import com.example.demoJava.entity.Users;
import com.example.demoJava.entity.repository.OrderItemRespository;
import com.example.demoJava.entity.repository.OrderRepository;
import com.example.demoJava.payload.request.OrderRequest;
import com.example.demoJava.service.imp.OrderServiceImp;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService implements OrderServiceImp {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRespository orderItemRespository;

    @Override
    public boolean insertOrder(OrderRequest orderRequest) {
        try {
            Users users = new Users();
            users.setId(orderRequest.getUserId());

            Restaurant restaurant = new Restaurant();
            restaurant.setId(orderRequest.getResId());

            Orders orders = new Orders();
            orders.setUser(users);
            orders.setRestaurant(restaurant);

            orderRepository.save(orders);

            List<OrdersItem> items = new ArrayList<>();
            // for (int idFood : orderRequest.getFoodIds()) {
            // Food food = new Food();
            // food.setId(idFood);

            // OrdersItem ordersItem = new OrdersItem();
            // KeyOrderItem keyOrderItem = new KeyOrderItem(orders.getId(), idFood);
            // ordersItem.setKeyOrderItem(keyOrderItem);

            // items.add(ordersItem);
            // }
            orderItemRespository.saveAll(items);
            return true;

        } catch (Exception e) {
            System.out.println("error insert order" + e.getMessage());
            return false;
        }
    }

}
