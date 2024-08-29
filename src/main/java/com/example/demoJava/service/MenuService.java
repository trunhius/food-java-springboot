package com.example.demoJava.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demoJava.entity.Category;
import com.example.demoJava.entity.Food;
import com.example.demoJava.entity.repository.FoodRepository;
import com.example.demoJava.service.imp.FileServiceImp;
import com.example.demoJava.service.imp.MenuServiceImp;

@Service
public class MenuService implements MenuServiceImp {

    @Autowired
    FileServiceImp fileServiceImp;

    @Autowired
    FoodRepository foodRepository;

    @Override
    public boolean createMenu(MultipartFile file, String title, boolean is_freeship, String time_freeship,
            BigDecimal price,
            int cate_id) {

        try {
            boolean isSaveFileSuccess = fileServiceImp.saveFile(file);
            if (isSaveFileSuccess) {
                Food food = new Food();
                food.setTitle(title);
                food.setImage(file.getOriginalFilename());
                food.setTimeShip(time_freeship);
                food.setFreeShip(is_freeship);
                food.setPrice(price);

                Category category = new Category();
                category.setId(cate_id);

                food.setCategory(category);

                foodRepository.save(food);

                return true; // Hoặc true nếu việc chèn restaurant thành công
            }
        } catch (Exception e) {
            e.printStackTrace(); // Xử lý khi không thể parse được ngày tháng
        }
        return false;
    }

}
