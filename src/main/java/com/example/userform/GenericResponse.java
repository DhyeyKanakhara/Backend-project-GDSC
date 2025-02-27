package com.example.userform;

import com.fasterxml.jackson.annotation.JsonView;

public class GenericResponse {

    @JsonView(View.Public.class)
    private String message;

    @JsonView(View.Public.class)
    private Boolean status;

    @JsonView(View.Public.class)
    private Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}