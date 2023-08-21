package com.vai.module3project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User{
    private long id;
    private String login;
    private String password;
    Character character;
}
