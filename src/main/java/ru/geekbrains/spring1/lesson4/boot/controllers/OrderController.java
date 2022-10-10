package ru.geekbrains.spring1.lesson4.boot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring1.lesson4.boot.entities.Order;
import ru.geekbrains.spring1.lesson4.boot.services.CartService;
import ru.geekbrains.spring1.lesson4.boot.services.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final Order orders;
    private final OrderService orderService;

    @GetMapping("/create")
    public void createOrder(Order order){
        orderService.saveOrder(order);
    }
}
