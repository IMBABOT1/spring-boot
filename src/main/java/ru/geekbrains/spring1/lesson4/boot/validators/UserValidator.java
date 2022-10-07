package ru.geekbrains.spring1.lesson4.boot.validators;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring1.lesson4.boot.dto.UserDto;
import ru.geekbrains.spring1.lesson4.boot.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserValidator {

    public void validate(UserDto userDto) {
        List<String> errors = new ArrayList<>();
        if (userDto.getName().isBlank()) {
            errors.add("User name can't be blank");
        }
        if (userDto.getEmail().isBlank()) {
            errors.add("User mail can't be blank");
        }
        if (userDto.getPassword().isBlank()) {
            errors.add("User password can't be blank");
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
