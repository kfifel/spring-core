package com.springcore;

import com.springcore.entities.User;
import com.springcore.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SpringCoreApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Test
    void shouldCRUDUser() {
        final User user = new User(1L, "khalid", "fifel", "khalid@gmail.com", "password");

        userRepository.save(user);

        Iterable<User> users = userRepository.findAll();
        assertThat(users)
                .hasSize(1)
                .first()
                .isEqualToComparingFieldByField(user);

        userRepository.delete(user);

        assertThat(userRepository.count())
                .isZero();

    }

}
