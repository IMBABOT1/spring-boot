package ru.geekbrains.spring1.lesson4.boot.validators;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring1.lesson4.boot.dto.ProductDto;
import ru.geekbrains.spring1.lesson4.boot.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {
    public void validate(ProductDto productDto) {
        List<String> errors = new ArrayList<>();
        if (productDto.getPrice() < 1) {
            errors.add("Price can't be less then 1");
        }
        if (productDto.getTitle().isBlank()) {
            errors.add("Product title can't be blank");
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
