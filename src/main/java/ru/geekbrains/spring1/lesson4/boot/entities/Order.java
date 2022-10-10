package ru.geekbrains.spring1.lesson4.boot.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.spring1.lesson4.boot.dto.OrderItemDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "totalprice")
    private int totalPrice;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;

}
