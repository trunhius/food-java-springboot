package com.example.demoJava.service.imp;

import java.util.List;

import com.example.demoJava.dto.UserDTO;
import com.example.demoJava.payload.request.SigUpRequest;

public interface LoginServiceImp {

    List<UserDTO> getAllUser();

    boolean checkLogin(String username, String password);

    boolean addUser(SigUpRequest sigUpRequest);

}
