package com.entelgy.reto01.service;

import com.entelgy.reto01.external.model.User;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserConverter {
    public List<String> convert(List<User> users) {
        return users.stream().map(
                user -> String.join("|", String.valueOf(user.getId()), user.getLast_name(), user.getEmail())
        ).collect(Collectors.toList());
    }
}
