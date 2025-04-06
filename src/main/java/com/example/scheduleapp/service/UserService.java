package com.example.scheduleapp.service;

import com.example.scheduleapp.entity.User;
import com.example.scheduleapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //필드 선언
    private final UserRepository userRepository;

    //생성자 주입
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 유저 생성
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // 전체 유저 조회
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // 특정 유저 조회
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    //트정 유저 정보 업데이트
    public User updateUser(Long id, User updatedUser) {
        User user = getUser(id);
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        return userRepository.save(user);
    }

    //특정 유저 삭제
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
