package ru.geekbrains.spring1.lesson4.boot.converters;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring1.lesson4.boot.dto.ProductDto;
import ru.geekbrains.spring1.lesson4.boot.entities.Product;

@Component
public class ProductConverter {
    public Product dtoToEntity(ProductDto productDto){
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice());
    }

    public ProductDto entityToDto(Product product){
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }
}
