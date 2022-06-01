package com.entelgy.reto01.service;

import com.entelgy.reto01.api.response.UserResponse;
import com.entelgy.reto01.external.ApiClient;
import com.entelgy.reto01.external.RestException;
import com.entelgy.reto01.external.model.User;
import com.entelgy.reto01.external.model.UserApiResponse;
import com.entelgy.reto01.model.UserDto;
import com.entelgy.reto01.util.DateUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final ApiClient apiClient;

    public UserService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public UserResponse processData() throws UserServiceException {
        try {
            UserApiResponse userApiResponse;
            userApiResponse = apiClient.getExternalUsers();

            Set<String> data = convert(userApiResponse.getData());
            UserResponse userResponse = new UserResponse();
            userResponse.setOperationDate(DateUtil.getISO8601DateTimeFormatted(LocalDateTime.now()));
            userResponse.setData(data);
        return userResponse;
        } catch (RestException e) {
            throw new UserServiceException(e.getMessage(), e);
        }
    }

    private Set<String> convert(Set<User> userApiResponse) {
        return userApiResponse.stream().map(this::joinData).collect(Collectors.toSet());
    }

    private String joinData(User user) {
        return String.join("|", String.valueOf(user.getId()), user.getLast_name(), user.getEmail());
    }
}
