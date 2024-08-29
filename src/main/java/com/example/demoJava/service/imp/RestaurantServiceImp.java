package com.example.demoJava.service.imp;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demoJava.dto.RestaurantDTO;

public interface RestaurantServiceImp {
    boolean insertRestaurant(MultipartFile file,
            String title,
            String subtitle,
            String description,
            boolean is_freeship,
            String address,
            String open_date);

    List<RestaurantDTO> getHomePageResstaurant();

    RestaurantDTO getDetailRestaurant(int id);
}
