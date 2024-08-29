package com.example.demoJava.service.imp;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

public interface MenuServiceImp {

    boolean createMenu(MultipartFile file,
            String title,
            boolean is_freeship,
            String time_freeship,
            BigDecimal price,
            int cate_id);
}
