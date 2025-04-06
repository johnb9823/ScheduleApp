package com.example.scheduleapp.controller;

import com.example.scheduleapp.entity.User;
import com.example.scheduleapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    //필드를 private final로 선언하는 이유는 가장 안전한 방법이라서.
    //
    //private 외부에서 마음대로 바꾸지 못하게 보호해줌. 캡슐화 원칙!
    //final	한 번 값이 들어가면 다시는 바뀌지 않게 막아줌. 불변성 확보!
    // final을 선언하지 않으면 실수로 setter 만들거나, 값을 나중에 바꿀 수도 있어서 위험하다.
    // 그래서 private final을 표준처럼 사용함
    // Lombok을 사용하면 더 편한다.
    //@RequiredArgsConstructor
    // final 필드만 골라서 자동으로 생성자 만들어줌.

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
