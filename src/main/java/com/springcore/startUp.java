package com.springcore;

import com.springcore.config.AppConfig;
import com.springcore.entities.User;
import com.springcore.repository.UserRepository;
import com.springcore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class startUp implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("from start Up");

        User save = userService.save(new User(5L, "adil", "soufian", "addil@gmail.com", "kjdkjç9"));

        userService.findAll().forEach(System.out::println);

        // test throwing error
        userService.update(new User());
    }
}
