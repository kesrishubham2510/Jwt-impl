package com.myreflectionthoughts.secmo.dto.request;


public class UserRegistrationRequest {
    private String userName;
    private String password;
    private int age;

    public UserRegistrationRequest(){}

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
