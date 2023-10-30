package com.springcore.service;

import com.springcore.entities.User;
import com.springcore.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {
    User save(User user);
    List<User> findAll();
    Optional<User> findById(Long id);
    void delete(User user);
    User update(User user);
    List<User> findUsersByFirstnameAndLastname(String firstname, String lastname);
}
