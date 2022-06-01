package com.entelgy.reto01.api.response;

import java.util.List;

public class UserResponse {
    private String operationDate;
    private List<String> data;

    public String getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
