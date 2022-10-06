package ru.geekbrains.spring1.lesson4.boot.configs;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("secrets.properties")
public class AppConfig {
}
