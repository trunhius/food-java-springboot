// package com.example.demoJava.controller;

// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demoJava.model.User;

// import java.util.List;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

// @RestController
// @RequestMapping("/user")
// public class UserControll {
// @GetMapping("/getAllUser")

// public String getAllUser() {
// return "Heloo á";
// }

// @GetMapping("/add")
// public String addUser(@RequestParam("username") String username,
// @RequestParam int id) {
// return "Heloo add user 123" + username + " " + id;
// }

// @GetMapping("/getDetail/{id}/{username}")
// public String getDetail(@PathVariable("id") int id, @PathVariable("username")
// String username) {
// return "hello helo" + id + "---" + username;
// }

// @PostMapping("/update")
// public String updateUser(@RequestBody List<User> user) {

// for (User data : user) {
// System.out.println("hello" + data.getUsername() + " " + data.getPassword() +
// " " + data.getId());
// }
// return "";

// // return "hello" + user.getUsername() + " " + user.getPassword() + " " +
// // user.getId();

// }

// }
