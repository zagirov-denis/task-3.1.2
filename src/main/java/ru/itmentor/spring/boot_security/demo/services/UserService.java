package ru.itmentor.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.itmentor.spring.boot_security.demo.models.Role;
import ru.itmentor.spring.boot_security.demo.models.User;


import java.util.List;
import java.util.Set;

public interface UserService extends UserDetailsService {
    void add(User user);

    List<User> listUsers();

    void deleteById(long id);

    User findById(long id);

    void update(User user);

    User findByUsername(String username);

    Set<Role> getSetOfRoles(List<String> id);

}
