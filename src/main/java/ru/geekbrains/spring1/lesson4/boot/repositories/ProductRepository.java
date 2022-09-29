package ru.geekbrains.spring1.lesson4.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.geekbrains.spring1.lesson4.boot.entities.Product;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findAllByPriceBetween(Integer min, Integer max);

}
