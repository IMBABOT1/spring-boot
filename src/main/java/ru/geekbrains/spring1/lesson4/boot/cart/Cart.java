package ru.geekbrains.spring1.lesson4.boot.cart;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring1.lesson4.boot.entities.Product;
import ru.geekbrains.spring1.lesson4.boot.repositories.ProductsRepository;

import javax.annotation.PostConstruct;
import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@Scope("prototype")
@RequiredArgsConstructor
@Data
public class Cart {
    private List<Product> products;
    private final ProductsRepository productsRepository;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
    }


    public void add(Long id){
        Optional<Product> p = productsRepository.findById(id);
        if (p.isPresent()) {
            products.add(p.get());
        }else {
            throw new ResolutionException("Product with id: " + id + "not exists");
        }
    }

    public List<Product> findAll(){
        return Collections.unmodifiableList(products);
    }

}

