package com.example.demoJava.entity.repository;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoJava.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    // select * users where userName = "" and passWord = ""

    List<Users> findByUserNameAndPassword(String username, String password);

    Users findByUserName(String userName);

}
