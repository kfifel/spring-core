package com.springcore.service.impl;

import com.springcore.entities.User;
import com.springcore.repository.UserRepository;
import com.springcore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Value("${fileLocation}")
    private String localtionFile;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User update(User user) {
        throw new IllegalArgumentException("Not implemented yet");
    }

    @Override
    public List<User> findUsersByFirstnameAndLastname(String firstname, String lastname) {
        return userRepository.findUsersByFirstnameAndLastname(firstname, lastname);
    }
}
