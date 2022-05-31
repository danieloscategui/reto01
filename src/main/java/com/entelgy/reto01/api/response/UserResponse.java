package com.entelgy.reto01.api.response;

import com.entelgy.reto01.model.UserDto;

import java.util.Set;

public class UserResponse {
    private String operationDate;
    private Set<UserDto> data;

    public String getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
    }

    public Set<UserDto> getData() {
        return data;
    }

    public void setData(Set<UserDto> data) {
        this.data = data;
    }
}
