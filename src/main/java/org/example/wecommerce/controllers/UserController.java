package org.example.wecommerce.controllers;

import lombok.RequiredArgsConstructor;
import org.example.wecommerce.models.User;
import org.example.wecommerce.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("add")
    public ResponseEntity<User> add(@RequestBody User user) {
        userService.add(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public User getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateByUserName(@RequestBody User newUser) {
        userService.updateByUserName(newUser.getId(), newUser.getUserName());
        return ResponseEntity.ok(newUser);
    }
}
