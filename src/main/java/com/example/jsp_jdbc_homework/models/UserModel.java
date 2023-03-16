package com.example.jsp_jdbc_homework.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserModel {
    private String username;
    private String firstName;
    private String lastName;
    private int age;
}
