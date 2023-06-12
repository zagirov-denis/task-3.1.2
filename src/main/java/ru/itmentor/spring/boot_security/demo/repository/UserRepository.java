package ru.itmentor.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.models.User;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.username = :username")
    User getUserByUsername(@Param("username") String username);

    @Query("select distinct u from User u left join fetch u.roles where u.id = :id")
    User findByIdWithRoles(@Param("id") long id);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email = :email")
    User getUserByEmail(@Param("email") String email);

}
