package ru.geekbrains.spring1.lesson4.boot.dto;


import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
