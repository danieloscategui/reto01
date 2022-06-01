package com.entelgy.reto01.service;

import com.entelgy.reto01.external.model.User;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserConverterTest {

    @Test
    void convert() {
        UserConverter userConverter = new UserConverter();
        assertEquals(expectedSet(), userConverter.convert(getUsersMock()));
    }

    private List<User> getUsersMock() {
        User user = new User();
        user.setId(1);
        user.setLast_name("abc");
        user.setFirst_name("gru");
        user.setEmail("abc@micorreo.com");
        user.setAvatar("gru abc");

        User user1 = new User();
        user1.setId(2);
        user1.setLast_name("def");
        user1.setFirst_name("toy");
        user1.setEmail("def@micorreo.com");
        user1.setAvatar("def toy");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        return users;
    }

    private List<String> expectedSet() {
        return Arrays.asList("1|abc|abc@micorreo.com", "2|def|def@micorreo.com");
    }
}