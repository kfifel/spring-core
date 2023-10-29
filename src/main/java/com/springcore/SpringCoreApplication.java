package com.springcore;

import com.springcore.entities.User;
import com.springcore.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCoreApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringCoreApplication.class, args);

        //ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(AppConfig.class);
        //UserService userRepository = applicationContext1.getBean("userService", UserService.class);
        //userRepository.findAll().forEach(System.out::println);

        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = appContext.getBean("userService", UserService.class);
        User save = userService.save(new User(5L, "adil", "soufian", "addil@gmail.com", "kjdkjç9"));

        userService.findAll().forEach(System.out::println);

        // test throwing error
        userService.update(new User());

    }

}
/*
@Component
@Controller(value = "/users")
class UserController{
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
*/