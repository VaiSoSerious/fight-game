package com.vai.module3project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private long id;
    private String name;
    private String login;
    private String email;
    private String password;
    private List<Character> characters = new ArrayList<>();
}