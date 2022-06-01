package com.entelgy.reto01.service;

import com.entelgy.reto01.external.ApiClient;
import com.entelgy.reto01.external.RestException;
import com.entelgy.reto01.external.model.UserApiResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private ApiClient apiClient;

    @InjectMocks
    private UserService userService;

    @Test
    public void test() throws RestException, UserServiceException {
        //when(this.apiClient.getExternalUsers()).thenReturn(new UserApiResponse());
        assertNotNull(userService.processData(), "sample");
    }

}