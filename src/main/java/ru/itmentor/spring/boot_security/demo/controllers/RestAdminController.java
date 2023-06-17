package ru.itmentor.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/admin/rest/users")
public class RestAdminController {

    private UserService userService;
    @Autowired
    public RestAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> showUsers(){
        List<User> userList = userService.listUsers();
        return userList;
    }

    @PostMapping
    public User create(@RequestBody User newUser) {
        userService.add(newUser);
        return newUser;
    }

    @PutMapping
    public User update(@RequestBody User editedUser) {
        userService.update(editedUser);
        return editedUser;
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        userService.deleteById(id);
        return user;
    }
}
