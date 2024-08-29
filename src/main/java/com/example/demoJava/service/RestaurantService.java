package com.example.demoJava.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demoJava.dto.CategoryDTO;
import com.example.demoJava.dto.RestaurantDTO;
import com.example.demoJava.entity.RatingRestaurant;
import com.example.demoJava.entity.Restaurant;
import com.example.demoJava.entity.repository.RestaurantRepository;
import com.example.demoJava.service.imp.FileServiceImp;
import com.example.demoJava.service.imp.RestaurantServiceImp;

@Service
public class RestaurantService implements RestaurantServiceImp {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public boolean insertRestaurant(MultipartFile file, String title, String subtitle, String description,
            boolean is_freeship, String address, String open_date) {
        try {
            boolean isSaveFileSuccess = fileServiceImp.saveFile(file);
            if (isSaveFileSuccess) {
                Restaurant restaurant = new Restaurant();
                restaurant.setTitle(title);
                restaurant.setSubtitle(subtitle);
                restaurant.setDescription(description);
                restaurant.setImage(file.getOriginalFilename());
                restaurant.setIsFreeShip(is_freeship);
                restaurant.setAddress(address);

                // Chuyển đổi open_date từ String sang Timestamp
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.util.Date parsedDate = dateFormat.parse(open_date + " 00:00:00");
                Timestamp timestamp = new Timestamp(parsedDate.getTime());

                restaurant.setOpenDate(timestamp);

                // Lưu đối tượng restaurant vào cơ sở dữ liệu (nếu cần)
                restaurantRepository.save(restaurant);

                return true; // Hoặc true nếu việc chèn restaurant thành công
            }
        } catch (Exception e) {
            e.printStackTrace(); // Xử lý khi không thể parse được ngày tháng
        }
        return false; // Hoặc xử lý lỗi khi lưu file không thành công
    }

    @Override
    public List<RestaurantDTO> getHomePageResstaurant() {
        List<RestaurantDTO> restaurantDTOs = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(0, 6);
        Page<Restaurant> listData = restaurantRepository.findAll(pageRequest);

        for (Restaurant data : listData) {
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            restaurantDTO.setId(data.getId());
            restaurantDTO.setImg(data.getImage());
            restaurantDTO.setTitle(data.getTitle());
            restaurantDTO.setSubtitle(data.getSubtitle());
            restaurantDTO.setFreeShip(data.getIsFreeShip());
            restaurantDTO.setDescription(data.getDescription());
            // restaurantDTO.setRating(calculateRating(data.getListRatingRestaurants()));
            restaurantDTOs.add(restaurantDTO);
        }
        return restaurantDTOs;
    }

    private double calculateRating(Set<RatingRestaurant> listRating) {
        if (listRating == null || listRating.isEmpty()) {
            return 0; // Hoặc giá trị mặc định khác tùy vào yêu cầu của bạn
        }
        double totalPoint = 0;
        int count = 0; // Số lượng đánh giá hợp lệ

        for (RatingRestaurant data : listRating) {
            if (data != null) {
                totalPoint += data.getRatePoint();
                count++;
            }
        }

        if (count == 0) {
            return 0; // Tránh chia cho số không khi không có đánh giá hợp lệ
        }

        return totalPoint / count;
    }

    @Override
    public RestaurantDTO getDetailRestaurant(int id) {

        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        if (restaurant.isPresent()) {
            List<CategoryDTO> categoryDTOs = new ArrayList<>();
            Restaurant data = restaurant.get();

            restaurantDTO.setId(data.getId());
            restaurantDTO.setTitle(data.getTitle());
            restaurantDTO.setSubtitle(data.getSubtitle());
            restaurantDTO.setImg(data.getImage());
            // restaurantDTO.setRating(calculateRating(data.getListRatingRestaurants()));
            restaurantDTO.setFreeShip(data.getIsFreeShip());
            restaurantDTO.setOpenDate(data.getOpenDate());

            // // category
            // for (MenuRestaurant menuRestaurant : data.getListMenuRestaurants()) {
            // List<MenuDTO> menuDTOList = new ArrayList<>();
            // CategoryDTO categoryDTO = new CategoryDTO();

            // categoryDTO.setName(menuRestaurant.getCategory().getName());

            // // menu
            // for (Food food : menuRestaurant.getCategory().getListFood()) {
            // MenuDTO menuDTO = new MenuDTO();
            // menuDTO.setId(food.getId());
            // menuDTO.setImage(food.getImage());
            // menuDTO.setFreeship(food.isFreeShip());
            // menuDTO.setTitle(food.getTitle());
            // menuDTO.setDesc(food.isDescription());
            // menuDTO.setPrice(food.getPrice());

            // menuDTOList.add(menuDTO);
            // }
            // categoryDTO.setMenus(menuDTOList);
            // categoryDTOs.add(categoryDTO);

            // }
            // restaurantDTO.setCategorys(categoryDTOs);
        }
        return restaurantDTO;
    }
}
