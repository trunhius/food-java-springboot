package com.example.demoJava.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoJava.payload.ResponseData;
import com.example.demoJava.payload.request.SigUpRequest;
import com.example.demoJava.service.imp.LoginServiceImp;
import com.example.demoJava.utils.JwtUtilsHelper;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginServiceImp loginServiceImp;

    @Autowired
    JwtUtilsHelper jwtUtilsHelper;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username, @RequestParam String password) {
        ResponseData responseData = new ResponseData();

        logger.trace("kinm rea trace log");
        logger.debug("kiẻm tra debug log");
        logger.info("kiem tra info log");
        logger.warn("kiem tra warn");
        logger.error("kiem tra error");

        // SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretString));
        // SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        // String encryptes = Encoders.BASE64.encode(secretKey.getEncoded());
        // System.out.println("đây là password đã được mã hoá khi đăng nhâp:" +
        // encryptes);

        if (loginServiceImp.checkLogin(username, password)) {
            String token = jwtUtilsHelper.genernateToken(username);
            responseData.setData(token);
        } else {
            // responseData.setData("");
            // responseData.setSuccess(false);
            responseData.setData(false);
        }

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SigUpRequest sigUpRequest) {

        ResponseData responseData = new ResponseData();
        responseData.setData(loginServiceImp.addUser(sigUpRequest));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/getalluser")
    public ResponseEntity<?> getAllUser() {

        ResponseData responseData = new ResponseData();
        responseData.setData(loginServiceImp.getAllUser());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
