package com.entelgy.reto01.service;

import com.entelgy.reto01.api.response.UserResponse;
import com.entelgy.reto01.external.ApiClient;
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

    public UserResponse processData() {
        UserApiResponse userApiResponse = apiClient.getExternalUsers();
        Set<UserDto> data = convert(userApiResponse.getData());
        UserResponse userResponse = new UserResponse();
        userResponse.setOperationDate(DateUtil.getISO8601DateTimeFormatted(LocalDateTime.now()));
        userResponse.setData(data);
        return userResponse;
    }

    private Set<UserDto> convert(Set<User> userApiResponse) {
        return userApiResponse.stream().map(this::toDto).collect(Collectors.toSet());
    }

    private UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setLast_name(user.getLast_name());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
