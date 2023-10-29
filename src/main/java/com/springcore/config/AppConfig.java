package com.springcore.config;


import com.springcore.repository.UserRepository;
import com.springcore.repository.UserRepositoryImpl;
import com.springcore.service.UserService;
import com.springcore.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean("userService")
    public UserService getUserService(){
        return new UserServiceImpl(getUserRepository());
    }

    @Bean("userRepository")
    public UserRepository getUserRepository() {
        return new UserRepositoryImpl();
    }
}
