package com.myreflectionthoughts.secmo.dto.response;

import org.springframework.data.mongodb.core.mapping.Field;

public class UserRegistrationResponse {

    private String userId;
    private String userName;
    private int age;

    public UserRegistrationResponse() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
