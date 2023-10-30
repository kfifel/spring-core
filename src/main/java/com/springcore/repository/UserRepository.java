package com.springcore.repository;

import com.springcore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository /* extends JpaRepository<User, Long> */{

    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    void delete(User user);
    User update(User user);
}
