package com.example.demoJava.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoJava.dto.UserDTO;
import com.example.demoJava.entity.Users;
import com.example.demoJava.entity.repository.UserRepository;
import com.example.demoJava.service.imp.UserServiceImp;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUser() {
        List<Users> listUser = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (Users user : listUser) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUserName(user.getUserName());
            userDTO.setFullname(user.getFullname());
            userDTO.setPassword(user.getPassword());
            userDTO.setCreateDate(user.getCreateDate());
            userDTOList.add(userDTO); // Thêm userDTO vào danh sách userDTOList
        }

        return userDTOList;
    }

}
