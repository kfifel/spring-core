package com.springcore;

import com.springcore.config.AppConfig;
import com.springcore.entities.User;
import com.springcore.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class SpringCoreApplication {

    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = appContext.getBean(UserService.class);
        User save = userService.save(new User(5L, "adil", "soufian", "addil@gmail.com", "kjdkjç9"));

        userService.findAll().forEach(System.out::println);

        // test throwing error
        userService.update(new User());

    }

}