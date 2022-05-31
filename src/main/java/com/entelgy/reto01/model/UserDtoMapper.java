package com.entelgy.reto01.model;

import com.entelgy.reto01.external.model.User;

public class UserDtoMapper {
    public static UserDto from(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setLast_name(user.getLast_name());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
