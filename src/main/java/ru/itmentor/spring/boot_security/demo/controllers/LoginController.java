package ru.itmentor.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itmentor.spring.boot_security.demo.models.Role;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.repository.RoleRepository;
import ru.itmentor.spring.boot_security.demo.services.UserService;

import java.util.HashSet;

@Controller
public class LoginController {

    private RoleRepository roleRepository;
    private UserService userService;

    @Autowired
    public LoginController(RoleRepository roleRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @GetMapping("/index")
    public String addUsersIntoDB() {
        Role admin = new Role();
        admin.setRoleName("ADMIN");
        Role user = new Role();
        user.setRoleName("USER");
        roleRepository.save(admin);
        roleRepository.save(user);

        userService.add(new User("den", "Zag",49,"admin",  "admin@mail.com",
                new HashSet<>() {{
            add(admin);
            add(user);
        }}));
        userService.add(new User("user", "Admin",46,"user",  "user@mail.com",

                new HashSet<>() {{
                    add(user);
                }}));
        return "login";
    }
    @GetMapping("/login")
    public String loginMethod(){
        return "login";
    }
}
