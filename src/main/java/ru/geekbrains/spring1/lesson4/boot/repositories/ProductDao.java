package ru.geekbrains.spring1.lesson4.boot.repositories;

import ru.geekbrains.spring1.lesson4.boot.entities.Product;
import java.util.List;

public interface ProductDao {
    Product findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);

    Product saveOrUpdate(Product product);
}
