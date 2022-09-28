package ru.geekbrains.spring1.lesson4.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.spring1.lesson4.boot.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {


}
