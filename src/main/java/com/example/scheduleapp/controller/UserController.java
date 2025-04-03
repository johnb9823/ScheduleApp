package com.example.scheduleapp.controller;

import com.example.scheduleapp.entity.User;
import com.example.scheduleapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //생성
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    //다건 조회
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    //단건 조회
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    //수정
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    //삭제
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
