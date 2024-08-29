package com.example.demoJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoJava.payload.ResponseData;
import com.example.demoJava.service.imp.CategoryServiceImp;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryServiceImp categoryServiceImp;

    @GetMapping()
    public ResponseEntity<?> getHomeCategory() {
        ResponseData responseData = new ResponseData();

        responseData.setData(categoryServiceImp.getCategoryHomePage());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @CacheEvict(value = "categoryhome", allEntries = true)
    @GetMapping("/clearncache")
    public String clearnCache() {
        return "clearn cache success";
    }
}
