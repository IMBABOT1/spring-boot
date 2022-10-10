package ru.geekbrains.spring1.lesson4.boot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring1.lesson4.boot.entities.Order;
import ru.geekbrains.spring1.lesson4.boot.repositories.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void saveOrder(Order order){
        orderRepository.save(order);
    }
}
