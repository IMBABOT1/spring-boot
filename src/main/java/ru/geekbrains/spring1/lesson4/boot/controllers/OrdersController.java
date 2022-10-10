package ru.geekbrains.spring1.lesson4.boot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring1.lesson4.boot.converters.OrderConverter;
import ru.geekbrains.spring1.lesson4.boot.dto.OrderDetailsDto;
import ru.geekbrains.spring1.lesson4.boot.dto.OrderDto;
import ru.geekbrains.spring1.lesson4.boot.entities.Order;
import ru.geekbrains.spring1.lesson4.boot.entities.User;
import ru.geekbrains.spring1.lesson4.boot.exceptions.ResourceNotFoundException;
import ru.geekbrains.spring1.lesson4.boot.services.OrderService;
import ru.geekbrains.spring1.lesson4.boot.services.UserService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final UserService userService;
    private final OrderService orderService;
    private final OrderConverter orderConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(Principal principal, @RequestBody OrderDetailsDto orderDetailsDto) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        orderService.createOrder(user, orderDetailsDto);
    }

    @GetMapping
    public List<OrderDto> getCurrentUserOrders(Principal principal) {
        return orderService.findOrdersByUsername(principal.getName()).stream()
                .map(orderConverter::entityToDto).collect(Collectors.toList());
    }
}
