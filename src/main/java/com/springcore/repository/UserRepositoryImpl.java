package com.springcore.repository;

import com.springcore.entities.User;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Profile("dev")
@Profile("prod")
public class UserRepositoryImpl implements UserRepository{
    List<User> users = new ArrayList<>(List.of(
            new User(1L, "khalid", "fifel", "khalid@gmail.com", "password"),
            new User(1L, "ali", "ahmas", "aliali@gmail.com", "password"),
            new User(1L, "mouad", "dzed", "mouad@gmail.com", "password"),
            new User(1L, "fatima", "fathi", "some@gmail.com", "password")
    ));
    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }

    @Override
    public User update(User user) {
        User userById = this.findById(user.getId()).orElse(null);
        if(userById == null) return null;

        userById.setEmail(user.getEmail());
        userById.setPassword(user.getPassword());
        userById.setFirstname(user.getFirstname());
        userById.setLastname(user.getLastname());
        return userById;
    }
}
