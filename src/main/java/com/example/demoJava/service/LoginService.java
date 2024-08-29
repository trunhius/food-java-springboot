package com.example.demoJava.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demoJava.dto.UserDTO;
import com.example.demoJava.entity.Role;
import com.example.demoJava.entity.Users;
import com.example.demoJava.entity.repository.UserRepository;
import com.example.demoJava.payload.request.SigUpRequest;
import com.example.demoJava.service.imp.LoginServiceImp;

@Service
public class LoginService implements LoginServiceImp {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    // @Transactional(readOnly = true)
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

    @Override
    public boolean checkLogin(String username, String password) {
        Users users = userRepository.findByUserName(username);

        return passwordEncoder.matches(password, users.getPassword());
    }
    // @Override
    // public boolean checkLogin(String username, String password) {
    // List<Users> Listusers = userRepository.findByUserNameAndPassword(username,
    // password);

    // return Listusers.size() > 0;
    // }

    public boolean addUser(SigUpRequest sigUpRequest) {

        Role role = new Role();
        role.setId(sigUpRequest.getRoleId());

        Users user = new Users();
        user.setFullname(sigUpRequest.getFullname());
        user.setUserName(sigUpRequest.getEmail());
        user.setPassword(sigUpRequest.getPassword());
        user.setRole(role);

        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}