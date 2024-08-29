package com.example.demoJava.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.demoJava.dto.CategoryDTO;
import com.example.demoJava.entity.Category;
import com.example.demoJava.entity.repository.CategoryRepository;
import com.example.demoJava.service.imp.CategoryServiceImp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class CategoryService implements CategoryServiceImp {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    RedisTemplate redisTemplate;

    private Gson gson = new Gson();

    // @Cacheable("categoryhome")
    @Override
    public List<CategoryDTO> getCategoryHomePage() {

        List<CategoryDTO> listCategoryDTOs = new ArrayList<>();
        String dataRedis = (String) redisTemplate.opsForValue().get("category");

        if (dataRedis == null) {

            System.out.println("Chua co data");
            PageRequest pageRequest = PageRequest.of(0, 3);
            Page<Category> listCategory = categoryRepository.findAll(pageRequest);
            for (Category category : listCategory.getContent()) {
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setId(category.getId());
                categoryDTO.setName(category.getName());

                // List<MenuDTO> menuDTOs = new ArrayList<>();
                // for (Food food : category.getListFood()) {
                // MenuDTO menuDTO = new MenuDTO();
                // menuDTO.setTitle(food.getTitle());
                // menuDTO.setFreeship(food.isFreeShip());
                // menuDTO.setImage(food.getImage());

                // menuDTOs.add(menuDTO);
                // }
                // categoryDTO.setMenus(menuDTOs);

                listCategoryDTOs.add(categoryDTO);
            }
            String dataJson = gson.toJson(listCategoryDTOs);
            redisTemplate.opsForValue().set("category", dataJson);
        } else {
            Type listType = new TypeToken<List<CategoryDTO>>() {
            }.getType();
            listCategoryDTOs = gson.fromJson(dataRedis, listType);
            System.out.println("co data");
        }
        return listCategoryDTOs;
    }
}
