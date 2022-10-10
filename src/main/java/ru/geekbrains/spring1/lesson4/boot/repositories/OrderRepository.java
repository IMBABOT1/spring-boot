package ru.geekbrains.spring1.lesson4.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring1.lesson4.boot.entities.Order;
import ru.geekbrains.spring1.lesson4.boot.entities.Product;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Product> {


}
