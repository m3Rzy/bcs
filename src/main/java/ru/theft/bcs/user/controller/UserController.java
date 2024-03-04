package ru.theft.bcs.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.theft.bcs.user.model.User;
import ru.theft.bcs.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping
    public List<User> readAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User readUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.add(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody User user) {
        userService.delete(user);
    }
}
