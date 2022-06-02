package com.entelgy.reto01.service;

import com.entelgy.reto01.api.response.UserResponse;
import com.entelgy.reto01.external.ApiClient;
import com.entelgy.reto01.external.RestException;
import com.entelgy.reto01.external.model.UserApiResponse;
import com.entelgy.reto01.util.DateUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

public class UserService {

    private final ApiClient apiClient;
    private final UserConverter userConverter;

    public UserService(ApiClient apiClient, UserConverter userConverter) {
        this.apiClient = apiClient;
        this.userConverter = userConverter;
    }

    public UserResponse processData() throws UserServiceException {
        try {
            UserApiResponse userApiResponse;
            userApiResponse = apiClient.getExternalUsers();

            List<String> data = userConverter.convert(userApiResponse.getData());
            UserResponse userResponse = new UserResponse();
            userResponse.setOperationDate(DateUtil.getISO8601DateTimeFormatted(LocalDateTime.now()));
            userResponse.setData(data);
        return userResponse;
        } catch (RestException e) {
            throw new UserServiceException(e.getMessage(), e);
        }
    }
}
