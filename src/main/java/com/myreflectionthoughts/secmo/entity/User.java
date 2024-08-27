package com.myreflectionthoughts.secmo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collation = "Users")
public class User {

    @MongoId
    private String userId;

    @Field(name = "userName")
    private String userName;

    @Field(name="password")
    private String password;

    @Field(name = "age")
    private int age;

    public User(){}

    public User(String userName, String userId, String password, int age){

        this.userName = userName;
        this.userId = userId;
        this.password = password;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}