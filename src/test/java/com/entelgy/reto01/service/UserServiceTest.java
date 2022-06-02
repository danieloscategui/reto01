package com.entelgy.reto01.service;

import com.entelgy.reto01.api.response.UserResponse;
import com.entelgy.reto01.external.ApiClient;
import com.entelgy.reto01.external.RestException;
import com.entelgy.reto01.external.model.User;
import com.entelgy.reto01.external.model.UserApiResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserConverter userConverter;
    @Mock
    private ApiClient apiClient;
    @InjectMocks
    private UserService userService;

    @Test
    public void testProcessData() throws RestException, UserServiceException {
        when(this.userConverter.convert(anyList())).thenReturn(Collections.singletonList("a|a|a"));
        when(this.apiClient.getExternalUsers()).thenReturn(getUserApiResponseMock());
        assertNotNull(userService.processData(), "ProcessDate fail test");
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

    private UserApiResponse getUserApiResponseMock() {
        UserApiResponse userApiResponse = new UserApiResponse();
        userApiResponse.setData(getUsersMock());
        return userApiResponse;
    }

}