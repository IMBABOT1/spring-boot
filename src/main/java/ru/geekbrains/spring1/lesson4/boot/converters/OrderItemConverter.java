package ru.geekbrains.spring1.lesson4.boot.converters;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring1.lesson4.boot.dto.OrderItemDto;
import ru.geekbrains.spring1.lesson4.boot.entities.OrderItem;

@Component
public class OrderItemConverter {
    public OrderItem dtoToEntity(OrderItemDto orderItemDto) {
        throw new UnsupportedOperationException();
    }

    public OrderItemDto entityToDto(OrderItem orderItem) {
        return new OrderItemDto(orderItem.getProduct().getId(), orderItem.getProduct().getTitle(), orderItem.getQuantity(), orderItem.getPricePerProduct(), orderItem.getPrice());
    }
}
