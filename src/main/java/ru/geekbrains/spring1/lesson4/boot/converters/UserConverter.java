package ru.geekbrains.spring1.lesson4.boot.converters;


import org.springframework.stereotype.Component;
import ru.geekbrains.spring1.lesson4.boot.dto.UserDto;
import ru.geekbrains.spring1.lesson4.boot.entities.User;

@Component
public class UserConverter {

    public User dtoToEntity(UserDto userDto){
        return new User(userDto.getId(), userDto.getName(), userDto.getPassword(), userDto.getEmail());
    }

    public UserDto entityToDto(User user){
        return new UserDto(user.getId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getRoles());
    }

}
