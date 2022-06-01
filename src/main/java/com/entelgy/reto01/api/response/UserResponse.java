package com.entelgy.reto01.api.response;

import com.entelgy.reto01.model.UserDto;

import java.util.Set;

public class UserResponse {
    private String operationDate;
    private Set<String> data;

    public String getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
    }

    public Set<String> getData() {
        return data;
    }

    public void setData(Set<String> data) {
        this.data = data;
    }
}
