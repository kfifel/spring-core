package com.springcore.repository;

import com.springcore.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //@Query("select u from User u where u.firstname = :firstname and u.lastname = :lastname")
    List<User> findUsersByFirstnameAndLastname(String firstname, String lastname);

}
